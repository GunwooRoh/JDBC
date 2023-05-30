package com.db;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BLOBTest {

	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement ps=null;

		try {
			con=DbUtil.getConnection("javauser","javauser123");
			String sql = "insert into memImg(no, name, photo)"
					+" values (memImg_seq.nextval,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, "홍길동");
			
			File image = new File("img/bgImg.JPG");
			FileInputStream fis = new FileInputStream(image);
			ps.setBinaryStream(2, fis, (int) image.length());
			//void setBinaryStream(int parameterIndex, InputStream x, int length) throws SQLException
			
			int cnt=ps.executeUpdate();
			System.out.println(cnt);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				DbUtil.dbClose(ps, con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}


	}

}

/*
create table memImg
(
 no number primary key,
 name varchar2(50) not null,
 photo	blob null
);

create sequence memImg_seq
start with 1
increment by 1
nocache;
*/