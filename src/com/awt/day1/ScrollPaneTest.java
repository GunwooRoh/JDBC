package com.awt.day1;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.ScrollPane;

public class ScrollPaneTest {

	public static void main(String[] args) {
		Frame f = new Frame("scrollPane test");
		f.setSize(300, 200);
		
		ScrollPane sp = new ScrollPane();
		Panel p = new Panel();
		p.setBackground(Color.orange);
		p.add(new Button("one"));
		p.add(new Button("two"));
		p.add(new Button("three"));
		p.add(new Button("four"));
		
		sp.add(p);
		f.add(sp);
		f.setVisible(true);
		
	}

}
