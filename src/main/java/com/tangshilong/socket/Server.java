package com.tangshilong.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
	private static final int MAX_THREAD = 50;
	private static final int PORT = 10086;
	public static void main(String[] args) throws IOException {
		/**
		 * 单线程服务端，阻塞
		 */
		//singleThead(PORT);
		/**
		 * 多线程服务端，非阻塞
		 */
		MultiThread(PORT);
	}

	@SuppressWarnings("resource")
	public static void MultiThread(int port) throws IOException {
		ExecutorService pool = Executors.newFixedThreadPool(MAX_THREAD);
		ServerSocket serverSocket  = new ServerSocket(port);
		while(true){
			//serveSocket接受到客户端请求则新建线程
			Socket server = serverSocket.accept();
			pool.execute(new MultithreadServer(server));
		}
	}

	public static void singleThead(int port) {
		try {
			Thread thread = new SingleThreadServer(10086);
			thread.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
