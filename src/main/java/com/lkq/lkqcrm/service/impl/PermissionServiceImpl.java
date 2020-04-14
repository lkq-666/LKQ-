package com.lkq.lkqcrm.service.impl;

import com.baomidou.mybatisplus.core.conditions.AbstractWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lkq.lkqcrm.entity.*;
import com.lkq.lkqcrm.mapper.DeptRoleMapper;
import com.lkq.lkqcrm.mapper.PermissionMapper;
import com.lkq.lkqcrm.service.IPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lkq.lkqcrm.utils.ShiroUtils;
import com.lkq.lkqcrm.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {
    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public IPage<Permission> selectList(Page<Permission> page) {
        return permissionMapper.selectList(page);
    }

    @Override
    public Integer add(Permission permission) {
        permission.setCreateTime(StringUtils.getNowTime());
        permission.setUpdateTime(permission.getCreateTime());  //获取创建时间，可以提高一点性能
        permission.setIsDel(0);
        int result =  permissionMapper.insert(permission);
        return result;
    }
    /*@Override
    public Integer update(Permission permission) {
        return permissionMapper.updateById(permission);
    }*/
    @Override
    public Integer update(Permission permission) {
        permission.setCreateTime(StringUtils.getNowTime());
        permission.setUpdateTime(permission.getCreateTime());  //获取创建时间，可以提高一点性能
        permission.setIsDel(0);
        int result =  permissionMapper.updateById(permission);
        return result;
    }
}
