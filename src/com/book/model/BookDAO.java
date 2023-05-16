package com.book.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.db.DbUtil;
import com.pd.model.PdDTO;

public class BookDAO {
	//[1] 입력, 수정의 경우 매개변수가 DTO인 메서드 이용
	public int insertBook(BookDTO dto) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		
		try {
			//1,2
			con=DbUtil.getConnection();
		
			//3
			String sql="insert into book(no, title, price, publisher, joindate)"
		               + " values(book_seq.nextval, ?, ?, ?, ?)";
			ps=con.prepareStatement(sql);
			
			ps.setString(1, dto.getTitle());
			ps.setInt(2, dto.getPrice());
			ps.setString(3, dto.getPublisher());
			ps.setString(4, dto.getJoindate());
			
			//4
			int cnt=ps.executeUpdate();
			System.out.println("상품 등록 결과, cnt : "+ cnt + ", 매개변수 dto : " + dto);
			
			return cnt;
		}finally {
			DbUtil.dbClose(ps, con);
		}		
	}


	public BookDTO selectByNo(int parseInt) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<BookDTO> selectAll() throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		//여러 개의 레코드를 List로 묶어서 리턴
		List<BookDTO> list = new ArrayList<>();
		try {
			//1,2
			con=DbUtil.getConnection();
			
			//3.
			String sql="select * from book";
			ps=con.prepareStatement(sql);
			
			//4.
			rs=ps.executeQuery();
			
			while(rs.next()) {
				int no = rs.getInt(1);
				String title = rs.getString(2);
				int price = rs.getInt(3);
				String publisher = rs.getString(4);
				String joindate = rs.getString(5);
				
				//[1] 먼저 한 개의 레코드를 DTO로 묶어준다
				BookDTO dto = new BookDTO(no, title, price, publisher, joindate);
				
				//[2] 각각의 DTO를 List로 묶어서 리턴한다
				list.add(dto);
			}
			System.out.println("상품전체 조회 결과, list.size : " + list.size());
			
			return list;
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
	
	}
	public int updateBook(BookDTO dto) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		
		try {
			//1,2
			con=DbUtil.getConnection();
			
			//3
			String sql="update book" + " set title = ?, price = ?, publisher = ?, joindate = ?" + "where no = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getTitle());
			ps.setInt(2, dto.getPrice());
			ps.setString(3, dto.getPublisher());
			ps.setString(4, dto.getJoindate());
			ps.setInt(5, dto.getNo());
			
			//4
			int cnt = ps.executeUpdate();
			System.out.println("상품 수정 결과, cnt : " + cnt + ", 매개변수 dto : " + dto);
			return cnt;
		}finally {
			DbUtil.dbClose(ps, con);
		}
	}
	public int delete(int no) throws SQLException {
	      Connection con = null;
	      PreparedStatement ps = null;
	      
	      try {
	         //1,2 드라이버로딩&db연결
	         con=DbUtil.getConnection();
	      
	         //3.sql문 처리를 위한 PrepareStatement 객체 생성
	         String sql = "delete from book where no =?";
	         ps=con.prepareStatement(sql);
	         ps.setInt(1, no);
	         
	         //4.sql 처리
	         int cnt = ps.executeUpdate();
	         System.out.println("삭제 결과 , cnt="+cnt+", 매개변수 no="+no);
	         
	         return cnt;	         
	      }finally {
	         DbUtil.dbClose(ps, con);	         
	      }
	   }
	
}
