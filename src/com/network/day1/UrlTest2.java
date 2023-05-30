package com.network.day1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class UrlTest2 {

	public static void main(String[] args) {
		BufferedReader br=null;
		BufferedWriter bw=null;
		
		try {
			URL url = new URL("http://www.yes24.com/24/category/bestseller?Gcode=100_012");
			InputStream is = url.openStream();
			br = new BufferedReader(new InputStreamReader(is, "euc-kr"));
			bw = new BufferedWriter(new FileWriter("text/url.txt"));
			
			String data="";
			while((data=br.readLine())!=null) {
				bw.write(data);
				bw.newLine();
			}
			System.out.println("파일에 저장함");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(br!=null) br.close();
				if(bw!=null) bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
