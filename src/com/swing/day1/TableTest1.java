package com.swing.day1;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TableTest1 extends JFrame {
	private JScrollPane scrollPane;
	private JTable table;  //view
	private String[][] data = {
			{"1","홍길동","서울"},
			{"2","김길동","인천"},
			{"3","이길동","부산"},
			{"4","강길동","대전"}
			}; //model
	
	private String[] colNames= {"번호","이름","주소"};
	
	public TableTest1() {
		super("JTable test");
		
		init();
		
		this.setSize(350,300);
		this.setVisible(true);
	}
		
	private void init() {
		//JTable(Object[][] rowData, Object[] columnNames)
		table=new JTable(data, colNames);
		scrollPane = new JScrollPane(table);
		this.add(scrollPane);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	public static void main(String[] args) {
		TableTest1 f = new TableTest1();
	}

}
