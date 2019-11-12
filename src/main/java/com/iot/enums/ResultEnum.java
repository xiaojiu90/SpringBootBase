package com.iot.enums;

/**
 * 为接口返回的code和message定义枚举
 * 方便统一管理
 * @author fuyang
 * @date 2019/10/31
 */
public enum ResultEnum {
    UNKNOW_ERROR(-1,"未知错误"),
    SUCCESS(0,"成功"),
    PRODUCER_ERROR(100,"发送人错误"),
    AMOUNT_ERROR(101,"发送金额错误"),
    PARAM_ERROR(102,"未查询到结果");

    private Integer code;
    private String message;

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
