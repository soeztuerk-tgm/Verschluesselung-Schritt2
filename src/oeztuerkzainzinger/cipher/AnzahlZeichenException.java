package oeztuerkzainzinger.cipher;
/**
 * Diese Klasse ist auch eine Exception, welches geworfen wird,
 * wenn eine Klasse eine Alphabet mit einer ung�ltigen L�ngenzahl
 * generiert werden soll
 * 
 * @author Sefa
 *
 */
public class AnzahlZeichenException extends Exception{
      //Parameterfreier Konstruktor
      public AnzahlZeichenException() {}

      //Konstruktor, das eine eine Nachricht annimt
      public AnzahlZeichenException(String message)
      {
         super(message);
      }
 }
