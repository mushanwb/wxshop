package com.mushanwb.github.wxshop.controller;

import com.mushanwb.github.wxshop.service.AuthService;
import org.apache.catalina.security.SecurityUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class AuthController {
    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/code")
    @ResponseBody
    public void code(@RequestBody Map<String, String> param) {
        String tel = param.get("tel");
        authService.sendVerificationCode(tel);
    }

    @PostMapping("/login")
    public void login(@RequestBody Map<String, String> param) {
        String tel = param.get("tel");
        String code = param.get("code");

        UsernamePasswordToken token = new UsernamePasswordToken(tel, code);

        SecurityUtils.getSubject().login(token);
    }

}
