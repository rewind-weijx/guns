package com.weilai.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.stylefeng.guns.core.base.controller.BaseController;
import com.weilai.service.impl.WebUploaderServiceImpl;

/**
 * 密码相关controller
 * @author weijx
 * @version V1.0
 * @date 2017年7月17日 下午6:02:58
*/
@Controller
@RequestMapping("/webUploader")
public class WebUploaderController extends BaseController{
	
	@Autowired
	private WebUploaderServiceImpl webUploaderService;
	
    @RequestMapping(value = "/upload")
    @ResponseBody
    public String sync( @RequestParam(value = "file", required = false) MultipartFile[] files, HttpServletRequest request,String fileType,String fileName)
            throws JsonGenerationException, JsonMappingException, IOException {
    	
    	String realName = webUploaderService.upload(files, request.getParameter("chunk")!=null,fileType,fileName);
    	
    	return realName;
    }
}
