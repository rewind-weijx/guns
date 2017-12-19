package com.weilai.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.weilai.model.Renovation;
import com.weilai.model.RenovationDetail;
import com.weilai.service.IRenovationService;
import com.weilai.service.WebIndexService;
import com.weilai.util.Constant;

@Service
@Transactional(readOnly=false)
public class WebIndexServiceImpl implements WebIndexService {

	@Autowired
	private IRenovationService renovationService;
	
	@Override
	public Map<String, Object> index() {
		Map<String, Object> result = new HashMap<>();
		//智能家居
		List<Renovation> list01 = this.listByType(Constant.RenovationType.type01.getValue());
		result.put("list01",list01 );
		//
		List<Renovation> list02 = this.listByType(Constant.RenovationType.type02.getValue());
		result.put("list02",list02 );
		//
		List<Renovation> list03 = this.listByType(Constant.RenovationType.type03.getValue());
		result.put("list03",list03 );
		//
		List<Renovation> list04 = this.listByType(Constant.RenovationType.type04.getValue());
		result.put("list04",list04 );
		//
		List<Renovation> list05 = this.listByType(Constant.RenovationType.type05.getValue());
		result.put("list05",list05 );
		//
		List<Renovation> list06 =this.listByType(Constant.RenovationType.type06.getValue());
		result.put("list06",list06 );
		//
		List<Renovation> list07 = this.listByType(Constant.RenovationType.type07.getValue());
		result.put("list07",list07 );
		//
		List<Renovation> list08 = this.listByType(Constant.RenovationType.type08.getValue());
		result.put("list08",list08 );
		//
		List<Renovation> list09 = this.listByType(Constant.RenovationType.type09.getValue());
		result.put("list09",list09 );
		//
		List<Renovation> list10 = this.listByType(Constant.RenovationType.type10.getValue());
		result.put("list10",list10 );
		//
		List<Renovation> list11 = this.listByType(Constant.RenovationType.type11.getValue());
		result.put("list11",list11 );
		//
		List<Renovation> list12 = this.listByType(Constant.RenovationType.type12.getValue());
		result.put("list12",list12 );
		//
		List<Renovation> list13 = this.listByType(Constant.RenovationType.type13.getValue());
		result.put("list13",list13 );
		//智能家居
		List<Renovation> list14 = this.listByType(Constant.RenovationType.type14.getValue());
		result.put("list14",list14 );
		return result;
	}

	@Override
	public List<Renovation> listByType(String type){
		Renovation entity = new Renovation();
		entity.setType(type);
		List<Renovation> list = renovationService.selectList(entity);
		return list;
	}

	@Override
	public Renovation detail(String id) {
		return renovationService.selectById(id);
	}
	@Override
	public List<RenovationDetail> detailList(String renovationId){
		return renovationService.selectDetailList(renovationId);
	}
	
}
