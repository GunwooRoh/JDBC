package com.jdbc.day3;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class CallableStatementTest1 {

	public static void main(String[] args) {
		// exec personInsert('ddd','010-1111-2222');
		
		Scanner sc = new Scanner(System.in);
		System.out.println("이름, 전화번호 입력");
		String name = sc.next();
		String tel = sc.next();
		
		Connection con = null;
		CallableStatement cs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 성공");
			
			String url = "jdbc:oracle:thin:@192.168.0.44:1521:xe";
			String user = "hr", pw = "hr123";
			con = DriverManager.getConnection(url, user, pw);
			System.out.println("DB 연결성공");
			
			String sql = "call personInsert(?, ?)";
			cs = con.prepareCall(sql);
			cs.setString(1, name);
			cs.setString(2, tel);
			
			boolean bool = cs.execute();
			System.out.println("프로시저 실행 결과 bool : " + bool);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(cs != null) cs.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
