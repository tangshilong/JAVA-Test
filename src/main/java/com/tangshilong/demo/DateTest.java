package com.tangshilong.demo;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;

public class DateTest {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		// ------下面是关于Clock的用法-----
		System.out.println("------下面是关于Clock的用法-----");
		Clock clock = Clock.systemUTC();
		System.out.println("当前时刻为： " + clock.instant());
		System.out.println("对应毫秒数为：" + clock.millis());
		System.out.println("对应毫秒数为：" + System.currentTimeMillis() + "\n");
		// ------下面是关于Duration的用法-----
		System.out.println("------下面是关于Duration的用法-----");
		Duration duration = Duration.ofSeconds(6000);
		System.out.println("6000毫秒相当于：" + duration.toMinutes() + "分钟");
		System.out.println("6000毫秒相当于：" + duration.toHours() + "小时");
		System.out.println("6000毫秒相当于：" + duration.toDays() + "天");
		System.out.println("\nclock基础上增加6000秒，返回新的clock：");
		System.out.println("当前时刻为： " + clock.instant());
		System.out.println("修改后时刻为：" + Clock.offset(clock, duration).instant());
		// -------instant用法-------
		System.out.println("\n-------instant用法-------");
		Instant instant = Instant.now();
		System.out.println("当前时间为： " + instant);
		System.out.println("根据字符串解析Instant对象： " + Instant.parse("2017-03-02T09:17:45.043Z"));
		// ------下面是关于LocalDate用法-------
		System.out.println("\n------下面是关于LocalDate用法-------");
		LocalDate localDate = LocalDate.now();
		System.out.println("当前日期为： " + localDate);
		// ------下面是关于LocalTime用法-------
		System.out.println("\n------下面是关于LocalTime用法-------");
		LocalTime localTime = LocalTime.now();
		System.out.println("当前时间： " + localTime);
		System.out.println("设置时间：" + localTime.of(10, 33));
		System.out.println("一天中的第5555秒：" + LocalTime.ofSecondOfDay(5555));
	}
}
