package com.swing.day2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.pd.model.PdDAO;
import com.pd.model.PdDTO;

public class PdGUI extends JFrame implements ActionListener{
	private JPanel plN, plS;
	private JTable table;
	private JScrollPane scrollPane;
	private JLabel lb1, lb2, lb3;
	private JTextField tfNo, tfPdName, tfPrice;
	private JButton btAdd, btEdit, btDel, btSearch, btShowAll, btCancel;
	private DefaultTableModel model = new DefaultTableModel();
	private PdDAO pdDao;
	
	public PdGUI() {
		super("상품 관리");		
		pdDao=new PdDAO();
		
		init();
		addEvent();
		
		this.setSize(600,500);
		this.setVisible(true);
	}
	
	private void init() {
		plN = new JPanel();
		plS = new JPanel();
		
		table=new JTable();
		scrollPane=new JScrollPane();
		scrollPane.setViewportView(table);
		
		this.add(scrollPane,"Center");
		
		lb1=new JLabel("번호");
		lb2=new JLabel("상품명");
		lb3=new JLabel("가격");
		
		tfNo=new JTextField(10);
		tfPdName=new JTextField(10);
		tfPrice=new JTextField(10);
		
		plN.add(lb1);
		plN.add(tfNo);
		plN.add(lb2);
		plN.add(tfPdName);
		plN.add(lb3);
		plN.add(tfPrice);
		
		btAdd=new JButton("입력");
		btEdit=new JButton("수정");
		btDel=new JButton("삭제");
		btSearch=new JButton("검색");
		btShowAll=new JButton("전체조회");
		btCancel=new JButton("취소");
		
		plS.add(btAdd);
		plS.add(btEdit);
		plS.add(btDel);
		plS.add(btSearch);
		plS.add(btShowAll);
		plS.add(btCancel);
		
		this.add(plN,"North");
		this.add(plS,"South");
		
		model.addColumn("번호");
		model.addColumn("상품명");
		model.addColumn("가격");
		model.addColumn("등록일");
		
		table.setModel(model);		
		table.getTableHeader().setReorderingAllowed(false);
		table.setRowHeight(25);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		try {
			showAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void showAll() throws SQLException {
		List<PdDTO> list=pdDao.selectAll();
		if(list==null || list.isEmpty()) {
			JOptionPane.showMessageDialog(this, "데이터가 없습니다.");
			return;
		}
		
		String[] colNames = {"번호","상품명","가격","등록일"};
		String[][] data = new String[list.size()][4];
		for(int i=0;i<list.size();i++) {
			PdDTO dto=list.get(i);
			
			data[i][0]=dto.getNo()+"";
			data[i][1]=dto.getPdName();
			data[i][2]=dto.getPrice()+"";
			data[i][3]=dto.getRegdate()+"";			
		}//for
		
		model.setDataVector(data, colNames);
		table.setModel(model);
	}

	private void addEvent() {
		btAdd.addActionListener(this);
		btEdit.addActionListener(this);
		btDel.addActionListener(this);
		btSearch.addActionListener(this);
		btShowAll.addActionListener(this);
		btCancel.addActionListener(this);
		
		
	}

	public static void main(String[] args) {
		PdGUI f = new PdGUI();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if(e.getSource()==btAdd) {
				addData();
				clearTf();
			}else if(e.getSource()==btEdit) {
				editData();
				clearTf();
			}else if(e.getSource()==btDel) {
				deleteData();
				clearTf();
			}else if(e.getSource()==btSearch) {
				searchData();
				clearTf();
			}else if(e.getSource()==btShowAll) {
					showAll();
				clearTf();
			}else if(e.getSource()==btCancel) {
				clearTf();
			}//if
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	private void searchData() {
		// TODO Auto-generated method stub
		
	}

	private void deleteData() {
		// TODO Auto-generated method stub
		
	}

	private void editData() throws SQLException {
	     String no = tfNo.getText();
	     String pdName = tfPdName.getText();
	     String price = tfPrice.getText();

	     if(no == null || no.isEmpty()) {
	       JOptionPane.showMessageDialog(this, "수정하려는 번호를 확인하세요.");
	       tfNo.requestFocus();
	        return;
	      }else if (pdName == null || pdName.isEmpty()) {
	          JOptionPane.showMessageDialog(this, "수정할 상품명을 입력하세요.");
	          tfPdName.requestFocus();
	          return;
	      }else if (price == null || price.isEmpty()) {
	          JOptionPane.showMessageDialog(this, "수정할 가격을 입력하세요.");
	          tfPrice.requestFocus();
	          return;
	      }
	     
	     PdDTO dto = new PdDTO();
	     dto.setNo(Integer.parseInt(no));
	     dto.setPdName(pdName);
	     dto.setPrice(Integer.parseInt(price));
	      
	      int cnt = pdDao.updatePd(dto);
		
	      if (cnt > 0) {
	          JOptionPane.showMessageDialog(this, "상품 수정 성공");
	          clearTf();
	          ShowAll();
	       } else {
	          JOptionPane.showMessageDialog(this, "상품 수정 실패");
	          tfNo.requestFocus();
	       }      
	    }
	private void ShowAll() {
		// TODO Auto-generated method stub
		
	}

	private void addData() throws SQLException {
		//1. 사용자로 부터 입력받기 
		String pdName=tfPdName.getText();
		String price=tfPrice.getText();
		
		if(pdName==null || pdName.isEmpty()) {
			JOptionPane.showMessageDialog(this, "상품명을 입력해야 합니다.");			
			return;
		}else if(price==null || price.isEmpty()) {
			JOptionPane.showMessageDialog(this, "가격을 입력해야 합니다.");			
			return;
		}
		
		//2. db작업
		PdDTO dto = new PdDTO();
	      dto.setPdName(pdName);
	      dto.setPrice(Integer.parseInt(price));
	      
	      int cnt = pdDao.insertPd(dto);
		
		//3. 결과 처리(화면 출력)
		String result="";
		if(cnt>0) {
			result="상품 등록 성공";
		}else {
			result="상품 등록 실패";			
		}
		
		JOptionPane.showMessageDialog(this, result);
	}

	private void clearTf() {
		tfNo.setText("");
		tfPdName.setText("");
		tfPrice.setText("");
	}

}



