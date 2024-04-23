package com.example.shardingjdbcdemo;

import com.example.shardingjdbcdemo.entity.Order;
import com.example.shardingjdbcdemo.entity.User;
import com.example.shardingjdbcdemo.mapper.OrderMapper;
import com.example.shardingjdbcdemo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

/**
 * @Author zhaojingchao
 * @Date 2024/04/23 14:10
 * @Email zhaojingchao@joysuch.com
 * @Desc
 */
@SpringBootTest
public class ShardingTest {

    @Autowired
    private OrderMapper orderMapper;


    /**
     * 水平分片测试
     */
    @Test
    public void testInsertOrder() {
        String test = "b38ea4a2-0157-11ef-b4e1-0242ac64fa0a";
        System.out.println(test.length());
    }

    /**
     * 水平分库测试
     */
    @Test
    public void testInsertOrderDataStrategy() {
        for (long i = 4; i < 8; i++) {
            Order order = new Order();
            order.setAmount(new BigDecimal(100));
            order.setUserId(i + 1);
            order.setOrderNo("123456");
            orderMapper.insert(order);
        }
    }
}

