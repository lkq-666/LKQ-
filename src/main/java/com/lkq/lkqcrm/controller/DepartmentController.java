package com.lkq.lkqcrm.controller;


import com.lkq.lkqcrm.entity.Department;
import com.lkq.lkqcrm.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class DepartmentController {

    @Autowired
    private IDepartmentService departmentService;

    @GetMapping("/deptList")
    public List<Department> list(){
        return departmentService.list();
    }
}
