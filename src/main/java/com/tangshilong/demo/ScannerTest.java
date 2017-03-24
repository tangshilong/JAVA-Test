package com.tangshilong.demo;

import java.util.Scanner;

public class ScannerTest {

	private static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		scanner.useDelimiter("\n");
		while (scanner.hasNext()) {
			System.out.println("键盘输入的内容是: " + scanner.next());
		}
	}

}
