package com.iot.utils;

import com.iot.domain.*;

/**
 * 为接口返回的字段赋值
 * 返回Result.java对象
 * @author fuyang
 * @date 2019/10/29
 */
public class ResultUtil {
    public static Result success(Object object){
        Result result = new Result();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }

    public static Result success(){
        return success(null);
    }

    public static Result error(Integer code,String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
