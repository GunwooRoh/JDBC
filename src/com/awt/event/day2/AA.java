package com.awt.event.day2;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;

public class AA extends Frame {
		Frame f = new Frame("Menu 실습");
		MenuBar mb = new MenuBar();
		Menu mFile = new Menu();
		
		
		Menu mSearch = new Menu("검색");
		Menu mTool = new Menu("도구");
		Menu mWindow = new Menu("창");
		Menu mHelp = new Menu("도움말");
		
		
		public AA() {
		super("Menu 실습");
		this.setLayout(new BorderLayout());

		f.setSize(300, 200);
		f.setLayout(new FlowLayout());
		
		
		
		mb.add(mSearch);
		mb.add(mTool);
		mb.add(mWindow);
		mb.setHelpMenu(mHelp);
		
		MenuItem miSearch = new MenuItem("찾기");
		MenuItem miChange = new MenuItem("바꾸기");
		
		Menu miTag = new Menu("표식");
		
		mSearch.add(miSearch);
		mSearch.add(miChange);
		mSearch.addSeparator();
		mSearch.add(miTag);
		
		MenuItem miOnOff = new MenuItem("표식설정/해제");
		MenuItem miNext = new MenuItem("다음표식으로");
		
		miTag.add(miOnOff);
		miTag.add(miNext);
		
		f.setMenuBar(mb);
		f.setVisible(true);
	}
	
		public static void main(String[] args) {
			AA a = new AA();
	}
}