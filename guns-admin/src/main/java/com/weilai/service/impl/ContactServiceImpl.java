package com.weilai.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stylefeng.guns.core.base.service.impl.BaseServiceImpl;
import com.weilai.dao.ContactMapper;
import com.weilai.model.Contact;
import com.weilai.service.IContactService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author weijx
 * @since 2017-12-10
 */
@Service
public class ContactServiceImpl extends BaseServiceImpl<Contact> implements IContactService {
	

	
	@Autowired
	private ContactMapper concatMapper;

	@Override
	@Transactional(readOnly=false)
	public void read(String id) {
		concatMapper.read(id);
	}
	
}
