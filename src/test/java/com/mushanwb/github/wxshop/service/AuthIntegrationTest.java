package com.mushanwb.github.wxshop.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.kevinsawicki.http.HttpRequest;
import com.mushanwb.github.wxshop.WxshopApplication;
import com.mushanwb.github.wxshop.entity.LoginResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.net.HttpURLConnection.HTTP_BAD_REQUEST;
import static java.net.HttpURLConnection.HTTP_OK;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = WxshopApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)    //随机端口
@TestPropertySource(locations = "classpath:application.yml")
public class AuthIntegrationTest {

    @Autowired
    Environment environment;

    private ObjectMapper objectMapper = new ObjectMapper();
    private final Map<String, String> param = new HashMap<>();

    @Test
    public void returnHttpOkWhenParameterIsCorrect() throws JsonProcessingException {
        param.put("tel", TelVerificationServiceTest.VALID_TEL);
        int responseCode = HttpRequest.post(getUrl("/api/code"))
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .send(objectMapper.writeValueAsString(param))
                .code();
        Assertions.assertEquals(HTTP_OK, responseCode);
    }

    @Test
    public void returnHttpBadRequestWhenParameterIsCorrect() throws JsonProcessingException {
        param.put("tel", TelVerificationServiceTest.NOT_TEL);
        int responseCode = HttpRequest.post(getUrl("/api/code"))
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .send(objectMapper.writeValueAsString(param))
                .code();
        Assertions.assertEquals(HTTP_BAD_REQUEST, responseCode);
    }

    @Test
    public void loginLogoutTest() throws JsonProcessingException {
        // 默认情况下访问 /api/status 处于未登录状态
        // 发送验证码
        // 带着验证码进行登录，得到 Cookie
        // 带着 Cookie 访问 /api/status 应该处于登录接口
        // 调用 /api/logout
        // 再次带着 Cookie 访问 /api/status

        // 默认情况下访问 /api/status 处于未登录状态
        String statusResponse = HttpRequest.get(getUrl("/api/status"))
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .body();

        LoginResponse response = objectMapper.readValue(statusResponse, LoginResponse.class);
        Assertions.assertFalse(response.isLogin());

        // 发送验证码
        Map<String, String> telParam = new HashMap<>();
        telParam.put("tel", TelVerificationServiceTest.VALID_TEL);
        int responseCode = HttpRequest.post(getUrl("/api/code"))
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .send(objectMapper.writeValueAsString(telParam))
                .code();
        Assertions.assertEquals(HTTP_OK, responseCode);

        // 带着验证码进行登录，得到 Cookie
        Map<String, String> telAndCodeParam = new HashMap<>();
        telAndCodeParam.put("tel", TelVerificationServiceTest.VALID_TEL);
        telAndCodeParam.put("code", TelVerificationServiceTest.VALID_CODE);
        Map<String, List<String>> responseHeaders = HttpRequest.post(getUrl("/api/login"))
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .send(objectMapper.writeValueAsString(telAndCodeParam))
                .headers();
        List<String> setCookie = responseHeaders.get("Set-Cookie");
        Assertions.assertNotNull(setCookie);

        String sessionId = getSessionIdFromSetCookie(setCookie.stream()
                .filter(cookie->cookie.contains("JSESSIONID"))
                .findFirst()
                .get());

        // 带着 Cookie 访问 /api/status 应该处于登录接口
        statusResponse = HttpRequest.get(getUrl("/api/status"))
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .header("Cookie", sessionId)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .body();

        response = objectMapper.readValue(statusResponse, LoginResponse.class);
        Assertions.assertTrue(response.isLogin());
        Assertions.assertEquals(TelVerificationServiceTest.VALID_TEL, response.getUser().getTel());

        // 调用 /api/logout
        HttpRequest.post(getUrl("/api/logout"))
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .header("Cookie", sessionId)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .headers();

        // 再次带着 Cookie 访问 /api/status
        statusResponse = HttpRequest.get(getUrl("/api/status"))
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .header("Cookie", sessionId)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .body();
        response = objectMapper.readValue(statusResponse, LoginResponse.class);
        Assertions.assertFalse(response.isLogin());
    }

    private String getSessionIdFromSetCookie(String setCookie) {
        // 由 JSESSIONID=53568606-6a4b-4179-83fc-8e1d523586bb; Path=/; HttpOnly; SameSite=lax
        // 拿到 JSESSIONID=53568606-6a4b-4179-83fc-8e1d523586bb
        int semiColonIndex = setCookie.indexOf(";");

        return setCookie.substring(0, semiColonIndex);
    }

    private String getUrl(String apiName) {
        return "http://localhost:" + environment.getProperty("local.server.port") + apiName;
    }

}
