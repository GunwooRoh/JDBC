package com.io.day2;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutTest2 {

	public static void main(String[] args) {
		int[] score= {95,70,85,100,69,99};
		
		FileOutputStream fos=null;
		DataOutputStream dos=null;
		
		try {
			fos=new FileOutputStream("text/score.dat");
			dos=new DataOutputStream(fos);
			
			for(int i=0;i<score.length;i++) {
				dos.writeInt(score[i]);
			}
			System.out.println("파일에 점수 저장!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(dos!=null) dos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}





