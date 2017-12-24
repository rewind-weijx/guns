package com.weilai.warpper;

import java.util.List;
import java.util.Map;

import com.stylefeng.guns.core.base.warpper.BaseWarpper;
import com.weilai.model.Contact;

/**
 * 用户管理的包装类
 *
 * @author fengshuonan
 * @date 2017年2月13日 下午10:47:03
 */
public class ContactWarpper extends BaseWarpper {

    public ContactWarpper(List<Contact> list) {
        super(list);
    }

    @Override
    public Map<String,Object> warpTheMap(Map<String, Object> map) {
    	String statusName = "未读";
    	if("1".equals(map.get("readState"))){
    		statusName = "已读";
    	}
        map.put("statusName", statusName);
        return map;
    }

}
