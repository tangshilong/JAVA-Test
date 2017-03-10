package com.tangshilong.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * 多线程 非阻塞
 * 
 * @author tangshilong
 *
 */
public class MultithreadServer extends Thread {
	private static Socket socket;

	public MultithreadServer(Socket server) {
		this.setSocket(server);
	}

	public void run() {
		System.out.println("Just connect to "+socket.getRemoteSocketAddress());
		try {
			DataInputStream in = new DataInputStream(socket.getInputStream());
			System.out.println("Client say "+in.readUTF());
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			out.writeUTF("Thank you for connecting to "+socket.getLocalAddress()+"\nGoodBye !");
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket1) {
		socket = socket1;
	}

}
