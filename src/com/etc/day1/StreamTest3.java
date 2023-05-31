package com.etc.day1;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest3 {

	public static void main(String[] args) {
		//최종연산 - forEach
		Stream<String> stream = Stream.of("넷","둘","셋","하나");
		stream.forEach(i->System.out.println(i));
		
		//reduce() 메소드는 첫 번째와 두 번째 요소를 가지고 연산을 수행한 뒤, 
		//그 결과와 세 번째 요소를 가지고 또다시 연산을 수행함
		Stream<String> stream1 = Stream.of("넷","둘","셋","하나");
		Stream<String> stream2 = Stream.of("넷","둘","셋","하나");
		
		Optional<String> result
		=stream1.reduce((s1,s2)->s1+ "++" + s2);
		result.ifPresent(i->System.out.println(i));
		//System.out.println(result);
		
		String result2
		=stream2.reduce("시작",(s1,s2)->s1+ "++" + s2);
		System.out.println(result2);
		
		//findFirst()와 findAny() 메소드는 해당 스트림에서 첫 번째 요소를 참조하는
		//Optional 객체를 반환
		IntStream stream3 = IntStream.of(4,2,7,3,1,5,6);
		IntStream stream4 = IntStream.of(4,2,7,3,1,5,6);
		
		OptionalInt res = stream3.sorted().findFirst();
		System.out.println(res.getAsInt());
		
		OptionalInt res2 = stream4.sorted().findAny();
		System.out.println(res2.getAsInt());
		
		
		
	}

}





