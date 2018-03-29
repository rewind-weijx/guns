package com.weilai.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.weilai.model.Contact;

public interface ContactMapper extends BaseMapper<Contact>{

	void read(String id);

}