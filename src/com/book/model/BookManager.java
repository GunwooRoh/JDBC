package com.book.model;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.pd.model.PdDAO;
import com.pd.model.PdDTO;

public class BookManager {
	public Scanner sc = new Scanner(System.in);
	
	private BookDAO BookDao;
	
	public BookManager() {
		BookDao = new BookDAO();
	}

	public void printTitle() {
		System.out.println("\n--------------상품 목록---------------");
		System.out.println("번호\t제목\t가격\t출판사\t출판일");
		System.out.println("---------------------------------------");
	}

	public void register() throws SQLException {
		//1.
		System.out.println("제목, 가격, 출판사, 출판일 입력");
		String title = sc.nextLine();
		int price=Integer.parseInt(sc.nextLine());
		String publisher = sc.nextLine();
		String joindate = sc.nextLine();
		
		//2.
		BookDTO dto = new BookDTO();
		dto.setTitle(title);
		dto.setPrice(price);
		dto.setPublisher(publisher);
		dto.setJoindate(joindate);
		int cnt = BookDao.insertBook(dto);
		
		//3.
		String result = (cnt > 0)?"상품등록 성공":"상품등록 실패";
		System.out.println(result);
	}

	public void mainMenu() {
		System.out.println("------------------------------------------");
		System.out.println("1.등록 2.전체조회 3.종료 4.수정 5.삭제");
		System.out.println("------------------------------------------");
		System.out.println("번호를 입력하세요");
	}

	public void printAll() throws SQLException {
		//1.사용자로부터 입력받기		
		//2. db작업 - 로직 처리
		List<BookDTO> list = BookDao.selectAll();
		
		//3. 결과 처리 (화면 출력)
		printTitle();
		for(int i=0;i<list.size();i++) {
			BookDTO dto=list.get(i);
			
			System.out.println(dto.getNo()+"\t" + dto.getTitle() + "\t"
					+ dto.getPrice() + "\t"+ dto.getPublisher() + "\t"+dto.getJoindate());
		}//for
		
	}

	public void printByNo() throws NumberFormatException, SQLException {
		//1. 사용자로부터 입력받기
		System.out.println("번호 입력!");
		String no=sc.nextLine();
		
		if(no==null || no.isEmpty()) {
			System.out.println("조회할 번호를 입력하세요!");
			return;
		}
		
		//2. db작업 - 로직 처리
		BookDTO dto= BookDao.selectByNo(Integer.parseInt(no));
		
		//3. 결과 처리 (화면 출력)
		printTitle();
		System.out.println(dto.getNo() + "\t" + dto.getTitle() + "\t"
				+ dto.getPrice() + "\t"+ dto.getPublisher() + "\t" +dto.getJoindate()+"\n");		
	}

	public void edit() throws SQLException {
		//1
		System.out.println("수정할 번호, 상품명, 가격, 출판사, 출판일 입력!");
		String no = sc.nextLine();
		String title = sc.nextLine();
		String price = sc.nextLine();
		String publisher = sc.nextLine();
		String joindate = sc.nextLine();
		
		if(no == null || no.isEmpty()) {
			System.out.println("번호를 입력해주세요.");
			return;
		}
		
		if(title == null || no.isEmpty()) {
			System.out.println("상품명을 입력해주세요.");
			return;
		}
		
		if(price == null || no.isEmpty()) {
			System.out.println("가격을 입력해주세요.");
			return;
		}
		
		if(publisher == null || no.isEmpty()) {
			System.out.println("출판사를 입력해주세요.");
			return;
		}
		
		if(joindate == null || no.isEmpty()) {
			System.out.println("출판일을 입력해주세요.");
			return;
		}
		//2
		BookDTO dto = new BookDTO();
		dto.setNo(Integer.parseInt(no));
		dto.setTitle(title);
		dto.setPrice(Integer.parseInt(price));
		dto.setPublisher(publisher);
		dto.setJoindate(joindate);
		int cnt = BookDao.updateBook(dto);
		
		//3
		String result = "";
		if(cnt > 0) {
			result = "상품 수정 성공";
		}else {
			result = "상품 수정 실패";
		}
		
		System.out.println(result);
	}
		public void remove() throws NumberFormatException, SQLException {
			  //1.사용자로부터 입력 받기
		      System.out.println("삭제할 번호를 입력하세요");
		      String no = sc.nextLine();
		      
		      if(no == null||no.isEmpty()) {
		         System.out.println("번호를 입력해주세요");
		         return;
		      }
		      
		      //2.DB작업 - 로직처리
		      int cnt = BookDao.delete(Integer.parseInt(no));
		      
		      //3.결과처리(화면 출력)
		      String result ="";	      
		      if(cnt>0) {
		         result ="삭제 성공";
		      }else {
		         result ="삭제 실패";
		      }
		      
		      System.out.println(result);
		
	
		}

}