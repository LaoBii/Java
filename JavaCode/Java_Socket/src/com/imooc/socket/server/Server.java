package com.imooc.socket.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.concurrent.CountDownLatch;

import javax.swing.plaf.SliderUI;

/**
 * 基于TCP协议的Socket通信,实现用户登录<br/>
 * 为了支持一个服务端可连接多个客户端,可采用多线程的方式来处理<br/>
 * 基本操作步骤:<br/>
 * 			1.服务器创建ServerSocket,循环调用accept()方法等待客户端连接<br/>
 * 			2.客户端创建一个Socket请求服务器<br/>
 * 			3.服务器接收请求后,创建Socket与请求的客户端进行专线连接 <br/>
 * 			4.建立连接的两个Socket在一个单独的线程上对话<br/>
  * @title Server
  * @author Administrator
  * @date 2016年8月5日 下午9:44:35
 */
public class Server {
	public static void main(String[] args) throws IOException {
		Server s = new Server();
		s.mutilThreadSocket();
		
	}
	
	public void mutilThreadSocket() throws IOException {
		//创建一个ServerSocket
		ServerSocket ss = new ServerSocket(8888);
		Socket socket;
		int count = 0;
		System.out.println("****服务器即将启动,等待客户端的连接***");
		while(true) {
			//开始监听端口
			socket = ss.accept();
			new ServerThread(socket).start();
			count++;
			System.out.println("客户端连接数:" + count);
		}
	}
	
	public void singleTreadSocket() throws IOException {
		//1. 创建一个服务器端的ServerSocket,绑定制定的端口,并监听端口
		ServerSocket ss = new ServerSocket(8888);
		//2. 调用ss.accept()方法开始监听,等待客户端的连接请求
		while (true) {
			System.out.println("****服务器即将启动,等待客户端的连接***");
			Socket client = ss.accept();
			//3. 获取客户端的输入信息
			InputStream clientIs = client.getInputStream();
			InputStreamReader isr = new InputStreamReader(clientIs);
			BufferedReader br = new BufferedReader(isr);
			String mes = null;
			while((mes = br.readLine()) != null) {
				System.out.println("我是服务器,客户端说:" + mes);
			}
			client.shutdownInput();
			//4.获取ServerSocket输出流,相应客户端请求
			OutputStream outputStream = client.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(outputStream);
			osw.write("服务器欢迎你");
			osw.flush();
			client.shutdownOutput();
			//5.关闭资源
			br.close();
			isr.close();
			clientIs.close();
			client.close();
		}
	}
}
