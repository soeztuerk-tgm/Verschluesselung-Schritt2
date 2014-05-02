package oeztuerkzainzinger.cipher;
public class ShiftCipher {
	//Verschiebeanzahl
	private int wert;

	public ShiftCipher(int value) {
		this.wert = value;

		setShiftCipher(this.wert);
	}

	public void setShiftCipher(int wert) {
		//Standardalphabet
		String alpha = "abcdefghijklmnopqrstuvwxyz";
		//Alphabet nach char casten
		char[] alphabet = alpha.toCharArray();
		char[] geheim = new char[26];
		//Hilfvariable für die nächsten Schritte
		int hilf = 0;
		char[] verschiebe = new char[wert];
		for (int i = 0; i < geheim.length; i++) {
			if (i >= wert) {
				geheim[hilf] = alphabet[i];
				hilf++;
			} else {
				verschiebe[i] = alphabet[i];
			}
		}

		int zaehler = 0;
		for (int i = hilf; i < geheim.length; i++) {
			geheim[i] = verschiebe[zaehler];
			zaehler++;
		}

		String ausgabe = "";
		for (int i = 0; i < geheim.length; i++) {
			ausgabe = ausgabe + geheim[i];
		}

		System.out.println("Cäsar: " + ausgabe);
	}

}
