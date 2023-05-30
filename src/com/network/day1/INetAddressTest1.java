package com.network.day1;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class INetAddressTest1 {

	public static void main(String[] args) {
		// InetAddress 클래스 : IP 주소를 다루기 위한 클래스
		
		try {
			System.out.println("===============naver.com==============");
			InetAddress ip=InetAddress.getByName("www.naver.com");
			System.out.println(ip);
			
			System.out.println("hostName:"+ ip.getHostName());
			System.out.println("hostAddress:"+ ip.getHostAddress());
			
			System.out.println("\n============Localhost================");
			ip=InetAddress.getLocalHost();
			System.out.println(ip);
			
			System.out.println("hostName : " + ip.getHostName());			
			System.out.println("hostAddress : " + ip.getHostAddress());
			System.out.println();
			
			InetAddress[] ipArr=InetAddress.getAllByName("www.naver.com");
			for(int i=0;i<ipArr.length;i++) {
				System.out.println(i + " : " + ipArr[i]);
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
	}

}
