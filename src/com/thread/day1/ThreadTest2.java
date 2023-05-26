package com.thread.day1;

import javax.swing.JOptionPane;

public class ThreadTest2 {

	public static void main(String[] args) {
		//하나의 쓰레드가 입력받는 작업과 숫자 출력하는 작업을 처리
		//1. 입력받는 작업
		String data = JOptionPane.showInputDialog("아무값이나 입력하세요");
		System.out.println("입력값은 " + data+"입니다.");
		
		//2. 숫자 출력하는 작업
		for(int i=10;i>0;i--) {
			System.out.println(i);
			try {
				Thread.sleep(1000);//지정된 시간동안 쓰레드를 일시정지시킴
				//void sleep(long millis) throws InterruptedException
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}//for
	}

}
