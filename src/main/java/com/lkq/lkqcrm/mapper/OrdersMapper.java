package com.lkq.lkqcrm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lkq.lkqcrm.entity.Orders;
import com.lkq.lkqcrm.entity.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersMapper extends BaseMapper<Orders> {
    IPage<Orders> selectList(Page<Orders> page);

    Orders selectByName(String businessName);
}