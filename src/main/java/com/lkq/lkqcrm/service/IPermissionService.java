package com.lkq.lkqcrm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lkq.lkqcrm.entity.Permission;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lkq.lkqcrm.entity.Role;

public interface IPermissionService extends IService<Permission> {
    IPage<Permission> selectList(Page<Permission> page);

    Integer add(Permission permission);

    Integer update(Permission permission);
}
