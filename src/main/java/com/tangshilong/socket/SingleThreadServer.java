package com.tangshilong.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
/**
 * 单线程 阻塞
 * @author tangshilong
 *
 */
public class SingleThreadServer extends Thread {
	private static ServerSocket serverSocket;

	public SingleThreadServer(Integer port) throws IOException {
		serverSocket= new ServerSocket(port);
		serverSocket.setSoTimeout(10000);;
	}
	
	public void run(){
		while (true) {
			System.out.println("waiting for client on port " + serverSocket.getLocalPort()+"...");
			try {
				Socket server = serverSocket.accept();
				System.out.println("Just connect to "+server.getRemoteSocketAddress());
				DataInputStream dataInputStream =new DataInputStream(server.getInputStream());
				System.out.println("client say "+dataInputStream.readUTF());
				DataOutputStream dataOutputStream =new DataOutputStream(server.getOutputStream());
				dataOutputStream.writeUTF("Thank you for connecting to "+ server.getLocalSocketAddress()+"\ngoodbye!");
				server.close();
			} catch (SocketTimeoutException e) {
				System.out.println("Socked timed out!");
//				e.printStackTrace();
				continue;
			} catch (IOException e) {
				e.printStackTrace();
				break;
			}
		}
	}
	
}
