package com.awt.day2;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.TextArea;

class MyPanel extends Panel {
	public Insets getInsets() {
		Insets insets = new Insets(10, 10, 10, 10);
		return insets;
	}
}

public class InsetTest extends Frame {
	Button bt1, bt2;
	TextArea ta;
		
	public InsetTest() {
		super("Inset Test");
		
		MyPanel pl = new MyPanel();
		pl.setBackground(Color.green);
		pl.setLayout(new GridLayout(1, 2, 10, 10));
		
		bt1 = new Button("OK");
		bt2 = new Button("Cancel");
		
		pl.add(bt1);
		pl.add(bt2);
		
		ta = new TextArea(5, 30);
		this.add(ta, "Center");
		this.add(pl, "South");
		
		this.setSize(300, 300);
		this.setVisible(true);
	}
	
	public Insets getInsetTest() {
		Insets insets = new Insets (10, 10, 10 ,10); 
		return insets;
		
	}
		public static void main(String[] args) {
			InsetTest f = new InsetTest();
	}

}
