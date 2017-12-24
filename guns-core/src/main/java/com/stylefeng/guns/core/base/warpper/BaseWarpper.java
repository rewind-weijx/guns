package com.stylefeng.guns.core.base.warpper;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 控制器查询结果的包装类基类
 *
 * @author fengshuonan
 * @date 2017年2月13日 下午10:49:36
 */
public class BaseWarpper {

	public Object obj = null;

	public BaseWarpper(Object obj) {
		this.obj = obj;
	}

	@SuppressWarnings("unchecked")
	public Object warp() {
		if (this.obj instanceof List) {
			List<Object> list = (List<Object>) this.obj;
			List<Map<String,Object>> resultList = new ArrayList<Map<String,Object>>();
			for (Object object : list) {
				if (!(object instanceof Map)) {
					resultList.add(warpTheMap(this.convertToMap(object)));
					continue;
				}
				resultList.add(warpTheMap((Map<String, Object>) object));
			}
			return resultList;
		} else if (this.obj instanceof Map) {
			Map<String, Object> map = (Map<String, Object>) this.obj;
			return warpTheMap(map);
		} else {
			return this.obj;
		}
	}

	public Map<String,Object> warpTheMap(Map<String, Object> map) {
		System.out.println(1);
		return map;
	}

	private Map<String, Object> convertToMap(Object object) {
		Map<String, Object> map = new HashMap<>();
		Field[] fields = object.getClass().getDeclaredFields();
		for (Field field : fields) {
			String fieldName = field.getName();
			Object fieldValue = this.getFieldValueByName(fieldName, object);
			map.put(fieldName, fieldValue);
		}
		return map;
	}

	/**
	 * 根据属性名获取属性值
	 */
	private Object getFieldValueByName(String fieldName, Object o) {
		try {
			String firstLetter = fieldName.substring(0, 1).toUpperCase();
			String getter = "get" + firstLetter + fieldName.substring(1);
			Method method = o.getClass().getMethod(getter, new Class[] {});
			Object value = method.invoke(o, new Object[] {});
			return value;
		} catch (Exception e) {
			return null;
		}
	}
}
