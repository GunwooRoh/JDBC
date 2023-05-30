package com.network.day1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

//데이터를 보내는 측
public class UDPClient {
	public static final int port=3000;
	
	public static void main(String[] args) throws IOException {
		/* 데이터 그램 소켓 생성 후 소켓 객체의 send() 메서드에 
		   데이터그램 패킷 객체를 매개변수로 넣어서 전송*/
		InetAddress inet = InetAddress.getByName("192.168.0.13");
		
		//키보드로 보낼 메시지를 입력받는다
		Scanner sc = new Scanner(System.in);
		
		String msg="";
		System.out.println("보낼 내용 입력:");
		DatagramPacket packet = null;
		DatagramSocket dataSocket=new DatagramSocket();
		
		while((msg=sc.nextLine())!=null) {
			if(msg.equalsIgnoreCase("x")) break;
			
			byte[] data=msg.getBytes();
			packet=new DatagramPacket(data, data.length, inet, port);
			dataSocket.send(packet);
			
			System.out.println("보낼 내용 입력: ");
		}//while
		
	}
}










