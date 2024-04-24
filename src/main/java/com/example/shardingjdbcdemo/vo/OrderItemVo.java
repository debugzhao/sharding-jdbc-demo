package com.example.shardingjdbcdemo.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author zhaojingchao
 * @Date 2024/04/24 11:14
 * @Email zhaojingchao@joysuch.com
 * @Desc
 */
@Data
public class OrderItemVo {
    private String orderNo;
    private BigDecimal amount;
}
