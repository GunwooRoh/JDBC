package com.awt.event.day2;

import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardLayoutTest extends Frame implements ActionListener{
	private Button btFirst, btPrev, btNext, btLast;
	private Panel plS, plC, plCard1, plCard2, plCard3, plCard4, plCard5;
	private CardLayout cardLayout;
	
	public CardLayoutTest() {
		super("CardLayout Event");
		
		init();
		addEvent();
		
		this.setSize(300,300);
		this.setVisible(true);
	}
	
	private void init() {
		btFirst = new Button("<<");
		btPrev = new Button("<");
		btNext = new Button(">");
		btLast= new Button(">>");
		
		plS=new Panel();
		plC=new Panel();
		
		plS.add(btFirst);
		plS.add(btPrev);
		plS.add(btNext);
		plS.add(btLast);
		
		cardLayout=new CardLayout();
		plC.setLayout(cardLayout);
	
		plCard1=new Panel();
		plCard1.setBackground(Color.orange);
		plCard1.add(new Label("one"));
		plCard2=new Panel();
		plCard2.setBackground(Color.green);
		plCard2.add(new Label("two"));
		plCard3=new Panel();
		plCard3.setBackground(Color.pink);
		plCard3.add(new Label("three"));
		plCard4=new Panel();
		plCard4.setBackground(Color.cyan);
		plCard4.add(new Label("four"));
		plCard5=new Panel();
		plCard5.setBackground(Color.magenta);
		plCard5.add(new Label("five"));
		
		plC.add(plCard1,"1");
		plC.add(plCard2,"2");
		plC.add(plCard3,"3");
		plC.add(plCard4,"4");
		plC.add(plCard5,"5");
		
		this.add("South", plS);
		this.add("Center", plC);
		
		cardLayout.show(plC, "1");
	}

	private void addEvent() {
		btFirst.addActionListener(this);
		btPrev.addActionListener(this);
		btNext.addActionListener(this);
		btLast.addActionListener(this);		
	}

	public static void main(String[] args) {
		CardLayoutTest f = new CardLayoutTest();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btFirst) {
			cardLayout.first(plC);
		}else if(e.getSource()==btPrev) {
			cardLayout.previous(plC);			
		}else if(e.getSource()==btNext) {
			cardLayout.next(plC);			
		}else if(e.getSource()==btLast) {
			cardLayout.last(plC);			
		}
	}

}
