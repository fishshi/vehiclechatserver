package com.vehiclechatserver.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.vehiclechatserver.pojo.User;

@Mapper
public interface UserMapper {
    /**
     * 根据用户名查询用户信息
     * 
     * @param username 用户名
     * @return 用户信息 {@link User}
     */
    @Select("SELECT * FROM user WHERE username = #{username}")
    public User getUserByUsername(String username);

    /**
     * 插入用户信息
     * 
     * @param user 用户信息 {@link User}
     */
    @Insert("INSERT INTO user(username, password) VALUES(#{username}, #{password})")
    public void insertUser(User user);
}