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
 * �ͻ���Socket
 * <p>Title:ClientSocket </p>
 * <p>Description: </p>
 * @author liubing
 * @date 2016��8��5�� ����3:10:11
 */
public class ClientSocket {
	public static void main(String[] args) throws IOException {
		//1.�ƶ��ͻ���Socket,���ƶ���������ַ�Ͷ˿�
		Socket s = new Socket("localhost",8888);
		//2.�ͻ��������������������.
		//��ȡ�����,�������������Ϣ
		OutputStream os = s.getOutputStream();
//		PrintWriter pw = new PrintWriter(os);
//		pw.write("pw�û���: admin; ����:123");
//		pw.write("pw �ڶ���");
//		pw.flush();
		OutputStreamWriter osw = new OutputStreamWriter(os);
		osw.write("osw�û���: admin; ����:123");
		osw.write("osw�ڶ���");
		osw.flush();
		s.shutdownOutput();
		//3.��ȡ������,��ȡ��������Ӧ����
		InputStream inputStream = s.getInputStream();
		InputStreamReader isr = new InputStreamReader(inputStream);
		BufferedReader br = new BufferedReader(isr);
		String msg = null;
		while((msg = br.readLine()) != null) {
			System.out.println("���ǿͻ���, ������˵:" + msg);
		}
		//4.�ر���Դ
		br.close();
		isr.close();
		inputStream.close();
		osw.close();
		os.close();
		s.close();
	}
}
