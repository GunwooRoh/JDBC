package com.io.day2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderTest {

	public static void main(String[] args) {
		/*
		 	파일에서 읽어서 화면에 출력
		 	문자기반, 버퍼 이용
		 	
		 	노드스트림 : FileReader
		 	보조스트림 : BufferedReader
		 */
		
		FileReader fr=null;
		BufferedReader br=null;
		
		try {
			fr=new FileReader("text/FileWriterTest.java");
			br=new BufferedReader(fr);
			
			String line="";
			while((line=br.readLine())!=null) {
				// ";"를 포함한 라인만 출력한다.
				if(line.indexOf(";")!=-1) {
					System.out.println(line);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(br!=null)br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}

}








