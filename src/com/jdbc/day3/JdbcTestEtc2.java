package com.jdbc.day3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JdbcTestEtc2 {

	public static void main(String[] args) 	{
		Scanner sc=new Scanner(System.in);
			System.out.println("수정할 번호, 아이디, 비밀번호, 이름, 전화번호를 입력하세요");
			int no=sc.nextInt();
			sc.nextLine();
			String id=sc.nextLine();
			String pwd=sc.nextLine();
			String name=sc.nextLine();
			String hp=sc.nextLine();
			
			Connection conn=null;
			PreparedStatement ps=null;
			try{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				String url="jdbc:oracle:thin:@192.168.0.44:1521:xe";
				String uid = "hr", upw = "hr123";
				conn = DriverManager.getConnection(url, uid, upw);
				
				String sql="update mem"
					+" set id=?,pwd=?,name=?,hp=?"
					+" where no=?";
				
				ps=conn.prepareStatement(sql);
				
				ps.setString(1, id);
				ps.setString(2, pwd);
				ps.setString(3, name);
				ps.setString(4, hp);
				ps.setInt(5, no);
				
				int cnt=ps.executeUpdate();
				String result=cnt>0? "수정 성공" : "수정 실패";
				System.out.println(result);
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				try{
					if(ps!=null) ps.close();
					if(conn!=null) conn.close();					
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}

	}
}
