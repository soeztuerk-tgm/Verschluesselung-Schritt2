package oeztuerkzainzinger.cipher;
/**
 * Die Schnittstelle Cipher beinhaltet die Funktionen encrypt und decrypt.Diese Methoden sollen die eigentliche
 * Verschl�sselungs- bzw. Entschl�sselungsarbeit vornehmen. Dazu �bernehmen sie als Parameter einen Text, 
 * wandeln diesen in Kleinbuchstaben um und geben den ver- bzw. entschl�sselten Text zur�ck.
 *
 */

public interface Cipher {
	public String encrypt(String text) throws FalscherParameterException;
	public String decrypt(String text) throws FalscherParameterException;
}
