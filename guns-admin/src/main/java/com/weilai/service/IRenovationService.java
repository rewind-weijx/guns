package com.weilai.service;

import com.stylefeng.guns.core.base.service.BaseService;
import com.weilai.model.Renovation;
import com.weilai.model.RenovationDetail;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author weijx
 * @since 2017-12-10
 */
public interface IRenovationService extends BaseService<Renovation> {

	void insertDetail(RenovationDetail renovationDetail);

}
