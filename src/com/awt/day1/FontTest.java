package com.awt.day1;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GraphicsEnvironment;
import java.awt.Label;

public class FontTest {

	public static void main(String[] args) {
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		Font[] fontArr = ge.getAllFonts();
		
		for(int i = 0; i < fontArr.length; i++) {
			System.out.println(fontArr[i].getFontName());
		}
		
		Frame f = new Frame("Font test");
		String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		Label lb1 = new Label(abc);
		Label lb2 = new Label(abc);
		Label lb3 = new Label(abc);
		Label lb4 = new Label(abc);
		Label lb5 = new Label(abc);
		
		Font font1 = new Font("Serif", Font.PLAIN, 20);
		Font font2 = new Font("Serif", Font.ITALIC, 20);
		Font font3 = new Font("Serif", Font.BOLD, 20);
		Font font4 = new Font("Serif", Font.BOLD + Font.ITALIC, 20);
		
		lb1.setFont(font1);
		lb2.setFont(font2);
		lb3.setFont(font3);
		lb4.setFont(font4);
		
		f.setLayout(new FlowLayout());
		f.add(lb1);
		f.add(lb2);
		f.add(lb3);
		f.add(lb4);
		f.add(lb5);
		
		f.setSize(400, 250);
		f.setVisible(true);
		

	}

}
