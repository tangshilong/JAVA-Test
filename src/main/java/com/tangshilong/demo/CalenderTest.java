package com.tangshilong.demo;

import java.util.Calendar;
import java.util.Date;

public class CalenderTest {

	public static void main(String[] args) {
		// ------下面是关于Calendar的用法-----
		System.out.println("------下面是关于Calendar的用法-----");
		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();
		System.out.println("当前时间为： " + date);
		Calendar calendar2 = Calendar.getInstance();
		calendar2.setTime(date);
		System.out.println("设置时间为： " + calendar2.getTime());
		calendar2.add(Calendar.YEAR, 2);
		System.out.println("增加年份后时间为： " + calendar2.getTime());
		System.out.println("获取年份为： " + calendar2.get(Calendar.YEAR));
		System.out.println("获取最大月份为：" + calendar.getActualMaximum(Calendar.MONTH));
	}
}
