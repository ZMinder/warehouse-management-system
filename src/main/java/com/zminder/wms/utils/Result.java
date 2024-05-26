package com.zminder.wms.utils;

import lombok.Data;

@Data
public class Result<T> {//后端返回给前端封装成的数据
    private Integer code;//业务状态码
    private String message;//业务状态描述信息
    private T data;//响应给前端的数据

    public Result(ResultCode resultCode, T data) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
        this.data = data;
    }

    public static <E> Result<E> success(E data) {
        return new Result<>(ResultCode.SUCCESS, data);
    }

    public static <E> Result<E> error(ResultCode resultCode, E data) {
        return new Result<>(resultCode, data);
    }

    public static <E> Result<E> fail(E data) {
        return new Result<>(ResultCode.FAILED, data);
    }
}
