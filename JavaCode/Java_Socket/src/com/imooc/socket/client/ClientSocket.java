package com.imooc.socket.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;

import javax.net.SocketFactory;

/**
 * 客户端Socket
 * <p>Title:ClientSocket </p>
 * <p>Description: </p>
 * @author liubing
 * @date 2016年8月5日 下午3:10:11
 */
public class ClientSocket {
	public static void main(String[] args) throws IOException {
		//1.制定客户端Socket,并制定服务器地址和端口
		Socket s = new Socket("localhost",8888);
		//2.客户端与服务器端连接上了.
		//获取输出流,想服务器发送信息
		OutputStream os = s.getOutputStream();
//		PrintWriter pw = new PrintWriter(os);
//		pw.write("pw用户名: admin; 密码:123");
//		pw.write("pw 第二行");
//		pw.flush();
		OutputStreamWriter osw = new OutputStreamWriter(os);
		osw.write("osw用户名: admin; 密码:123");
		osw.write("osw第二行");
		osw.flush();
		s.shutdownOutput();
		//3.获取输入流,获取服务器响应数据
		InputStream inputStream = s.getInputStream();
		InputStreamReader isr = new InputStreamReader(inputStream);
		BufferedReader br = new BufferedReader(isr);
		String msg = null;
		while((msg = br.readLine()) != null) {
			System.out.println("我是客户端, 服务器说:" + msg);
		}
		//4.关闭资源
		br.close();
		isr.close();
		inputStream.close();
		osw.close();
		os.close();
		s.close();
	}
}
