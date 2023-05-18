package com.awt.event.day2;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ItemTest extends Frame implements ItemListener{
	private Checkbox ck1, ck2, ck3;
	private CheckboxGroup group;
	private TextField tfResult;
	
	public ItemTest() {
		super("ItemEvent test");
		
		init();
		addEvent();
		
		this.setSize(300,200);
		this.setVisible(true);
	}
	
	private void init() {
		group=new CheckboxGroup();  
		ck1 = new Checkbox("java", group, false);
		ck2 = new Checkbox("spring", group, false);
		ck3 = new Checkbox("oracle", group, false);
		tfResult=new TextField(30);  
		
		this.setLayout(new FlowLayout());
		this.add(ck1);
		this.add(ck2);
		this.add(ck3);
		this.add(tfResult);
	}

	private void addEvent() {
		//이벤트 소스 : 체크박스 3개
		//리스너 : ItemListener
		ck1.addItemListener(this);
		ck2.addItemListener(this);
		ck3.addItemListener(this);		
	}
	
	public static void main(String[] args) {
		ItemTest f = new ItemTest();
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		Checkbox ck = (Checkbox) e.getSource();
		String str=ck.getLabel();
		tfResult.setText(str);
	}

}




