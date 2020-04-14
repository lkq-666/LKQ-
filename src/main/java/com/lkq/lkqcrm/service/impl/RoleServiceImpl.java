package com.lkq.lkqcrm.service.impl;

import com.baomidou.mybatisplus.core.conditions.AbstractWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lkq.lkqcrm.entity.DeptRole;
import com.lkq.lkqcrm.entity.Role;

import com.lkq.lkqcrm.mapper.DeptRoleMapper;
import com.lkq.lkqcrm.mapper.RoleMapper;

import com.lkq.lkqcrm.service.RoleService;
import com.lkq.lkqcrm.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
    @Autowired
    private RoleMapper mapper;

    @Autowired
    private DeptRoleMapper deptRoleMapper;

    @Override
    public IPage<Role> selectList(Page<Role> page) {
        return mapper.selectList(page);
    }
    @Override
    public Role selectByName(String deptName) {
        return mapper.selectByName(deptName);
    }
    @Override
    public Integer add(Role role,Integer deptId) {
        role.setCreateTime(StringUtils.getNowTime());
        role.setUpdateTime(role.getCreateTime());  //获取创建时间，可以提高一点性能
        role.setIsDel(0);
        int result =  mapper.insert(role);
        int roleId = role.getRoleId();  //获取插入自增的id
        //将roleId和deptId一同插入到  员工与角色关系表
        DeptRole deptRole = new DeptRole(roleId,deptId);
        deptRole.setCreateTime(StringUtils.getNowTime());
        deptRole.setUpdateTime(deptRole.getCreateTime());
        deptRole.setIsDel(0);
        deptRoleMapper.insert(deptRole);
        return result;
    }

    @Override
    public Integer update(Role role,Integer deptId) {
        role.setCreateTime(StringUtils.getNowTime());
        int result = mapper.updateById(role);
        DeptRole deptRole = new DeptRole(role.getRoleId(),deptId);
        deptRole.setUpdateTime(StringUtils.getNowTime());
        AbstractWrapper wrapper = new QueryWrapper();
        wrapper.eq("role_id",role.getRoleId());
        deptRoleMapper.update(deptRole,wrapper);
        return result;
    }

}
