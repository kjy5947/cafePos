package main_component;
import java.awt.BorderLayout;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import handler.CashActionHandler;
import handler.ChangeActionListener;
import handler.ChangeMenuDownActionListener;
import handler.ChangeMenuUpActionListener;
import handler.MemberShipActionListener;
import handler.MenuButtonActionListener;
import main_component.BasicButton;
import main_component.ButtonSetting;
import main_component.MainBtns;
import main_component.OrderButton;


public class MenuPanel extends JPanel {
	String sort;
	CardLayout card;
	int count;
	
	public MenuPanel(String sort, RightPanelBasic rpb, ActionListener al) {
		this.sort = sort;
		card = new CardLayout();
		JPanel rightCenter = rpb.getRightLCenter();
		JPanel rightR = rpb.getRightR();
		ButtonSetting up = new ButtonSetting("△", 25 ,0xb0e8f7, null);
		ButtonSetting down  = new ButtonSetting("▽", 25 ,0xb0e8f7, null);
			
		rightCenter.setLayout(card);
		
		GridLayout gl2 = new GridLayout(3, 4);
		
		gl2.setVgap(40);
		gl2.setHgap(40);
		
		JPanel panel1 = new JPanel(gl2);
		JPanel panel2 = new JPanel(gl2);
		JPanel panel3 = new JPanel(gl2);
		
		rightR.removeAll();
		rightCenter.removeAll();
		
		for(int i = 0; i < 36; i++) {
			++count;
			if(i > 23) {
				panel3.add(new ButtonSetting(sort+count, 15, 0xfafeff, al));
			} else if (i > 11) {
				panel2.add(new ButtonSetting(sort+count, 15, 0xfafeff, al));
			} else {
				panel1.add(new ButtonSetting(sort+count, 15, 0xfafeff, al));
			}
		}
		
		up.addActionListener(new ChangeMenuUpActionListener(rightCenter));
		down.addActionListener(new ChangeMenuDownActionListener(rightCenter));
		
		rightR.add(up);
		rightR.add(down);
		
		rightCenter.add(panel1);
		rightCenter.add(panel2);
		rightCenter.add(panel3);
				
	}

}
