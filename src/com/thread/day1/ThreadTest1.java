package com.thread.day1;

class MyThread extends Thread{
	MyThread(String name){
		super(name);  //Thread(String name)
	}
	
	@Override
	public void run() {
		for(int i=0;i<5;i++) {
			System.out.println("스레드 이름:"+getName());
		}
	}	
}

class MyRunnable implements Runnable{
	@Override
	public void run() {
		for(int i=0;i<5;i++) {
			System.out.println(Thread.currentThread().getName());
		}
	}	
}

public class ThreadTest1 {

	public static void main(String[] args) {
		MyThread th = new MyThread("나의 쓰레드");
		th.start();
		
		MyRunnable r = new MyRunnable();
		Thread th2 = new Thread(r); //Thread(Runnable target)
		th2.start();
		
		System.out.println("main쓰레드 종료!");
	}

}




