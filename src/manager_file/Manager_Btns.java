package manager_file;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;

// 관리자메뉴 버튼 5개 설정
public class Manager_Btns {

	private ArrayList<JButton> btns;
	
	public Manager_Btns(JFrame frame) {
		btns = new ArrayList<>();
		
		// 버튼 폰트, 배경색 설정
		for(int i = 0; i < 5; i++) {
			JButton jb = new JButton();
			jb.setFont(new Font("default", Font.BOLD, 16));
			jb.setBackground(new Color(0xD7E7F7));
			btns.add(jb);
		}
				
		// 버튼 이름 설정
		btns.get(0).setText("매출 현황");
		btns.get(1).setText("마감 용지 출력");
		btns.get(2).setText("직원 등록");
		btns.get(3).setText("출퇴근 기록 열람");
		btns.get(4).setText("메뉴 관리");
		
		// get(1) : 마감용지출력, get(2) : 직원등록
		btns.get(1).addActionListener(new ClosingBtn());
		btns.get(2).addActionListener(new EmpBtn());
		
		btns.get(0).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ManagerSales ms = new ManagerSales();
				ms.setDefaultOptions();
				frame.dispose();
			}
		});
		
		btns.get(3).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ManagerPage mp = new ManagerPage();
				mp.setDefaultOptions();
				frame.dispose();
			}
		});
		btns.get(4).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ManagerMenu mm = new ManagerMenu();
				mm.setDefaultOptions();
				frame.dispose();
			}
		});

	}
	
	public ArrayList<JButton> getJBtns() {
		return btns;	
	}
}