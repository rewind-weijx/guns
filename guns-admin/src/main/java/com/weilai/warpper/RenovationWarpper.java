package com.weilai.warpper;

import java.util.List;
import java.util.Map;

import com.stylefeng.guns.core.base.warpper.BaseWarpper;
import com.weilai.model.Contact;
import com.weilai.model.Renovation;

/**
 * 用户管理的包装类
 *
 * @author fengshuonan
 * @date 2017年2月13日 下午10:47:03
 */
public class RenovationWarpper extends BaseWarpper {

    public RenovationWarpper(List<Renovation> list) {
        super(list);
    }

    @Override
    public void warpTheMap(Map<String, Object> map) {
    	String hotName = "否";
    	if("1".equals(map.get("hot"))){
    		hotName = "是";
    	}
        map.put("hotName", hotName);
    }

}
