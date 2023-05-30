package com.network.day1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TcpServer2 {

	public static void main(String[] args) {
		ServerSocket serverSocket=null;

		try {
			// 서버소켓을 생성하여 7777번 포트와 결합(bind)시킨다.
			serverSocket=new ServerSocket(7777);
			System.out.println(getTime()+"서버가 준비되었습니다.");			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		while(true) {
			System.out.println(getTime()+"연결요청을 기다립니다.");
			// 서버소켓은 클라이언트의 연결요청이 올 때까지 실행을 멈추고 계속 기다린다.
			// 클라이언트의 연결요청이 오면 클라이언트 소켓과 통신할 새로운 소켓을 생성한다.
			
			DataOutputStream dos=null;
			Socket socket = null;
			DataInputStream dis=null;
			
			try {
				socket = serverSocket.accept();
				System.out.println(getTime()+socket.getInetAddress()
						+"로부터 연결요청이 들어왔습니다.");
				
				//소켓의 출력스트림을 얻는다
				OutputStream os = socket.getOutputStream();
				dos=new DataOutputStream(os);
				dos.writeUTF("서버가 메시지를 보냅니다.");
				System.out.println(getTime()+"데이터를 전송했습니다.");
				
				// 소켓의 입력스트림을 얻는다.
				InputStream is = socket.getInputStream();
				dis=new DataInputStream(is);
				
				// 원격 소켓으로 부터 받은 데이터를 출력한다.
				System.out.println(getTime()+" 클라이언트로부터 받은 메시지:"+ dis.readUTF());
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				try {
					if(dos!=null)dos.close();
					if(dis!=null)dis.close();
					if(socket!=null)socket.close();					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}//while
	}

	public static String getTime() {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("[HH:mm:ss] ");
		String str=sdf.format(d);
		return str;
	}
}




