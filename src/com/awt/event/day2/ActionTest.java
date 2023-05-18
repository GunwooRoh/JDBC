package com.awt.event.day2;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionTest extends Frame implements ActionListener{
	private Checkbox ck1,ck2,ck3, ckM, ckF;
	private CheckboxGroup group;
	private Button btOk;
	
	public ActionTest() {
		super("ActionEvent");
		
		init();
		addEvent();
		
		this.setSize(350,200);
		this.setVisible(true);
	}
	
	private void init() {
		ck1=new Checkbox("java");
		ck2=new Checkbox("c");
		ck3=new Checkbox("c++");
		
		group=new CheckboxGroup();
		ckM=new Checkbox("Male", group, false);
		ckF=new Checkbox("FeMale", group, false);
		
		btOk=new Button("OK");
		
		this.setLayout(new FlowLayout());
		this.add(ck1);
		this.add(ck2);
		this.add(ck3);
		this.add(ckM);
		this.add(ckF);
		this.add(btOk);
	}

	private void addEvent() {
		btOk.addActionListener(this);
	}

	public static void main(String[] args) {
		ActionTest f = new ActionTest();				
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String result="";
		if(ckM.getState()) {
			result="남자";
		}else if(ckF.getState()) {
			result="여자";
		}
		
		//=> Checkbox의 getState() 를 이용해서 Checkbox의 상태 
		//(선택되었는지, 선택되지 않았는지) 을 알 수 있음

		String str="";
		if(ck1.getState()) {
			str+=ck1.getLabel()+ " ";
		}
		if(ck2.getState()) {
			str+=ck2.getLabel()+ " ";
		}
		if(ck3.getState()) {
			str+=ck3.getLabel()+ " ";
		}
		
		System.out.println("성별 : " + result+", 선택한 언어:"+ str);
	}

}
