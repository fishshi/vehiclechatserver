package com.smarteducationserverside.utils;

import com.smarteducationserverside.pojo.Result;

/**
 * 向前端返回结果的工具类
 */
public class ResultUtils {
    /**
     * 成功返回无数据的结果
     * 
     * @return 成功的结果对象{@link Result}
     */
    public static Result success() {
        return new Result(1, null, null);
    }

    /**
     * 成功返回带数据的结果
     * 
     * @param data 成功返回的数据
     * @return 成功的结果对象{@link Result}
     */
    public static Result success(Object data) {
        return new Result(1, null, data);
    }

    /**
     * 失败返回带信息的结果
     * 
     * @param msg 失败的错误信息
     * @return 失败的结果对象{@link Result}
     */
    public static Result error(String msg) {
        return new Result(0, msg, null);
    }
}