package com.weilai.util;

public class Constant {

	public enum RenovationType{
		
		//装饰设计
		type01("01","室内设计"),
		type02("02","别墅定制"),
		type03("03","写字楼办公室定制"),
		type04("04","酒店会所定制"),
		type05("05","餐饮定制"),
		type06("06","品牌店面定制"),
		
		//产品定制
		type07("07","橱柜定制"),
		type08("08","家具定制"),
		type09("09","木门定制"),
		
		//工程服务
		type10("10","保温系列"),
		type11("11","瓷砖系列"),
		type12("12","水电系列"),
		type13("13","防火防潮系列"),
		
		//智能家居
		type14("14","智能家居"),
		
		//软装设计
		type15("15","家装软装案例"),
		type16("16","会所软装案例"),
		type17("17","商业软装案例"),
		
		//公司简介
		type18("18","公司简介"),
		type19("19","部门简介");
		
		RenovationType(String value,String name) {
			this.value = value;
			this.name = name;
		}

		String value;
		String name;
		
		public String getValue() {
			return this.value;
		}
		public String getName() {
			return this.name;
		}
		
		
		
	}
	public static String getRenovationNameByValue(String value) {
		RenovationType[] list = RenovationType.values();
		for (RenovationType renovationType : list) {
			if(renovationType.getValue().equals(value)) {
				return renovationType.getName();
			}
		}
		return null;
	}
}
