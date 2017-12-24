package com.weilai.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stylefeng.guns.core.base.controller.BaseController;
import com.weilai.model.Contact;
import com.weilai.model.Renovation;
import com.weilai.service.WebIndexService;
import com.weilai.util.Constant;

@Controller
public class WebIndexController  extends BaseController {

	private String PREFIX = "/weilai/web/";
	
	@Autowired
	private WebIndexService webIndexService;
	
	@RequestMapping(value={"/index","","/"})
	public String index(ModelMap modelMap) {
		//智能家居
		List<Renovation> smartHome = webIndexService.listByType(Constant.RenovationType.type14.getValue());
		modelMap.put("smartHome",smartHome );
		Map<String,Object> map = webIndexService.index();
		modelMap.put("map", map);
		return PREFIX+"index.html";
	}
	
	@RequestMapping(value="sendMessage")
	public String sendMessage(String name,String mobile,String description){
		webIndexService.sendMessage(name,mobile,description);
		return "redirect:/";
	}
	
}
