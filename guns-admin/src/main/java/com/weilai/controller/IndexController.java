package com.weilai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stylefeng.guns.core.base.controller.BaseController;

@Controller
public class IndexController  extends BaseController {

	private String PREFIX = "/index/";
	
	@RequestMapping("/index")
	public String index() {
		return PREFIX+"index.html";
	}
}
