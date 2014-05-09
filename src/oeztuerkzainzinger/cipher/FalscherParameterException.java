package oeztuerkzainzinger.cipher;
/**
 * Klasse FalscherParameterException ist eine Exception-Klasse,dass bei Fehelrmeldungen,
 * bei Eingabe von einem ungültigen Parameter in Klassen eingesetzt wird.
 * @author Sefa
 *
 */
public class FalscherParameterException extends Exception{
      //Parameterfreier Konstruktor
      public FalscherParameterException() {}

      //Konstruktor, das eine eine Nachricht annimmt
      public FalscherParameterException(String message)
      {
         super(message);
      }
 }
