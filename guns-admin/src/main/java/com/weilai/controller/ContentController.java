package com.weilai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stylefeng.guns.core.base.controller.BaseController;
import com.weilai.model.Renovation;
import com.weilai.model.RenovationDetail;
import com.weilai.service.WebIndexService;
import com.weilai.util.Constant;

@Controller
@RequestMapping("/content")
public class ContentController  extends BaseController {

	private String PREFIX = "/weilai/web/";
	
	@Autowired
	private WebIndexService webIndexService;

	@RequestMapping(value={"/list/{type}"})
	public String page2(@PathVariable String type,ModelMap modelMap) {
		//智能家居
		List<Renovation> smartHome = webIndexService.listByType(Constant.RenovationType.type14.getValue());
		modelMap.put("smartHome",smartHome );
		List<Renovation> list = webIndexService.listByType(type);
		modelMap.put("list", list);
		modelMap.put("menuName", Constant.getRenovationNameByValue(type));
		return PREFIX+"page2.html";
	}
	@RequestMapping(value={"/detail/{id}"})
	public String detail(@PathVariable String id,ModelMap modelMap) {
		//智能家居
		List<Renovation> smartHome = webIndexService.listByType(Constant.RenovationType.type14.getValue());
		modelMap.put("smartHome",smartHome );
		
		Renovation renovation = webIndexService.detail(id);
		modelMap.put("renovation", renovation);
		modelMap.put("typeName", Constant.getRenovationNameByValue(renovation.getType()));
		List<RenovationDetail> list = webIndexService.detailList(id);
		modelMap.put("list", list);
		if(Constant.RenovationType.type18.getValue().equals(renovation.getType())||(Constant.RenovationType.type19.getValue().equals(renovation.getType()))){
			return PREFIX+"company_dept.html";
		}
		return PREFIX+"page3.html";
	}
}
