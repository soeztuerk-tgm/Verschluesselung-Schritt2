/**
 * 
 */
package oeztuerkzainzinger.cipher;

/**
 * 
 * @author lukas zainzinger
 *
 */
public class TestTranspo {

	/**
	 * @param args
	 * @throws FalscherParameterException 
	 */
	public static void main(String[] args) throws FalscherParameterException {
			TranspositionCipher xy = new TranspositionCipher(2);
			String t = xy.encrypt("Lukas");
			System.out.println(t);
		}
		

	}

