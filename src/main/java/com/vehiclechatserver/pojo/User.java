package com.vehiclechatserver.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author fishshi
 * @apiNote
 *          id: 用户id
 *          username: 用户名
 *          password: 用户密码
 */
@Data
@AllArgsConstructor
public class User {
    private int id;
    private String username;
    private String password;
}