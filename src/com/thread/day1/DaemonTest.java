package com.thread.day1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

class MyThread5 extends Thread{
	@Override
	public void run() {
		while(true) {
			Date d = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String str=sdf.format(d);
			System.out.println("\n[현재 시간 : "+str+"]");
			
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}//while
	}	
}

class MyRunnable5 implements Runnable{

	@Override
	public void run() {
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자 입력!");
		int cnt=sc.nextInt();
		int sum=0;
		for(int i=1;i<=cnt;i++) {
			sum+=i;
		}//for
		
		System.out.println("\n[ 1~"+cnt+"까지의 합 : " + sum+" ]");
	}	
}

public class DaemonTest {
	public static void main(String[] args) {
		MyThread5 th1=new MyThread5();
		th1.setDaemon(true); //일반 쓰레드가 모두 종료되면 th1(데몬스레드)은 강제적으로 자동 종료
		//th1.start();
		
		MyRunnable5 r = new MyRunnable5();
		Thread th2 = new Thread(r);
		th2.start();
		
		try {
			th2.join();//1~n까지의 합=>main 쓰레드는 th2의 작업이 끝날 때까지 기다린다. 
			/*
			 지정된 시간동안 스레드가 실행되도록 한다 
			 지정된 시간이 지나거나 작업이 종료되면 join()을 호출한 스레드로 
			 다시 돌아와 실행을 계속한다 */
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		th1.start(); //현재시간 출력
		
		for(int i=0;i<100;i++) {
			System.out.print(i+ " ");
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}//for
		
		System.out.println("[main 스레드 종료]");
		
	}

}



