package com.awt.event.day1;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AdapterTest extends Frame {
	public AdapterTest() {
		super("Adapter Test");
		/*
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				super.windowClosing(e);
			}
			
			
		});*/
		this.addWindowListener(new EventHandler());
		
		this.setSize(300, 200);
		this.setVisible(true);
	
	
	}

	class EventHandler extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			System.out.println("종료");
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		AdapterTest a = new AdapterTest();

	}

}
