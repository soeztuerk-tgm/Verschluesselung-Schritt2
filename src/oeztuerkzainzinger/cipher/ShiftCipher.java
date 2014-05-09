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
	public String shiftgeheim = "";
	public ShiftCipher(){
	/**
	 * Der Konstruktor besitzt einen Parameter value, mit dem der Wert für
	 * die Verschiebung der einzelnen Buchstaben im Alphabet.
	 * 
	 * @param value
	 * @throws FalscherParameterException
	 */
	}
	public ShiftCipher(int value) throws FalscherParameterException {
		this.wert = value;
		setShiftCipher(this.wert);
	}
	/**
	 * 
	 * @param wert
	 * @throws FalscherParameterException
	 */
	public void setShiftCipher(int wert) throws FalscherParameterException{
		try{
			if(wert>=0&&wert<=30){
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
		}catch(NumberFormatException nfe){
			//nfe.getMessage();
		}
	}

}
