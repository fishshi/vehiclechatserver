package com.vehiclechatserver.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehiclechatserver.dao.UserDao;
import com.vehiclechatserver.pojo.User;
import com.vehiclechatserver.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public int register(User user) {
        if (userDao.findUserByUsername(user.getUsername()) == null) {
            userDao.addUser(user);
            return 1;
        }
        return 0;
    }

    @Override
    public int login(User user) {
        User findUser = userDao.findUserByUsername(user.getUsername());
        if (findUser == null || !findUser.getPassword().equals(user.getPassword()))
            return 0;
        else
            return 1;
    }
}