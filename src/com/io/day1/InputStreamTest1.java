package com.io.day1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class InputStreamTest1 {

	public static void main(String[] args) {
		FileInputStream fis = null;
		
		try {
			fis=new FileInputStream("text/poetry2.txt");
			
			int data=0;
			while((data=fis.read())!=-1) {
				char ch = (char)data;
				System.out.print(ch);  //Prints a character. => char 단위로 출력
				//System.out.println(data);
				//해당 file 의 byte 수만큼 while문을 반복함
			}
			
			/*
			int read() throws IOException
				- Reads a byte of data from this input stream.
				- inpuStream에서 1바이트씩 읽어온다
				- 아스키코드를 리턴함
				- 더 이상 읽어올 것이 없으면 -1을 리턴함
			*/
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(fis!=null) fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
