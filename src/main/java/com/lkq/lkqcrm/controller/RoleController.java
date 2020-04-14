package com.lkq.lkqcrm.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lkq.lkqcrm.entity.Employee;
import com.lkq.lkqcrm.entity.Role;
import com.lkq.lkqcrm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class RoleController {

    @Autowired
    private RoleService service;

    @GetMapping("/role1")
    public List<Role> roles(){

        return service.list();
    }
    /**
     *  查询一页员工信息
     * @param page 当前页码
     * @param limit 每页记录数
     * @return
     */

    @GetMapping("/role")
    public Map getList(Integer page,Integer limit ){
        Map<String,Object> map = new HashMap<String,Object>();
        //设置mybatisPlus分页
        Page<Role> p = new Page<Role>();
        p.setSize(limit);
        p.setCurrent(page);
        IPage<Role> iPage = service.selectList(p);
        map.put("msg","查询情况");
        map.put("count",iPage.getTotal());
        map.put("data",iPage.getRecords());
        map.put("code",0);
        return map;
    }
    /**
     *  新增用户
     */
    @PostMapping("/roleAdd")
    public Map add(Role role,Integer deptId){
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("state",service.add(role,deptId));
        return result;
    }

    /**
     *  修改用户
     */
    @PutMapping("/roleUpdate")
    public Map edit(Role role,Integer deptId){
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("state",service.update(role,deptId));
        return result;
    }



    /**
     *  删除用户
     */
    @DeleteMapping("/role/del/{roleId}")
    public Map del(@PathVariable Integer roleId){
        Role role = new Role();
        role.setRoleId(roleId);
        role.setIsDel(1);
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("state",service.updateById(role));
        return result;
    }


}
