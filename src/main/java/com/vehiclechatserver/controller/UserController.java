package com.vehiclechatserver.controller;

import org.springframework.web.bind.annotation.RestController;

import com.vehiclechatserver.pojo.Result;
import com.vehiclechatserver.pojo.User;
import com.vehiclechatserver.service.UserService;
import com.vehiclechatserver.utils.JwtUtils;
import com.vehiclechatserver.utils.ResultUtils;
import com.vehiclechatserver.utils.SHA256Utils;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 注册
     * 
     * @param user 用户信息
     * @return {@link Result}
     */
    @PostMapping("/register")
    public Result register(@RequestBody User user) {
        if (user.getUsername() == null || user.getPassword() == null)
            return ResultUtils.error("缺失参数");
        user.setPassword(SHA256Utils.sha256(user.getPassword()));
        if (userService.register(user) == 1)
            return ResultUtils.success();
        else
            return ResultUtils.error("注册失败，用户名重复");
    }

    /**
     * 登陆
     * 
     * @param user 用户信息
     * @return {@link Result}
     */
    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        if (user.getUsername() == null || user.getPassword() == null)
            return ResultUtils.error("缺失参数");
        user.setPassword(SHA256Utils.sha256(user.getPassword()));
        if (userService.login(user) == 1) {
            String jwt = JwtUtils.generateJwt(new HashMap<String, Object>() {
                {
                    put("username", user.getUsername());
                }
            });
            return ResultUtils.success(jwt);
        } else
            return ResultUtils.error("登陆失败，用户名或密码错误");
    }
}
