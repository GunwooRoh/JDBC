package com.network.day1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

//데이터를 받는 측
public class UDPServer {

	public static void main(String[] args) throws IOException {
		//클라이언트(송신자)가 보낸 데이터를 담아줄 바이트 배열을 생성
		byte[] buffer = new byte[100];
		
		DatagramSocket dataSocket=new DatagramSocket(3000);
		//=> DatagramSocket 생성시 클라이언트 포트 번호를 매개변수로 지정

		DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
		//=> 버퍼 배열을 DatagramPacket 객체 생성시 매개변수로 지정
		
		while(true) {
			//DatagramSocket의 receive()메서드를 이용하여 패킷을 받는다
			dataSocket.receive(packet);
			
			byte[] bmsg = packet.getData();
			//버퍼 배열에 담긴 데이터를 문자열로 만들어 출력
			String msg=new String(bmsg,0,packet.getLength());
			//String(byte[] bytes, int offset, int length)
			
			System.out.println(packet.getAddress()+"로부터 >>" 
					+ packet.getPort() +"번 포트에서 온 메시지 : " + msg);
		}//while
				
	}

}






