package com.jdbc.day3;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CallableStatementTest3 {

	public static void main(String[] args) {
		Connection con = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 성공");

			String url = "jdbc:oracle:thin:@192.168.0.44:1521:xe";
			String user = "hr";
			String pw = "hr123";
			con = DriverManager.getConnection(url, user, pw);
			System.out.println("DB 연결 성공");
			
			String sql = "call personList(?)";
			cs = con.prepareCall(sql);
			cs.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
			boolean bool = cs.execute();
			
			rs = (ResultSet) cs.getObject(1);
			while(rs.next()) {
				int no = rs.getInt(1);
				String name = rs.getString(2);
				String tel = rs.getString(3);
				
				System.out.println(no + "\t" + name + "\t" + tel);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(con != null) con.close();
				if(cs != null) cs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
		}
	}

}
