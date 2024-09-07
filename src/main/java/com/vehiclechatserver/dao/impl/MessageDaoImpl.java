package com.vehiclechatserver.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vehiclechatserver.dao.MessageDao;
import com.vehiclechatserver.mapper.MessageMapper;
import com.vehiclechatserver.pojo.Message;

@Repository
public class MessageDaoImpl implements MessageDao {
    @Autowired
    private MessageMapper messageMapper;

    @Override
    public void addMessage(Message message) {
        messageMapper.insertMessage(message);
    }
}