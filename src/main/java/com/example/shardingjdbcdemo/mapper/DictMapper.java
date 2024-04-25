package com.example.shardingjdbcdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.shardingjdbcdemo.entity.Dict;
import com.example.shardingjdbcdemo.entity.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author zhaojingchao
 * @Date 2024/04/25 23:29
 * @Email zhaojingchao@joysuch.com
 * @Desc
 */
@Mapper
public interface DictMapper extends BaseMapper<Dict> {
}
