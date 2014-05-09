package oeztuerkzainzinger.test;

import static org.junit.Assert.*;
import oeztuerkzainzinger.cipher.AnzahlZeichenException;
import oeztuerkzainzinger.cipher.FalscherParameterException;
import oeztuerkzainzinger.cipher.KeywordCipher;
import oeztuerkzainzinger.cipher.MonoAlphabeticCipher;
import oeztuerkzainzinger.cipher.ShiftCipher;
import oeztuerkzainzinger.cipher.SubstitutionCipher;
import oeztuerkzainzinger.gui.GUI;

import org.junit.Test;

public class JunitTest {
	//Attribut hallo ist das Parameter zum ent- bzw. verschlüsseln
	String text="hallo";
	//Hier zum Test ein Geheimalphabet
	String secretAlphabet="xyzabcdefghijklmnopqrstuvwäüöß";
	//Neues Objekt aus der Klasse MAC
	MonoAlphabeticCipher mac=new MonoAlphabeticCipher();
	SubstitutionCipher sub;

	@Test
	public void testSetSecretAlphabet() {
		try {
			//Versuch, ob die Anzahl an Buchstaben im Geheimalphabet richtig ist
			mac.setSecretAlphabet(secretAlphabet);
			//Wenn was schief geht, dann halt Exception werfen
		} catch (AnzahlZeichenException e) {
			System.out.println("Anzahl Buchstaben im Geheimalphabet falsch");
		}
	}
	@Test
	public void testSubstitutionCipher() throws AnzahlZeichenException {
		sub=new SubstitutionCipher(secretAlphabet);
		try {
			//Versuch, ob die Anzahl an Buchstaben im Geheimalphabet richtig ist
			sub.setSecretAlphabet(secretAlphabet);
			//Wenn was schief geht, dann halt Exception werfen
		} catch (AnzahlZeichenException e) {
			System.out.println("Anzahl Buchstaben im Geheimalphabet falsch");
		}
	}
	@Test
	public void testEncrypt() throws AnzahlZeichenException{
		try {
			//Zuerst Geheimalphabet setzten 
			mac.setSecretAlphabet(secretAlphabet);
			//Dann verschlüsseln
			System.out.println(mac.encrypt(text));
			//Wenn was schief geht, dann halt Exception werfen
		} catch (FalscherParameterException e) {
			System.out.println("Ungültiges Wort ins Parameter eingegeben");
		} 
	}

	@Test
	public void testDecrypt() throws AnzahlZeichenException{
		try {
			//Wieder zuerst Geheimalphabet eingeben
			mac.setSecretAlphabet(secretAlphabet);
			//Dann entschlüsseln
			System.out.println(mac.decrypt(text));
			//Wenn was schief geht, dann Exception werfen
		} catch (FalscherParameterException e) {
			System.out.println("Ungültiges Wort ins Parameter eingegeben");
		} 
	}

	@Test
	public void testgetSecretAlphabet() throws AnzahlZeichenException{
		mac.setSecretAlphabet(secretAlphabet);
		System.out.println("GetSecretAlphabet:"+mac.getSecretAlphabet());
	}
	
	@Test
	public void testKeyWordCipher() {
		try {
			KeywordCipher kc2=new KeywordCipher();
			KeywordCipher kc=new KeywordCipher("sefa");
		} catch (FalscherParameterException e) {
			System.out.println("Falsches Parameter");
		}
	}
	@Test
	public void testShiftCipher() {
		try {
			ShiftCipher sc2=new ShiftCipher();
			ShiftCipher sc=new ShiftCipher(2);
		} catch (FalscherParameterException e) {
			System.out.println("Falsches Parameter");
		}
	}
	@Test
	public void testGUI(){
		new GUI();
		new GUI("");
	}
	@Test
	public void Exception(){
		new AnzahlZeichenException();
		new AnzahlZeichenException("Falsch");
		new FalscherParameterException();
		new FalscherParameterException("Falsch Parameter");
	}
}
