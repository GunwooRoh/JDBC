package com.thread.day2;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

public class ProgressbarTest extends JFrame implements ActionListener, Runnable{
	JButton bt;
	JProgressBar bar;
	JTextField tfMemo;
	JLabel lb;
	Thread th;  //버튼 클릭시 작동할 쓰레드

	public ProgressbarTest() {
		super("진행바");
		this.setLayout(new FlowLayout());

		init();
		addEvent();
	}

	private void init() {
		lb=new JLabel("메모");
		tfMemo=new JTextField(30);

		bar=new JProgressBar();
		bar.setStringPainted(true); //진행바에 퍼센티지가 표시됨

		add(lb);
		add(tfMemo);
		add(bt=new JButton("start"));
		add(bar);

		setSize(400,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void addEvent() {
		bt.addActionListener(this);
	}

	public static void main(String[] args) {
		ProgressbarTest f = new ProgressbarTest();
	}

	@Override
	public void run() {
		synchronized (bar) {
			System.out.println("run(), bar.min="+bar.getMinimum()
			+", bar.max="+bar.getMaximum());

			for(int i=bar.getMinimum();i<=bar.getMaximum();i+=5) {
				System.out.println(Thread.currentThread().getName()
						+", i="+i);

				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				bar.setValue(i);
			}//for
		}//synchronized
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		th=new Thread(this);
		th.start();
	}

}




