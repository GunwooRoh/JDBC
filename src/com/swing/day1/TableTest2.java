package com.swing.day1;



import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TableTest2 extends JFrame {
	private JScrollPane scrolPane;
	private JTable table;
	private DefaultTableModel model = new DefaultTableModel();

	private String[][] data= {
			{"1", "홍길동", "서울"},
			{"2", "정길동", "대구"},
			{"3", "안길동", "부산"},
			{"4", "이길동", "광주"}			
	};
	
	private String[] colNames= {"번호","이름","주소"};
	
	public TableTest2() {
		super("JTable test2");
		
		init();
		this.setSize(300,300);
		this.setVisible(true);
	}
	
	private void init() {
		table=new JTable();
		scrolPane = new JScrollPane(table);
		//void setDataVector(Object[][] dataVector, Object[] columnIdentifiers)
		model.setDataVector(data, colNames);
		table.setModel(model);
		
		this.add(scrolPane);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		TableTest2 f = new TableTest2();
	}

}







