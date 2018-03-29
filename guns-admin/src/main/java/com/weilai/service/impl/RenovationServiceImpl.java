package com.weilai.service.impl;

<<<<<<< HEAD
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.weilai.dao.RenovationMapper;
import com.weilai.model.Renovation;
=======
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.stylefeng.guns.core.base.service.impl.BaseServiceImpl;
import com.stylefeng.guns.core.util.IdFactory;
import com.weilai.dao.RenovationMapper;
import com.weilai.model.Renovation;
import com.weilai.model.RenovationDetail;
>>>>>>> master
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
<<<<<<< HEAD
public class RenovationServiceImpl extends ServiceImpl<RenovationMapper, Renovation> implements IRenovationService {
=======
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
		entity.setReadCount(0L);
		entity.setCreateBy("admin");
		entity.setCreateTime(new Date());
		entity.setDelFlag("0");
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

	@Override
	public List<RenovationDetail> selectDetailList(String renovationId) {
		RenovationDetail detail = new RenovationDetail();
		detail.setRenovationId(renovationId);
		return renovationMapper.selectDetailList(detail);
	}

	@Override
	public int deleteDetail(String renovationId) {
		return renovationMapper.deleteDetail(renovationId);
	}
>>>>>>> master
	
}
