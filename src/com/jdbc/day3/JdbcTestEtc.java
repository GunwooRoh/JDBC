package com.jdbc.day3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class JdbcTestEtc {

	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 성공");
			
			
			String url = "jdbc:oracle:thin:@DESKTOP-O03MT84:1521:xe";
			String user = "hr", upwd = "hr123";
			con = DriverManager.getConnection(url, user, upwd);
			System.out.println("db연결 성공");
			
			String sql = "select * from mem order by no";
			ps = con.prepareStatement(sql);
			
			
			rs = ps.executeQuery();
			while(rs.next()) {
				int no=rs.getInt("no");
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String hp = rs.getString("hp");
				
				Timestamp regdate=rs.getTimestamp(6);
				
				System.out.println(no+"\t"+ id +"\t"+ pwd +"\t" + name + "\t" + hp + "\t" + regdate);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
				if(con!=null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

}
