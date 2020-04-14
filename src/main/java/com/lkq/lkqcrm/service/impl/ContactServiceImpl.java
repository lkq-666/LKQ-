package com.lkq.lkqcrm.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lkq.lkqcrm.entity.Contact;
import com.lkq.lkqcrm.entity.Employee;
import com.lkq.lkqcrm.mapper.ContactMapper;
import com.lkq.lkqcrm.service.ContactService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author PIGS
 * @since 2020-03-28
 */
@Service
@Transactional
public class ContactServiceImpl extends ServiceImpl<ContactMapper, Contact> implements ContactService {
    @Autowired
    private ContactMapper contactMapper;
    @Override
    public IPage<Contact> listCmC(Page<Contact> page) {
        Subject subject = SecurityUtils.getSubject();
        Employee employee = (Employee) subject.getPrincipal();
        return contactMapper.listCmC(page,employee.getEmpId());
    }
}
