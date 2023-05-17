package com.awt.day2;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CardTest {

	public static void main(String[] args) {
		Frame f = new Frame ("CardLayout");
		CardLayout cardLayout = new CardLayout(10, 10);
		f.setLayout(cardLayout);
		
		Panel plCard1 = new Panel();
		plCard1.setBackground(Color.pink);
		plCard1.add(new Label("Card1"));
		
		Panel plCard2 = new Panel();
		plCard2.setBackground(Color.green);
		plCard2.add(new Label("Card2"));
		
		Panel plCard3 = new Panel();
		plCard3.setBackground(Color.orange);
		plCard3.add(new Label("Card3"));
		
		f.add(plCard1, "1");
		f.add(plCard2, "2");
		f.add(plCard3, "3");
		
		class Handler extends MouseAdapter {
			public void mouseClicked(MouseEvent e) {
				if(e.getModifiers() == e.BUTTON3_MASK) {
					
				}else {
					cardLayout.next(f);
				}
			}
		}
		plCard1.addMouseListener(new Handler());
		plCard2.addMouseListener(new Handler());
		plCard3.addMouseListener(new Handler());
		
		f.setSize(300, 300);
		f.setVisible(true);
		
		cardLayout.show(f, "1");
	}

}
