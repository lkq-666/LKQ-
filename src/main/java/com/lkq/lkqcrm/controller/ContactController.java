package com.lkq.lkqcrm.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lkq.lkqcrm.entity.Contact;
import com.lkq.lkqcrm.entity.Employee;
import com.lkq.lkqcrm.service.ContactService;
import com.lkq.lkqcrm.utils.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author PIGS
 * @since 2020-03-28
 */
@RestController
public class ContactController {
    @Autowired
    private ContactService contactService;
    @GetMapping("/contact")
    public Map list(Integer page, Integer limit){
        Map<String,Object> map = new HashMap<String,Object>();
        Page<Contact> page1 = new Page<>();
        page1.setSize(limit);
        page1.setCurrent(page);
        IPage<Contact> iPage=contactService.listCmC(page1);
        map.put("msg","查询情况");
        map.put("count",iPage.getTotal());
        map.put("data",iPage.getRecords());
        map.put("code",0);
        return map;
    }
    @PostMapping("/contactAdd")
    public Map add(Contact contact){
        Map<String,Object> map=new HashMap<>();
        contact.setUpdateTime(StringUtils.getNowTime());
        contact.setCreateTime(contact.getUpdateTime());
        Subject subject = SecurityUtils.getSubject();
        Employee employee = (Employee) subject.getPrincipal();
        contact.setEmpId(employee.getEmpId());
        if (contactService.save(contact)){
            map.put("state",1);
        }
        return  map;
    }
    @DeleteMapping("/contact/del/{contactId}")
    public Map del(@PathVariable Integer contactId){
        Map<String,Object> map=new HashMap<>();
        Contact contact=new Contact();
        contact.setIsDel(1);
        contact.setContactId(contactId);
        map.put("state",contactService.updateById(contact));
        return map;
    }
}
