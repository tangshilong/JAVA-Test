package com.tangshilong.demo;

public class MathTest {

	public static void main(String[] args) {
		System.out.println(Math.floor(-1.34));//小于目标的最大整数
		System.out.println(Math.ceil(-1.34));//大于目标的最小整数
		System.out.println(Math.round(-1.34));//四舍五入
		System.out.println(Math.sqrt(4));//开平方根
		System.out.println(Math.cbrt(4));//计算立方根
		System.out.println(Math.pow(4,2));//计算平根
		System.out.println(Math.abs(-3));//计算绝对值
		System.out.println(Math.max(2, 3));//找出最大值
		System.out.println(Math.min(3, 4));//找出最小值
		System.out.println(Math.random());
	}
}
