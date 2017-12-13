package com.weilai.dao;

import com.weilai.model.Renovation;
import com.weilai.model.RenovationDetail;
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

	void insertDetail(RenovationDetail renovationDetail);

}