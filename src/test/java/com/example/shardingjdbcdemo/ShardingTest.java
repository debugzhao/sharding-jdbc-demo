package com.example.shardingjdbcdemo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
        for (long i = 100; i < 104; i++) {
            Order order = new Order();
            order.setAmount(new BigDecimal(100));
            order.setUserId(2L);
            order.setOrderNo("GEEK00" + i);
            orderMapper.insert(order);
        }
    }

    /**
     * 查询所有的订单数据
     */
    @Test
    public void listAllOrder() {
        orderMapper.selectList(null).forEach(System.out::println);
    }

    @Test
    public void listOrderByUserId() {
        QueryWrapper<Order> wrapper = new QueryWrapper<Order>().eq("user_id", 1L);
        orderMapper.selectList(wrapper).forEach(System.out::println);
    }

}

