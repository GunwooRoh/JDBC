package com.thread.day2;

class Circle{
	int insR=0;
}

class MyThread extends Thread{
	Circle c;
	
	MyThread(Circle c){
		this.c=c;
	}
	
	public void run() {
		int localVar=0;
		
		while(localVar<3) {
			System.out.println(getName()+" local var:"+ ++localVar);
			System.out.println(getName()+"------------instance var:"+ ++c.insR);
			System.out.println();			
		}//while
	}
}

public class SynchroTest2 {

	public static void main(String[] args) {
		Circle c = new Circle();
		MyThread th1 = new MyThread(c);
		MyThread th2 = new MyThread(c);
		
		th1.start();
		th2.start();
		
	}

}
