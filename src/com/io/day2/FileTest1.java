package com.io.day2;

import java.io.File;
import java.io.IOException;

public class FileTest1 {

	public static void main(String[] args) {
		File f = new File("text/test.txt");
		
		String fileName=f.getName();
		
		System.out.println("경로제외한 파일이름:"+ fileName);
		System.out.println("경로포함한 파일이름:"+ f.getPath());
		System.out.println("파일의 절대경로 포함: "+f.getAbsolutePath());
		System.out.println("파일이 속해있는 디렉토리:"+f.getParent());
		
		System.out.println("pathSeparator- "+ File.pathSeparator);
		System.out.println("separator- "+ File.separator);
		
		File f2 = new File("text/abc.txt");
		try {
			f2.createNewFile();
			if(f2.exists()) {
				System.out.println("파일 생성됨!");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
