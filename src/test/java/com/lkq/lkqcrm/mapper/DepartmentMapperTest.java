package com.lkq.lkqcrm.mapper;

import com.lkq.lkqcrm.entity.Department;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DepartmentMapperTest {

    @Autowired
    private DepartmentMapper departmentMapper;

    /**
     * 查询全部部门信息
     */
    @Test
    public void selectList(){
        List<Department> list=departmentMapper.selectList(null);
        for(Object o : list){
            System.out.println(o);
        }
    }

    /**
     * 添加部门信息
     */
    @Test
    public void insert(){
        Department department=new Department();
        department.setDeptId(2);
        department.setDeptName("凌康乾");
        department.setCreateTime("2020-3-23");
        department.setUpdateTime("2020-3-23");
        department.setIsDel(1);
        int insert=departmentMapper.insert(department);
        System.out.println(insert);
    }

    /**
     * 根据id修改部门信息
     */
   @Test
    public void updateById(){
        Department department=new Department();
        department.setDeptId(2);
        department.setDeptName("凌康乾");
        department.setCreateTime("2020-03-23 20:33:44");
        department.setUpdateTime("2020-03-23 20:33:44");
        department.setIsDel(1);
        int updateById=departmentMapper.updateById(department);
        System.out.println(updateById);
    }

    /**
     * 根据id删除部门信息
     */
    @Test
    public void deleteById(){
        departmentMapper.deleteById(2);
    }

}