package com.lkq.lkqcrm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lkq.lkqcrm.entity.Contact;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author PIGS
 * @since 2020-03-28
 */
public interface ContactService extends IService<Contact> {
    IPage<Contact> listCmC(Page<Contact> page);
}
