package com.awt.event.day2;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseEventTest extends Frame{
	private Label lbLocation;
	
	public MouseEventTest() {
		super("MouseEvent test");
		
		init();
		addEvent();
		
		this.setSize(300,200);
		this.setVisible(true);
	}
	
	private void init() {
		lbLocation=new Label("Mouse Pointer Location : ");
		lbLocation.setBackground(Color.pink);
		
		this.add(lbLocation);
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
	}

	private void addEvent() {
		this.addMouseMotionListener(new EventHandler());
	}

	class EventHandler implements MouseMotionListener{
		@Override
		public void mouseDragged(MouseEvent e) {			
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			lbLocation.setText("Mouse Location : (" + e.getX()+" , "
					+ e.getY()+")");
		}		
	}
	
	public static void main(String[] args) {
		MouseEventTest f = new MouseEventTest();
	}

}
