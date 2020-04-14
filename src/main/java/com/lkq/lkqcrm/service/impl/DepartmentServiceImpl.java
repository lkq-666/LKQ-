package com.lkq.lkqcrm.service.impl;

import com.lkq.lkqcrm.entity.Department;
import com.lkq.lkqcrm.mapper.DepartmentMapper;
import com.lkq.lkqcrm.service.IDepartmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements IDepartmentService {

}
