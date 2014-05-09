/**
 * 
 */
package oeztuerkzainzinger.cipher;

/**
 * TranspositionCipher 
 * @author lukaszainzinger, oeztuerk
 *
 */

public class TranspositionCipher implements Cipher {
	//Attribut
	private int transpositionlvl; 
	
	public TranspositionCipher(int translvl) throws FalscherParameterException{
		this.setTranspositionLevel(translvl);
	}

	public void setTranspositionLevel(int lvl) throws FalscherParameterException{
		if(lvl > 0) {
			this.transpositionlvl = lvl;
		}else{
			throw new FalscherParameterException("Level muss groeﬂer 0 sein!");
		}
	}
	/**
	 * encrypt-Methode
	 * @param text 
	 * @return decryptText
	 */
	@Override
	public String encrypt(String text) throws FalscherParameterException {

		String largeText = text.toUpperCase();
		String[] crypt = new String[transpositionlvl];
		for(int i = 0; i < crypt.length; i++) {
			crypt[i] = "";
		}
		for(int i = 0; i < largeText.length(); i++) {
			crypt[i%crypt.length] += largeText.charAt(i);
		}

		String cryptText = "";
		for(String subCrypt:crypt) {
			cryptText += subCrypt;
		}

		return cryptText;
	}
	/**
	 * decrypt-Methode
	 * @param text 
	 * @return decryptText
	 */
	@Override
	public String decrypt(String text) throws FalscherParameterException {
		String[] crypt = new String[transpositionlvl]; 
		int teil = text.length()/transpositionlvl;
		int teil2;
		if(text.length()%transpositionlvl != 0){
			teil2 = teil+1;
		}else{
			teil2 = teil;
		}
		for(int i = 0; i < crypt.length; i++) {
			if(i == 0){
				crypt[i] = text.substring(i*teil,(i+1)*teil2);
			}else{
				crypt[i] = text.substring(teil2 + teil*(i-1),(i+1)*teil+1);
			}
		}  
		char[][] cryptChars = new char[crypt.length][]; 
		for(int i = 0; i < crypt.length; i++) { 
			cryptChars[i] = crypt[i].toCharArray(); 
		} 
		String decryptText = ""; 
		for(int i = 0; i < cryptChars[0].length; i++) 
			for(int j = 0; j < cryptChars.length; j++) 
				if(i < cryptChars[j].length) { 
					decryptText += cryptChars[j][i]; 
				} 
		return decryptText; 
	}
}