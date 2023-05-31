package com.etc.day1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;

public class Test {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add("1.홍");
		list.add("2.김");
		list.add("3.이");
		list.add("4.박");
		list.add("5.정");

		Iterator<String> it = list.iterator();     
		// Iterator는 일회용이기 때문에 한번만 사용할 수 있음

		System.out.println();
		while(it.hasNext()){
			System.out.println(it.next());			
		}

		System.out.println("\n================");
		
		it=list.iterator();
		it.forEachRemaining(i->System.out.println(i));
		
		System.out.println("\n-------foreach-----");
		list.forEach(i->System.out.println(i));
		
		Map<String, String> map = new HashMap<>();
		it=list.iterator();
		it.forEachRemaining(name->map.put(name, name));
		
		map.forEach((k,v)->System.out.println(k+" => "+ v));
		
		Map<Integer, String> map2 = new HashMap<>();
		map2.put(1, "java");
		map2.put(2, "oracle");
		map2.put(3, "spring");
		map2.put(4, "oracle");
		
		map2.forEach((k,v)->System.out.println(k+" : " + v));
		
		map2.keySet().iterator()
			.forEachRemaining(k-> System.out.println(k+"=>"+map2.get(k)));
		
		System.out.println("\n---------------------");
		Optional<String> str 
			= map2.values().stream().filter(s->s.equals("oracle")).findAny();
		if(str.isPresent()) {
			System.out.println("str="+str.get());			
		}
		
		
	}

}





