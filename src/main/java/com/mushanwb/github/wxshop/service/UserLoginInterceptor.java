package com.mushanwb.github.wxshop.service;

import com.mushanwb.github.wxshop.generate.User;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class UserLoginInterceptor implements HandlerInterceptor {
    private final UserService userService;

    @Autowired
    public UserLoginInterceptor(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object tel = SecurityUtils.getSubject().getPrincipals();
        if (tel != null) {
            // 说明已经登录了
            User user = userService.getUserByTel(tel.toString());
            // 放入上下文
            UserContext.setCurrentUser(user);
        }

        System.out.println("preHandle");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        // 线程用完后需要将上下文清理掉，因为线程是会被服用的（非常非常重要）
        UserContext.setCurrentUser(null);
    }
}
