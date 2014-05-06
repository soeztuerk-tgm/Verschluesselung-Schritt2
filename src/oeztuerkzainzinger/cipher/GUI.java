package oeztuerkzainzinger.cipher;

import java.awt.event.*;

import javax.swing.*;

public class GUI extends JFrame{
	JTabbedPane tab;
	JPanel keyword, shift;
	public GUI() {
		tab=new JTabbedPane();
		keyword=new JPanel();
		shift=new JPanel();
		
		tab.addTab("KeywordCipher",keyword);
		tab.addTab("ShiftCipher",shift);
		
		
		
		
		
		this.add(tab);
		this.setSize(600,400);
		this.setVisible(true);
	}
}
