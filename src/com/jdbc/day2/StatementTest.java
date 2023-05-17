package com.jdbc.day2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class StatementTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("상품명, 가격 입력!");
		String pdName=sc.nextLine();
		int price=sc.nextInt();
		
		Connection con = null;
		Statement ps = null;
		
		try {
			//1. 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 성공");
			
			//2. DB서버에 연결하기 위한 Connection객체 생성
			String url="jdbc:oracle:thin:@DESKTOP-O03MT84:1521:xe";
			//String url="jdbc:oracle:thin:@192.168.0.13:1521:xe";
			String user="hr", upwd="hr123";
			con=DriverManager.getConnection(url, user, upwd);
			System.out.println("db연결됨!");
			
			//3. sql문장을 처리하기 위한 PreparedStatement객체 생성
			ps=con.createStatement();
			String sql="insert into pd(no, pdname,price)"
					+ " values(pd_seq.nextval, '"+pdName+"',"+ price+")";
			
			//4. 실행
			int cnt=ps.executeUpdate(sql);
			System.out.println(cnt+"개 행이 입력됨!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//5. 자원해제
			try {
				if(ps!=null) ps.close();
				if(con!=null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
