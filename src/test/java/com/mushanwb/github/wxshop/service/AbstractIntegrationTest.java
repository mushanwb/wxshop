package com.mushanwb.github.wxshop.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.kevinsawicki.http.HttpRequest;
import com.mushanwb.github.wxshop.entity.LoginResponse;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.configuration.ClassicConfiguration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.core.env.Environment;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.net.HttpURLConnection.HTTP_OK;

public class AbstractIntegrationTest {
    @Autowired
    Environment environment;

    @Value("${spring.datasource.url}")
    private String databaseUrl;
    @Value("${spring.datasource.username}")
    private String databaseUsername;
    @Value("${spring.datasource.password}")
    private String databasePassword;


    @BeforeEach
    public void initDatabase() {
        // 在每个测试开始前，执行一次 flyway:clean flyway:migrate
        ClassicConfiguration conf = new ClassicConfiguration();
        conf.setDataSource(databaseUrl, databaseUsername, databasePassword);
        Flyway flyway = new Flyway(conf);
        flyway.clean();
        flyway.migrate();
    }

    public ObjectMapper objectMapper = new ObjectMapper();

    public String getUrl(String apiName) {
        return "http://localhost:" + environment.getProperty("local.server.port") + apiName;
    }

    public static class HttpResponse {
        int code;
        String body;
        Map<String, List<String>> headers;

        public HttpResponse(int code, String body, Map<String, List<String>> headers) {
            this.code = code;
            this.body = body;
            this.headers = headers;
        }
    }

    public HttpResponse doHttpRequest(String apiName, boolean isGet, Object requestBody, String cookie) throws JsonProcessingException {
        HttpRequest request = isGet ? HttpRequest.get(getUrl(apiName)) : HttpRequest.post(getUrl(apiName));

        if (cookie != null) {
            request.header("Cookie", cookie);
        }

        request.contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE);

        if (requestBody != null) {
            request.send(objectMapper.writeValueAsString(requestBody));
        }
        return new HttpResponse(request.code(), request.body(), request.headers());
    }

    // 默认情况下访问 /api/status 处于未登录状态
    // 发送验证码
    // 带着验证码进行登录，得到 Cookie
    public String loginAndGetCookie() throws JsonProcessingException {
        String statusResponse = doHttpRequest("/api/status", true, null, null).body;
        LoginResponse response = objectMapper.readValue(statusResponse, LoginResponse.class);
        Assertions.assertFalse(response.isLogin());

        // 发送验证码
        Map<String, String> telParam = new HashMap<>();
        telParam.put("tel", TelVerificationServiceTest.VALID_TEL);
        int responseCode = doHttpRequest("/api/code", false, telParam, null).code;
        Assertions.assertEquals(HTTP_OK, responseCode);

        // 带着验证码进行登录，得到 Cookie
        Map<String, String> telAndCodeParam = new HashMap<>();
        telAndCodeParam.put("tel", TelVerificationServiceTest.VALID_TEL);
        telAndCodeParam.put("code", TelVerificationServiceTest.VALID_CODE);
        Map<String, List<String>> responseHeaders = doHttpRequest("/api/login", false, telAndCodeParam, null).headers;
        List<String> setCookie = responseHeaders.get("Set-Cookie");
        Assertions.assertNotNull(setCookie);

        return getSessionIdFromSetCookie(setCookie.stream()
                .filter(cookie->cookie.contains("JSESSIONID"))
                .findFirst()
                .get());
    }

    protected String getSessionIdFromSetCookie(String setCookie) {
        // 由 JSESSIONID=53568606-6a4b-4179-83fc-8e1d523586bb; Path=/; HttpOnly; SameSite=lax
        // 拿到 JSESSIONID=53568606-6a4b-4179-83fc-8e1d523586bb
        int semiColonIndex = setCookie.indexOf(";");

        return setCookie.substring(0, semiColonIndex);
    }

}
