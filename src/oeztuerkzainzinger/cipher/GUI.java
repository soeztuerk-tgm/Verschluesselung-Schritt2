package oeztuerkzainzinger.cipher;


import java.awt.*;

import javax.swing.*;
/**
 * Diese Klasse erstellt das Hauptfenster mit den einzelnen Tabs 
 * und deren Komponenten.
 * 
 * @author Sefa Öztürk
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
		kwlabel=new JLabel("1.) Bitte ein Kennwort fürs Geheimalphabet eingeben:");
		kweingabe=new JTextField(10);
		kwalphaerstellen=new JButton("Geheimalphabet erstellen");
		//Nächste Zeile
		kwalphabet=new JLabel("Das aktuelle Geheimalphabet:");
		kwgeheimalphabet=new JTextField(30);
		kwgeheimalphabet.setEditable(false);
		//3.Zeile
		kwlabel2=new JLabel("2.) Wort zum Entschlüsseln oder Verschlüsseln eingeben:");
		worteingabe=new JTextField(20);
		//4.Zeile
		kwencrypt=new JButton("Wort verschlüsseln!");
		kwdecrypt=new JButton("Wort entschlüsseln!");
		//Ausgabe letzte Zeile
		ausgabe=new JTextField(30);
		ausgabe.setEditable(false);
		///////////////////////////////////////////////////////
		///////////////////////////////////////////////////////
		kwlaei=new JPanel(new FlowLayout());
		kwtext=new JPanel(new FlowLayout());
		kwhilf=new JPanel(new FlowLayout());
		kwende=new JPanel(new FlowLayout());
		
		//Komponenten zum Hilfspanel hinzufügen
		kwlaei.add(kwlabel);
		kwlaei.add(kweingabe);
		kwlaei.add(kwalphaerstellen);
		//Komponenten zum 2.Hilfspanel hinzufügen
		kwtext.add(kwalphabet);
		kwtext.add(kwgeheimalphabet);
		//Komponenten zum 3.Hilfspanel hinzufügen
		kwhilf.add(kwlabel2);
		kwhilf.add(worteingabe);
		//Komponenten zum 4.Hilfspanel hinzufügen
		kwende.add(kwencrypt);
		kwende.add(kwdecrypt);
		///////////////////////////////////////////////////////
		///////////////////////////////////////////////////////
		//Alle 4 Hilfspanel und die Ausgabe in das keywordtab zusammenfügen
		keyword.add(kwlaei);
		keyword.add(kwtext);
		keyword.add(kwhilf);
		keyword.add(kwende);
		keyword.add(ausgabe);
		
		//Hauptfenster sichtbar machen und die 
		//einzelnen Tabs dem Fenster hinzufügen
		this.add(tab);
		this.setSize(640,400);
		this.setVisible(true);
	}
}
