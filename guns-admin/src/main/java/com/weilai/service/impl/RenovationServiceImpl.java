package com.weilai.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.stylefeng.guns.core.base.service.impl.BaseServiceImpl;
import com.stylefeng.guns.core.util.IdFactory;
import com.weilai.dao.RenovationMapper;
import com.weilai.model.Renovation;
import com.weilai.model.RenovationDetail;
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
public class RenovationServiceImpl extends BaseServiceImpl<Renovation> implements IRenovationService {
	
	@Autowired
	private RenovationMapper renovationMapper;
	
	@Override
	public List<Renovation> selectList(Renovation entity) {
		Wrapper<Renovation> wrapper = new EntityWrapper<Renovation>();
		wrapper = wrapper.eq("type", entity.getType());
		return super.baseMapper.selectList(wrapper);
	}

	@Override
	public boolean insert(Renovation entity) {
		entity.setId(IdFactory.getID());
		return super.insertAllColumn(entity);
	}

	@Override
	public void insertDetail(RenovationDetail renovationDetail) {
		renovationDetail.setCreateBy("admin");
		renovationDetail.setCreateTime(new Date());
		renovationDetail.setDelFlag("0");
		renovationDetail.setId(IdFactory.getID());
		renovationMapper.insertDetail(renovationDetail);
	}
	
}
