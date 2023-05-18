package com.awt.event.day2;

import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Example extends Frame implements ActionListener{
	private Choice ch;
	private List list;
	private TextField tf;
	private Panel p1, p2;
	private Label lb1, lb2;
	
	public Example(Choice ch) {
		super("Event test");
		this.ch = ch;
		
	
		init();
		addEvent();
		
		this.setSize(300,200);
		this.setVisible(true);
	}
	
	private void init() {
	    p1 = new Panel();
	    p2 = new Panel();
	      
	    tf = new TextField(50);
	    tf.setEditable(false);
	      
	    lb1 = new Label("사용가능 언어");
	    lb2 = new Label("취미");
		
		ch = new Choice();
		list = new List(4, false);
		
		ch.add("jsp");
		ch.add("oralce");
		ch.add("mybatis");
		
		list.add("축구");
		list.add("야구");
		list.add("여행");
		list.add("영화");
		
	    p1.add(lb1);
	    p1.add(ch);
	    p1.add(lb2);
	    p1.add(list);
	      

	    p2.add(tf);
	      
	    this.setLayout(new FlowLayout());   
	    this.add(p1, "Center");
	    this.add(p2, "South");
		
	}

	private void addEvent() {
		//이벤트 소스: Choice, List
		//리스너 : ItemListener
		ch.addItemListener(new EventHandler());
		list.addItemListener(new EventHandler());		
	}

	class EventHandler implements ItemListener{
		@Override
		public void itemStateChanged(ItemEvent e) {
			if(e.getSource()== list) {
				String str=ch.getSelectedItem();

				System.out.println("선택한 index:"+ ch.getSelectedIndex()+"\n");				
			}else if(e.getSource()==list) {
				String str=list.getSelectedItem();

				System.out.println("선택한 index:"+ list.getSelectedIndex()+"\n");					
			}
		}
		
	}//class
	
	public static void main(String[] args) {
		ItemTest2 f = new ItemTest2();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//Choice ch = tf.getText();
		
	}

}
