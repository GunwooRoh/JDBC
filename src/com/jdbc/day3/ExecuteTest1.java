package com.jdbc.day3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ExecuteTest1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("상품명, 가격 입력");
		String pdName = sc.nextLine();
		int price = sc.nextInt();
		
		Connection con = null;
		PreparedStatement ps = null;
	
		try {
			//1.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 성공");
				
			//2.
			String url = "jdbc:oracle:thin:@192.168.0.44:1521:xe";
			String user = "hr", pw = "hr123";
			con = DriverManager.getConnection(url, user, pw);
			System.out.println("DB연결 성공");
			
			//3.
			String sql = "insert into pd3(no, pdname,price)"
					+ " values(pd_seq.nextval, ?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, pdName);
			ps.setInt(2, price);
			
			//4.
			boolean bool = ps.execute();
			if(!bool) {
				int cnt = ps.getUpdateCount();
				
				String result = (cnt > 0) ? "상품등록 성공" : "상품등록 실패";
				System.out.println(result);
			} 
			
		} catch (ClassNotFoundException e) {
				
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(ps != null) ps.close();
				if(con != null) con.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		}
			
		


	}

}
