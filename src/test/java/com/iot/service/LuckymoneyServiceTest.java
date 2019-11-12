package com.iot.service;

import com.iot.domain.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 单元测试
 * 基于事务中的校验
 * @author fuyang
 * @date 2019/11/10
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LuckymoneyServiceTest {

    @Autowired
    private LuckymoneyService luckymoneyService;

    @Test
    public void findOneTest(){
        Luckymoney luckymoney = luckymoneyService.findOne(30);
        Assert.assertEquals("echo",luckymoney.getProducer());
    }

}
