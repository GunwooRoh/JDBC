package com.io.day2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderTest2 {

	public static void main(String[] args) {
		/*
		 문자기반
		 파일에서 읽어서 다른 파일에 저장하기
		 
		 노드스트림 - FileReader, FileWriter
		 */
		
		FileReader fr=null;
		FileWriter fw=null;
		
		try {
			fr=new FileReader("text/poetry.txt");
			fw=new FileWriter("text/poetry.bak");
			
			int data=0;
			int count=0;
			while((data=fr.read())!=-1) {
				if(data!='\t' && data!='\r' && data!='\n' && data!=' ') {
					fw.write(data);
				}
				
				count++;
			}
			
			System.out.println("파일에 출력함, count="+count);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(fr!=null)fr.close();
				if(fw!=null)fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}









