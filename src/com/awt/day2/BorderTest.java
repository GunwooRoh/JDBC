package com.awt.day2;

import java.awt.Button;
import java.awt.Frame;

public class BorderTest {

	public static void main(String[] args) {
		Frame f = new Frame("BorderLayout");
		f.setSize(200, 200);
		
		Button btN = new Button("North");
		Button btS = new Button("South");
		Button btE = new Button("East");
		Button btW = new Button("West");
		Button btC = new Button("Center");
		
		f.add(btN, "North");
		f.add(btS, "South");
		f.add(btE, "East");
		f.add(btW, "West");
		f.add(btC, "Center");
		
		f.setVisible(true);
	}

}
