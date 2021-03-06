package com.stylefeng.guns.core.base.tips;

/**
 * 返回给前台的成功提示
 *
 * @author fengshuonan
 * @date 2016年11月12日 下午5:05:22
 */
public class SuccessTip extends Tip {
	
	private Object data;
	
	public SuccessTip(){
		super.code = 200;
		super.message = "操作成功";
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
