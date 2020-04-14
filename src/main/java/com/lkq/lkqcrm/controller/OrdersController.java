package com.lkq.lkqcrm.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lkq.lkqcrm.entity.Orders;
import com.lkq.lkqcrm.entity.Role;
import com.lkq.lkqcrm.service.OrdersService;
import com.lkq.lkqcrm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class OrdersController {

    @Autowired
    private OrdersService service;

    @GetMapping("/role2")
    public List<Orders> roles(){

        return service.list();
    }
    /**
     *  查询一页员工信息
     * @param page 当前页码
     * @param limit 每页记录数
     * @return
     */

    @GetMapping("/orders")
    public Map getList(Integer page,Integer limit ){
        Map<String,Object> map = new HashMap<String,Object>();
        //设置mybatisPlus分页
        Page<Orders> p = new Page<Orders>();
        p.setSize(limit);
        p.setCurrent(page);
        IPage<Orders> iPage = service.selectList(p);
        map.put("msg","查询情况");
        map.put("count",iPage.getTotal());
        map.put("data",iPage.getRecords());
        map.put("code",0);
        return map;
    }
    /**
     *  新增用户
     */
    @PostMapping("/ordersAdd")
    public Map add(Orders orders,Integer businessId,Integer customerId){
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("state",service.add(orders,businessId,customerId));
        return result;
    }



    /**
     *  删除用户
     */
    @DeleteMapping("/orders/del/{ordersId}")
    public Map del(@PathVariable Integer ordersId){
        Orders orders = new Orders();
        orders.setOrdersId(ordersId);
        orders.setIsDel(1);
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("state",service.updateById(orders));
        return result;
    }


}
