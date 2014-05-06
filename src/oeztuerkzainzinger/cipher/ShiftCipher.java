package oeztuerkzainzinger.cipher;
/**
 * Die Klasse ShiftCipher soll einen Verschiebechiffre implementieren. 
 * Dazu muss beim Konstruktor und bei der Methode setShiftAmount() der
 * Wert der Verschiebung angegeben werden. Das Geheimalphabet soll dann 
 * aus diesem Verschiebewert generiert werden.
 * 
 * 
 * @author Sefa Öztürk
 *
 */
public class ShiftCipher extends MonoAlphabeticCipher {
	//Verschiebeanzahl
	private int wert;
	String shiftgeheim = "";
	public ShiftCipher(){
		
	}
	public ShiftCipher(int value) {
		this.wert = value;
		setShiftCipher(this.wert);
	}

	public void setShiftCipher(int wert) {
		//Standardalphabet
		String alpha = "abcdefghijklmnopqrstuvwxyzäöüß";
		//Alphabet nach char casten
		char[] alphabet = alpha.toCharArray();
		char[] geheim = new char[30];
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

		for (int i = 0; i < geheim.length; i++) {
			shiftgeheim = shiftgeheim + geheim[i];
		}
	}

}
