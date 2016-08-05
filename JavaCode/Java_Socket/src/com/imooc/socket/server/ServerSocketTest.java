package com.imooc.socket.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.SocketAddress;

public class ServerSocketTest {
	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket();
		InetSocketAddress sa = new InetSocketAddress("LIUBING", 2233);
		ss.bind(sa);
		while(true) {
			ss.accept();
		}
	}
}
