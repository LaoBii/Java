package com.imooc.socket.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * 服务器端线程处理类
  * @title ServerThread
  * @author Administrator
  * @date 2016年8月5日 下午10:18:30
 */
public class ServerThread extends Thread {
	private Socket client = null;
	
	public ServerThread(Socket socket) {
		this.client = socket;
	}
	
	@Override
	public void run() {
		super.run();
		//3. 获取客户端的输入信息
		InputStream clientIs;
		try {
			clientIs = client.getInputStream();
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
			if(client.isClosed()) {
				System.out.println(client.getInetAddress() + "已关闭连接");
			}
			//5.关闭资源
			br.close();
			isr.close();
			clientIs.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
