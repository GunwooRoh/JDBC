package com.awt.event.day2;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;

public class BB extends Frame{
	private Label lbName, lbPwd, lbWthr, lbLoc, lbHbby,
	lbIntro;
	private TextField tfName, tfPwd;
	private TextArea taIntro;
	private Checkbox ckWthr1, ckWthr2, ckWthr3, ckWthr4, ck1, ck2, ck3;
	private CheckboxGroup group;
	private Choice chHbby;
	private Button bt1,bt2;
	
	Frame f;
	
	public BB() {
		super("일기예보");
		init();
		this.setSize(380, 500);
		this.setVisible(true);
	}
	
	
	private void init() {
		lbName = new Label("이름");
		lbPwd = new Label("비밀번호");
		tfName = new TextField(10);
		tfPwd = new TextField(10);
		tfPwd.setEchoChar('*');
		
		
		lbWthr = new Label("날씨");
		group = new CheckboxGroup();
		ckWthr1 = new Checkbox("맑음", group, false);
		ckWthr2 = new Checkbox("눈", group, false);
		ckWthr3 = new Checkbox("비", group, false);
		ckWthr4 = new Checkbox("구름", group, false);
		
		
		lbLoc = new Label("지역설정");
		ck1 = new Checkbox("서울, 경기");
		ck2 = new Checkbox("충청");
		ck3 = new Checkbox("강원");
		
		lbHbby = new Label("취미");
		chHbby = new Choice();
		
		lbIntro = new Label("자기소개");
		taIntro = new TextArea(8, 35);
		
		bt1 = new Button("저장");
		bt2 = new Button("취소");
		
		add(lbName);
		add(tfName);
		add(lbPwd);
		add(tfPwd);
		
	
		add(lbWthr);
		add(ckWthr1);
		add(ckWthr2);
		add(ckWthr3);
		add(ckWthr4);
	
		add(lbLoc);
		add(ck1);
		add(ck2);
		add(ck3);
		
	
		add(lbHbby);
		add(chHbby);
		chHbby.add("축구");
		chHbby.add("야구");
		chHbby.add("여행");
		chHbby.add("영화");

		add(lbIntro);
		add(taIntro);
		
		add(bt1);
		add(bt2);
		setLayout(new FlowLayout());
	}	

		
	public static void main(String[] args) {
		BB b = new BB();

	}

}