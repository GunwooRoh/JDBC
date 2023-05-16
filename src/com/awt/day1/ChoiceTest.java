package com.awt.day1;

import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.List;

public class ChoiceTest {

	public static void main(String[] args) {
		Frame f = new Frame("Choice, List");
		f.setSize(300, 500);
		f.setLayout(new FlowLayout());
		
		Choice chLang = new Choice();
		chLang.add("java");
		chLang.add("c");
		chLang.add("c++");
		
		f.add(chLang);
		
		List list = new List(3);
		list.add("student");
		list.add("teacher");
		list.add("programmer");
		
		List list2 = new List(5, true);
		list2.add("one");
		list2.add("two");
		list2.add("three");
		list2.add("four");
		list2.add("five");
		
		f.add(list);
		f.add(list2);
		
		
		f.setVisible(true);
	}

}
