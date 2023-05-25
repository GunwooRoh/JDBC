package com.io.day2;

import java.awt.Frame;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

class Member implements Serializable{ //직렬화 가능 클래스(네트워크 통해 전송한다고 표시)
	private String userid;
	private transient String pwd; //직렬화 대상에서 제외(비밀번호는 보내지 않겠다, 
									//pwd는 null이 출력됨)
	private int age;
	
	public Member() {
		super();
	}

	public Member(String userid, String pwd, int age) {
		this.userid = userid;
		this.pwd = pwd;
		this.age = age;
	}
	
	public void showInfo() {
		System.out.println("=============="+ userid +"의 정보 ==============");
		System.out.println("아이디 : " + userid);
		System.out.println("비밀번호 : " + pwd);
		System.out.println("나이 : " + age+"\n");
	}	
}

public class ObjectOutputTest {
	public static void main(String[] args) {
		Member m1 = new Member("hong", "1234", 20);
		Member m2 = new Member("kim", "789", 22);
		ArrayList<Member> list = new ArrayList<>();
		list.add(m1);
		list.add(m2);
				
		FileOutputStream fos=null;
		ObjectOutputStream oos=null;
		
		try {
			fos=new FileOutputStream("text/member.ser");
			oos=new ObjectOutputStream(fos);
			
			oos.writeObject(m1);
			oos.writeObject(m2);
			oos.writeObject(new Date());
			
			Frame f = new Frame("직렬화 연습");			
			oos.writeObject(f);
			oos.writeObject(list);
			
			System.out.println("직렬화 성공");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(oos!=null) oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}






