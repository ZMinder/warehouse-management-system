package com.zminder.wms.utils;

public enum ResultCode {
    SUCCESS(200, "Success"),
    FAILED(400, "Fail"),
    USER_NOT_EXISTS(405, "User not exist"),

    STORAGE_NOT_EXISTS(406, "Storage not exists"),
    GOODS_TYPE_NOT_EXISTS(406, "GoodsType not exists");

    private final int code;
    private final String message;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
