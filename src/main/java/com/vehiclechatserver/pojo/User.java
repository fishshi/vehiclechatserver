package com.vehiclechatserver.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * @author fishshi
 * @apiNote
 *          id: 用户id
 *          username: 用户名
 *          password: 用户密码
 */
@Data
@AllArgsConstructor
@ToString
public class User {
    private int id;
    private String username;
    private String password;
}