package com.thread.day1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.swing.JOptionPane;

class MyThread4 extends Thread{
	@Override
	public void run() {
		//1. JOptionPane.showInputDialog()
		String number = JOptionPane.showInputDialog("아무값이나 입력하세요.");
		int number1 = Integer.parseInt(number);
		int sum = 0;
		for(int i=0; i<number1; i++) {
			sum+=i;
		}
		System.out.println("입력 값 " + number1 + "까지의 합 = " + sum);
		
		//2. Scanner 이용
		Scanner sc = new Scanner(System.in);
		sum = 0;

		System.out.println("\n숫자를 입력하세요.\n");
		int num = sc.nextInt();
		for(int i=0; i<num; i++) {
			sum+=i;
		}
		System.out.println(num + "까지의 합 = " + sum);
	}
}

class MyRunnable4 implements Runnable{

	@Override
	public void run() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String today = sdf.format(date);
		
		try {
			for(int i=0; i<5; i++) {
				System.out.println("\n"+ today + "\n");
				Thread.sleep(3000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

public class ThreadExam1 {
	public static void main(String[] args) {
		MyThread4 th1 = new MyThread4();
		MyRunnable4 r = new MyRunnable4();
		Thread th2 = new Thread(r);

		th1.start();
		th2.start();

		System.out.println("main 스레드 종료!");
	}

}
