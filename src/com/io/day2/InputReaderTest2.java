package com.io.day2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class InputReaderTest2 {

	public static void main(String[] args) {
		String line="";
		
		Properties prop = System.getProperties();
		System.out.println("OS의 인코딩 : "+prop.get("sun.jnu.encoding"));
		
		InputStreamReader isr=null;
		BufferedReader br=null;		
		try {			
			//InputStreamReader(InputStream in, String charsetName) throws UnsupportedEncodingException
			isr=new InputStreamReader(System.in, "euc-kr");
			br=new BufferedReader(isr);
			
			System.out.println("InputStreamReader의 인코딩 : " + isr.getEncoding());
			
			System.out.println("문장을 입력하세요");
			while((line=br.readLine())!=null) {
				System.out.println("입력한 문장:"+ line);
			}
			
			System.out.println("\n\n");
			
			int data=0;
			while((data=isr.read())!=-1) {
				System.out.println(data+"=>"+(char)data);
			}
				
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
