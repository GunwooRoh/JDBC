package com.awt.event.day2;

import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChattingTest extends Frame implements ActionListener{
	private TextArea ta;
	private TextField tf;
	private String nickName;
	
	public ChattingTest(String nickName) {
		super("Chatting");
		this.nickName=nickName;
		
		init();
		addEvent();
		
		this.setSize(350,300);
		this.setVisible(true);
		tf.requestFocus();
	}
	
	private void init() {
		ta = new TextArea();
		tf=new TextField();
		ta.setText("#" + nickName +"님 즐거운 채팅되세요");
		ta.setEditable(false);
		
		this.add(ta,"Center");
		this.add(tf,"South");		
	}

	private void addEvent() {
		tf.addActionListener(this);
	}

	public static void main(String[] args) {
		ChattingTest f = new ChattingTest("hong");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String msg=tf.getText();
		if(msg.trim().equals("")) return;
		
		ta.append("\r\n"+nickName+">"+ msg);
		tf.setText("");
	}

}




