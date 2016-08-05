package com.imooc.socket.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * ���������̴߳�����
  * @title ServerThread
  * @author Administrator
  * @date 2016��8��5�� ����10:18:30
 */
public class ServerThread extends Thread {
	private Socket client = null;
	
	public ServerThread(Socket socket) {
		this.client = socket;
	}
	
	@Override
	public void run() {
		super.run();
		//3. ��ȡ�ͻ��˵�������Ϣ
		InputStream clientIs;
		try {
			clientIs = client.getInputStream();
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
			if(client.isClosed()) {
				System.out.println(client.getInetAddress() + "�ѹر�����");
			}
			//5.�ر���Դ
			br.close();
			isr.close();
			clientIs.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
