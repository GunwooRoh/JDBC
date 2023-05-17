package com.awt.day1;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogTest {

	public static void main(String[] args) {
		Frame f = new Frame("Parent 창");
		f.setSize(300, 200);
		
		Dialog d = new Dialog(f, "information", true);
		d.setSize(140, 90);
		d.setLocation(50, 50);
		d.setLayout(new FlowLayout());
		
		Label lbMsg = new Label("This is modal dialog", Label.CENTER);
		Button btOk = new Button("OK");	
		
		btOk.addActionListener(new ActionListener() {
			
			//익명 클래스
			@Override
			public void actionPerformed(ActionEvent e) {
				d.setVisible(false);
				
			}
		});
		
		d.add(lbMsg);
		d.add(btOk);
		
		f.setVisible(true);
		d.setVisible(true);
	}

}
