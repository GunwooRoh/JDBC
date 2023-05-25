package com.io.day2;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DataInTest2 {

	public static void main(String[] args) {
		int sum=0, score=0;
		
		FileInputStream fis=null;
		DataInputStream dis=null;
		
		try {
			fis=new FileInputStream("text/score.dat");
			dis=new DataInputStream(fis);
			
			while(true) {
				score=dis.readInt();
				System.out.println(score);
				sum+=score;
			}
			//DataInputStream의 readInt() 와 같이 데이터를 읽는 메서드는
			//더 이상 읽을 데이터가 없으면 EOFException 을 발생시킴
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EOFException e) {
			System.out.println("점수의 총합 : " + sum);
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





