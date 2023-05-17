package com.awt.day2;

import java.awt.Frame;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class PopupTest {

	public static void main(String[] args) {
		Frame f = new Frame("Popup Menu");
		f.setSize(300, 200);
		
		PopupMenu pMenu = new PopupMenu("Edit");
		MenuItem miCut = new MenuItem("Cut");
		MenuItem miCopy = new MenuItem("Copy");
		MenuItem miPaste = new MenuItem("Paste");
		
		pMenu.add(miCut);
		pMenu.add(miCopy);
		pMenu.add(miPaste);
		
		f.add(pMenu);
		
		f.addMouseListener (new MouseAdapter() {
				
				public void mousePressed(MouseEvent e) {
					if(e.getModifiers()==e.BUTTON3_MASK) {
						pMenu.show(f, e.getX(), e.getY());
					}
				}
		});
	
		f.setVisible(true);
	}

}
