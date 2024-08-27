package com.vehiclechatserver.service;

import com.vehiclechatserver.pojo.User;

public interface UserService {
    /**
     * 注册
     * 
     * @param user 用户信息
     * @return {@link User}
     */
    int register(User user);
    
    /**
     * 登录
     * 
     * @param user 用户信息
     * @return {@link User}
     */
    int login(User user);
}