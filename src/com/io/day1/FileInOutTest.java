package com.io.day1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInOutTest {

	public static void main(String[] args) {
		/*
		 poerty2.txt 파일에서 읽어서 poetry2.bak 파일에 출력(저장)
		 바이트 기반
		 
		 노드 스트림 : FileInputStream/FileOutputStream 
		*/
		
		FileInputStream fis=null;
		FileOutputStream fos=null;

		try {
			fis=new FileInputStream("text/poetry2.txt");
			fos=new FileOutputStream("text/poetry2.bak", true);
			//- append 변수에 true 를 지정하면 파일의 내용이 추가(append)됨
			
			int data=0;
			while((data=fis.read())!=-1) {  //1바이트씩 읽기
				//1바이트씩 출력하기
				fos.write(data); //void write(int b) throws IOException
				//=> byte단위로 출력
			}
			System.out.println("파일 저장됨!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(fis!=null) fis.close();
				if(fos!=null) fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}







