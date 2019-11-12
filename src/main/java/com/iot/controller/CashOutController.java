package com.iot.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 直营商户／代理商提现
 *
 * @author fuyang
 * @date 2019/10/24
 */
@RestController
@RequestMapping("iot")
@Api(tags = {"提现操作"})
public class CashOutController {

    @GetMapping("/login/{id}")
    public void login(){

    }

    @PostMapping("/ydCashOut")
    @ApiOperation(value = "友电企业提现",notes = "友电直营企业有票提现")
    public void ydCashOut(){

    }
}
