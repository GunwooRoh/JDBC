package com.book.model;

import java.sql.Timestamp;

public class BookDTO {
	private int no;
	private String title;
	private int price;
	private String publisher;
	private String joindate;
	
	public BookDTO(int no, String title, int price, String publisher, String joindate) {
		super();
		this.no = no;
		this.title = title;
		this.price = price;
		this.publisher = publisher;
		this.joindate = joindate;
	}
	
	

	public int getNo() {
		return no;
	}



	public void setNo(int no) {
		this.no = no;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public int getPrice() {
		return price;
	}



	public void setPrice(int price) {
		this.price = price;
	}



	public String getPublisher() {
		return publisher;
	}



	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}



	public String getJoindate() {
		return joindate;
	}



	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}


	
	public BookDTO() {
		super();
		// TODO Auto-generated constructor stub
	}



	@Override
	public String toString() {
		return "BookDTO [no=" + no + ", title=" + title + ", price=" + price + ", publisher=" + publisher
				+ ", joindate=" + joindate + "]";
	}
}
