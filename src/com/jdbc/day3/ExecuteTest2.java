package com.jdbc.day3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Scanner;

public class ExecuteTest2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				System.out.println("드라이버 로딩 성공");
				
				String url = "jdbc:oracle:thin:@192.168.0.44:1521:xe";
				String user = "hr";
				String pw = "hr123";
				con = DriverManager.getConnection(url, user, pw);
				System.out.println("DB 연결 성공");
				
				String sql = "select * from pd3 order by no desc";
				ps = con.prepareStatement(sql);
				
				boolean bool = ps.execute();
				if(bool) {
					rs = ps.getResultSet();
					while(rs.next()) {
						int no = rs.getInt(1);
						String pdname = rs.getString(2);
						int price = rs.getInt(3);
						Timestamp regdate = rs.getTimestamp(4);
						
						System.out.println(no + "\t" + pdname + "\t" + price + "\t" + regdate);
					}
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}

	}

}
