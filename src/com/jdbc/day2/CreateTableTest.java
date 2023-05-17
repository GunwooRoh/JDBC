package com.jdbc.day2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateTableTest {

	public static void main(String[] args) {
		//table, sequence 생성하기
		Connection con=null;
		PreparedStatement ps=null;
		
		try {
			//1.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 성공");
			
			//2
			String url="jdbc:oracle:thin:@DESKTOP-O03MT84:1521:xe";
			String user="hr", upwd="hr123";
			con=DriverManager.getConnection(url, user, upwd);
			System.out.println("db연결 성공");
			
			//3.
			String sql="create table pd3"
					+ "("
					+ " no number primary key,"
					+ " pdName varchar2(50) not null,"
					+ " price number null,"
					+ " regdate  date default sysdate"
					+ ")";
			ps=con.prepareStatement(sql);
			
			//4
			boolean bool=ps.execute();
			/* - 모든 sql문장을 실행시킴
			   - select문이면 true, select문이 아니면 false를 반환*/
			System.out.println("table 생성 결과, bool="+bool);
			
			//sequence 생성하기
			sql="create sequence pd3_seq"
					+ " start with 1"
					+ " increment by 1"
					+ " nocache";
			ps=con.prepareStatement(sql);
			
			bool=ps.execute();
			System.out.println("sequence 생성 결과, bool="+bool);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps!=null) ps.close();
				if(con!=null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

}







