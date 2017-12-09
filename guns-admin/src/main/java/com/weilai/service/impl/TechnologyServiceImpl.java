package com.weilai.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stylefeng.guns.core.base.service.impl.BaseServiceImpl;
import com.weilai.model.Technology;
import com.weilai.service.TechnologyService;

@Service
@Transactional
public class TechnologyServiceImpl extends BaseServiceImpl<Technology> implements TechnologyService {

}
