package com.db;

import java.awt.FlowLayout;
import java.awt.TextArea;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BLOBTest2 extends JFrame{
	JLabel lb;
	TextArea ta;
	public BLOBTest2(){
		super("BLOB Test");
		setLayout(new FlowLayout());
				
		showImage();
		
		setSize(450,500);
		setVisible(true);
	}
	
	private void showImage() {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;

		//1,2
		try {
			con=DbUtil.getConnection("javauser","javauser123");
			
			String sql = "select * from memImg where no=1";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			byte[] buf=null;
			if (rs.next()) {
				int no = rs.getInt(1);
				String name = rs.getString(2);
				
				buf= rs.getBytes(3);			
				System.out.println(no+", "+name);
				
				ImageIcon icon = new ImageIcon(buf);
				lb=new JLabel(icon);
				this.add(lb);
				
				ta=new TextArea();
				ta.append(name);
				this.add(ta);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();		
		}finally {
			try {
				DbUtil.dbClose(rs, ps, con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		BLOBTest2 f = new BLOBTest2();

	}

}
