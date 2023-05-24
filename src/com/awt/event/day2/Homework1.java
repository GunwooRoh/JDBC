package com.awt.event.day2;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Homework1 extends Frame implements ActionListener{

	private Checkbox ck1,ck2,ck3, ck4, ck5, ck6, ck7, ck8;
	private CheckboxGroup group;
	private Button btOk;
	private Label lb1, lb2, lb3, lbr;
	private Panel pl;
	
	//43
	public Homework1() {
		super("CheckboxEventTest");
		
		init();
		addEvent();
		
		this.setSize(800,500);
		this.setVisible(true);
	}
	
	private void init() {
		pl = new Panel();
		pl.setLayout(new GridLayout(13, 1));
		lb1 = new Label("1. 다음 중 ActionEvent의 actionPerformed 메서드가 호출되는 경우는? (모두 고르세요)");
		ck1 = new Checkbox("Button을 눌렀을때");
		ck2 = new Checkbox("TextField에서 Enter키를 눌렀을때");
		ck3 = new Checkbox("MenuItem을 클릭했을때");
		ck4 = new Checkbox("List에서 더블클릭으로 item을 선택했을때");
		
		this.setLayout(new FlowLayout());
		
		group=new CheckboxGroup();
		lb2 =new Label("2. Frame의 기본 LayoutManager는? (하나만 고르세요)");
		ck5 = new Checkbox("FlowLayout", group, false);
		ck6 = new Checkbox("GridLayout", group, false);
		ck7 = new Checkbox("BorderLayout", group, false);
		ck8 = new Checkbox("CardLayout", group, false);
		
		
		btOk=new Button("결과 확인");
		
		lbr= new Label("");
		pl.add(lb1);
		pl.add(ck1);
		pl.add(ck2);
		pl.add(ck3);
		pl.add(ck4);
		
		this.setLayout(new FlowLayout());
		
		
		pl.add(lb2);
		pl.add(ck5);
		pl.add(ck6);
		pl.add(ck7);
		pl.add(ck8);
		pl.add(btOk);
		
		pl.add(lbr);
		add(pl);
	}

	private void addEvent() {
		btOk.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		double result = 0;
		if(ck1.getState())  {
			result += 12.5;
		}if(ck2.getState()) {
			result += 12.5;
		}if(ck3.getState()) {
			result += 12.5;
		}if(ck4.getState()) {
			result += 12.5;	
		}if(ck7.getState()) {
			result += 50;	
		}else {
			result += 0;
		}
		
		lbr.setText("*결과 : 당신의 점수는" + result + "점 입니다.");
	
	}
	
	public static void main(String[] args) {
		Homework1 ac = new Homework1();				
	}

}
