package com.stylefeng.guns.core.base.service.impl;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.stylefeng.guns.core.base.service.BaseService;

public class BaseServiceImpl <T> extends ServiceImpl<BaseMapper<T>, T> implements BaseService<T>{

}
