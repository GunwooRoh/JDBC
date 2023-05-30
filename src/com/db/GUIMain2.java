package com.db;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;

import javax.swing.AbstractCellEditor;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import com.pd.model.PdDAO;
import com.pd.model.PdDTO;

public class GUIMain2 extends JFrame implements ActionListener{
	JLabel lbNo, lbPdName, lbPrice;
	JTextField tfNo, tfPdName, tfPrice;
	JTable table;
	JScrollPane scrollPane;
	JPanel plNorth, plSouth;
	JButton btAdd, btEdit, btDel, btSearch, btAll, btCancel;
	DefaultTableModel model=new DefaultTableModel();
	
	//ComboBoxModel
	String[] cbData= {"java","spring","oracle"};
	DefaultComboBoxModel<String> cbModel=new DefaultComboBoxModel<>(cbData);
	
	PdDAO pdDao;
	String[] colNames= {"번호","상품명","가격","등록일"};

	public GUIMain2() {
		super("상품 관리2");
		pdDao=new PdDAO();
		
		init();
		addEvent();
	}

	private void init() {
		lbNo=new JLabel("번호");
		lbPdName=new JLabel("상품명");
		lbPrice=new JLabel("가격");

		tfNo=new JTextField(10);
		tfPdName=new JTextField(10);
		tfPrice=new JTextField(10);
		tfNo.setEditable(false);

		plNorth=new JPanel();
		plSouth=new JPanel();

		plNorth.add(lbNo);
		plNorth.add(tfNo);
		plNorth.add(lbPdName);
		plNorth.add(tfPdName);
		plNorth.add(lbPrice);
		plNorth.add(tfPrice);

		add(plNorth, "North");

		btAdd=new JButton("입력");
		btEdit=new JButton("수정");
		btDel=new JButton("삭제");
		btSearch=new JButton("검색");
		btAll=new JButton("전체조회");
		btCancel=new JButton("취소");

		plSouth.add(btAdd);
		plSouth.add(btEdit);
		plSouth.add(btDel);
		plSouth.add(btSearch);
		plSouth.add(btAll);
		plSouth.add(btCancel);

		add(plSouth, "South");

		table=new JTable();
		scrollPane=new JScrollPane();

		model.addColumn("번호");
		model.addColumn("상품명");
		model.addColumn("가격");
		model.addColumn("등록일");

		table.setModel(model);
		table.getTableHeader().setReorderingAllowed(false);
		table.setRowHeight(20);

		scrollPane.setViewportView(table);
		add(scrollPane);

		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		try {
			showAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void addEvent() {
		btAdd.addActionListener(this);
		btEdit.addActionListener(this);
		btDel.addActionListener(this);
		btSearch.addActionListener(this);
		btAll.addActionListener(this);
		btCancel.addActionListener(this);

		table.addMouseListener(new EventHandler());
	}

	class EventHandler extends MouseAdapter{

		@Override
		public void mousePressed(MouseEvent e) {
			int row=table.getSelectedRow();
			//System.out.println("선택된 row=" + row);

			for(int i=0;i<3;i++) {
				//Object getValueAt(int row, int column)
				Object obj=table.getValueAt(row, i);
				//String str=obj.toString();
				String str="";
				
				switch(i) {
				case 0: //0열
					boolean bool= (boolean) obj;
					tfNo.setText(bool+"");
					break;
				case 1: //1열
					str=(String) obj;
					tfPdName.setText(str);
					break;
				case 2: //2열
					str=(String) obj;
					tfPrice.setText(str);
					break;						
				}
			}//for
		}

	}



	private void showAll() throws SQLException {
		//1.
		//2
		List<PdDTO> list=pdDao.selectAll();
		if(list==null || list.isEmpty()) {
			JOptionPane.showMessageDialog(this, "데이터가 없습니다.");
			return;
		}

		//3.		
		Object[][] data=new Object[list.size()][4];

		for(int i=0;i<data.length;i++) {
			PdDTO dto=list.get(i);
			//data[i][0]=dto.getNo()+"";
			data[i][0]=false;
			data[i][1]=dto.getPdName();
			data[i][2]=dto.getPrice()+"";
			//data[i][3]=dto.getRegdate()+"";			
			data[i][3]="java";			
		}

		model.setDataVector(data, colNames);
		table.setModel(model);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		DefaultTableCellRenderer renderer = new MyDefaultTableCellRenderer();
		table.getColumn("번호").setCellRenderer(renderer);
		table.getColumn("번호").setCellEditor(new DefaultCellEditor(new JCheckBox()));

		table.getColumn("등록일").setCellRenderer(renderer);
		table.getColumn("등록일").setCellEditor(new DefaultCellEditor(new JComboBox<>(cbModel)));
		
		table.getColumnModel().getColumn(1).setCellRenderer(new TableCell());
		table.getColumnModel().getColumn(1).setCellEditor(new TableCell());
		
		
		/*
		TableColumn testColumn = table.getColumnModel().getColumn(3);
	      JComboBox<String> comboBox = new JComboBox<>();
	      comboBox.addItem("java");
	      comboBox.addItem("spring");
	      comboBox.addItem("oracle");
	      testColumn.setCellEditor(new DefaultCellEditor(comboBox));*/
	      
	}


	public static void main(String[] args) {
		GUIMain2 f = new GUIMain2();
		f.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if(e.getSource()==btAll) {
				showAll();									
			}else if(e.getSource()==btCancel) {
				getData();							
			}//if
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	private void getData() {
		for(int i=0;i<model.getRowCount();i++) {
			boolean bool=(boolean) model.getValueAt(i, 0);
			String price=(String) model.getValueAt(i, 2);
			String str=(String) model.getValueAt(i, 3);
			//System.out.println(i+" : bool="+bool+", price="+price);
			if(bool) {
				System.out.println(i+" : bool="+bool+", price="+price+",combo="+str);						
			}
		}//for
	}
	

	class TableCell extends AbstractCellEditor 
		implements TableCellEditor, TableCellRenderer{

		JButton bt;

		public TableCell() {
			bt = new JButton("확인");

			bt.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println(table.getValueAt(table.getSelectedRow(), 2));
				}
			});
		}

		@Override
		public Object getCellEditorValue() {
			return null;
		}

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			return bt;
		}

		@Override
		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
				int column) {
			return bt;
		}

	}//class

	
	class MyDefaultTableCellRenderer extends DefaultTableCellRenderer{

		
		@Override
		public Component getTableCellRendererComponent(JTable table, 
				Object value,boolean isSelected, boolean hasFocus, 
				int row, int column) {
			/*JTable table : 현재 작업 중인 JTable
			Object value : 현재 작업 중인 JTable의 셀객체
			int row : 현재 작업 중인 row번호
			int column : 현재 작업 중인 column번호*/
			
			if(column==0){
				JCheckBox comp = null;
				comp = new JCheckBox();
				comp.setSelected(((Boolean)value).booleanValue());	 	 	
				return comp;		
			}else if(column==3) {
				JComboBox cb=new JComboBox();
				cb.addItem(value);				
				return cb;
			}else {
				return null;
			}
		}
	}//class
}//class




