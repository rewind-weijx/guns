package com.weilai.util;

public class Constant {

	public enum RenovationType{
		
		//装饰设计
		type01("1","室内设计"),
		type02("2","别墅定制"),
		type03("3","写字楼办公室定制"),
		type04("4","酒店会所定制"),
		type05("5","餐饮定制"),
		type06("6","品牌店面定制"),
		
		//产品定制
		type07("7","橱柜定制"),
		type08("8","家具定制"),
		type09("9","木门定制"),
		
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
