package com.example.shardingjdbcdemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Author zhaojingchao
 * @Date 2024/04/25 23:27
 * @Email zhaojingchao@joysuch.com
 * @Desc
 */
@Data
@TableName("t_dict")
public class Dict {

    /**
     * 可以使用MP雪花算法
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    private String dictType;
}
