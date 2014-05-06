package oeztuerkzainzinger.cipher;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
/**
 * Diese Klasse erstellt das Hauptfenster mit den einzelnen Tabs 
 * und deren Komponenten.
 * 
 * @author Sefa �zt�rk
 *
 */

public class GUI extends JFrame implements ActionListener{
	//tab und panels
	JTabbedPane tab;
	JPanel keyword, shift;

	//Ab dieser Zeile beginnt die Komponentendeklarierung von KeywordCipher
	JPanel kwlaei,kwtext,kwhilf,kwende;
	JLabel kwlabel,kwalphabet,kwlabel2;
	JTextField kweingabe,kwgeheimalphabet,worteingabe, ausgabe;
	JButton kwalphaerstellen,kwdecrypt,kwencrypt;
	//Hier enden die Komponenten von KeywordCipher
	////////////////////////////////////////////////////
	//Ab hier sind dann wieder die neuen Fensterteile jetzt von ShiftCipher deklariert
	JPanel sclaei,sctext,schilf,scende;
	JLabel sclabel,scalphabet,sclabel2;
	JTextField sceingabe,scgeheimalphabet,worteingabe2, ausgabe2;
	JButton scalphaerstellen,scdecrypt,scencrypt;
	/////////////////////////////////////////

	public GUI(){
	}

