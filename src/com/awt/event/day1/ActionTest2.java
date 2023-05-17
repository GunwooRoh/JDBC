package com.awt.event.day1;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionTest2 extends Frame {
	Label lbId, lbPwd;
	TextField tfId, tfPwd;
	Button btOK;
	
	public ActionTest2() {
		super("login");
		
		lbId = new Label("ID : " , Label.RIGHT);
		lbPwd = new Label("Password : ", Label.RIGHT);
		
		tfId = new TextField(10);
		tfPwd = new TextField(10);
		tfPwd.setEchoChar('*');
		
		btOK = new Button("OK");
		
		btOK.addActionListener(new EventHandler());
		tfId.addActionListener(new EventHandler());
		tfPwd.addActionListener(new EventHandler());
		
		this.setLayout(new FlowLayout());
	    this.add(lbId);
	    this.add(tfId);      
	    this.add(lbPwd);
	    this.add(tfPwd);
	    add(btOK);
	    
	    setSize(450,100);
	    setVisible(true);

	}
	
	class EventHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String id = tfId.getText();
			String pwd = tfPwd.getText();
			if(!id.equals("hong")) {
				System.out.println("해당 아이디가 없습니다.");
			}else if (!pwd.equals("1234")) {
				System.out.println("비밀번호가 틀렸습니다.");
				tfId.requestFocus();
				tfId.selectAll();
			}else {
				System.out.println(id + "님, 성공적으로 로그인 되었습니다.");
			}
			
		}
		
	}

	public static void main(String[] args) {
		ActionTest2 f = new ActionTest2();
	}
}

