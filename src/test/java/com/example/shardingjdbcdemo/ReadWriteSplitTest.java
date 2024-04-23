package com.example.shardingjdbcdemo;

import com.example.shardingjdbcdemo.entity.Order;
import com.example.shardingjdbcdemo.entity.User;
import com.example.shardingjdbcdemo.mapper.OrderMapper;
import com.example.shardingjdbcdemo.mapper.UserMapper;
import org.apache.calcite.linq4j.Ord;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author zhaojingchao
 * @Date 2024/04/22 15:06
 * @Email zhaojingchao@joysuch.com
 * @Desc
 */
@SpringBootTest
public class ReadWriteSplitTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Test
    public void testInsert() {
        User user = new User();
        user.setUname("赵静超");
        userMapper.insert(user);
    }

    /**
     * 事务测试
     */
    @Test
    @Transactional
    public void testTrans() {
        User user = new User();
        user.setUname("赵静超");
        userMapper.insert(user);

        // 查询所有数据
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }

    @Test
    public void testInsertUserAndOrder() {
        User user = new User();
        user.setUname("赵静超");
        userMapper.insert(user);

        Order order = new Order();
        order.setOrderNo("202204221506");
        order.setUserId(user.getId());
        order.setAmount(new BigDecimal(100));
        orderMapper.insert(order);
    }

    @Test
    public void testSelectData() {
        User user = userMapper.selectById(1);
        System.out.println(user);
        Order order = orderMapper.selectById(1);
        System.out.println(order);
    }
}
