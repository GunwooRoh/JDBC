package com.awt.event.day2;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HandlerTest extends Frame{
	private Button bt, bt2;
	
	public HandlerTest() {
		super("이벤트 핸들러1");
		
		init();
		addEvent();
		this.setSize(300,300);
		this.setVisible(true);
	}
	
	private void init() {
		bt=new Button("one");
		bt2=new Button("two");
		
		this.setLayout(new FlowLayout());
		this.add(bt);
		this.add(bt2);
	}

	private void addEvent() {
		//1. 내부 클래스 이용
		bt.addActionListener(new EventHandler());
		
		//2. 익명 클래스 이용
		bt2.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("종료!!");
				System.exit(0);
			}
		});
	}

	class EventHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("종료");
			System.exit(0);
		}		
	}//class
	
	public static void main(String[] args) {
		HandlerTest f = new HandlerTest();
	}

}
