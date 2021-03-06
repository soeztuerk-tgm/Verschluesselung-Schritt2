package oeztuerkzainzinger.cipher;
/**
 * Die Klasse KeywordChipher generiert ein Geheimalphabet
 * aus einem �bergebenen Schl�sselwort bzw. Kennwort. Dazu 
 * muss beim Konstruktor und bei der Methode setKeyword()
 * ein g�ltiger Passwort angegeben werden. Das Geheimalphabet 
 * soll dann aus diesem Passwort generiert werden.
 * 
 * @author Sefa �zt�rk
 *
 */
public class KeywordCipher extends MonoAlphabeticCipher {

	private String keyword;
	public String keywordAlphabet = "";
	
	public KeywordCipher(){
	}
	
	public KeywordCipher(String keyword) throws FalscherParameterException {
		this.keyword = keyword;
		setKeyword(this.keyword);
	}
	/**
	 * Die Methode setKeyword besitzt einen parameter keyword mit dem dann das
	 * geheime Alphabet mittels dem KeywordCipher-Verfahren generiert werden soll
	 * 
	 * @param keyword
	 * @throws FalscherParameterException
	 */
	public void setKeyword(String keyword) throws FalscherParameterException {
		String alpha = "abcdefghijklmnopqrstuvwxyz����";

		char[] alphabet = alpha.toCharArray();
		char[] kennwort = keyword.toCharArray();

		char[] geheim = new char[30];
		int lengthK = kennwort.length;
		String restAlpha = "";

		// 1. Zuerst geheim in keyword speichern.
		for (int i = 0; i < lengthK; i++) {
			geheim[i] = kennwort[i];
		}
		// 2. Die restlichen Buchstaben finden
		// Alle Buchstaben von Kennwort sollen im Alphabet als ein "."
		// markiert werden
		for (int j = 0; j < alphabet.length; j++) {
			for (int i = 0; i < lengthK; i++) {
				if (alphabet[j] == kennwort[i]) {
					alphabet[j] = '.';
				}
			}
			
			// Und jetzt noch das Restalphabet in die neue Variable
			// restAlpha zusammenf�gen
			if (alphabet[j] != '.') {
				restAlpha = restAlpha + alphabet[j];
			}
		}
		// Jetzt das eigentliche Geheimalphabet mit restAlphabet
		// f�llen
		for (int i = lengthK; i < geheim.length; i++) {
			geheim[i] = restAlpha.charAt(i - lengthK);
		}
		
		//Endg�ltige Ausgabe erstellen
		

		for (int i = 0; i < geheim.length; i++) {
			keywordAlphabet = keywordAlphabet + geheim[i];
		}
	}

}
