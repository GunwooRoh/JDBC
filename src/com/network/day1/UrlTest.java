package com.network.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class UrlTest {

	public static void main(String[] args) {
		BufferedReader br=null;
		
		try {
			URL url = new URL("http://www.yes24.com/24/category/bestseller?Gcode=100_012");
			
			System.out.println("protocol : " + url.getProtocol());
			System.out.println("host : " + url.getHost());
			System.out.println("port : " + url.getPort());//-1 반환 => 기본 포트 사용한 경우
			System.out.println("file : " + url.getFile());

			URLConnection con = url.openConnection();
			System.out.println("\n\n파일 크기 : " + con.getContentLength());
			System.out.println("contentType : " + con.getContentType());
			
			//URL과 연결된 URLConnection의 InputStream을 얻는다.
			
			InputStream is = url.openStream();
			br=new BufferedReader(new InputStreamReader(is,"euc-kr"));
			String data="";
			while((data=br.readLine())!=null) {
				System.out.println(data);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(br!=null) br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}






