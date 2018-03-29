package com.weilai.service;

import java.util.List;
import java.util.Map;

import com.weilai.model.Renovation;
import com.weilai.model.RenovationDetail;

/**
 * 部门服务
 *
 * @author fengshuonan
 * @date 2017-04-27 17:00
 */
public interface WebIndexService {

	Map<String, Object> index();
	List<Renovation> listByType(String type);
	Renovation detail(String id);
	List<RenovationDetail> detailList(String renovationId);
	int sendMessage(String name, String mobile, String description);
}
