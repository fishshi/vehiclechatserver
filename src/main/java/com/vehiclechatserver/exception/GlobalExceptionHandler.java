package com.vehiclechatserver.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.vehiclechatserver.pojo.Result;
import com.vehiclechatserver.utils.ResultUtils;

/**
 * 全局异常处理器
 */
@RestControllerAdvice // 相当于 @ControllerAdvice + @ResponseBody
public class GlobalExceptionHandler {
    @ExceptionHandler(Throwable.class) // 指定捕获异常类型（所有错误 + 异常）
    public Result ex(Throwable e) {
        e.printStackTrace();
        return ResultUtils.error("未知错误，请联系系统管理员");
    }
}