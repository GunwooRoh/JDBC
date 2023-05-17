package com.jdbc.day2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class ReverseSelect {

	public static void main(String[] args) {
		//ResultSet의 커서 이동
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			//1. 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 성공");
			
			//2. db서버에 연결하기 위한 Connection객체 생성
			String url="jdbc:oracle:thin:@DESKTOP-O03MT84:1521:xe";
			String user="hr", upwd="hr123";
			con=DriverManager.getConnection(url, user, upwd);
			System.out.println("db연결 성공");
			
			//3. sql문장을 처리하기 위한 PreparedStatement객체 생성
			String sql="select * from pd order by no";
			ps=con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_READ_ONLY); 
			//=> ResultSet의 커서를 자유자재로 이동시키기 위한 설정
			
			//4. 실행
			rs=ps.executeQuery();
			rs.afterLast(); //rs를 마지막 행의 바로 뒤에 위치시킨다.
			while(rs.previous()) {
				int no=rs.getInt(1);
				String pdName=rs.getString(2);
				int price=rs.getInt(3);
				Timestamp regdate=rs.getTimestamp(4);
				
				System.out.println(no+"\t"+pdName+"\t"+price+"\t"+regdate);
			}
			
			System.out.println("\n==========================");
			rs.absolute(2);
			System.out.println(rs.getInt(1) +" : " + rs.getString(2));
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










