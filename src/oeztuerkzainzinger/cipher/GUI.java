package oeztuerkzainzinger.cipher;

import java.awt.event.*;

import javax.swing.*;

public class GUI extends JFrame{
	JTabbedPane tab;
	JPanel keyword, shift;
	
	JLabel kwlabel,kwalphabet,kwlabel2,ausgabe;
	JTextField kweingabe,worteingabe;
	JButton kwalphaerstellen,kwdecrypt,kwencrypt;
	
	public GUI() {
		//Deklarierung der Hauptkomponenten
		tab=new JTabbedPane();
		keyword=new JPanel();
		shift=new JPanel();
		tab.addTab("KeywordCipher",keyword);
		tab.addTab("ShiftCipher",shift);
		
		//Erste Zeile
		kwlabel=new JLabel("Hier bitte das Kennwort f�rs Geheimalphabet eingeben:");
		kweingabe=new JTextField();
		kwalphaerstellen=new JButton("Geheimalphabet erstellen");
		//N�chste Zeile
		kwalphabet=new JLabel("Geheimalphabet:");
		//3.Zeile
		kwlabel2=new JLabel("Wort zum Entschl�sseln oder Verschl�sseln eingeben:");
		worteingabe=new JTextField();
		//4.Zeile
		kwencrypt=new JButton("Wort verschl�sseln!");
		kwdecrypt=new JButton("Wort entschl�sseln!");
		//Ausgabe letzte Zeile
		ausgabe=new JLabel("");
		
		
		
		
		this.add(tab);
		this.setSize(600,400);
		this.setVisible(true);
	}
}
