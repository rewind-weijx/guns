package com.weilai.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.stylefeng.guns.core.util.IdFactory;

/**
 * 文件上传service
 * @author weijx
 * @version V1.0
 * @date 2017年7月17日 下午6:03:28
*/
@Service("webUploaderService")
public class WebUploaderServiceImpl{

	private final String fileWritePath = "";
	
	public String upload(MultipartFile[] files,boolean chunked,String fileType,String realName)
            throws JsonGenerationException, JsonMappingException, IOException {
		
		
		String filePath = fileWritePath+"/"+fileType+"/";
    	File fileWritePathFile = new File(filePath);
    	if(!fileWritePathFile.exists()) {
    		fileWritePathFile.mkdirs();
        }
    	for (MultipartFile file : files) {
    		
    		String Ogfilename = file.getOriginalFilename();
    		if(realName==null||realName=="") {
    			realName = IdFactory.getID();
    			int extIndex = Ogfilename.lastIndexOf(".");
                
                if(extIndex>0) {
                    String ext = Ogfilename.substring(extIndex);
                 	realName+=ext;
                }
    		}
            
    		if (!chunked) {
                File targetFile = new File(filePath, realName);
                if (!targetFile.exists()) {
                    targetFile.mkdirs();
                }
                file.transferTo(targetFile); // 小文件，直接拷贝

            } else {

                File tempFile = new File(filePath,realName );
                
                OutputStream outputStream = new FileOutputStream(tempFile, true);
                InputStream inputStream = file.getInputStream();

                byte buffer[] = new byte[1024];
                int len = 0;
                while ((len = inputStream.read(buffer)) > 0) {
                    outputStream.write(buffer, 0, len);
                }
                inputStream.close();
                outputStream.close();
            }
		}
    	return realName;
    }
}
