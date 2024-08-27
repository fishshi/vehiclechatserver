package com.vehiclechatserver.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Message {
    private User sender;
    private String content;
    private String time;
}