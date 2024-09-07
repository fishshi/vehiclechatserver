package com.vehiclechatserver.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.vehiclechatserver.pojo.Message;

@Mapper
public interface MessageMapper {
    @Insert("insert into messages(senderName, message) values(#{senderName}, #{message})")
    void insertMessage(Message m);    
}
