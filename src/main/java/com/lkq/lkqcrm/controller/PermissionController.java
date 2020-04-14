package com.lkq.lkqcrm.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lkq.lkqcrm.entity.Employee;
import com.lkq.lkqcrm.entity.Permission;
import com.lkq.lkqcrm.entity.Role;
import com.lkq.lkqcrm.mapper.PermissionMapper;
import com.lkq.lkqcrm.service.IPermissionService;
import com.lkq.lkqcrm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PermissionController {
    @Autowired
    private IPermissionService permissionMapper;

    @GetMapping("/permission")
    public Map getList(Integer page, Integer limit ){
        Map<String,Object> map = new HashMap<String,Object>();
        //设置mybatisPlus分页
        Page<Permission> p = new Page<Permission>();
        p.setSize(limit);
        p.setCurrent(page);
        IPage<Permission> iPage = permissionMapper.selectList(p);
        map.put("msg","查询情况");
        map.put("count",iPage.getTotal());
        map.put("data",iPage.getRecords());
        map.put("code",0);
        return map;
    }
    /**
     *  新增用户
     */
    @PostMapping("/permissionAdd")
    public Map add(Permission permission){
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("state",permissionMapper.add(permission));
        return result;
    }

    @PutMapping("/permissionUpdate")
    public Map update(Permission permission){
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("state",permissionMapper.update(permission));
        return result;
    }
    @DeleteMapping("/permission/del/{permId}")
    public Map del(@PathVariable Integer permId){
        Permission permission = new Permission();
        permission.setPermId(permId);
        permission.setIsDel(1);
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("state",permissionMapper.updateById(permission));
        return result;
    }
}
