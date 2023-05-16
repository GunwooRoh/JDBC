package com.awt.day1;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;

public class LabelTest {

	public static void main(String[] args) {
		Frame f = new Frame("Label,TestField, Checkbox, TextArea");
		f.setSize(380, 500);
		f.setLayout(new FlowLayout());
		
		Label lbId = new Label("ID : ");
		lbId.setBackground(Color.cyan);
		Label lbPwd = new Label("Password : ");
		lbPwd.setBackground(Color.MAGENTA);
		
		TextField tfId = new TextField(10);
		TextField tfPwd = new TextField(10);
		tfPwd.setEchoChar('*');
		
		f.add(lbId);
		f.add(tfId);
		f.add(lbPwd);
		f.add(tfPwd);
		
		
		Checkbox ck1 = new Checkbox("news", true);
		Checkbox ck2 = new Checkbox("sports");
		Checkbox ck3 = new Checkbox("movies");
		Checkbox ck4 = new Checkbox("music");
		
		f.add(ck1);
		f.add(ck2);
		f.add(ck3);
		f.add(ck4);
		
		CheckboxGroup group = new CheckboxGroup();
		Checkbox ckGender = new Checkbox("Male", group, false);
		Checkbox ckGender2 = new Checkbox("FeMale", group, false);
		
		f.add(ckGender);
		f.add(ckGender2);
		
		TextArea taCmt = new TextArea(10, 40);
		f.add(taCmt);
		
		
		f.setVisible(true);
	}

}
