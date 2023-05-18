package com.swing.day1;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class SwingTest1 extends JFrame implements ActionListener{
	private JButton bt1, bt2,bt3,bt4;
	
	public SwingTest1() {
		super("Swing test");
		
		init();
		addEvent();
		
		this.setSize(600,200);
		this.setVisible(true);
		
	}
	
	private void init() {
		this.setLayout(new GridLayout(1,0));
		
		bt1=new JButton("버튼");
		
		ImageIcon icon1 = new ImageIcon("img/open.jpg");
		ImageIcon icon2 = new ImageIcon("img/input.jpg");
		ImageIcon icon3 = new ImageIcon("img/confirm.jpg");
		
		bt2=new JButton("열기", icon1);
		bt3=new JButton("입력", icon2);
		bt4=new JButton("확인", icon3);
		
		this.add(bt1);
		this.add(bt2);
		this.add(bt3);
		this.add(bt4);
		
		bt2.setVerticalTextPosition(JButton.BOTTOM);
		bt2.setHorizontalTextPosition(JButton.CENTER);
		
		bt3.setVerticalTextPosition(JButton.TOP);
		bt3.setHorizontalTextPosition(JButton.CENTER);
		bt3.setToolTipText("풍선 도움말");
		
		ImageIcon icon4 = new ImageIcon("img/exit.jpg");
		bt4.setPressedIcon(icon4);
		bt4.setMnemonic('C'); //단축키 alt+C
		
		//각 버튼에 border 주기
		bt1.setBorder(new LineBorder(Color.green, 5));
		bt2.setBorder(new TitledBorder("테두리에 제목 주기"));
		
		//bt3.setBorder(new BevelBorder(BevelBorder.LOWERED));
		bt3.setBorder(new BevelBorder(BevelBorder.RAISED));
		bt4.setBorder(new EtchedBorder());
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //창닫기 처리
	}

	private void addEvent() {
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		bt3.addActionListener(this);
		bt4.addActionListener(this);
	}

	public static void main(String[] args) {
		SwingTest1 f = new SwingTest1();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==bt1) {
			JOptionPane.showMessageDialog(this, "환영합니다.");			
		}else if(e.getSource()==bt2) {
			JOptionPane.showMessageDialog(this, "누르지 마세요!","경고",
					JOptionPane.WARNING_MESSAGE);
		}else if(e.getSource()==bt3) {
			String name=JOptionPane.showInputDialog(this,"이름을 입력하세요");
			setTitle(name);
		}else if(e.getSource()==bt4) {
			int quit=JOptionPane.showConfirmDialog(this, "종료하시겠습니까",
					"종료", JOptionPane.YES_NO_OPTION);
			setTitle("quit="+quit);
			//0:yes, 1:no, 2:cancel
			if(quit==JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		}//if
		
	}

}













