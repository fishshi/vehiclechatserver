package com.vehiclechatserver.dao;

import com.vehiclechatserver.pojo.User;

public interface UserDao {
    public User findUserByUsername(String username);

    public void addUser(User user);
}