package com.iot.domain;

import io.swagger.annotations.ApiParam;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.*;

/**
 * This is Description
 *
 * @author fuyang
 * @date 2019/10/20
 */
@Entity
public class Luckymoney {
    @Id
    @GeneratedValue
    private Integer id;

    @ApiParam(value = "红包金额")
    @Min(value = 10,message = "最小金额不能小于10")
    @Max(value = 200,message = "最大金额不能大于200")
    @NotNull(message = "金额字段为必传字段！！！")
    private BigDecimal money;

    private String producer;


    private String consumer;

    public Luckymoney() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getConsumer() {
        return consumer;
    }

    public void setConsumer(String consumer) {
        this.consumer = consumer;
    }

    @Override
    public String toString() {
        return "Luckymoney{" +
                "id=" + id +
                ", money=" + money +
                ", producer='" + producer + '\'' +
                ", consumer='" + consumer + '\'' +
                '}';
    }
}
