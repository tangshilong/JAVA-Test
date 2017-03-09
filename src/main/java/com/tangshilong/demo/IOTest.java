package com.tangshilong.demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public class IOTest {

	public static void main(String[] args) throws IOException {
		/**
		 * 字节流处理出入输出，8比特字节 FileInputStream
		 */
		copyFile1();
		/**
		 * 字符流处理输入输出，16位，一次读取两个字节 FileReader
		 */
		copyeFile2();
		/**
		 * 控制台显示输入的字符 InputStreamReader
		 */
		showInput();
		/**
		 * 文件输出流 FileInputStream
		 */
		fileInOutPutStream();
		/**
		 * 获取文件列表
		 */
		getFileList();
		/**
		 * bufferedReader 可以使用readline()
		 */
		bufreredReaderTest();
	}

	public static void bufreredReaderTest() throws UnsupportedEncodingException, FileNotFoundException, IOException {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(new FileInputStream("E:\\test\\input.txt"), "UTF-8"));
		String data;
		while ((data = br.readLine()) != null) {
			System.out.println(data);
		}
		br.close();
	}

	public static void getFileList() {
		File file = new File("E:\\test");
		String[] strings = file.list();
		for (String string : strings) {
			System.out.println(string + "");
		}
	}

	public static void fileInOutPutStream() throws FileNotFoundException, IOException {
		FileInputStream f1 = new FileInputStream("E:\\test\\input.txt");
		// File file = new File("E:\\test\\output2.txt");E:\\test
		OutputStream out = new FileOutputStream("E:\\test\\output2.txt");
		int c;
		while ((c = f1.read()) != -1) {
			out.write(c);
		}
		f1.close();
		out.close();
		FileInputStream f = new FileInputStream("E:\\test\\output2.txt");
		int n = f.available();
		for (int i = 0; i < n; i++) {
			System.out.println((char) f.read() + "   ");
		}
		f.close();
	}

	public static void showInput() {
		try {
			InputStreamReader in = null;
			in = new InputStreamReader(System.in);
			System.out.println("Enter character: 'q' to quit.");
			char c;
			do {
				c = (char) in.read();
				System.out.println(c);
			} while (c != 'q');
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void copyeFile2() throws FileNotFoundException, IOException {
		FileReader in = null;
		FileWriter out = null;
		try {
			in = new FileReader("E:\\test\\input.txt");
			out = new FileWriter("E:\\test\\output16.txt");
			int a;
			while ((a = in.read()) != -1) {
				out.write(a);
			}
			System.out.println("复制成功1");
		} finally {
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
		}
	}

	public static void copyFile1() throws IOException {
		FileInputStream in = null;
		FileOutputStream out = null;
		try {
			in = new FileInputStream("E:\\test\\input.txt");
			out = new FileOutputStream("E:\\test\\output.txt");
			int a;
			while ((a = in.read()) != -1) {
				out.write(a);
			}
			System.out.println("复制成功2");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
		}
	}
}
