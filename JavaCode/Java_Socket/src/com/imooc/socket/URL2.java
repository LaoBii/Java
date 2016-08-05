package com.imooc.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class URL2 {
	public static void main(String[] args) throws IOException {
		URL url = new URL("http://www.baidu.com");
		InputStream openStream = url.openStream();
		InputStreamReader isr = new InputStreamReader(openStream,"UTF-8");
		BufferedReader br = new BufferedReader(isr);
		String data = br.readLine();
		while(data != null) {
			System.out.println(data);
			data = br.readLine();
		}
		br.close();
		isr.close();
		openStream.close();
		
	}
}
