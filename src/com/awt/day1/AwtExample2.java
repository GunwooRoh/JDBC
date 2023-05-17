package com.awt.day1;

import java.awt.CheckboxMenuItem;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;

public class AwtExample2 {

	public static void main(String[] args) {
		Frame f = new Frame("메뉴");
		f.setSize(300, 200);
		
		MenuBar mb = new MenuBar();
		Menu mFile = new Menu("보기");
		
		Menu miTools = new Menu("도구모음/창");
		MenuItem miTab = new MenuItem("탭과 공백기호");
		MenuItem miLnbrk = new MenuItem("줄바꿈 기호");
		MenuItem miEmph = new MenuItem("구문강조");
		
		mFile.add(miTools);
		mFile.addSeparator();
		mFile.add(miTab);
		mFile.add(miLnbrk);
		mFile.add(miEmph);
		
		MenuItem miUser = new MenuItem("사용자 도구모음");
		MenuItem miHtml = new MenuItem("HTML 도구모음");
		
		miTools.add(miUser);
		miTools.add(miHtml);
		
		Menu mSearch = new Menu("검색");
		Menu mRepo = new Menu("문서");
		Menu mProject = new Menu("프로젝트");
		Menu mHelp = new Menu("도움말");

		
		mb.add(mFile);
		mb.add(mSearch);
		mb.add(mRepo);
		mb.add(mProject);
		mb.setHelpMenu(mHelp);
		
		f.setMenuBar(mb);
		f.setVisible(true);

	}

}
