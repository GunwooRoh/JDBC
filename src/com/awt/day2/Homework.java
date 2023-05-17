package com.awt.day2;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;

public class Homework extends Frame {
	Button bt;
	TextField tf;
	Label lb;
	
		public Homework() {
			super("레이아웃 실습");
	        this.setLayout(new FlowLayout());
	      
			Label lbId = new Label("ID : " , Label.RIGHT);
			Label lbJm1 = new Label("주민번호 : ", Label.RIGHT);
			
			TextField tfId = new TextField(10);
			TextField tfJm1 = new TextField(5);
			TextField tfJm2 = new TextField(5);
			
			tfJm1.setEchoChar('*');
			tfJm2.setEchoChar('*');
			
			Button bt1 = new Button("확인");
			Button bt2 = new Button("취소");
			
			
	        lbId.setBounds(10, 50, 30, 10); // x, y, width, height
	        tfId.setBounds(80, 50, 50, 10);
	        lbJm1.setBounds(10, 80, 30, 10);
	        tfJm1.setBounds(77, 80, 50, 10);
	        tfJm2.setBounds(77, 80, 50, 10);
	        bt1.setBounds(225, 80, 60, 20);
	        bt2.setBounds(225, 130, 60, 20);
			
			this.setLayout(new FlowLayout());
		    this.add(lbId);
		    this.add(tfId);      
		    this.add(lbJm1);
		    this.add(tfJm1);
		    this.add(tfJm2);
		    
		    this.add(bt1, "East");
		    this.add(bt2, "East");
		    
		    setSize(225,150);
		    setVisible(true);
		}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Homework h1 = new Homework();
	}

}
