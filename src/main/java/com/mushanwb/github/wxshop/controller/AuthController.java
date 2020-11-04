package com.mushanwb.github.wxshop.controller;

import com.mushanwb.github.wxshop.generate.User;
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

    public static class LoginResponse {
        private boolean login = false;
        private User user;

        public static LoginResponse notLogin() {
            return new LoginResponse(false, null);
        }

        public static LoginResponse login(User user) {
            return new LoginResponse(true, user);
        }

        private LoginResponse(boolean login, User user) {
            this.login = login;
            this.user = user;
        }

        public User getUser() {
            return user;
        }

        public boolean isLogin() {
            return login;
        }

    }

    @GetMapping("/status")
    public Object loginStatus() {
        if (UserContext.getCurrentUser() == null) {
            return LoginResponse.notLogin();
        } else {
            return LoginResponse.login(UserContext.getCurrentUser());
        }
    }

}



