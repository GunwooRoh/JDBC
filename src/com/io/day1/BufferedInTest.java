package com.io.day1;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BufferedInTest {

	public static void main(String[] args) {
		/*
		 파일에서 읽어와서 화면에 출력
		 바이트 기반, 보조스트림(버퍼)이용
		 
		 노드스트림 - FileInputStream
		 보조스트림 - BufferedInputStream
		 */
		FileInputStream fis=null;
		BufferedInputStream bis=null;
		
		try {
			fis=new FileInputStream("text/poetry2.txt");
			bis=new BufferedInputStream(fis, 1024); //버퍼 사이즈 생략하면 2048
			
			int data=0;
			while((data=bis.read())!=-1) {
				System.out.print((char)data);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(bis!=null) bis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}







