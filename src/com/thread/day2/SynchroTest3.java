package com.thread.day2;

class Account{
	int balance=1000;
	
	/*
	public synchronized void withdraw(int money) {
		if(balance>=money) { //200>=100
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			balance-=money;			
		}//if
	}*/
	
	/*
	-한 쓰레드에 의해서 먼저 withdraw()가 호출되면, 종료될 때까지 다른 쓰레드가 
	 withdraw()를 호출하더라도 대기상태에 머물게 됨
	-withdraw()는 한 순간에 단 하나의 쓰레드만 사용할 수 있다.*/

	public void withdraw(int money) {
		synchronized (this) {
			if(balance>=money) { //200>=100
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				balance-=money;
				
				/* 잔고가 음수 <= 한 쓰레드가 if문의 조건식을 통과하고 출금하기 바로 직전에 
				   다른 쓰레드가 끼어들어서 출금을 먼저 했기 때문*/
			}//if
		}
	}
}

class MyRunnable2 implements Runnable{
	Account acc=new Account();
	
	@Override
	public void run() {
		while(acc.balance>0) {
			int money=(int)(Math.random()*3+1)*100; //100,200,300
			acc.withdraw(money);
			
			System.out.println(Thread.currentThread().getName()
				+" : balance="+acc.balance+", money="+money);
		}//while
	}
	
}

public class SynchroTest3 {
	public static void main(String[] args) {
		MyRunnable2 r = new MyRunnable2();
		Thread th1=new Thread(r);
		Thread th2=new Thread(r);
		
		th1.start();
		th2.start();
	}

}
