package com.lkq.lkqcrm.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lkq.lkqcrm.entity.Orders;
import com.lkq.lkqcrm.mapper.OrdersBusinessCustomerMapper;
import com.lkq.lkqcrm.mapper.OrdersMapper;
import com.lkq.lkqcrm.service.OrdersService;
import com.lkq.lkqcrm.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements OrdersService {
    @Autowired
    private OrdersMapper ordersMapper;

    @Override
    public IPage<Orders> selectList(Page<Orders> page) {
        return ordersMapper.selectList(page);
    }
    @Override
    public Orders selectByName(String businessName) {
        return ordersMapper.selectByName(businessName);
    }

    @Override
    public Integer add(Orders orders,Integer businessId,Integer customerId) {
        orders.setCreateTime(StringUtils.getNowTime());
        orders.setUpdateTime(orders.getCreateTime());  //获取创建时间，可以提高一点性能
        orders.setIsDel(0);
        int result =  ordersMapper.insert(orders);
        return result;
    }

}
