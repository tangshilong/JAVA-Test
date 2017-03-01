package test;

import java.util.Scanner;

public class scanner {

	private static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		scanner.useDelimiter("\n");
		while(scanner.hasNext()){
			System.out.println("键盘输入的内容是: " + scanner.next());
			System.out.println("开心就好");
		}
	}

}
