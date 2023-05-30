package com.thread.day2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

class MyThread2 extends Thread{
	//bar마다 다른 값들
	int interval;  //sleep interval
	int n; //bar 증가치
	JProgressBar bar;
	
	MyThread2(int interval, int n, JProgressBar bar){
		this.interval=interval;
		this.n=n;
		this.bar=bar;				
	}
	
	public void run() {
		synchronized (bar) {
			for(int i=bar.getMinimum();i<=bar.getMaximum();i+=n) {
				try {
					this.sleep(interval);
					
					System.out.println(getName()+ ", i="+i);
					bar.setValue(i);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}//for
		}
	}
	
}//class

public class ProgressbarTest2 extends JFrame implements ActionListener{
	JButton bt;
	JProgressBar bar1, bar2, bar3;
	JPanel pl;
	
	MyThread2 th1, th2, th3;
	
	public ProgressbarTest2() {
		super("진행바2");
		
		init();
		addEvent();
	}
	
	private void init() {
		bt=new JButton("start");
		bar1=new JProgressBar();
		bar2=new JProgressBar();
		bar3=new JProgressBar();
		
		bar1.setStringPainted(true);
		bar2.setStringPainted(true);
		bar3.setStringPainted(true);
		
		pl=new JPanel();
		
		add(bt, "South");
		
		pl.add(bar1);
		pl.add(bar2);
		pl.add(bar3);
		
		add(pl, "Center");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,200);
		setVisible(true);
	}
	
	private void addEvent() {
		bt.addActionListener(this);
	}

	public static void main(String[] args) {
		ProgressbarTest2 f = new ProgressbarTest2(); 
		
		/*main() 이 실행되는 메인 쓰레드와, 운영체제로부터
		들어오는 이벤트를 처리하고 등록된 리스너에 해당 이벤트에 대해 통지를 해주는 AWT 쓰레드가 
		기본적으로 생성됨*/
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		th1=new MyThread2(1000, 10, bar1);
		th2=new MyThread2(500, 5, bar2);
		th3=new MyThread2(100, 1, bar3);
		
		th1.start();
		th2.start();
		th3.start();
	}

}
