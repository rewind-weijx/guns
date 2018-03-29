package com.stylefeng.guns.core.base.service;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;

public interface BaseService <T> extends IService<T>{

	List<T> selectList(T entity);
}
