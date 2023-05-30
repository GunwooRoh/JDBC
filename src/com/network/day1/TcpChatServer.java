package com.network.day1;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TcpChatServer extends JFrame implements ActionListener{
	JTextArea taList;
	JScrollPane scrollpane;
	JTextField tfChat;
	JButton btSend;
	JPanel pl;
		
	DataOutputStream dos;
	String name;
	
	public TcpChatServer() {
		super("[Server]");
		
		init();
		addEvent();
	}
	
	private void init() {
		taList=new JTextArea();
		taList.setEditable(false);
		
		scrollpane=new JScrollPane(taList);
		pl=new JPanel(new BorderLayout());
		tfChat=new JTextField();
		btSend=new JButton("Send");
		pl.add(btSend,"East");
		pl.add(tfChat,"Center");
		
		add(scrollpane,"Center");
		add(pl,"South");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setSize(300,400);
		setVisible(true);
		
	}

	private void addEvent() {
		btSend.addActionListener(this);
		tfChat.addActionListener(this);
		
	}

	public static void main(String[] args) {
		TcpChatServer f = new TcpChatServer();
		f.startMain();
	}

	private void startMain() {
		System.out.println("======[Server]======\n\n");
		
		try {
			ServerSocket serverSocket=new ServerSocket(8888);
			System.out.println(TcpServer.getTime()+"서버가 준비되었습니다.\n");
			
			//클라이언트에서 요청이 들어오면 쓰레드를 생성
			System.out.println("연결 요청을 기다립니다.\n");
			Socket socket = serverSocket.accept();
			System.out.println(socket.getInetAddress()+", "
					+ socket.getPort()+" 에서 연결 요청이 들어왔습니다.\n");
			
			name="server";
			
			//출력용 스트림
			dos=new DataOutputStream(socket.getOutputStream());
			
			//쓰레드 실행
			ServerReceiver th = new ServerReceiver(socket);
			th.start();					
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	class ServerReceiver extends Thread{
		Socket socket;
		DataInputStream dis;
		
		public ServerReceiver(Socket socket) {
			this.socket=socket;
			
			//입력용 스트림
			try {
				dis=new DataInputStream(socket.getInputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public void run() {
			try {
				while(dis!=null) {
					String data;
						data = dis.readUTF();
					taList.append(data+"\n");
				}
			} catch (IOException e) {
				//e.printStackTrace();
			}
		}
	}//class
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btSend || e.getSource()==tfChat) {
			try {
				if(dos!=null) {
					dos.writeUTF("["+name+"]" + tfChat.getText()+"\n");
					tfChat.setText("");
					tfChat.requestFocus();
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

}
