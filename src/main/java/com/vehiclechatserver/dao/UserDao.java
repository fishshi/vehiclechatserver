package com.vehiclechatserver.dao;

import com.vehiclechatserver.pojo.User;

public interface UserDao {
    /**
     * 通过用户名查找用户
     * 
     * @param username 用户名
     * @return User 用户对象{@link User}
     */
    public User findUserByUsername(String username);

    /**
     * 添加用户
     * 
     * @param user 用户对象{@link User}
     */
    public void addUser(User user);
}