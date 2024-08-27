package com.vehiclechatserver.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * 封装返回结果
 * 
 * @author fishshi
 * @apiNote
 *          code: 1表示成功, 0表示失败
 *          message: 成功或失败的提示信息
 *          data: 成功时返回的数据, 失败时返回错误信息
 */
@Data
@AllArgsConstructor
@ToString
public class Result {
    private int code;
    private String message;
    private Object data;
}