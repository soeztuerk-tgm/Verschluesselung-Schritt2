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
		
	}

}
