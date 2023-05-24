package com.io.day1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInOutTest2 {

	public static void main(String[] args) {
		//파일에서 파일로 출력
		//byte배열 이용
		FileInputStream fis=null;
		FileOutputStream fos=null;
		
		try {
			fis=new FileInputStream("text/poetry4.txt");
			fos=new FileOutputStream("text/poetry4.bak");
			
			/*
			 int read(byte[] b) throws IOException
			 	-InputStream에서 읽어서 byte배열에 넣는다(byte배열의 길이만큼)
				-읽어온 개수를 리턴함

			 void write(byte[] buf, int off, int len)
			 	- byte배열에서 시작위치 off에서 len개 만큼 OutputStream에 출력
			 */
			int cnt=0, count=0, total=0;
			byte[] buf=new byte[1024];
			while((cnt=fis.read(buf))!=-1) {
				System.out.write(buf,0,cnt);
				//=> buf 배열에서 0부터 cnt개 읽어서 출력소스에 쓴다
				fos.write(buf,0,cnt);
				
				System.out.println("\n--------cnt : "+cnt+"\n");
				total+=cnt; //1024+1009
				count++;
			}
			
			System.out.println("\n\n총 "+total+"byte"); //2033
			System.out.println("\n반복횟수 : " + count); //2
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(fis!=null)fis.close();
				if(fos!=null)fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}

}









