package com.mushanwb.github.wxshop.service;

import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class TelVerificationService {

    private static Pattern TEL_PATTERN = Pattern.compile("1\\d{10}");

    /**
     * 验证输入得参数是否合法
     * tel 必须存在且为合法的中国大陆手机号
     * @param tel  输入得手机号
     * @return  true 合法，否则返回 false
     */
    public boolean verifyTelParameter(String tel) {
        if (tel == null) {
            return false;
        } else {
            return TEL_PATTERN.matcher(tel).find();
        }
    }

}
