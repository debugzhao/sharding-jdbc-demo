package com.example.shardingjdbcdemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author zhaojingchao
 * @Date 2024/04/22 13:45
 * @Email zhaojingchao@joysuch.com
 * @Desc
 */
@TableName("t_order")
@Data
public class Order {

    /**
     * 当配置了shardingsphere-jdbc的分布式序列时，自动使用shardingsphere-jdbc的分布式序列
     * 当没有配置shardingsphere-jdbc的分布式序列时，自动依赖数据库的主键自增策略
     */
    @TableId(type = IdType.AUTO)
     // @TableId(type = IdType.ASSIGN_ID) // 分布式id（默认值）
    private Long id;
    private String orderNo;
    private Long userId;
    private BigDecimal amount;
}
