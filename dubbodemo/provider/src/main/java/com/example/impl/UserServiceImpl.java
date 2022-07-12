package com.example.impl;

import com.example.entity.User;
import com.example.service.UserService;
import org.apache.dubbo.config.annotation.DubboService;

import java.util.Arrays;
import java.util.List;

/**
 * 3.0x后dubbo @Service 为了和 spring的 @Service区分，改为了 @DubboService，相应的 @Reference
 * 也改为了 @DubboReference
 */
@DubboService
public class UserServiceImpl implements UserService {

    // 模拟数据
    private static final List<User> USERS = Arrays.asList(
            new User(1, "张三"),
            new User(2, "李四")
    );

    @Override
    public User getByUserId(Integer userId) {
        for (User user : USERS) {
            if (user.getUserId().equals(userId)) {
                return user;
            }
        }
        return null;
    }
}