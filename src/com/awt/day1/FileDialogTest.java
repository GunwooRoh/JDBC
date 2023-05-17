package com.awt.day1;

import java.awt.FileDialog;
import java.awt.Frame;

public class FileDialogTest {

	public static void main(String[] args) {
		Frame f = new Frame("Parent");
		f.setSize(300, 200);
		
		FileDialog fileOpen = new FileDialog(f, "파일열기", FileDialog.LOAD);
		
		f.setVisible(true);
		
		fileOpen.setDirectory("D:\\lecture");
		fileOpen.setVisible(true);
		
		System.out.println("선택한 파일 : " + fileOpen.getDirectory() + fileOpen.getFile());

	}

}
