package com.weilai.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

/**
 * 文件上传service
 * @author weijx
 * @version V1.0
 * @date 2017年7月17日 下午6:03:28
*/
public interface WebUploaderService{

	public String upload(MultipartFile[] files,boolean chunked,String fileType,String realName)
            throws JsonGenerationException, JsonMappingException, IOException ;
}
