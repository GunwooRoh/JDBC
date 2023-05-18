package com.awt.event.day2;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyEventTest extends Frame implements KeyListener{
	private Label lb1, lb2;
	private TextField tfSsn1, tfSsn2;
	
	public KeyEventTest() {
		super("KeyEvent Test");
		
		init();
		addEvent();
		
		this.setSize(400,100);
		this.setVisible(true);
	}
	
	private void init() {
		lb1=new Label("ID Card Number : ");
		lb2=new Label(" - ");
		tfSsn1=new TextField(10);
		tfSsn2=new TextField(10);
		
		this.setLayout(new FlowLayout());
		this.add(lb1);
		this.add(tfSsn1);		
		this.add(lb2);
		this.add(tfSsn2);		
	}
	
	private void addEvent() {
		tfSsn1.addKeyListener(this);
	}


	public static void main(String[] args) {
		KeyEventTest f = new KeyEventTest();
	}

	@Override
	public void keyTyped(KeyEvent e) {		
	}

	@Override
	public void keyPressed(KeyEvent e) {		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		String ssn1=tfSsn1.getText().trim();
		if(ssn1.length()==6) {
			tfSsn2.requestFocus();
		}
	}

}












