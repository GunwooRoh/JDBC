package com.jdbc.day1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JdbcTest1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("상품명, 가격 입력!");
		String pdName=sc.nextLine();
		int price=sc.nextInt();
		
		Connection con = null;
		PreparedStatement ps = null;

		try {
			//1. ����̹� �ε�
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 성공");
			
			//2. DB������ �����ϱ� ���� Connection��ü ����
			String url="jdbc:oracle:thin:@DESKTOP-O03MT84:1521:xe";
			//String url="jdbc:oracle:thin:@192.168.0.13:1521:xe";
			String user="hr", upwd="hr123";
			con=DriverManager.getConnection(url, user, upwd);
			System.out.println("db 연결됨!");
			
			//3. sql������ ó���ϱ� ���� PreparedStatement��ü ����
			String sql="insert into pd(no, pdname,price)"
					+ " values(pd_seq.nextval, ?,?)";
			ps=con.prepareStatement(sql);
			
			//in parameter setting
			ps.setString(1, pdName);
			ps.setInt(2, price);
			
			//4. ����
			int cnt=ps.executeUpdate();
			System.out.println(cnt+"개 행이 입력됨");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//5. �ڿ�����
			try {
				if(ps!=null) ps.close();
				if(con!=null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}

}





