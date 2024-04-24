package com.example.shardingjdbcdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.shardingjdbcdemo.entity.Order;
import com.example.shardingjdbcdemo.entity.OrderItem;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author zhaojingchao
 * @Date 2024/04/22 13:45
 * @Email zhaojingchao@joysuch.com
 * @Desc
 */
@Mapper
public interface OrderItemMapper extends BaseMapper<OrderItem> {
}
