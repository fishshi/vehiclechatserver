package com.vehiclechatserver.service;

import com.vehiclechatserver.pojo.User;

public interface UserService {
    int register(User user);
    
    int login(User user);
}