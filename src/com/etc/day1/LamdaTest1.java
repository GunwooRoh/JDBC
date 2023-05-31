package com.etc.day1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//함수형 인터페이스
@FunctionalInterface
interface Calc{
	int min(int x, int y);
}

class MyCalc implements Calc{

	@Override
	public int min(int x, int y) {
		return x<y?x:y;
	}	
}

public class LamdaTest1 {

	public static void main(String[] args) {
		//1
		Calc c = new MyCalc();
		System.out.println("1 : "+c.min(90, 120));
		
		//2. 익명클래스 이용
		Calc m = new Calc() {
			
			@Override
			public int min(int x, int y) {
				return x<y?x:y;
			}
		};
		
		System.out.println("2 : "+m.min(10, 7));
		
		
		//3. 람다식 이용
		Calc c2 = (x,y)->x<y?x:y;
		System.out.println("3 : "+c2.min(55, 31)+"\n");
		
		
		//
		new Thread(new Runnable(){
			public void run(){
				System.out.println("전통적인 방식의 일회용 스레드 생성");
			}
		}).start();
				
		new Thread(()->
			System.out.println("람다 표현식을 사용한 일회용 스레드 생성")
		).start();

		System.out.println("main");
	
		//
		List<String> list = Arrays.asList("abc", "aaa", "bbb", "ddd", "aaa");

		Collections.sort(list, new Comparator<String>() {
		                            public int compare(String s1, String s2) {
		                                return s1.compareTo(s2);
		                            }
		                       });

		System.out.println("1 : " + list);
		
		//
		//List<String> list = Arrays.asList("abc", "aaa", "bbb", "ddd", "aaa");
		Collections.sort(list,(s1,s2)-> s2.compareTo(s1));

		System.out.println("2 : " + list);
		
	}

}





