package com.io.day2;

import java.io.IOException;

public class InputReaderTest {

	public static void main(String[] args) {
		System.out.println("입력하세요");
		
		try {
			int data=0;
			while((data=System.in.read())!=-1) {
				System.out.println("data : " + data+", 문자:"+ (char)data);
			}
			//키보드로 부터 입력 받은 값을 출력 => 한글은 깨짐(byte기반)
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}





