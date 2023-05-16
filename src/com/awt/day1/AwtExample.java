package com.awt.day1;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Scrollbar;
import java.awt.TextField;

public class AwtExample {

	public static void main(String[] args) {
		Frame f = new Frame("Label,TestField, Checkbox, TextArea");
		f.setSize(380, 500);
		f.setLayout(new FlowLayout());
		
		Label lbId = new Label("Name : ");
		Label lbPwd = new Label("Password : ");


		
		TextField tfId = new TextField(10);
		TextField tfPwd = new TextField(10);
		tfPwd.setEchoChar('*');
		
		f.add(lbId);
		f.add(tfId);
		f.add(lbPwd);
		f.add(tfPwd);
		
		Choice chJob = new Choice();
		chJob.add("Clerk");
		chJob.add("Salesman");
		chJob.add("Housekeeper");
		
		f.add(chJob);
		
		Checkbox ck1 = new Checkbox("SKT");
		Checkbox ck2 = new Checkbox("KT");
		Checkbox ck3 = new Checkbox("LG U+");
		
		f.add(ck1);
		f.add(ck2);
		f.add(ck3);
		
		CheckboxGroup group = new CheckboxGroup();
		Checkbox ckMarriage = new Checkbox("Married", group, false);
		Checkbox ckMarriage2 = new Checkbox("Not Married", group, false);
		
		f.add(ckMarriage);
		f.add(ckMarriage2);
		
		
		
		Scrollbar hor = new Scrollbar(Scrollbar.HORIZONTAL, 0, 50, 0, 100);
		hor.setSize(100, 15);
		hor.setLocation(60, 30);
		
		Scrollbar ver = new Scrollbar(Scrollbar.VERTICAL, 50, 20, 0, 100);
		ver.setSize(15, 100);
		ver.setLocation(30, 30);
		
		f.add(hor);
		f.add(ver);
		
		
		f.setVisible(true);
	}

}
