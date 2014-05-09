package oeztuerkzainzinger.cipher;

/**
 * Die Klasse MonoAlphabeticCipher stellt die Basisfunktionalit�ten auf Basis
 * des Interfaces Cipher zur Verf�gung und setzt das Geheimalphabet immer auf
 * das Ausgangsalphabet
 * 
 * @author Sefa �zt�rk, Lukas Zainzinger
 * @date 06.04.2014
 */
public class MonoAlphabeticCipher implements Cipher {

	// Das Attribut alphabet ist das Standardalphabet
	private String alphabet;
	private String secretAlphabet;
	// Privates Attribut secretAlphabet ist zun�chst das Ausgangsalphabet, das sp�ter
	//mit der Methode setSecretAlphabet mit einem ander Alphabet ersetzt werden kann
	/**
	 * Das ist der Default-Konstruktor
	 */
	public MonoAlphabeticCipher() {
		alphabet = "abcdefghijklmnopqrstuvwxyz����";
		secretAlphabet = "abcdefghijklmnopqrstuvwxyz����";
	}

	/**
	 * Die Methode getSecretAlphabet gibt das verschl�sselte Alphabet zur�ck.
	 * 
	 * @return secretAlphabet
	 */
	public String getSecretAlphabet() {
		return secretAlphabet;
	}

	/**
	 * Die Methode setSecretAlphabet ersetzt neu erhaltene Alphabet.
	 * 
	 * @param secretAlphabet
	 * @throws AnzahlZeichenException
	 */
	public void setSecretAlphabet(String secretAlphabet)throws AnzahlZeichenException {
		//Die if-Anweisung �berpr�ft, ob die L�nge des Geheima. 
		//genau 30 Buchstaben enth�lt
		if (secretAlphabet.length() == 30) {
			this.secretAlphabet = secretAlphabet;
		} else {
			throw new AnzahlZeichenException();
		}
	}
	/**
	 * encrypt ist eine Methode zum verschl�sseln von W�rtern
	 * 
	 * @param text 
	 * @throws FalscherParameterException
	 */
	@Override
	public String encrypt(String text) throws FalscherParameterException {
		//verschl�sselt=ausgabewort
		String verschluesselt = "";
		//die matches methode vergleicht ein String mit einem Regul�ren Ausdruck
		//und gibt true oder false zur�ck.
		
		//RegAu: Wenn der Parameter text, Zeichen au�erhalb des STANDARDALPHABETS enth�lt,
		//dann soll true zur�ckggegeben werden, also das soll hei�en das dieses Wort ein
		//falsches Zeichen enth�lt und daher eine Exception geworfen wird, andersfalls 
		//kann das Wort entschl�sselt werden.
		boolean a = text.matches(".*[^" + alphabet + "].*");

		if (a == true) {
			throw new FalscherParameterException();
		} else {
			for (int i = 0; i < text.length(); i++) {
				for (int j = 0; j < alphabet.length(); j++) {
					if (alphabet.charAt(j) == (text.charAt(i))) {
						verschluesselt += secretAlphabet.charAt(j);
					}
				}
			}
		}
		//Das verschl�sselte Wort zur�ckgeben
		return verschluesselt;
	}
	/**
	 * decrypt ist eine Methode zum entschl�sseln von W�rtern
	 * 
	 * @param text 
	 * @throws FalscherParameterException
	 */
	@Override
	public String decrypt(String text) throws FalscherParameterException {
		
		String entschluesselt = "";
		//hier gilt dasselbe nur  umgekehrt mit dem GEHEIMALPHABET
		boolean a = text.matches(".*[^" + secretAlphabet + "].*");
		if (a == true) {
			throw new FalscherParameterException();
		} else {
			for (int i = 0; i < text.length(); i++) {
				for (int j = 0; j < secretAlphabet.length(); j++) {
					if (secretAlphabet.charAt(j) == text.charAt(i)) {
						entschluesselt += alphabet.charAt(j);
					}
				}
			}
		}
		//Das entschl�sselte Wort zur�ckgeben
		return entschluesselt;
	}
}
