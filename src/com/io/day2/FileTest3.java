package com.io.day2;

import java.io.File;

public class FileTest3 {

	public static void main(String[] args) {
		File f = new File("D:\\lecture\\java");
		if(!f.exists() || !f.isDirectory()) {
			System.out.println("유효하지 않은 디렉토리입니다!");
			return;
		}
		
		File[] fileArr = f.listFiles();
		for(int i=0;i<fileArr.length;i++) {
			String fileName=fileArr[i].getName();
			System.out.println(fileArr[i].isDirectory()?"["+fileName+"]" : fileName
					+ "  " + fileArr[i].length()+"byte");
					
		}
	}

}





