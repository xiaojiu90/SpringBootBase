package com.iot.exception;

import com.iot.enums.*;

/**
 * 部分异常的情况不满足Result.java定义的格式，需单独处理
 * 自定义异常类，需传入code和message
 * @author fuyang
 * @date 2019/10/30
 */
public class LuckymoneyException extends RuntimeException{

    private Integer code;

    public LuckymoneyException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
