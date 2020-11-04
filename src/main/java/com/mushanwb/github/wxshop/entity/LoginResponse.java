package com.mushanwb.github.wxshop.entity;

import com.mushanwb.github.wxshop.generate.User;

public class LoginResponse {
    private boolean login = false;
    private User user;

    public static LoginResponse notLogin() {
        return new LoginResponse(false, null);
    }

    public static LoginResponse login(User user) {
        return new LoginResponse(true, user);
    }

    public LoginResponse() {
        
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
