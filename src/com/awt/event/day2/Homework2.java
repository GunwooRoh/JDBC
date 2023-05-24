package com.awt.event.day2;

import java.awt.Choice;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Homework2 extends Frame{
	private Choice ch;
	private List list;
	private Label lb1, lb2;
	private TextField tf;
	
	//45
	public Homework2() {
		super("Event test");
		
		init();
		addEvent();
		
		this.setSize(400,300);
		this.setVisible(true);
	}
	
	private void init() {
		Panel pl = new Panel();
		ch = new Choice();
		list=new List(3, false);
		
		lb1 = new Label("사용 가능 언어");
		ch.add("JSP");
		ch.add("HTML");
		ch.add("jquery");
		
		lb2 = new Label("취미");
		list.add("축구");
		list.add("야구");
		list.add("여행");
		list.add("영화");
		
		
		tf = new TextField();
		tf.setEditable(false);
		
		
		pl.add(lb1);
		pl.add(lb2);
		pl.add(ch);
		pl.add(list);	
		pl.add(tf);
		
		add(pl,"Center");
		add(tf,"South");
	}

	private void addEvent() {
		ch.addItemListener(new EventHandler());
		list.addItemListener(new EventHandler());
	}

	class EventHandler implements ItemListener{
		@Override
		public void itemStateChanged(ItemEvent e) {
			String str = "";
			if(e.getSource()==ch) {
				str = ch.getSelectedItem();		
			}else if(e.getSource()==list) {
				str = list.getSelectedItem();					
			}
			tf.setText(str);
		}		
	}//class
	
	public static void main(String[] args) {
		Homework2 h2 = new Homework2();
	}

}
