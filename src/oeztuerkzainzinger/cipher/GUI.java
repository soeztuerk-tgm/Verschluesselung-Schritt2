package oeztuerkzainzinger.cipher;


import java.awt.*;

import javax.swing.*;
/**
 * Diese Klasse erstellt das Hauptfenster mit den einzelnen Tabs 
 * und deren Komponenten.
 * 
 * @author Sefa �zt�rk
 *
 */

public class GUI extends JFrame{
	//tab und panels
	JTabbedPane tab;
	JPanel keyword, shift;
	
	JPanel kwlaei,kwtext,kwhilf,kwende;
	
	JLabel kwlabel,kwalphabet,kwlabel2;
	JTextField kweingabe,kwgeheimalphabet,worteingabe, ausgabe;
	JButton kwalphaerstellen,kwdecrypt,kwencrypt;
	
	public GUI() {
		//Deklarierung der Hauptkomponenten
		tab=new JTabbedPane();
		keyword=new JPanel();
		shift=new JPanel();
		tab.addTab("KeywordCipher",keyword);
		tab.addTab("ShiftCipher",shift);
		
		////////////////////////////////////////////////////////
		//Erste Zeile
		kwlabel=new JLabel("1.) Bitte ein Kennwort f�rs Geheimalphabet eingeben:");
		kweingabe=new JTextField(10);
		kwalphaerstellen=new JButton("Geheimalphabet erstellen");
		//N�chste Zeile
		kwalphabet=new JLabel("Das aktuelle Geheimalphabet:");
		kwgeheimalphabet=new JTextField(30);
		kwgeheimalphabet.setEditable(false);
		//3.Zeile
		kwlabel2=new JLabel("2.) Wort zum Entschl�sseln oder Verschl�sseln eingeben:");
		worteingabe=new JTextField(20);
		//4.Zeile
		kwencrypt=new JButton("Wort verschl�sseln!");
		kwdecrypt=new JButton("Wort entschl�sseln!");
		//Ausgabe letzte Zeile
		ausgabe=new JTextField(30);
		ausgabe.setEditable(false);
		///////////////////////////////////////////////////////
		///////////////////////////////////////////////////////
		kwlaei=new JPanel(new FlowLayout());
		kwtext=new JPanel(new FlowLayout());
		kwhilf=new JPanel(new FlowLayout());
		kwende=new JPanel(new FlowLayout());
		
		//Komponenten zum Hilfspanel hinzuf�gen
		kwlaei.add(kwlabel);
		kwlaei.add(kweingabe);
		kwlaei.add(kwalphaerstellen);
		//Komponenten zum 2.Hilfspanel hinzuf�gen
		kwtext.add(kwalphabet);
		kwtext.add(kwgeheimalphabet);
		//Komponenten zum 3.Hilfspanel hinzuf�gen
		kwhilf.add(kwlabel2);
		kwhilf.add(worteingabe);
		//Komponenten zum 4.Hilfspanel hinzuf�gen
		kwende.add(kwencrypt);
		kwende.add(kwdecrypt);
		///////////////////////////////////////////////////////
		///////////////////////////////////////////////////////
		//Alle 4 Hilfspanel und die Ausgabe in das keywordtab zusammenf�gen
		keyword.add(kwlaei);
		keyword.add(kwtext);
		keyword.add(kwhilf);
		keyword.add(kwende);
		keyword.add(ausgabe);
		
		//Hauptfenster sichtbar machen und die 
		//einzelnen Tabs dem Fenster hinzuf�gen
		this.add(tab);
		this.setSize(640,400);
		this.setVisible(true);
	}
}
