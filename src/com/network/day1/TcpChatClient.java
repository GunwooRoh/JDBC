package com.network.day1;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TcpChatClient extends JFrame implements ActionListener{
	JTextArea taList;
	JScrollPane scrollpane;
	JTextField tfChat;
	JButton btSend;
	JPanel pl;
	
	DataOutputStream dos;
	String name;
	
	private String serverIp="192.168.0.44";
	private int port=8888;
	
	public TcpChatClient() {
		super("[Client]");
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
		add(pl, "South");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setSize(300,400);
		setVisible(true);
	}

	private void addEvent() {
		btSend.addActionListener(this);
		tfChat.addActionListener(this);
		
	}

	public static void main(String[] args) {
		TcpChatClient f = new TcpChatClient();
		f.startMain();
	}

	private void startMain() {
		name=JOptionPane.showInputDialog(this, "닉네임을 입력하세요");
		this.setTitle("[Client - " + name+"]");
		
		try {
			Socket socket = new Socket(serverIp, port);
			taList.append(TcpServer.getTime()+"서버에 연결되었습니다.\n");
			
			//입력용 쓰레드 실행
			ClientReceiver th = new ClientReceiver(socket);
			th.start();
			
			//출력용 스트림
			dos=new DataOutputStream(socket.getOutputStream());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//입력용 스레드
	class ClientReceiver extends Thread{
		Socket socket;
		DataInputStream dis;
		
		public ClientReceiver(Socket socket) {
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
				}//while
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
		}//if
	}

}
