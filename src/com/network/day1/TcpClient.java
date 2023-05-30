package com.network.day1;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClient {

	public static void main(String[] args) {
		String serverIp="192.168.0.13";
		int port=7777;
		System.out.println("서버에 연결중입니다. 서버IP:"+ serverIp);
		
		DataInputStream dis=null;
		Socket socket=null;
		try {
			// 소켓을 생성하여 연결을 요청한다
			socket=new Socket(serverIp, port);
			
			// 소켓의 입력스트림을 얻는다.
			InputStream is = socket.getInputStream();
			dis=new DataInputStream(is);
			
			// 소켓으로 부터 받은 데이터를 출력한다
			System.out.println("서버로부터 받은 메시지: "+ dis.readUTF());
			System.out.println("연결을 종료합니다.");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			// 스트림과 소켓을 닫는다.
			try {
				if(dis!=null)dis.close();
				if(socket!=null)socket.close();
				System.out.println("연결이 종료되었습니다.");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		

	}

}
