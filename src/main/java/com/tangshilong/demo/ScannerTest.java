package com.tangshilong.demo;

import java.util.Scanner;

public class ScannerTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		scanner.useDelimiter("\n");
		while (scanner.hasNext()) {
			System.out.println("键盘输入的内容是: " + scanner.next());
		}
	}

}
