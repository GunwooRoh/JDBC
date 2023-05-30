package com.thread.day2;

class MyRunnable implements Runnable{
	int insVar=0;  //공유
	
	@Override
	public void run() {
		int localVar=0;
		String name=Thread.currentThread().getName();
		
		while(localVar<3) {
			System.out.println(name+ " localVAr : " + ++localVar);
			System.out.println(name +" -------------instance var:" + ++insVar);
			System.out.println();
		}//while
	}
	
}

public class SynchroTest1 {

	public static void main(String[] args) {
		MyRunnable r = new MyRunnable();
		Thread th1 = new Thread(r);
		Thread th2 = new Thread(r);
		
		th1.start();
		th2.start();		
		
		/* 하나의 객체(MyRunnable인스턴스)를 두 개의 쓰레드가 공유 
		   => 인스턴스변수(insVar)의 값은 두 쓰레드 모두 접근 가능*/

	}

}
