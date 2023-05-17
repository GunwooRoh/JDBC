package com.jdbc.day3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Scanner;

import com.db.DbUtil;

public class PdConsole1 {
   static Scanner sc = new Scanner(System.in);

   public static void main(String[] args) {
      
      while(true) {
         try {
            mainMenu();
            int type=Integer.parseInt(sc.nextLine());
            
            switch(type) {
               case 1:
                  register();
                  break;
               case 2:
                  selectAll();
                  break;
               case 6:
                  System.out.println("프로그램 종료!");
                  System.exit(0);
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

   private static void selectAll() throws SQLException {
      Connection con=null;
      PreparedStatement ps=null;
      ResultSet rs=null;
      
      try {
         //1,2
         con=DbUtil.getConnection();
         
         //3.
         String sql="select * from pd order by no desc";
         ps=con.prepareStatement(sql);
         
         //4.
         rs=ps.executeQuery();
         printTitle();
         while(rs.next()) {
            int no=rs.getInt(1);
            String pdName=rs.getString(2);
            int price=rs.getInt(3);
            Timestamp regdate=rs.getTimestamp(4);
            
            System.out.println(no+"\t"+pdName+"\t"+price+"\t"+regdate);
         }
      }finally {
         DbUtil.dbClose(rs, ps, con);
      }
   }

   private static void printTitle() {
      System.out.println("\n--------------상품 목록---------------");
      System.out.println("번호\t상품명\t가격\t등록일");
      System.out.println("---------------------------------------");
   }

   private static void register() throws SQLException {
      System.out.println("상품명, 가격 입력!");
      String pdName=sc.nextLine();
      int price=Integer.parseInt(sc.nextLine());
      
      int cnt = insertPd(pdName, price);
      String result=(cnt>0)?"상품등록 성공":"상품등록 실패";
      System.out.println(result);
   }

   private static int insertPd(String pdName, int price) throws SQLException {
      Connection con=null;
      PreparedStatement ps=null;
      
      try {
         //1,2
         con=DbUtil.getConnection();
      
         //3
         String sql="insert into pd(no,pdname,price)"
                     + " values(pd_seq.nextval, ?, ?)";
         ps=con.prepareStatement(sql);
         
         ps.setString(1, pdName);
         ps.setInt(2, price);
         
         //4
         int cnt=ps.executeUpdate();
         return cnt;
      }finally {
         DbUtil.dbClose(ps, con);
      }
   }

   private static void mainMenu() {
      System.out.println("------------------------------------------");
      System.out.println("1.등록 2.전체조회 3.수정 4.삭제 5.검색 6.종료");
      System.out.println("------------------------------------------");
      System.out.println("번호를 입력하세요");
   }

}
