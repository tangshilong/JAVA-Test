package com.tangshilong.demo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionTest {

	public static void main(String[] args) {
		String string = "hello , java";
		System.out.println(string.replaceFirst("\\w", "*"));
		System.out.println("贪婪模式：" + string.replaceFirst("\\w*", "*"));// 贪婪模式
		System.out.println("勉强模式：" + string.replaceFirst("\\w*?", "*"));// 勉强模式

		// 将一个字符串编译成Pattern对象
		System.out.println("\nPattern和Matcher用法：");
		Pattern p = Pattern.compile("a*b");
		// 使用pattern对象创建Matcher对象
		Matcher m = p.matcher("aaaaab");
		while (m.find()) {
			System.out.println(m.group());
		}

		String string2 = "啊是豆花饭13974656666，按实际还带个18646468999，阿斯顿发生13948575665";
		Matcher matcher = Pattern.compile("((13\\d)|(18\\d))\\d{8}").matcher(string2);
		System.out.println("\n输出所有的电话号码：");
		while (matcher.find()) {
			System.out.println(matcher.group()+"-- 起始位置是："+matcher.start()+" 结束位置为："+matcher.end());
		}
	}
}
