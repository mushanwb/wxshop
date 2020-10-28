package com.mushanwb.github.wxshop.service;

import org.springframework.stereotype.Service;

@Service
public class MockSmsCodeService implements SmsCodeService {

    /**
     * 使用假的测试数据，让每一个手机号都返回 000000，
     * 真实情况下，是不允许这么做的
     * 要考虑手机运营商发短信的次数（限流），以及防止暴力破解（用户输入的次数）
     * @param tel 目标手机号
     * @return 返回的验证码
     */
    @Override
    public String sendSmsCode(String tel) {
        return "000000";
    }

}
