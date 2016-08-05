package com.imooc.socket;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {
	public static void main(String[] args) throws UnknownHostException {
		InetAddress addr = InetAddress.getLocalHost();
		System.out.println("计算机名" + addr.getHostName());
		System.out.println("计算机名" + addr.getHostAddress());
	}
}
