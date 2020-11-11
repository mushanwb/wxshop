package com.mushanwb.github.wxshop.dao;

import com.mushanwb.github.wxshop.generate.User;
import com.mushanwb.github.wxshop.generate.UserExample;
import com.mushanwb.github.wxshop.generate.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDao {
    private final UserMapper userMapper;

    @Autowired
    public UserDao(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public void insertUser(User user) {
        userMapper.insert(user);
    }

    public User getUserByTel(String tel) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andTelEqualTo(tel);
        return userMapper.selectByExample(userExample).get(0);
    }
}
