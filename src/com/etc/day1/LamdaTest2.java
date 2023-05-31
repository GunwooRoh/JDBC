package com.etc.day1;

@FunctionalInterface
interface MyFunction{
	void myMethod();
}

public class LamdaTest2 {
	public static void aMethod(MyFunction f) {
		f.myMethod();
	}
	
	public static void main(String[] args) {
		//함수형 인터페이스가 매개변수인 경우
		//1
		MyFunction f = new MyFunction() {
			
			@Override
			public void myMethod() {
				System.out.println("1. 익명객체 이용");
			}
		};
		
		aMethod(f);
		
		//2
		MyFunction f2 = ()->System.out.println("2. 람다식 이용");
		aMethod(f2);
		
		//3
		aMethod(()->System.out.println("3. 람다식 직접 입력"));
		
		//함수형 인터페이스가 리턴타입인 경우
		System.out.println();
		MyFunction f3 =myMethod2();
		f3.myMethod();
	
		MyFunction f4 = myMethod3();
		f4.myMethod();
		
	}

	public static MyFunction myMethod2() {
		MyFunction f = new MyFunction() {
			
			@Override
			public void myMethod() {
				System.out.println("1. 익명객체 리턴");
			}
		};
		
		return f;
	}
	
	public static MyFunction myMethod3() {
		return ()-> System.out.println("2. 람다식 리턴");
	}
	
}






