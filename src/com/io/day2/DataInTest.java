package com.io.day2;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DataInTest {

	public static void main(String[] args) {
		/*
		 파일로부터 기본자료형 단위로 읽어온다
		 
		 노드스트림 - FileInputStream
		 보조스트림 - DataInputStream
		 */
		
		FileInputStream fis=null;
		DataInputStream dis=null;
		
		try {
			fis=new FileInputStream("text/sample.dat");
			dis=new DataInputStream(fis);
			
			int data=dis.readInt();
			System.out.println(data);
			System.out.println(dis.readFloat());
			System.out.println(dis.readBoolean());
			System.out.println(dis.readChar());
			String str=dis.readUTF();
			System.out.println(str);
			
			//=>여러 가지 종류의 자료형으로 출력한 경우, 읽을 때는 반드시 쓰인 순서대로 읽어야 한다
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(dis!=null) dis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}

}









