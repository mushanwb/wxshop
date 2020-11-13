package com.mushanwb.github.wxshop.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.kevinsawicki.http.HttpRequest;
import com.mushanwb.github.wxshop.WxshopApplication;
import com.mushanwb.github.wxshop.entity.LoginResponse;
import com.mushanwb.github.wxshop.service.TelVerificationServiceTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.HashMap;
import java.util.Map;

import static java.net.HttpURLConnection.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = WxshopApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)    //随机端口
@TestPropertySource(properties = { "spring.config.location=classpath:test-application.yml" })    // 测试数据库配置
public class AuthIntegrationTest extends AbstractIntegrationTest {

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
        // 发送验证码
        // 带着验证码进行登录，得到 Cookie
        String sessionId = loginAndGetCookie();

        // 带着 Cookie 访问 /api/status 应该处于登录接口
        String statusResponse = doHttpRequest("/api/status", true, null, sessionId).body;

        LoginResponse response = objectMapper.readValue(statusResponse, LoginResponse.class);
        Assertions.assertTrue(response.isLogin());
        Assertions.assertEquals(TelVerificationServiceTest.VALID_TEL, response.getUser().getTel());

        // 调用 /api/logout
        doHttpRequest("/api/logout", false, null, sessionId);

        // 再次带着 Cookie 访问 /api/status
        statusResponse = doHttpRequest("/api/status", true, null, sessionId).body;
        response = objectMapper.readValue(statusResponse, LoginResponse.class);
        Assertions.assertFalse(response.isLogin());
    }

    @Test
    public void returnUnauthorizedIfNotLogin() throws JsonProcessingException {
        int responseCode = doHttpRequest("/api/any", true, null, null).code;
        Assertions.assertEquals(HTTP_UNAUTHORIZED, responseCode);

    }



}
