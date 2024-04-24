package com.example.shardingjdbcdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.shardingjdbcdemo.entity.Order;
import com.example.shardingjdbcdemo.entity.User;
import com.example.shardingjdbcdemo.vo.OrderItemVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author zhaojingchao
 * @Date 2024/04/22 13:45
 * @Email zhaojingchao@joysuch.com
 * @Desc
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {

    /**
     * 计算订单总金额
     * @return
     */
    @Select({"select o.order_no, SUM(oi.price * oi.count) as amount " +
            "from t_order as o left join t_order_item as oi on o.order_no = oi.order_no " +
            "group by o.order_no"})
    List<OrderItemVo> orderAmount();
}
