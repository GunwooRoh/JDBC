package com.etc.day1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest1 {

	public static void main(String[] args) {
		//1. 컬렉션
		List<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(20);
		list.add(30);
		
		//컬렉션에서 스트림 생성
		Stream<Integer> stream = list.stream();
		stream.forEach(i->System.out.println(i));
		
		//2. 배열
		String[] arr = {"java","oracle","spring","html"};
		
		//배열에서 스트림 생성
		Stream<String> stream2=Arrays.stream(arr);
		stream2.forEach(System.out::println);
		
		// 배열의 특정 부분만을 이용한 스트림 생성
		System.out.println("\n---------");
		Stream<String> stream3 = Arrays.stream(arr, 1,3);
		stream3.forEach(System.out::println);
		
		//3. 가변 매개변수에서 스트림 생성
		Stream<Double> stream4=Stream.of(3.14, 5.6, 73.8, 9.7);
		stream4.forEach(i->System.out.println(i));
		
		//4. 지정된 범위의 연속된 정수에서 스트림 생성
		IntStream stream5 = IntStream.range(1, 4);
		stream5.forEach(i->System.out.print(i+" "));
		System.out.println("\n");
		
		IntStream stream6 = IntStream.rangeClosed(1, 4);
		stream6.forEach(i->System.out.print(i+" "));
		System.out.println("\n");
		
		//5. 빈 스트림 생성
		Stream<Object> stream7 = Stream.empty();
		System.out.println(stream7.count());//스트림의 요소의 총 개수
		
		
	}

}







