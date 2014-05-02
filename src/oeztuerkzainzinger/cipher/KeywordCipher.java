package oeztuerkzainzinger.cipher;
public class KeywordCipher {

	private String keyword;

	public KeywordCipher(String keyword) {
		this.keyword = keyword;

		setKeyword(this.keyword);
	}

	public void setKeyword(String keyword) {

		String alpha = "abcdefghijklmnopqrstuvwxyz";

		char[] alphabet = alpha.toCharArray();
		char[] kennwort = keyword.toCharArray();

		char[] geheim = new char[26];
		int lengthK = kennwort.length;
		String restAlpha = "";

		// 1. Zuerst geheim in keyword speichern
		for (int i = 0; i < lengthK; i++) {
			geheim[i] = kennwort[i];
		}
		// 2. Die restlichen Buchstaben finden
		// Alle Buchstaben von Kennwort sollen im Alphabet als .
		// markiert werden
		for (int j = 0; j < alphabet.length; j++) {
			for (int i = 0; i < lengthK; i++) {
				if (alphabet[j] == kennwort[i]) {
					alphabet[j] = '.';
				}
			}
		// Und jetzt noch das Restalphabet in die neue Variable
		// restAlpha zusammenfügen
			if (alphabet[j] != '.') {
				restAlpha = restAlpha + alphabet[j];
			}

		}

	}

}
