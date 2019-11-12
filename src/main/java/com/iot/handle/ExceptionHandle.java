package com.iot.handle;

import com.iot.domain.*;
import com.iot.exception.*;
import com.iot.utils.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 定义一个异常捕获类
 * 对捕获到的类进行字段返回值的处理
 * @author fuyang
 * @date 2019/10/30
 */
@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        LuckymoneyException luckymoneyException = (LuckymoneyException) e;
        //如果捕获到的异常类是LuckymoneyException抛出的则走下面判断
        if (e instanceof LuckymoneyException){
            return ResultUtil.error(luckymoneyException.getCode(),luckymoneyException.getMessage());
        }else {
            logger.error("【系统异常】{}",e);
            return ResultUtil.error(-1,"未知错误");
        }

    }
}