	public GUI(String leer) {
		//Deklarierung der Hauptkomponenten
		tab=new JTabbedPane();
		keyword=new JPanel();
		shift=new JPanel();

		////////////////////////////////////////////////////////
		//Erste Zeile
		kwlabel=new JLabel("1.) Bitte ein Kennwort f�rs Geheimalphabet eingeben:");
		kweingabe=new JTextField(10);

		kwalphaerstellen=new JButton("Geheimalphabet generieren");
		kwalphaerstellen.addActionListener(this);
		//N�chste Zeile
		kwalphabet=new JLabel("Das aktuelle Geheimalphabet:");
		kwgeheimalphabet=new JTextField(30);
		kwgeheimalphabet.setEditable(false);
		//3.Zeile
		kwlabel2=new JLabel("2.) Wort zum Entschl�sseln oder Verschl�sseln eingeben:");
		worteingabe=new JTextField(20);
		worteingabe.setEditable(false);
		//4.Zeile
		kwencrypt=new JButton("Wort verschl�sseln!");
		kwdecrypt=new JButton("Wort entschl�sseln!");
		kwencrypt.addActionListener(this);
		kwdecrypt.addActionListener(this);
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
		/////////////////////////////////////////////////////
		/////////////////////////////////////////////////////
		//Erste Zeile
		sclabel=new JLabel("         1.) Bitte ein Verschiebewert f�rs Geheimalphabet eingeben:");
		sceingabe=new JTextField(10);

		scalphaerstellen=new JButton("Geheimalphabet erstellen");
		scalphaerstellen.addActionListener(this);
		//N�chste Zeile
		scalphabet=new JLabel("Das aktuelle Geheimalphabet:");
		scgeheimalphabet=new JTextField(30);
		scgeheimalphabet.setEditable(false);
		//3.Zeile
		sclabel2=new JLabel("2.) Wort zum Entschl�sseln oder Verschl�sseln eingeben:");
		worteingabe2=new JTextField(20);
		worteingabe2.setEditable(false);
		//4.Zeile
		scencrypt=new JButton("Wort verschl�sseln");
		scdecrypt=new JButton("Wort entschl�sseln");
		scencrypt.addActionListener(this);
		scdecrypt.addActionListener(this);
		//Ausgabe letzte Zeile
		ausgabe2=new JTextField(30);
		ausgabe2.setEditable(false);
		///////////////////////////////////////////////////////
		///////////////////////////////////////////////////////
		sclaei=new JPanel(new FlowLayout());
		sctext=new JPanel(new FlowLayout());
		schilf=new JPanel(new FlowLayout());
		scende=new JPanel(new FlowLayout());

		//Komponenten zum Hilfspanel hinzuf�gen
		sclaei.add(sclabel);
		sclaei.add(sceingabe);
		sclaei.add(scalphaerstellen);
		//Komponenten zum 2.Hilfspanel hinzuf�gen
		sctext.add(scalphabet);
		sctext.add(scgeheimalphabet);
		//Komponenten zum 3.Hilfspanel hinzuf�gen
		schilf.add(sclabel2);
		schilf.add(worteingabe2);
		//Komponenten zum 4.Hilfspanel hinzuf�gen
		scende.add(scencrypt);
		scende.add(scdecrypt);
		///////////////////////////////////////////////////////
		///////////////////////////////////////////////////////
		//Alle 4 Hilfspanel und die Ausgabe in das keywordtab zusammenf�gen
		shift.add(sclaei);
		shift.add(sctext);
		shift.add(schilf);
		shift.add(scende);
		shift.add(ausgabe2);


		//keyword-Panel dem Haupt-Tab adden
		tab.addTab("KeywordCipher",keyword);
		tab.addTab("ShiftCipher",shift);

		//Hauptfenster sichtbar machen und die 
		//einzelnen Tabs dem Fenster hinzuf�gen
		this.add(tab);
		this.setSize(660,400);
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		MonoAlphabeticCipher mac=new MonoAlphabeticCipher();
		KeywordCipher kc=new KeywordCipher();
		ShiftCipher sc=new ShiftCipher();
		///////////////////////////////////////////////////////
		if("Geheimalphabet generieren".equals(e.getActionCommand())){
			worteingabe.setEditable(true);
			kc.setKeyword(kweingabe.getText());
			kwgeheimalphabet.setText(kc.keywordAlphabet);
			try {
				mac.setSecretAlphabet(kc.keywordAlphabet);
			} catch (AnzahlZeichenException e1) {
				System.out.println("Anzahl der Buchstaben falsch");
			}
		}
		//////////////////////////////////////////////////////
		if("Wort verschl�sseln!".equals(e.getActionCommand())){
			kc.setKeyword(kweingabe.getText());
			try {
				//Zuerst Geheimalphabet setzten 
				mac.setSecretAlphabet(kc.keywordAlphabet);
				//Dann verschl�sseln
				ausgabe.setText(mac.encrypt(worteingabe.getText()));
				//Wenn was schief geht, dann halt Exception werfen
			} catch (FalscherParameterException e2) {
				System.out.println("Ung�ltiges Zeichen ins Parameter eingegeben");
			} catch (AnzahlZeichenException e1) {
				System.out.println("Anzahl der Buchstaben falsch");
			} 
		}
		////////////////////////////////////////////////////////
		if("Wort entschl�sseln!".equals(e.getActionCommand())){
			kc.setKeyword(kweingabe.getText());
			try {
				//Zuerst Geheimalphabet setzten 
				mac.setSecretAlphabet(kc.keywordAlphabet);
				//Dann verschl�sseln
				ausgabe.setText(mac.decrypt(worteingabe.getText()));
				//Wenn was schief geht, dann halt Exception werfen
			} catch (FalscherParameterException e2) {
				System.out.println("Ung�ltiges Zeichen ins Parameter eingegeben");
			} catch (AnzahlZeichenException e1) {
				System.out.println("Anzahl der Buchstaben falsch");
			} 
		}
		///////////////////////////////////////////////////////
		if("Geheimalphabet erstellen".equals(e.getActionCommand())){
			worteingabe2.setEditable(true);
			String hilf=sceingabe.getText();
			int wert=Integer.parseInt(hilf);
			sc.setShiftCipher(wert);
			scgeheimalphabet.setText(sc.shiftgeheim);
			try {
				mac.setSecretAlphabet(sc.shiftgeheim);
			} catch (AnzahlZeichenException e1) {
				System.out.println("Anzahl der Buchstaben falsch");
			}
		}
		//////////////////////////////////////////////////////
		if("Wort verschl�sseln".equals(e.getActionCommand())){
			String hilf=sceingabe.getText();
			int wert=Integer.parseInt(hilf);
			sc.setShiftCipher(wert);
			try {
				//Zuerst Geheimalphabet setzten 
				mac.setSecretAlphabet(sc.shiftgeheim);
				//Dann verschl�sseln
				ausgabe2.setText(mac.encrypt(worteingabe2.getText()));
				//Wenn was schief geht, dann halt Exception werfen
			} catch (FalscherParameterException e2) {
				System.out.println("Ung�ltiges Zeichen ins Parameter eingegeben");
			} catch (AnzahlZeichenException e1) {
				System.out.println("Anzahl der Buchstaben falsch");
			} 
		}
		////////////////////////////////////////////////////////
		if("Wort entschl�sseln".equals(e.getActionCommand())){
			String hilf=sceingabe.getText();
			int wert=Integer.parseInt(hilf);
			sc.setShiftCipher(wert);
			try {
				//Zuerst Geheimalphabet setzten 
				mac.setSecretAlphabet(sc.shiftgeheim);
				//Dann verschl�sseln
				ausgabe2.setText(mac.decrypt(worteingabe2.getText()));
				//Wenn was schief geht, dann halt Exception werfen
			} catch (FalscherParameterException e2) {
				System.out.println("Ung�ltiges Zeichen ins Parameter eingegeben");
			} catch (AnzahlZeichenException e1) {
				System.out.println("Anzahl der Buchstaben falsch");
			} 
		}
	}
}
