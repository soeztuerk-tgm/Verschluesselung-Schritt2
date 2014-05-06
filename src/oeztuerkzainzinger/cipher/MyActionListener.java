package oeztuerkzainzinger.cipher;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Diese Klasse steuert welche Aktionen wann gestartet, beendet, gelöscht,
 * etc. werden. 
 * 
 * @author Sefa Öztürk
 *
 */
public class MyActionListener implements ActionListener {
	public MyActionListener(){
	}
	
	MonoAlphabeticCipher mac=new MonoAlphabeticCipher();
	KeywordCipher kc=new KeywordCipher();
	GUI g=new GUI();
	public void actionPerformed(ActionEvent e) {
		if("Geheimalphabet erstellen".equals(e.getActionCommand())){
			System.out.println("Hallo");
		}
	}

}
