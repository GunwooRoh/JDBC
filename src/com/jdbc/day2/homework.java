package com.jdbc.day2;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class homework {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("제목, 책가격, 출판인, 출판날짜(YYYY-MM-DD)를 입력해주세요");
		
		System.out.print("제목: ");
		String title = sc.nextLine();
		System.out.print("책가격: ");
		int price = sc.nextInt();
		System.out.print("출판인: ");
		sc.nextLine();
		String publisher = sc.nextLine();
		System.out.print("출판날짜: ");
		String date = sc.nextLine();
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 성공");
			
			String url = "jdbc:oracle:thin:@192.168.0.44:1521:xe";
			String user = "hr", pw = "hr123";
			con = DriverManager.getConnection(url, user, pw);
			System.out.println("DB연결 성공");
			
			String sql = "insert into book(no, title, price, publisher, joindate)" + " values(book_seq.nextval, ?, ?, ?, ?)";
			ps = con.prepareStatement(sql);
			
			ps.setString(1, title);
			ps.setInt(2, price);
			ps.setString(3, publisher);
			ps.setString(4, date);
			
			int cnt = ps.executeUpdate();
			System.out.println(cnt + "개 행 추가");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		sc.close();
	}
}