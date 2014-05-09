package oeztuerkzainzinger.gui;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import oeztuerkzainzinger.cipher.AnzahlZeichenException;
import oeztuerkzainzinger.cipher.FalscherParameterException;
import oeztuerkzainzinger.cipher.KeywordCipher;
import oeztuerkzainzinger.cipher.MonoAlphabeticCipher;
import oeztuerkzainzinger.cipher.ShiftCipher;
/**
 * Diese Klasse erstellt das Hauptfenster mit den einzelnen Tabs 
 * und deren Komponenten.
 * 
 * @author Sefa Öztürk
 *
 */

public class GUI extends JFrame implements ActionListener{
	//tab und panels
	JTabbedPane tab;
	JPanel keyword, shift, trans;

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
		kwlabel=new JLabel("1.) Bitte ein Kennwort fuers Geheimalphabet eingeben:");
		kweingabe=new JTextField(10);

		kwalphaerstellen=new JButton("Geheimalphabet generieren");
		kwalphaerstellen.addActionListener(this);
		//Nächste Zeile
		kwalphabet=new JLabel("Das aktuelle Geheimalphabet:");
		kwgeheimalphabet=new JTextField(30);
		kwgeheimalphabet.setEditable(false);
		//3.Zeile
		kwlabel2=new JLabel("2.) Wort zum Entschluesseln oder Verschlüsseln eingeben:");
		worteingabe=new JTextField(20);
		worteingabe.setEditable(false);
		//4.Zeile
		kwencrypt=new JButton("Wort verschluesseln!");
		kwdecrypt=new JButton("Wort entschluesseln!");
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
		/////////////////////////////////////////////////////
		/////////////////////////////////////////////////////
		//Erste Zeile
		sclabel=new JLabel("         1.) Bitte ein Verschiebewert fuers Geheimalphabet eingeben:");
		sceingabe=new JTextField(10);

		scalphaerstellen=new JButton("Geheimalphabet erstellen");
		scalphaerstellen.addActionListener(this);
		//Nächste Zeile
		scalphabet=new JLabel("Das aktuelle Geheimalphabet:");
		scgeheimalphabet=new JTextField(30);
		scgeheimalphabet.setEditable(false);
		//3.Zeile
		sclabel2=new JLabel("2.) Wort zum Entschluesseln oder Verschluesseln eingeben:");
		worteingabe2=new JTextField(20);
		worteingabe2.setEditable(false);
		//4.Zeile
		scencrypt=new JButton("Wort verschluesseln");
		scdecrypt=new JButton("Wort entschluesseln");
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

		//Komponenten zum Hilfspanel hinzufügen
		sclaei.add(sclabel);
		sclaei.add(sceingabe);
		sclaei.add(scalphaerstellen);
		//Komponenten zum 2.Hilfspanel hinzufügen
		sctext.add(scalphabet);
		sctext.add(scgeheimalphabet);
		//Komponenten zum 3.Hilfspanel hinzufügen
		schilf.add(sclabel2);
		schilf.add(worteingabe2);
		//Komponenten zum 4.Hilfspanel hinzufügen
		scende.add(scencrypt);
		scende.add(scdecrypt);
		///////////////////////////////////////////////////////
		///////////////////////////////////////////////////////
		//Alle 4 Hilfspanel und die Ausgabe in das keywordtab zusammenfügen
		shift.add(sclaei);
		shift.add(sctext);
		shift.add(schilf);
		shift.add(scende);
		shift.add(ausgabe2);


		//keyword-Panel dem Haupt-Tab adden
		tab.addTab("KeywordCipher",keyword);
		tab.addTab("ShiftCipher",shift);
		tab.addTab("TranspositionCipher",trans);

