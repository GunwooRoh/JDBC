package com.awt.event.day2;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Homework3 extends Frame implements ActionListener {
	private Label lb1, lb2, lb3;
	private TextField tf1, tf2, tf3;
	private Button bt1, bt2;
	private Panel pl, pl2;
	
	public Homework3() {
		super("덧셈");
		
		init();
		addEvent();
		setLayout(new GridLayout(1,2,10,10));
		setSize(300,300);
		setVisible(true);
	}

	private void init() {
		pl = new Panel();
		pl.setBackground(Color.pink);
		pl.setLayout(new GridLayout(4,1,10,10));
		
		lb1 = new Label("첫번째 숫자 :");
		lb2 = new Label("두번째 숫자 :");
		lb3 = new Label("결과 :");
		
		pl2 = new Panel();
		pl2.setBackground(Color.pink);
		pl2.setLayout(new GridLayout(4,1,10,10));
		
		tf1 = new TextField();
		tf2 = new TextField();
		tf3 = new TextField();
		tf3.setEditable(false);
		
		
		bt1 = new Button("더하기");
		bt2 = new Button("화면 지우기");
		
		
		pl.add(lb1);
		pl.add(lb2);
		pl.add(lb3);
		pl2.add(tf1);
		pl2.add(tf2);
		pl2.add(tf3);
		pl.add(bt1);
		pl2.add(bt2);
		
		add(pl);
		add(pl2);
	}
	
	
	private void addEvent() {
		bt1.addActionListener(this);
		bt2.addActionListener(this);
	}


	public static void main(String[] args) {
		Homework3 h3 = new Homework3();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
	    if (e.getSource() == bt1) {
	        String num1 = tf1.getText();
	        String num2 = tf2.getText();
	        
		
		if (num1.isEmpty() || num2.isEmpty()) {
            tf3.setText("숫자를 입력하세요");
        } else {
            try {
                int sum = Integer.parseInt(num1) + Integer.parseInt(num2);
                tf3.setText(Integer.toString(sum));
            } catch (NumberFormatException ex) {
                tf3.setText("숫자를 입력하세요");
            	}
        	}
		}else if(e.getSource()==bt2) {
			tf1.setText("");
			tf2.setText("");
			tf3.setText("");
		}
	}
}
