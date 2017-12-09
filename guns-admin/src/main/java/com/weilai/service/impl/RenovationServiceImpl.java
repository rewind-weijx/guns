package com.weilai.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.weilai.dao.RenovationMapper;
import com.weilai.model.Renovation;
import com.weilai.service.IRenovationService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author weijx
 * @since 2017-12-10
 */
@Service
public class RenovationServiceImpl extends ServiceImpl<RenovationMapper, Renovation> implements IRenovationService {
	
}
