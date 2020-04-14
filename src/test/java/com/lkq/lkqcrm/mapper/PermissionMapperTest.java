package com.lkq.lkqcrm.mapper;

import com.lkq.lkqcrm.entity.Permission;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PermissionMapperTest {
    @Autowired
    private PermissionMapper permissionMapper;

    /**
     * 添加权限信息
     */
    @Test
    public void insert(){
        Permission permission=new Permission();
        permission.setPermId(null);
        permission.setPermName("员工1");
        permission.setUrl("1");
        permission.setPermission("1");
        permission.setCreateTime("2020-3-23");
        permission.setUpdateTime("2020-3-23");
        permission.setIsDel(1);
        int insert=permissionMapper.insert(permission);
        System.out.println(insert);
    }

    /**
     * 根据id修改权限信息
     */
    @Test
    public void updateById(){
        Permission permission=new Permission();
        permission.setPermName("员工");
        permission.setUrl("1");
        permission.setPermission("1");
        permission.setCreateTime("2020-3-23");
        permission.setUpdateTime("2020-3-23");
        permission.setIsDel(1);
        int updateById=permissionMapper.updateById(permission);
        System.out.println(updateById);
    }

    /**
     * 根据id删除权限信息
     */
    @Test
    public void deleteById(){
        permissionMapper.deleteById(2);
    }

}