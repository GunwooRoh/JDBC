package com.thread.day1;

import javax.swing.JOptionPane;

class MyThread1 extends Thread{
	public void run() {
		for(int i=10;i>0;i--) {
			System.out.println(i);
			try {
				Thread.sleep(1000);//지정된 시간동안 쓰레드를 일시정지시킴
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}//for
	}
}

public class ThreadTest3 {
	public static void main(String[] args) {
		MyThread1 th = new MyThread1();
		th.start();
		
		String data=JOptionPane.showInputDialog("값 입력!");
		System.out.println("입력값 : " + data);
		
		System.out.println("main스레드 종료");
		
		//두 개의 쓰레드로 나누어서 처리
		// - 사용자가 입력을 마치지 않았어도 화면에 숫자가 출력

	}

}




