package com.thread.day1;

import javax.swing.JOptionPane;

class MyThread2 extends Thread{
	public void run() {
		for(int i=10;i>0;i--) {
			if(ThreadTest4.inputCheck) return;
			
			System.out.println(i);
			try {
				Thread.sleep(1000);//지정된 시간동안 쓰레드를 일시정지시킴
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}//for
		
		System.out.println("10초동안 값이 입력되지 않아 프로그램 종료함!!");
		System.exit(0);
	}
}

class MyRunnable1 implements Runnable{
	@Override
	public void run() {
		System.out.println("10초안에 값을 입력해야 합니다.");
		String data=JOptionPane.showInputDialog("값 입력!");
		ThreadTest4.inputCheck=true;
		
		System.out.println("입력값 : " + data);
	}	
}

public class ThreadTest4 {
	static boolean inputCheck=false;
	
	public static void main(String[] args) {
		//10초 동안 사용자가 입력하지 않으면 종료하는 예제
		MyThread2 th = new MyThread2();
		th.start();
		
		MyRunnable1 r = new MyRunnable1();
		Thread th2 = new Thread(r);
		th2.start();
		
		System.out.println("main스레드 종료");
		
	}

}




