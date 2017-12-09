package com.weilai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.base.warpper.BaseWarpper;
import com.weilai.model.Technology;
import com.weilai.service.TechnologyService;

@Controller
@RequestMapping("/technology")
public class TechnologyController extends BaseController{
	
	private static String PREFIX = "/technology/";

	@Autowired
	private TechnologyService technologyService;
	
	
	@RequestMapping("")
	public String list() {
		return PREFIX+"list.html";
	}
	 /**
     * 获取通知列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(Technology technology) {
    	List<Technology> list = technologyService.selectList(technology);
        return super.warpObject(new BaseWarpper(list));
    }
}
