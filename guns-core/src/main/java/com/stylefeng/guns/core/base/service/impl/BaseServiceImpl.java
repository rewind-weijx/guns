package com.stylefeng.guns.core.base.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.stylefeng.guns.core.base.service.BaseService;

public class BaseServiceImpl <T> extends ServiceImpl<BaseMapper<T>, T> implements BaseService<T>{

	@Autowired
	protected BaseMapper<T> baseMapper;
	
	@Override
	public List<T> selectList(T entity) {
		 Wrapper<T> wrapper = new EntityWrapper<>();
		return baseMapper.selectList(wrapper);
	}

}
