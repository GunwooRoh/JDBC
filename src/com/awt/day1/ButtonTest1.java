package com.awt.day1;

import java.awt.Button;
import java.awt.Frame;

public class ButtonTest1 {

	public static void main(String[] args) {
		Frame f = new Frame("로그인");
		f.setSize(300, 200);
		
		Button b = new Button("확인");
		b.setSize(100, 50);
		
		f.add(b);
		f.setVisible(true);
	}

}
