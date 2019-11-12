package com.iot.service;

import com.iot.domain.*;
import com.iot.enums.*;
import com.iot.exception.*;
import com.iot.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.*;

/**
 * 数据库事务，同时成功或失败
 * ex:扣库存 > 创建订单 需同时成功或失败
 * @author fuyang
 * @date 2019/10/20
 */
@Service
public class LuckymoneyService {

    @Autowired
    private LuckymoneyRepository repository;

    @Transactional
    public void createTwoLuckymoney(){
        Luckymoney luckymoney1 = new Luckymoney();
        luckymoney1.setProducer("廖氏兄弟");
        luckymoney1.setMoney(new BigDecimal("20"));
        repository.save(luckymoney1);

        Luckymoney luckymoney2 = new Luckymoney();
        luckymoney2.setProducer("卢氏兄弟");
        luckymoney2.setMoney(new BigDecimal("14"));
        repository.save(luckymoney2);
    }

    /**
     * 校验红包发送人
     * @param id
     * @throws Exception
     */
    public void getMoney(Integer id) throws Exception{
        Luckymoney luckymoney = repository.findById(id).get();
        String producer = luckymoney.getProducer();
        if (producer.equals("echo")){
            throw new LuckymoneyException(ResultEnum.PRODUCER_ERROR);
        }else if (producer.equals("luke")){
            throw new LuckymoneyException(ResultEnum.AMOUNT_ERROR);
        }

    }

    /**
     * 通过id查询红包信息
     * @param id
     * @return
     */
    public Luckymoney findOne(Integer id){
        return repository.findById(id).get();
    }

}
