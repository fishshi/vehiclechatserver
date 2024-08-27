package com.vehiclechatserver.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.vehiclechatserver.pojo.User;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM user WHERE username = #{username}")
    public User getUserByUsername(String username);

    @Insert("INSERT INTO user(username, password) VALUES(#{username}, #{password})")
    public void insertUser(User user);
}