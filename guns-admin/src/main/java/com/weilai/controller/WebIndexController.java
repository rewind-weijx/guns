package com.weilai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stylefeng.guns.core.base.controller.BaseController;

@Controller
public class WebIndexController  extends BaseController {

	private String PREFIX = "/weilai/web/";
	
	@RequestMapping(value={"/index","","/"})
	public String index() {
		return PREFIX+"index.html";
	}
	@RequestMapping(value={"/page2"})
	public String page2() {
		return PREFIX+"page2.html";
	}
	@RequestMapping(value={"/page3"})
	public String page3() {
		return PREFIX+"page3.html";
	}
}
