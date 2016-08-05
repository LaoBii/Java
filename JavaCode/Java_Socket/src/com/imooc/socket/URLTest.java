package com.imooc.socket;

import java.net.MalformedURLException;
import java.net.URL;

public class URLTest {
	public static void main(String[] args) throws MalformedURLException {
		URL url = new URL("http://www.imooc.com");
		//?后面表示的是参数, #后面表示的是锚点
		URL urlC = new URL(url, "/index.html?username=tom#test");
		System.out.println("协议:" + urlC.getProtocol());
		System.out.println("主机:" + urlC.getHost());
		System.out.println("端口:" + urlC.getPort());
		System.out.println("文件路径:" + urlC.getPath());
		System.out.println("文件名:" + urlC.getFile());
		System.out.println("相对路径:" + urlC.getRef());
		System.out.println("查询字符串:" + urlC.getQuery());
	}
}
