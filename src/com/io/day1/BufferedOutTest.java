package com.io.day1;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutTest {

	public static void main(String[] args) {
		/*
		 1~9까지 파일에 출력
		 바이트기반, 보조스트림(버퍼)이용
		 
		 노드스트림: FileOutputStream
		 보조스트림: BufferedOutputStream
		 */
		FileOutputStream fos=null;
		BufferedOutputStream bos=null;

		try {
			fos=new FileOutputStream("text/123.txt");
			bos=new BufferedOutputStream(fos, 5); //버퍼크기를 5로 지정
			
			for(int i='1';i<='9';i++) {
				bos.write(i);
			}
			System.out.println("파일에 출력함!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(bos!=null) bos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}









