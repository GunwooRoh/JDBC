package com.awt.event.day1;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionTest extends Frame {
	Button bt;
	TextField tf;
	Label lb;
	

	public ActionTest() {
		super("버튼 클릭");
		
		this.setLayout(new FlowLayout());
		tf = new TextField(20);
		bt = new Button("OK");
		lb = new Label("여기에 결과가 출력됩니다.");
		
		this.add(tf);
		this.add(bt);
		add(lb);
		
		bt.addActionListener(new EventHandler2());
		
		this.setSize(400, 200);
		this.setVisible(true);
		
	}
	
	
	public static void main(String[] args) {
		ActionTest f = new ActionTest();
	}

class EventHandler2 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			lb.setText(tf.getText() + ", " + cmd + " Button Clicked");
		
		}
	
}
	
}
