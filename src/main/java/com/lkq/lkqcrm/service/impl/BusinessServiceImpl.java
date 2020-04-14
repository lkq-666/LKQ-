package com.lkq.lkqcrm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lkq.lkqcrm.entity.Business;
import com.lkq.lkqcrm.mapper.BusinessMapper;
import com.lkq.lkqcrm.service.BusinessService;
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
public class BusinessServiceImpl extends ServiceImpl<BusinessMapper, Business> implements BusinessService {

}
