package com.awt.day2;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;

class MyPanel3 extends Panel {
	public Insets getInsets() {
		Insets insets = new Insets(10, 10, 10, 10);
		return insets;
	}
}

public class Homework2 extends Frame {
	Frame f;
	Button bt1, bt2, bt3, bt4, bt5;
	Label lbTa;
	TextArea ta;
	
		public Homework2() {
			super("게시판");
			
			
		MyPanel3 pl1 = new MyPanel3();	
		pl1.setLayout(new GridLayout(1, 2, 10, 10));
			
		Label lbTa = new Label("글쓰기 : " , Label.ABORT);
		Label lbJm1 = new Label("주민번호 : ", Label.RIGHT);

		ta = new TextArea(5, 30);
	
		
		this.add(ta, "Center");

		
		bt1 = new Button("글쓰기");
		bt2 = new Button("새로고침");
		
		
		
		pl1.add(bt1);
		pl1.add(bt2);
		this.add(pl1, "South");
		
		MyPanel3 pl2 = new MyPanel3();	
		pl1.setLayout(new GridLayout(2, 1, 10, 10));
		
		
	    setSize(750, 600);
	    setVisible(true);
		}
		
public Insets getInsetTest() {
		Insets insets = new Insets (10, 10, 10 ,10); 
		return insets;
}

	public static void main(String[] args) {
		Homework2 h2 = new Homework2();

	}

}
