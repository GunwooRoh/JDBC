package com.thread.day1;

public class MainThreadTest {

	public static void main(String[] args) {
		System.out.println("main메서드입니다.");
		
		Thread currentTh = Thread.currentThread();
		System.out.println("현재 실행중인 스레드 이름 : " + currentTh.getName());
		
		int cnt=Thread.activeCount();
		System.out.println("실행중인 스레드 개수:"+ cnt);
		
		Thread.currentThread().setName("Prime");
		System.out.println("변경된 스레드 이름:"+ Thread.currentThread().getName());
		
	}

}
