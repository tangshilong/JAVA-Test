package com.tangshilong.demo;

import java.math.BigDecimal;
/**
 * PS:用BigDecimal时一定要用String对象作为构造参数，用double类型会发生精度丢失
 * 
 * @author tangshilong
 *
 */
public class BigDecimalTest {

	public static void main(String[] args) {
		BigDecimal a = new BigDecimal("0.05");
		BigDecimal b = BigDecimal.valueOf(0.01);
		BigDecimal c = new BigDecimal(0.05);
		System.out.println("String作为BigDecimal构造参数");
		System.out.println("a=" + a);
		System.out.println("a+b="+a.add(b));
		System.out.println("a-b="+a.subtract(b));
		System.out.println("a*b="+a.multiply(b));
		System.out.println("a/b="+a.divide(b));
		System.out.println("\nDouble作为BigDecimal构造参数");
		System.out.println("c="+c);
	}
}
