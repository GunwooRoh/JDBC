package com.jdbc.day3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Scanner;

public class JdbcTestEtc3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("조회하려는 번호를 입력해주세요.");
		int input = Integer.parseInt(sc.nextLine());
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@DESKTOP-O03MT84:1521:xe";
			String user = "hr", upwd = "hr123";
			con = DriverManager.getConnection(url, user, upwd);
			
			
			String sql = "select * from mem where no = ?";
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, input);
			rs = ps.executeQuery();
			
			
			while(rs.next()) {
				int no = rs.getInt(input);
				String id = rs.getString(1);
				String pwd = rs.getString(2);
				String name = rs.getString(3);
				String hp = rs.getString(4);
				
				Timestamp regdate = rs.getTimestamp(6);
				
				System.out.println(no +"\t"+ id +"\t"+ pwd +"\t" + name + "\t" + hp + "\t" + regdate);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

}
