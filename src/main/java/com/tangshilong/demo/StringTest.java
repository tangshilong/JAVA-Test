package com.tangshilong.demo;

public class StringTest {

	public static void main(String[] args) {
		String string = "abdcde";
		System.out.println(string.indexOf("c"));
		System.out.println(string.substring(2, 3));
		System.out.println(string.indexOf("d",3));
		System.out.println(string.lastIndexOf("d"));
		System.out.println(string.endsWith("e"));
		System.out.println(string.hashCode());
		System.out.println(string.matches("dc"));
		for (String string1 : string.split("d")) {
			System.out.println(string1);
		}
		System.out.println(string.matches("dc"));
		System.out.println(string.toUpperCase());
		System.out.println(String.valueOf(11).getClass());
		System.out.println(System.currentTimeMillis());
	}
}
