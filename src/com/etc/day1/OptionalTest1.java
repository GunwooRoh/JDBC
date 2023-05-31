package com.etc.day1;

import java.util.Optional;

public class OptionalTest1 {

	public static void main(String[] args) {
		//Optional 객체를 사용하면 예상치 못한 NullPointerException 예외를 
		//제공되는 메소드로 간단히 회피할 수 있다.
		
		/*
		 of() 메소드는 null이 아닌 명시된 값을 가지는 Optional 객체를 반환함
		 
		 참조 변수의 값이 만에 하나 null이 될 가능성이 있다면, 
		 ofNullable() 메소드를 사용하여 Optional 객체를 생성하는 것이 좋다.		
		 */

		Optional<String> opt=Optional.ofNullable("자바 optional 객체");
		System.out.println(opt.get());

		Optional<String> opt2=Optional.of(null);		
		//System.out.println("value="+opt2.get());
		//Optional 객체에 저장된 값이 null이면,	NoSuchElementException 예외가 발생함

		if(opt2.isPresent()) {
			System.out.println(opt2.get());
		}else {
			System.out.println("값이 null 임!");
		}
		
		
	}

}





