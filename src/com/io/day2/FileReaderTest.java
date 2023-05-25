package com.io.day2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {

	public static void main(String[] args) {
		//1. 바이트 기반 파일에서 읽어오기 - FileInputStream 
		String fileName="text/test.txt";
		FileInputStream fis=null;
		
		try {
			fis = new FileInputStream(fileName);
			
			int data=0;
			while((data=fis.read())!=-1) {
				//System.out.println(data);
				System.out.print((char)data);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(fis!=null)fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("\n\n");
		
		//2. 문자기반 파일에서 읽어오기 - FileReader
		FileReader fr = null;
		
		try {
			fr=new FileReader(fileName);
			
			int data=0;
			while((data=fr.read())!=-1) {
				//System.out.println(data);
				System.out.print((char)data);				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(fr!=null) fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
