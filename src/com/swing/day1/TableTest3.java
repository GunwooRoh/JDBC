package com.swing.day1;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.pd.model.PdDAO;
import com.pd.model.PdDTO;

public class TableTest3 extends JFrame implements ActionListener{
	private JButton bt;
	private JTable table;
	private JScrollPane scrollPane;
	private DefaultTableModel model=new DefaultTableModel();
	private PdDAO pdDao;
	
	public TableTest3() {
		super("JTable test3");		
		pdDao=new PdDAO();
		
		init();
		addEvent();
		
		this.setSize(600,300);
		this.setVisible(true);		
	}	
	
	private void init() {
		bt=new JButton("조회");
		this.add(bt,"North");
		
		table=new JTable();
		scrollPane = new JScrollPane();
		
		model.addColumn("번호");
		model.addColumn("상품명");
		model.addColumn("가격");
		model.addColumn("등록일");
		
		//model을 view와 연결
		table.setModel(model);
		table.getTableHeader().setBackground(Color.black);
		table.getTableHeader().setForeground(Color.yellow);
		table.getTableHeader().setReorderingAllowed(false);
		table.setRowHeight(20);
		
		scrollPane.setViewportView(table);
		this.add(scrollPane,"Center");
	}

	private void addEvent() {
		bt.addActionListener(this);
	}

	public static void main(String[] args) {
		TableTest3 f = new TableTest3();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==bt) {
			try {
				showData();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	private void showData() throws SQLException {
		List<PdDTO> list=pdDao.selectAll();
		
		String[] colNames= {"번호","상품명","가격","등록일"};
		String[][] data=new String[list.size()][4];
		for(int i=0;i<list.size();i++) {
			PdDTO dto=list.get(i);
			
			data[i][0] = dto.getNo()+"";
			data[i][1] = dto.getPdName();
			data[i][2] = dto.getPrice()+"";
			data[i][3] = dto.getRegdate()+"";			
		}//for
		
		model.setDataVector(data, colNames);
		table.setModel(model);
	}

}




