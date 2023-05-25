package com.io.day2;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutTest1 {

	public static void main(String[] args) {
		/*
		 기본자료형 단위로 파일에 출력
		 
		 노드스트림 - FileOutputStream
		 보조스트림 - DataOutputStream
		*/
		
		FileOutputStream fis=null;
		DataOutputStream dos=null;

		try {
			fis=new FileOutputStream("text/sample.dat");
			dos=new DataOutputStream(fis);
			
			dos.writeInt(78);  //4byte
			dos.writeFloat(3.141595f);  //4byte
			dos.writeBoolean(true);  //1byte
			dos.writeChar('H');  //2byte
			dos.writeUTF("java!안녕");
			//=> 출력한 값들은 이진데이터로 저장됨
			
			System.out.println("파일에 출력됨!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(dos!=null)dos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}







