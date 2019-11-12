package com.iot.controller;

import com.iot.config.*;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * This is Description
 *
 * @author 芙杨
 * @date 2019/09/01
 */
@RestController
@RequestMapping("hello")
@Api(tags = {"Demo"})
public class HelloController {
    public String contents;
    @Autowired
    private LimitConfig limitConfig;

    @GetMapping("/say")
    public String say(@RequestParam(value = "id",required = false,defaultValue = "0")Integer id){
        return "说明:"+limitConfig.getDescription();

    }

}
