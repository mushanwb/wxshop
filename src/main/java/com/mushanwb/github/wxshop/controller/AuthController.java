package com.mushanwb.github.wxshop.controller;

import com.mushanwb.github.wxshop.entity.LoginResponse;
import com.mushanwb.github.wxshop.service.AuthService;
import com.mushanwb.github.wxshop.service.TelVerificationService;
import com.mushanwb.github.wxshop.service.UserContext;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class AuthController {
    private final AuthService authService;
    private TelVerificationService telVerificationService;

    @Autowired
    public AuthController(AuthService authService,
                          TelVerificationService telVerificationService) {
        this.telVerificationService = telVerificationService;
        this.authService = authService;
    }

    @PostMapping("/code")
    public void code(@RequestBody Map<String, String> param,
                     HttpServletResponse response) {
        String tel = param.get("tel");
        if (telVerificationService.verifyTelParameter(tel)) {
            authService.sendVerificationCode(tel);
        } else {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
        }
    }

    @PostMapping("/login")
    public void login(@RequestBody Map<String, String> param) {
        String tel = param.get("tel");
        String code = param.get("code");

        UsernamePasswordToken token = new UsernamePasswordToken(tel, code);

        SecurityUtils.getSubject().login(token);
    }

    @GetMapping("/status")
    public Object loginStatus() {
        if (UserContext.getCurrentUser() == null) {
            return LoginResponse.notLogin();
        } else {
            return LoginResponse.login(UserContext.getCurrentUser());
        }
    }

    @PostMapping("/logout")
    public void logout() {
        SecurityUtils.getSubject().logout();
    }

}



