package com.weilai.service;

<<<<<<< HEAD
import com.weilai.model.Renovation;
import com.baomidou.mybatisplus.service.IService;
=======
import java.util.List;

import com.stylefeng.guns.core.base.service.BaseService;
import com.weilai.model.Renovation;
import com.weilai.model.RenovationDetail;
>>>>>>> master

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author weijx
 * @since 2017-12-10
 */
<<<<<<< HEAD
public interface IRenovationService extends IService<Renovation> {
	
=======
public interface IRenovationService extends BaseService<Renovation> {

	void insertDetail(RenovationDetail renovationDetail);

	List<RenovationDetail> selectDetailList(String id);

	int deleteDetail(String renovationId);

>>>>>>> master
}
