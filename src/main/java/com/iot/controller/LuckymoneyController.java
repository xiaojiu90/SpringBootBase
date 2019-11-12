package com.iot.controller;

import com.iot.domain.*;
import com.iot.enums.*;
import com.iot.exception.*;
import com.iot.repository.*;
import com.iot.service.*;
import com.iot.utils.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.*;
import java.util.*;

/**
 * 红包收发
 *
 * @author fuyang
 * @date 2019/09/23
 */
@RestController
@Api(tags = {"红包收发操作"})
public class LuckymoneyController {

    private final static Logger logger = LoggerFactory.getLogger(LuckymoneyController.class);

    @Autowired
    private LuckymoneyRepository repository;

    @Autowired
    private LuckymoneyService service;

    /**
     * 获取红包列表
     * @return
     */
    @GetMapping("/luckymoneys")
    @ApiOperation(value = "获取红包列表",notes = "获取所有红包信息")
    public List<Luckymoney> list(){
        //非空判断
        if (repository.findAll().isEmpty()){
            throw new LuckymoneyException(ResultEnum.PARAM_ERROR);
        }else {
            return repository.findAll();
        }
    }

    /**
     * 创建红包(发红包)
     * @return
     */
    @PostMapping("/createLuckymoney")
    @ApiOperation(value = "创建红包",notes = "发红包")
    public Result<Luckymoney> createLuckymoney (@Valid Luckymoney luckymoney,BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtil.success(repository.save(luckymoney));
    }

    /**
     * 通过id查询红包
     * @PathVariable注解为从url中获取参数
     * @param id
     * @return
     */
    @GetMapping("/selectLuckymoney/{id}")
    @ApiOperation(value = "通过id查询红包",notes = "获取指定红包信息")
    public Luckymoney selectLuckymoney(@ApiParam(name = "id",value = "主键ID")@PathVariable("id") Integer id){
        if (repository.findById(id).isPresent()){
            return repository.findById(id).get();
        }else {
            throw new LuckymoneyException(ResultEnum.PARAM_ERROR);
        }

    }

    /**
     * 更新红包（领红包）
     * @param id
     * @param consumer
     * @return
     */
    @PutMapping("/updateLuckymoney/{id}")
    @ApiOperation(value = "更新红包",notes = "发红包")
    public Luckymoney updateLuckymoney(@ApiParam(name ="id",value = "主键ID") @PathVariable("id") Integer id,
                                       @ApiParam(value = "红包接收方") @RequestParam("consumer") String consumer){
        Optional<Luckymoney> optional = repository.findById(id);
        if (optional.isPresent()){
            Luckymoney luckymoney = optional.get();
            luckymoney.setConsumer(consumer);
            return repository.save(luckymoney);
        }
        return null;
    }

    /**
     * 根据id删除对应红包
     * @param id
     * @return
     */
    @DeleteMapping("/deleteLuckymoney/{id}")
    @ApiOperation(value = "删除红包",notes = "根据id删除指定红包")
    public String deleteLuckymoney(@ApiParam(name ="id",value = "主键ID") @PathVariable("id") Integer id){
        repository.deleteById(id);
        throw new LuckymoneyException(ResultEnum.SUCCESS);
    }

    /**
     * 调用事务方法，同时创建两个红包
     */
    @PostMapping("/createTwo")
    @ApiOperation(value = "创建两个红包",notes = "同时创建两个红包")
    public Result<Luckymoney> createTwo(){
        service.createTwoLuckymoney();
        //需要优化为只返回创建成功的两条数据
        Sort sort = new Sort(Sort.Direction.DESC,"id");
        return ResultUtil.success(repository.findAll(sort).subList(0,2));
    }

    /**
     * 调用事务中的业务校验逻辑
     * @param id
     * @throws Exception
     */
    @GetMapping("/luckymoneys/getProducer/{id}")
    @ApiOperation(value = "获取红包发送人信息",notes = "校验发送人信息")
    public void getProducer(@ApiParam(name = "id",value = "主键ID") @PathVariable("id") Integer id) throws Exception {
        service.getMoney(id);
    }

}
