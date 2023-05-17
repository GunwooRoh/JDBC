package com.awt.day1;

import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;

public class ColorTest {

	public static void main(String[] args) {
		Frame f = new Frame("Color Test");
		f.setLayout(new GridLayout(14, 2));
		
		Panel p1 = new Panel();
		p1.setBackground(Color.black);
		
		Panel p2 = new Panel();
		p2.setBackground(Color.blue);
		
		Panel p3 = new Panel();
		p3.setBackground(Color.cyan);
		
		Panel p4 = new Panel();
		p4.setBackground(Color.lightGray);
		
		Panel p5 = new Panel();
		p5.setBackground(Color.red);
		
		Panel p6 = new Panel();
		p6.setBackground(Color.white);
		
		Panel p7 = new Panel();
		p7.setBackground(Color.yellow);
		
		Panel p8 = new Panel();
		p8.setBackground(Color.orange);
		
		Panel p9 = new Panel();
		p9.setBackground(Color.magenta);
		
		Panel p10 = new Panel();
		p10.setBackground(Color.green);
		
		Panel p11 = new Panel();
		p11.setBackground(Color.DARK_GRAY);
		
		Panel p12 = new Panel();
		p12.setBackground(new Color(80,150,30));
		
		f.add(p1);
		f.add(new Label("black"));
		
		f.add(p2);
		f.add(new Label("blue"));
		
		f.add(p3);
		f.add(new Label("cyan"));
		
		f.add(p4);
		f.add(new Label("lightgray"));
		
		f.add(p5);
		f.add(new Label("red"));
		
		f.add(p6);
		f.add(new Label("white"));
		
		f.add(p7);
		f.add(new Label("yellow"));
		
		f.add(p8);
		f.add(new Label("orange"));
		
		f.add(p9);
		f.add(new Label("magenta"));
		
		f.add(p10);
		f.add(new Label("green"));
		
		f.add(p11);
		f.add(new Label("Dark Gray"));
		
		f.add(p12);
		f.add(new Label("Color(80, 150, 30)"));
		
	    f.setSize(250,300);
	    f.setVisible(true);

	}

}