		//Hauptfenster sichtbar machen und die 
		//einzelnen Tabs dem Fenster hinzufügen
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
			try {
				kc.setKeyword(kweingabe.getText());
			} catch (FalscherParameterException e2) {
				System.out.println("Falscher Parameter");
			}
			kwgeheimalphabet.setText(kc.keywordAlphabet);
			try {
				mac.setSecretAlphabet(kc.keywordAlphabet);
			} catch (AnzahlZeichenException e1) {
				System.out.println("Anzahl der Buchstaben ist falsch");
			}
		}
		//////////////////////////////////////////////////////
		if("Wort verschlüsseln!".equals(e.getActionCommand())){
			try {
				kc.setKeyword(kweingabe.getText());
			} catch (FalscherParameterException e3) {
				System.out.println("Falsches Parameter");
			}
			try {
				//Zuerst Geheimalphabet setzten 
				mac.setSecretAlphabet(kc.keywordAlphabet);
				//Dann verschlüsseln
				ausgabe.setText(mac.encrypt(worteingabe.getText()));
				//Wenn was schief geht, dann halt Exception werfen
			} catch (FalscherParameterException e2) {
				System.out.println("Ungueltiges Zeichen ins Parameter eingegeben");
			} catch (AnzahlZeichenException e1) {
				System.out.println("Anzahl der Buchstaben falsch");
			} 
		}
		////////////////////////////////////////////////////////
		if("Wort entschlüsseln!".equals(e.getActionCommand())){
			try {
				kc.setKeyword(kweingabe.getText());
			} catch (FalscherParameterException e3) {
				System.out.println("Falsches Parameter");
			}
			try {
				//Zuerst Geheimalphabet setzten 
				mac.setSecretAlphabet(kc.keywordAlphabet);
				//Dann verschlüsseln
				ausgabe.setText(mac.decrypt(worteingabe.getText()));
				//Wenn was schief geht, dann halt Exception werfen
			} catch (FalscherParameterException e2) {
				System.out.println("Ungueltiges Zeichen ins Parameter eingegeben");
			} catch (AnzahlZeichenException e1) {
				System.out.println("Anzahl der Buchstaben falsch");
			} 
		}
		///////////////////////////////////////////////////////
		if("Geheimalphabet erstellen".equals(e.getActionCommand())){
			worteingabe2.setEditable(true);
			String hilf=sceingabe.getText();
			int wert;
			try {
				wert=Integer.parseInt(hilf);
				sc.setShiftCipher(wert);
			} catch (FalscherParameterException e2) {
				System.out.println("Falsches Parameter");
			} catch (NumberFormatException nfe){
				
			}
			scgeheimalphabet.setText(sc.shiftgeheim);
			try {
				mac.setSecretAlphabet(sc.shiftgeheim);
			} catch (AnzahlZeichenException e1) {
				System.out.println("Anzahl der Buchstaben ist falsch");
			}
		}
		//////////////////////////////////////////////////////
		if("Wort verschlüsseln".equals(e.getActionCommand())){
			String hilf=sceingabe.getText();
			int wert=Integer.parseInt(hilf);
			try {
				sc.setShiftCipher(wert);
			} catch (FalscherParameterException e3) {
				System.out.println("Falsches Parameter");
			}

			try {
				//Zuerst Geheimalphabet setzten 
				mac.setSecretAlphabet(sc.shiftgeheim);
				//Dann verschlüsseln
				ausgabe2.setText(mac.encrypt(worteingabe2.getText()));
				//Wenn was schief geht, dann halt Exception werfen
			} catch (FalscherParameterException e2) {
				System.out.println("Ungueltiges Zeichen ins Parameter eingegeben");
			} catch (AnzahlZeichenException e1) {
				System.out.println("Anzahl der Buchstaben falsch");
			} 
		}
		////////////////////////////////////////////////////////
		if("Wort entschlüsseln".equals(e.getActionCommand())){
			String hilf=sceingabe.getText();
			int wert=Integer.parseInt(hilf);
			try {
				sc.setShiftCipher(wert);
			} catch (FalscherParameterException e3) {
				System.out.println("Falsches Parameter");
			}
			try {
				//Zuerst Geheimalphabet setzten 
				mac.setSecretAlphabet(sc.shiftgeheim);
				//Dann verschlüsseln
				ausgabe2.setText(mac.decrypt(worteingabe2.getText()));
				//Wenn was schief geht, dann halt Exception werfen
			} catch (FalscherParameterException e2) {
				System.out.println("Ungueltiges Zeichen ins Parameter eingegeben");
			} catch (AnzahlZeichenException e1) {
				System.out.println("Anzahl der Buchstaben falsch");
			} 
		}
	}
}
