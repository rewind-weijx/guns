package com.weilai.dao;

import com.weilai.model.Renovation;
<<<<<<< HEAD
=======
import com.weilai.model.RenovationDetail;

import java.util.List;

>>>>>>> master
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author weijx
 * @since 2017-12-10
 */
public interface RenovationMapper extends BaseMapper<Renovation> {

<<<<<<< HEAD
=======
	void insertDetail(RenovationDetail renovationDetail);

	List<RenovationDetail> selectDetailList(RenovationDetail detail);

	int deleteDetail(String renovationId);

>>>>>>> master
}