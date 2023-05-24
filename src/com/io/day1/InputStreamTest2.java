package com.io.day1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class InputStreamTest2 {

	public static void main(String[] args) {
		FileInputStream fis=null;
		
		try {
			fis=new FileInputStream("text/poetry2.txt");
			int data=0, count=0;
			while((data=fis.read())!=-1) {
				char ch = (char)data;
				System.out.print(ch);
				count++;
			}
			
			System.out.println("반복횟수 : " + count);
			File f = new File("text/poetry2.txt");
			System.out.println("파일의 바이트 수 : " + f.length());
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
