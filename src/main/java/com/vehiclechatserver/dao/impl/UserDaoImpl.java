package com.vehiclechatserver.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vehiclechatserver.dao.UserDao;
import com.vehiclechatserver.mapper.UserMapper;
import com.vehiclechatserver.pojo.User;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User findUserByUsername(String username) {
        return userMapper.getUserByUsername(username);
    }

    @Override
    public void addUser(User user) {
        userMapper.insertUser(user);
    }

}
