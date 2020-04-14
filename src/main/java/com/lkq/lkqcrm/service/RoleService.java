package com.lkq.lkqcrm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lkq.lkqcrm.entity.Role;


public interface RoleService extends IService<Role> {
    IPage<Role> selectList(Page<Role> page);

    Role selectByName(String deptName);

    Integer add(Role role,Integer deptId);

    Integer update(Role role,Integer deptId);
}
