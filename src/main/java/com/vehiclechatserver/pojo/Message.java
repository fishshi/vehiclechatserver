package com.vehiclechatserver.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
public class Message {
    private int id;
    private String senderName;
    private String message;
    private Timestamp sendTime;
}