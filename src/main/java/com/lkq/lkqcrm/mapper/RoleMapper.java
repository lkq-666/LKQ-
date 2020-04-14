package com.lkq.lkqcrm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lkq.lkqcrm.entity.Employee;
import com.lkq.lkqcrm.entity.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleMapper extends BaseMapper<Role> {
    IPage<Role> selectList(Page<Role> page);

    Role selectByName(String deptName);
}