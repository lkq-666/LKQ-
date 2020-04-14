package com.lkq.lkqcrm.service.impl;

import com.baomidou.mybatisplus.core.conditions.AbstractWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lkq.lkqcrm.entity.*;

import com.lkq.lkqcrm.mapper.*;

import com.lkq.lkqcrm.service.CustomerService;
import com.lkq.lkqcrm.service.EmployeeService;
import com.lkq.lkqcrm.service.RoleService;
import com.lkq.lkqcrm.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService {
    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private CustEmpMapper custEmpMapper;

    @Override
    public IPage<Customer> selectList(Page<Customer> page) {
        return customerMapper.selectList(page);
    }

    @Override
    public Customer selectByName(String customerName) {
        return customerMapper.selectByName(customerName);
    }

    @Override
    public Integer add(Customer customer, Integer empId) {
        customer.setCreateTime(StringUtils.getNowTime());
        customer.setUpdateTime(customer.getCreateTime());  //获取创建时间，可以提高一点性能
        customer.setIsDel(0);
        int result =  customerMapper.insert(customer);
        int customerId = customer.getCustomerId();  //获取插入自增的id
        //将roleId和deptId一同插入到  员工与角色关系表
        CustEmp custEmp = new CustEmp(customerId,empId);
        custEmp.setCreateTime(StringUtils.getNowTime());
        custEmp.setUpdateTime(custEmp.getCreateTime());
        custEmp.setIsDel(0);
        custEmpMapper.insert(custEmp);
        return result;
    }

    /*@Override
    public Integer update(Customer customer, Integer empId) {
        return null;
    }*/


    @Override
    public Integer update(Customer customer, Integer empId) {
        customer.setCreateTime(StringUtils.getNowTime());
        int result = customerMapper.updateById(customer);
        CustEmp custEmp = new CustEmp(customer.getCustomerId(),empId);
        custEmp.setUpdateTime(StringUtils.getNowTime());
        AbstractWrapper wrapper = new QueryWrapper();
        wrapper.eq("customer_id",customer.getCustomerId());
        custEmpMapper.update(custEmp,wrapper);
        return result;
    }
}