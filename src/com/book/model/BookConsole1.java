package com.book.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Scanner;

import com.db.DbUtil;

public class BookConsole1 {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		BookManager manager = new BookManager();
		
		while(true) {
			try {
				manager.mainMenu();
				int type=Integer.parseInt(sc.nextLine());
				
				switch(type) {
					case 1:
						manager.register();
						break;
					case 2:
						manager.printAll();
						break;
					case 3:
						System.out.println("프로그램 종료");
						System.exit(0);
					case 4 :
						manager.edit();
						break;
					case 5 :
						manager.remove();
						break;
					default:
						System.out.println("잘못 선택!");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}//while
	}

}

