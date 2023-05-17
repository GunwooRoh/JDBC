package com.awt.event.day1;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

class EventHandler implements WindowListener{

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	// Frame의 닫기 버튼을 눌렀을 때 호출된다
	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("프로그램 종료함!");
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}

public class EventTest1 extends Frame{

	public EventTest1() {
		super("Event test");
		this.setSize(300,200);
		
		this.addWindowListener(new EventHandler());
	}	
	
	public static void main(String[] args) {
		EventTest1 f = new EventTest1();
		f.setVisible(true);				
	}
}




