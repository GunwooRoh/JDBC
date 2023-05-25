package com.io.day2;

import java.awt.Frame;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Date;

public class ObjectInputTest {

	public static void main(String[] args) {
		FileInputStream fis=null;
		ObjectInputStream ois=null;
		
		try {
			fis=new FileInputStream("text/member.ser");
			ois=new ObjectInputStream(fis);
			
			Object obj=ois.readObject();
			Member m1 = (Member)obj;
			Member m2 = (Member) ois.readObject();
			
			Date d = (Date)ois.readObject();
			Frame f = (Frame)ois.readObject();
			ArrayList<Member> list = (ArrayList<Member>) ois.readObject();
			
			m1.showInfo();
			m2.showInfo();
			
			Date today = new Date();
			System.out.println("저장된 객체 시간:"+ d.toLocaleString());			
			System.out.println("현재 시간:"+ today.toLocaleString());
			f.setSize(300,200);
			f.setVisible(true);
			
			System.out.println("\n[ArrayList의 내용]");
			for(Member m : list) {
				m.showInfo();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				if(ois!=null) ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
