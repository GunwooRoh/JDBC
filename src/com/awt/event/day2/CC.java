package com.awt.event.day2;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

public class CC extends Frame implements WindowListener, ActionListener {
    private TextArea ta;
    private TextField tf1, tf2;
    private Label lb1, lb2, lb3;
    private Button bt1, bt2, bt3, bt4, bt5;
    private Panel pl1, pl2, pl3, pl4;

    public CC() {
        super("레이아웃 테스트");
        init();
        addEvent();
        setSize(600, 400);
        setVisible(true);
    }

    private void init() {
    	setLayout(new BorderLayout());
        pl1 = new Panel();
        lb1 = new Label("아이디", Label.RIGHT);
        tf1 = new TextField(10);

        lb2 = new Label("비밀번호", Label.RIGHT);
        tf2 = new TextField(10);
        tf2.setEchoChar('*');

        bt1 = new Button("로그인");
        bt2 = new Button("취소");
        
        
        pl4 = new Panel();
        pl4.add(bt1);
        pl4.add(bt2);
        
        
        pl1.add(lb1);
        pl1.add(tf1);
        pl1.add(lb2);
        pl1.add(tf2);
        pl1.add(pl4);
        
        pl2 = new Panel();
        lb3 = new Label("글보기", Label.LEFT);
        ta = new TextArea();
        ta.setEditable(false);

        pl2.add(lb3);
        pl2.add(ta);

        
        pl3 = new Panel();
        bt3 = new Button("수정");
        bt4 = new Button("삭제");
        bt5 = new Button("종료");

        pl3.add(bt3);
        pl3.add(bt4);
        pl3.add(bt5);
        
        pl2.add(lb3, "North");
        pl2.add(ta, "Center");
        pl2.add(pl3, "South");
        

        
		this.setLayout(new GridLayout(1, 2));
		this.addWindowListener(new EventHandler());
        
        this.add(pl1);
        this.add(pl2);
 
    }
    
	class EventHandler extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			System.out.println("종료");
			System.exit(0);
		}
	}
    private void addEvent() {
        bt1.addActionListener(this);
    }

    @Override
    public void windowOpened(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void windowClosing(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void windowClosed(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void windowIconified(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void windowActivated(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == bt1) {
			String id = tf1.getText();
			String pw = tf2.getText();
			if(!id.equals("hong")) {
				JOptionPane.showMessageDialog(this, "아이디가 없습니다");
				tf1.requestFocus();
				tf1.selectAll();
			} else if(!pw.equals("1234")) {
				JOptionPane.showMessageDialog(this, "비밀번호가 틀렸습니다");
				tf1.requestFocus();
				tf1.selectAll();
			} else {
				JOptionPane.showMessageDialog(this, "아이디: " + id + "으로 로그인 되었습니다.");
			}
	}
}

	public static void main(String[] args) {
	    CC l = new CC();
	}
}
