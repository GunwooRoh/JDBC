package com.awt.day1;

import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Panel;

public class CanvasTest {

	public static void main(String[] args) {
		Frame f = new Frame("Canvas, Panel");
		f.setSize(300, 400);
		f.setLayout(null);
	
		Canvas c = new Canvas();
		c.setBackground(Color.pink);
		c.setBounds(50, 50, 150, 100);
		
		f.add(c);
		
		Panel p = new Panel();
		p.setBackground(Color.orange);
		p.setSize(100, 100);
		p.setLocation(50, 200);
		
		
		Button bt = new Button("OK");
		p.add(bt);
		
		f.add(p);
		
		f.setVisible(true);

	}

}
