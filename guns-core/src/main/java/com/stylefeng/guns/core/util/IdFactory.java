package com.stylefeng.guns.core.util;

import java.net.InetAddress;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;





/**
 * 创建SEQUENCE
 * 
 * @created 2013-08-29 上午10:50:05
 * @since v1.1
 * @history
 * @see
 */

public class IdFactory {
	private static IdFactory _instance  = new IdFactory();
	private static long max = 999999;
	private static long saveSecond = 0l;
	private static String IP_LAST;
	int i = 1;
	static {
		saveSecond = System.currentTimeMillis() / 1000;

		// saveSecond = saveSecond / 60;
	}

	private IdFactory() {
		try {
			InetAddress objAddr = InetAddress.getLocalHost();
			// 获取IP地址
			String ip = objAddr.getHostAddress();

			String[] ips = ip.split("\\.");

			String ip1 = ips[3];

			int ip1_last = Integer.valueOf(ip1);

			String ip_3 = format(ip1, 2);

			IP_LAST = ip_3;

		} catch (Exception e) {
			// log.error("get IP_LAST error!", e);
			e.printStackTrace();
			String ip_last1 = format(String.valueOf(new Random().nextInt(255)),
					2);
			IP_LAST = ip_last1;
		}
	}

	/**
	 * 
	 * @return 返回实例
	 * @created 2013-08-29 上午10:50:05
	 */
	public static IdFactory getInstance() {
		return _instance ;
	}

	/**
	 * 设置时间
	 * 
	 * @created 2013-08-29 上午10:50:05
	 * @since v1.1
	 * @history
	 * @see
	 */
	private synchronized String getUniqTimer() {

		StringBuffer sb = new StringBuffer();

		if (max == i) {
			long currentTime = System.currentTimeMillis() / 1000;
			// currentTime = currentTime / 60;

			if (currentTime <= saveSecond) {
				saveSecond++;
			} else {
				saveSecond = currentTime;
			}
			i = 1;

		} else {
			i++;
		}
		sb.append(saveSecond);

		String saveTime = format(String.valueOf(saveSecond), 5);

		String add_i = format(String.valueOf(i), 1);

		return saveTime + add_i;
	}

	/**
	 * 获取下一个Sequence键值 
	 * @return  下一个Sequence键值(String)
	 * @created 2013-08-29 上午10:50:05
	 */
	public static String getNextKeyValue() {
		StringBuffer sb = new StringBuffer();
		sb.append(IP_LAST);
		sb.append(IdFactory.getInstance().getUniqTimer());
		return sb.toString();
	}
	
	/**
	 * 获取下一个Sequence键值 
	 * @return  下一个Sequence键值(long)
	 * @created 2013-08-29 上午10:50:05
	 */
	public static String getID() {
		StringBuffer sb = new StringBuffer();
		sb.append(IP_LAST);
		sb.append(IdFactory.getInstance().getUniqTimer());
		Long id = Long.valueOf(sb.toString());
		return Long.toHexString(id);
	}
	/**
	 * 获取id
	 * @param prefix
	 * @return
	 */
	public static String getID(String prefix) {
		return (prefix==null?"":prefix)+getID();
	}
	/**
	 * 
	 * @param str
	 * @param len
	 * @return
	 * @created 2013-08-29 上午10:50:05
	 */
	private static String format(String str, int len) {
		if (str.length() < len) {
			for (int i = 0; i < len - str.length(); i++) {
				str = "1" + str;
			}
			return str;
		} else {
			return str;
		}
	}

	public static void main(String args[]) {
		System.out.println(IdFactory.getID());
//		Set<String> set = new HashSet<String>();
//		for (int i = 0; i < 10; i++) {
////			set.add(SequenceUtilImpl.getInstance().getNextKeyValue());
//			
//			set.add(IdFactory.getNextKeyValue());
////			System.out.println("SequenceId()="
////					+ SequenceUtilImpl.getNextKeyValue());
//		}
//		
//		System.out.println("set size=" + set.size());
	}

}
