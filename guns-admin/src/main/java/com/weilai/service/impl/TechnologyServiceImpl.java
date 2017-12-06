package com.weilai.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.weilai.dao.TechnologyMapper;
import com.weilai.model.Technology;
import com.weilai.service.TechnologyService;

@Service
@Transactional
public class TechnologyServiceImpl extends ServiceImpl<TechnologyMapper, Technology> implements TechnologyService {

//    @Resource
//    private TechnologyMapper technologyMapper;

    
}
