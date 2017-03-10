package com.tangshilong.socket;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientTest {
	private static final String SocketName = "localhost";
	private static final Integer port = 10086;

	/**
	 * DataIOnputStream 可以操作的流 可以用.writeUTF()和.readUTF()读取所有流
	 * 
	 * @param args
	 * @throws UnknownHostException
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket client = new Socket(SocketName, port);
		System.out.println("连接到服务器:" + SocketName + "\n端口为:" + port);
		OutputStream outtoserver = client.getOutputStream();
		DataOutputStream outputStream = new DataOutputStream(outtoserver);
		outputStream.writeUTF("client" + client.getLocalAddress() + " say hello !");
		InputStream infromserver = client.getInputStream();
		DataInputStream inputStream = new DataInputStream(infromserver);
		System.out.println("server " + client.getInetAddress() + " say: " + inputStream.readUTF());
		BufferedReader br = new BufferedReader(new InputStreamReader(infromserver, "UTF-8"));
		while (br.readLine() != null) {
			br.readLine();
		}
		br.close();
	}
}
