package com.imooc.socket;

import java.net.MalformedURLException;
import java.net.URL;

public class URLTest {
	public static void main(String[] args) throws MalformedURLException {
		URL url = new URL("http://www.imooc.com");
		//?�����ʾ���ǲ���, #�����ʾ����ê��
		URL urlC = new URL(url, "/index.html?username=tom#test");
		System.out.println("Э��:" + urlC.getProtocol());
		System.out.println("����:" + urlC.getHost());
		System.out.println("�˿�:" + urlC.getPort());
		System.out.println("�ļ�·��:" + urlC.getPath());
		System.out.println("�ļ���:" + urlC.getFile());
		System.out.println("���·��:" + urlC.getRef());
		System.out.println("��ѯ�ַ���:" + urlC.getQuery());
	}
}
