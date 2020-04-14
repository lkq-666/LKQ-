package com.lkq.lkqcrm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lkq.lkqcrm.entity.Orders;
import com.lkq.lkqcrm.entity.Role;


public interface OrdersService extends IService<Orders> {
    IPage<Orders> selectList(Page<Orders> page);

    Orders selectByName(String businessName);

    Integer add(Orders orders, Integer businessId,Integer customerId);
}
