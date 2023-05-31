package com.etc.day1;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest2 {

	public static void main(String[] args) {
		//스트림 필터링
		IntStream stream1 = IntStream.of(7,5,5,2,1,2,3,5,4,6);
		IntStream stream2 = IntStream.of(7,5,5,2,1,2,3,5,4,6);
		
		// 스트림에서 중복된 요소를 제거함.
		stream1.distinct().forEach(i->System.out.print(i+" "));
		//IntStream distinct()
		
		System.out.println("\n");
		
		//filter() 메소드는 해당 스트림에서 주어진 조건	(predicate)에 맞는 요소만으로 
		//구성된 새로운 스트림을	반환함
		
		// 스트림에서 홀수만을 골라냄.
		stream2.filter(n->n%2!=0).forEach(i->System.out.print(i+" "));
		//IntStream filter(IntPredicate predicate)
		
		//map() 메소드는 해당 스트림의 요소들을 주어진 함수에 인수로 전달하여, 
		//그 반환값들로 이루어진 새로운 스트림을 반환함.
		System.out.println("\n");
		Stream<String> stream3
			=Stream.of("html","css","java","javascript");
		stream3.map(s->s.length()).forEach(i->System.out.println(i));
		//Stream<Integer> map(Function<? super String, ? extends Integer> mapper)
		
		System.out.println("\n");
		String[] arr = {"I study hard", "You study java","i am hungry"};
		Stream<String> stream4 = Arrays.stream(arr);
		stream4.flatMap(s->Stream.of(s.split(" "))).forEach(System.out::println);
		
		
	}

}






