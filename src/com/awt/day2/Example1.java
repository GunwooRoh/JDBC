package com.awt.day2;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Panel;

class MyPanel2 extends Panel {
	public Insets getInsets() {
		Insets insets = new Insets(10, 10, 10, 10);
		return insets;
	}
}

public class Example1 extends Frame {
	Button bt1, bt2, bt3, bt4, bt5, bt6;
		
	public Example1() {
		super("Example1");
		 this.setLayout(new BorderLayout());

		
		
		MyPanel2 pl1 = new MyPanel2();
		pl1.setBackground(Color.pink);
		pl1.setLayout(new GridLayout(2, 2, 10, 10));
		
		MyPanel2 pl2 = new MyPanel2();
		pl2.setBackground(Color.cyan);
		pl2.setLayout(new GridLayout(1, 2, 10, 10));
		
		
		bt1 = new Button("1");
		bt2 = new Button("2");
		bt3 = new Button("3");
		bt4 = new Button("4");
		
		
		pl1.add(bt1);
		pl1.add(bt2);
		pl1.add(bt3);
		pl1.add(bt4);
		
		
		bt5 = new Button("5");
		bt6 = new Button("6");
		
		pl2.add(bt5);
		pl2.add(bt6);
		
		this.add(pl1, "Center");
		this.add(pl2, "East");
		
		this.setSize(300, 300);
		this.setVisible(true);
	}
	
	public Insets getExample1() {
		Insets insets = new Insets (40, 40, 40 ,40); 
		return insets;
		
	}
		public static void main(String[] args) {
			Example1 e = new Example1();
	}

}