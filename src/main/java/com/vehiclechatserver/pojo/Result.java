package com.vehiclechatserver.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

/*
 * 
 */
@Data
@AllArgsConstructor
public class Result { 
    private int code;
    private String message;
    private Object data;
}