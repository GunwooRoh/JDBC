package com.thread.day1;

class MyThread3 extends Thread{
	@Override
	public void run() {
		System.out.println("MyThread3");
		for(int i=0;i<1000;i++) {
			System.out.print("-");
		}//for
		
		System.out.println("\n\n[MyThread3 소요시간 (-) : " 
			+ (System.currentTimeMillis() - PriorityTest.startTime) +"] \n");
	}
}//class

class MyRunnable3 implements Runnable{
	@Override
	public void run() {
		System.out.println("MyRunnable3");
		for(int i=0;i<1000;i++) {
			System.out.print("2");
		}//for
		
		System.out.println("\n\n[MyRunnable3 소요시간 (2) : "
			+ (System.currentTimeMillis() - PriorityTest.startTime)+"] \n");
	}	
}//class

public class PriorityTest {
	static long startTime=0;
	
	public static void main(String[] args) {
		startTime=System.currentTimeMillis();
		
		MyThread3 th1 = new MyThread3();
		MyRunnable3 r = new MyRunnable3();
		Thread th2 = new Thread(r);
		
		th2.setPriority(10); //쓰레드를 실행하기 전에만 우선순위를 변경할 수 있음
		th1.setPriority(1);
		System.out.println("Priority of th1 (-) : " + th1.getPriority());
		System.out.println("Priority of th2 (2) : " + th2.getPriority());
		
		th1.start();
		th2.start();
		
		/* 
		th1과 th2 모두 main 메서드에서 생성하였기 때문에 main 
		메서드를 실행하는 쓰레드의 우선순위인 5을 상속 받았음
		*/
	}

}






