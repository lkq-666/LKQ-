package com.lkq.lkqcrm.service.impl;
import com.baomidou.mybatisplus.core.conditions.AbstractWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lkq.lkqcrm.entity.EmpRole;
import com.lkq.lkqcrm.entity.Employee;
import com.lkq.lkqcrm.mapper.EmpRoleMapper;
import com.lkq.lkqcrm.mapper.EmployeeMapper;
import com.lkq.lkqcrm.service.EmployeeService;
import com.lkq.lkqcrm.utils.ShiroUtils;
import com.lkq.lkqcrm.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {
    @Autowired
    private EmployeeMapper mapper;

    @Autowired
    private EmpRoleMapper empRoleMapper;

    @Override
    public IPage<Employee> selectList(Page<Employee> page) {
        return mapper.selectList(page);
    }

    @Override
    public Employee selectByName(String empName) {
        return mapper.selectByName(empName);
    }

    @Override
    public Integer add(Employee employee, Integer roleId) {
        /*
            1.获取盐
            2.shiro加盐加密
            3.用户信息存入对象，插入数据库，获取到插入的id
            4.将empId和roleId插入到emp_role表中
         */
        //从ShiroUtils类中随机生成盐
        employee.setSalt(ShiroUtils.randomSalt());
        //将密码设置为 加密后的密码（由ShiroUtils里面encryptPassword方法实现）
        employee.setPwd(ShiroUtils.encryptPassword(employee.getPwd(),employee.getCredentialsSalt()));
        //设置时间，idDel
        employee.setCreateTime(StringUtils.getNowTime());
        employee.setUpdateTime(employee.getCreateTime());  //获取创建时间，可以提高一点性能
        employee.setIsDel(0);

        int result =  mapper.insert(employee);

        int empId = employee.getEmpId();  //获取插入自增的id
        //将empId和roleId一同插入到  员工与角色关系表
        EmpRole empRole = new EmpRole(empId,roleId);
        empRole.setCreateTime(StringUtils.getNowTime());
        empRole.setUpdateTime(empRole.getCreateTime());  //获取创建时间，可以提高一点性能
        empRole.setIsDel(0);

        empRoleMapper.insert(empRole);

        return result;
    }


    @Override
    public Integer update(Employee employee,Integer roleId) {
        //System.out.println("修改的员工信息："+employee);
        //判断用户是否输入密码，如果没有，获取的就是空字符串 ("")  就不修改密码
        if (!"".equals(employee.getPwd()) ){
            //从ShiroUtils类中随机生成盐
            employee.setSalt(ShiroUtils.randomSalt());
            //将密码设置为 加密后的密码（由ShiroUtils里面encryptPassword方法实现）
            employee.setPwd(ShiroUtils.encryptPassword(employee.getPwd(),employee.getCredentialsSalt()));
        }else {
            employee.setPwd(null);
        }
        //设置时间
        employee.setUpdateTime(StringUtils.getNowTime());
        //将信息更新到数据库中（空的属性不修改）
        int result =  mapper.updateById(employee);


        EmpRole empRole = new EmpRole(employee.getEmpId(),roleId);
        empRole.setUpdateTime(StringUtils.getNowTime());
        AbstractWrapper wrapper = new QueryWrapper();
        wrapper.eq("emp_id",employee.getEmpId());
        empRoleMapper.update(empRole,wrapper);

        return result;
    }
}