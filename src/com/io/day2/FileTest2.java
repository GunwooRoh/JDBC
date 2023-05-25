package com.io.day2;

import java.io.File;

public class FileTest2 {

	public static void main(String[] args) {
		File f = new File("text/poetry.txt");
		System.out.println("파일명:"+ f.getName());
		System.out.println("파일 상대경로:"+ f.getPath());
		System.out.println("파일 절대경로:"+ f.getAbsolutePath());
		System.out.println("파일 크기:"+ f.length() +"byte");
		
		File f2 = new File("text","test.txt"); //디렉토리, 파일명
		File file = new File("text\\123.txt"); //디렉토리, 파일명
		File f3 = new File("text"+File.separator+"test1.txt");
		
		System.out.println("f2 존재여부:"+ f2.exists());
		System.out.println("file 존재여부:"+ file.exists());
		System.out.println(f3.exists()?"f3 존재함":"f3 존재하지 않음");
		
		System.out.println("file이 파일인지 여부 : " + file.isFile());
		System.out.println("file이 디렉토리인지 여부 : " + file.isDirectory());
		System.out.println(f2.canWrite()? "f2 쓰기 가능" : "f2 쓰기 불가");
		System.out.println(f2.canRead()? "f2 읽기 가능" : "f2 읽기 불가");
		
		File f4 = new File("rain");
		f4.mkdir();
		
		File f5 = new File("sun", "moon");
		f5.mkdirs();
		
		boolean bool = f4.renameTo(new File("Star"));
		System.out.println("이름변경 여부 : " + bool);
		
		bool = f5.delete();
		System.out.println("삭제여부 : " + bool);
		
		String str = "text\123.txt";
		
	}

}
