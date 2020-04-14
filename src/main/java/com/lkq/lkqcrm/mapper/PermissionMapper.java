package com.lkq.lkqcrm.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lkq.lkqcrm.entity.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionMapper extends BaseMapper<Permission> {
    IPage<Permission> selectList(Page<Permission> page);
}
