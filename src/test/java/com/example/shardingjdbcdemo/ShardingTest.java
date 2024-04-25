package com.example.shardingjdbcdemo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.shardingjdbcdemo.entity.Dict;
import com.example.shardingjdbcdemo.entity.Order;
import com.example.shardingjdbcdemo.entity.OrderItem;
import com.example.shardingjdbcdemo.entity.User;
import com.example.shardingjdbcdemo.mapper.DictMapper;
import com.example.shardingjdbcdemo.mapper.OrderItemMapper;
import com.example.shardingjdbcdemo.mapper.OrderMapper;
import com.example.shardingjdbcdemo.mapper.UserMapper;
import com.example.shardingjdbcdemo.vo.OrderItemVo;
import javafx.scene.layout.BorderImage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

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

    @Autowired
    private OrderItemMapper orderItemMapper;

    @Autowired
    private DictMapper dictMapper;

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
        for (long i = 1; i < 5; i++) {
            Order order = new Order();
            order.setAmount(new BigDecimal(100));
            order.setUserId(1L);
            order.setOrderNo("GEEK00" + i);
            orderMapper.insert(order);
        }

        for (long i = 5; i < 9; i++) {
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

    @Test
    public void testInsertOrderAndOrderItem() {
        for (long i = 1; i < 5; i++) {
            Order order = new Order();
            order.setAmount(new BigDecimal(100));
            order.setUserId(1L);
            order.setOrderNo("GEEK00" + i);
            orderMapper.insert(order);

            for (int i1 = 0; i1 < 3; i1++) {
                OrderItem orderItem = new OrderItem();
                orderItem.setOrderNo("GEEK00" + i);
                orderItem.setUserId(1L);
                orderItem.setPrice(new BigDecimal(100));
                orderItem.setCount(3);
                orderItemMapper.insert(orderItem);
            }
        }

        for (long i = 5; i < 9; i++) {
            Order order = new Order();
            order.setAmount(new BigDecimal(100));
            order.setUserId(2L);
            order.setOrderNo("GEEK00" + i);
            orderMapper.insert(order);

            for (int i1 = 0; i1 < 3; i1++) {
                OrderItem orderItem = new OrderItem();
                orderItem.setOrderNo("GEEK00" + i);
                orderItem.setUserId(2L);
                orderItem.setPrice(new BigDecimal(99));
                orderItem.setCount(2);
                orderItemMapper.insert(orderItem);
            }
        }
    }

    @Test
    public void orderAmount() {
        List<OrderItemVo> orderItemVoList = orderMapper.orderAmount();
        orderItemVoList.forEach(System.out::println);
    }

    /**
     * 广播表插入测试
     * 会同时向所有数据源做插入操作，保持所有数据源为最新副本
     */
    @Test
    public void testInsertBroadcast() {
        Dict dict = new Dict();
        dict.setDictType("电子产品类");
        dictMapper.insert(dict);
    }

    /**
     * 广播表查询操作
     * 根据负载均衡算法只会查询一个数据源
     */
    @Test
    public void testSelectBroadcast() {
        dictMapper.selectList(null).forEach(System.out::println);
    }
}

