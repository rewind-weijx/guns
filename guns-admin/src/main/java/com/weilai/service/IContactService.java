package com.weilai.service;

import com.stylefeng.guns.core.base.service.BaseService;
import com.weilai.model.Contact;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author weijx
 * @since 2017-12-10
 */
public interface IContactService extends BaseService<Contact> {

	void read(String id);

}
