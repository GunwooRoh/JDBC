package com.jdbc.day2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

public class JdbcTest2 {

	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			//1. 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 성공");
			
			//2. db서버와 연결하기 위한 Connection객체 생성
			String url="jdbc:oracle:thin:@DESKTOP-O03MT84:1521:xe";
			String user="hr", upwd="hr123";
			con=DriverManager.getConnection(url, user, upwd);
			System.out.println("db연결 성공!");
			
			//3. sql문장을 처리하기 위한 PreparedStatement 객체 생성
			String sql="select * from pd order by no desc";
			ps=con.prepareStatement(sql);
			
			//4. 실행
			rs=ps.executeQuery();
			while(rs.next()) {
				int no=rs.getInt("no");
				String pdName=rs.getString("pdName");
				int price=rs.getInt("price");
				Date regdate=rs.getDate("regdate");
				Timestamp regdate2=rs.getTimestamp(4);
				
				System.out.println(no+"\t"+pdName+"\t"+price+"\t"+regdate+"\t"+regdate2);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//5. 자원반납
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
