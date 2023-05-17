package com.awt.day2;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;

public class FlowTest {

	public static void main(String[] args) {
		Frame f = new Frame("FlowLayout");
		f.setSize(300, 200);
		f.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		f.add(new Button("One"));
		f.add(new Button("Two"));
		f.add(new Button("Three"));
		f.add(new Button("Four"));
		f.add(new Button("Five"));
		
		f.setVisible(true);
		

	}

}
