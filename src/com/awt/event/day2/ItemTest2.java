package com.awt.event.day2;

import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.List;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ItemTest2 extends Frame{
	private Choice ch;
	private List list;
	
	public ItemTest2() {
		super("ItemEvent test2");
		
		init();
		addEvent();
		
		this.setSize(300,200);
		this.setVisible(true);
	}
	
	private void init() {
		ch=new Choice();
		list=new List(3, false);
		
		ch.add("java");
		ch.add("html");
		ch.add("jquery");
		
		list.add("jsp");
		list.add("oralce");
		list.add("mybatis");
		
		this.setLayout(new FlowLayout());
		
		this.add(ch);
		this.add(list);		
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
			if(e.getSource()==ch) {
				String str=ch.getSelectedItem();
				System.out.println("콤보상자에서 선택한 값:"+ str);
				System.out.println("선택한 index:"+ ch.getSelectedIndex()+"\n");				
			}else if(e.getSource()==list) {
				String str=list.getSelectedItem();
				System.out.println("List에서 선택한 값:"+ str);
				System.out.println("선택한 index:"+ list.getSelectedIndex()+"\n");					
			}
		}
		
	}//class
	
	public static void main(String[] args) {
		ItemTest2 f = new ItemTest2();
	}

}
