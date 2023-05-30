package com.thread.day2;
import javax.swing.JOptionPane;

class MyThread3 extends Thread{

   MyThread3(){
      super();
   }

   @Override
   public void run() {
      String ssn = JOptionPane.showInputDialog("주민번호를 입력하세요");

      String birth = "";
      if(ssn.substring(7, 8).equals("1") || ssn.substring(7, 8).equals("1")) {
         birth = 19 + ssn.substring(0, 2) + "-" + ssn.substring(2, 4) + "-" + ssn.substring(4, 6);
      }else {
         birth = 20 + ssn.substring(0, 2) + "-" + ssn.substring(2, 4) + "-" + ssn.substring(4, 6);
      }

      String gender = "";
      if(ssn.substring(7, 8).equals("1") || ssn.substring(7, 8).equals("3")) {
         gender = "남";
      }else {
         gender = "여";
      }

      System.out.println("주민번호 : " + ssn);
      System.out.println("생일 : " + birth);
      System.out.println("성별 : " + gender);

   }

}

class MyRunnable3 implements Runnable{
   String site;

   public MyRunnable3(String site) {
      this.site = site;
   }

   @Override
   public void run() {
      for(int i = 0; i <= 100; i += 10) {
         System.out.println(site + "에서 " + i + "% 다운로드 중..");
         try {
            Thread.sleep(1000);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }//for

   }

}

public class Example1 {

   public static void main(String[] args) {
      MyThread3 th1 = new MyThread3();
      MyRunnable3 r = new MyRunnable3("http://www.nate.com");
      Thread th2 = new Thread(r);

      th1.start();
      th2.start();

   }

}