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
 * ����TCPЭ���Socketͨ��,ʵ���û���¼<br/>
 * Ϊ��֧��һ������˿����Ӷ���ͻ���,�ɲ��ö��̵߳ķ�ʽ������<br/>
 * ������������:<br/>
 * 			1.����������ServerSocket,ѭ������accept()�����ȴ��ͻ�������<br/>
 * 			2.�ͻ��˴���һ��Socket���������<br/>
 * 			3.���������������,����Socket������Ŀͻ��˽���ר������ <br/>
 * 			4.�������ӵ�����Socket��һ���������߳��϶Ի�<br/>
  * @title Server
  * @author Administrator
  * @date 2016��8��5�� ����9:44:35
 */
public class Server {
	public static void main(String[] args) throws IOException {
		Server s = new Server();
		s.mutilThreadSocket();
		
	}
	
	public void mutilThreadSocket() throws IOException {
		//����һ��ServerSocket
		ServerSocket ss = new ServerSocket(8888);
		Socket socket;
		int count = 0;
		System.out.println("****��������������,�ȴ��ͻ��˵�����***");
		while(true) {
			//��ʼ�����˿�
			socket = ss.accept();
			new ServerThread(socket).start();
			count++;
			System.out.println("�ͻ���������:" + count);
		}
	}
	
	public void singleTreadSocket() throws IOException {
		//1. ����һ���������˵�ServerSocket,���ƶ��Ķ˿�,�������˿�
		ServerSocket ss = new ServerSocket(8888);
		//2. ����ss.accept()������ʼ����,�ȴ��ͻ��˵���������
		while (true) {
			System.out.println("****��������������,�ȴ��ͻ��˵�����***");
			Socket client = ss.accept();
			//3. ��ȡ�ͻ��˵�������Ϣ
			InputStream clientIs = client.getInputStream();
			InputStreamReader isr = new InputStreamReader(clientIs);
			BufferedReader br = new BufferedReader(isr);
			String mes = null;
			while((mes = br.readLine()) != null) {
				System.out.println("���Ƿ�����,�ͻ���˵:" + mes);
			}
			client.shutdownInput();
			//4.��ȡServerSocket�����,��Ӧ�ͻ�������
			OutputStream outputStream = client.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(outputStream);
			osw.write("��������ӭ��");
			osw.flush();
			client.shutdownOutput();
			//5.�ر���Դ
			br.close();
			isr.close();
			clientIs.close();
			client.close();
		}
	}
}
