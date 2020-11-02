package com.mushanwb.github.wxshop.service;

import com.mushanwb.github.wxshop.generate.User;

public class UserContext {
    private static ThreadLocal<User> currentUser = new ThreadLocal<>();

    public static User getCurrentUser() {
        return currentUser.get();
    }

    public static void setCurrentUser(User user) {
        currentUser.set(user);
    }

}
