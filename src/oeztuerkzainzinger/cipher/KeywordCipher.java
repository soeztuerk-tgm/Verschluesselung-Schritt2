package oeztuerkzainzinger.cipher;
/**
 * Die Klasse KeywordChipher generiert ein Geheimalphabet
 * aus einem übergebenen Schlüsselwort bzw. Kennwort. Dazu 
 * muss beim Konstruktor und bei der Methode setKeyword()
 * ein gültiger Passwort angegeben werden. Das Geheimalphabet 
 * soll dann aus diesem Passwort generiert werden.
 * 
 * @author Sefa Öztürk
 *
 */
public class KeywordCipher extends MonoAlphabeticCipher {

	private String keyword;
	String keywordAlphabet = "";
	
	public KeywordCipher(){
	}
	
	public KeywordCipher(String keyword) throws FalscherParameterException {
		this.keyword = keyword;
		setKeyword(this.keyword);
	}

	public void setKeyword(String keyword) throws FalscherParameterException {
		String alpha = "abcdefghijklmnopqrstuvwxyzäüöß";

		char[] alphabet = alpha.toCharArray();
		char[] kennwort = keyword.toCharArray();

		char[] geheim = new char[30];
		int lengthK = kennwort.length;
		String restAlpha = "";

		// 1. Zuerst geheim in keyword speichern
		for (int i = 0; i < lengthK; i++) {
			geheim[i] = kennwort[i];
		}
		// 2. Die restlichen Buchstaben finden
		// Alle Buchstaben von Kennwort sollen im Alphabet als ein "."
		// markiert werden
		int zaehler=0;
		for (int j = 0; j < alphabet.length; j++) {
			for (int i = 0; i < lengthK; i++) {
				if (alphabet[j] == kennwort[i]) {
					alphabet[j] = '.';
					zaehler++;
				}
			}
			
			// Und jetzt noch das Restalphabet in die neue Variable
			// restAlpha zusammenfügen
			if (alphabet[j] != '.') {
				restAlpha = restAlpha + alphabet[j];
			}
		}
		
		if(zaehler==0){
			throw new FalscherParameterException();
		}
		// Jetzt das eigentliche Geheimalphabet mit restAlphabet
		// füllen
		for (int i = lengthK; i < geheim.length; i++) {
			geheim[i] = restAlpha.charAt(i - lengthK);
		}
		
		//Endgültige Ausgabe erstellen
		

		for (int i = 0; i < geheim.length; i++) {
			keywordAlphabet = keywordAlphabet + geheim[i];
		}
	}

}
