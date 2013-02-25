package grp30;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class CardManager {
	
		static JPanel centercardpanel;
		
	public CardManager(){
		centercardpanel = new JPanel();
		centercardpanel.setBackground(Color.GRAY);
		
		centercardpanel.setLayout(new CardLayout(0, 0));
		
		JPanel startinloggad = new Startinloggad();
		centercardpanel.add(startinloggad, "name_89197531763174");
		JPanel startutloggad = new JPanel();
		startutloggad.setBackground(Color.BLUE);
		centercardpanel.add(startutloggad, "name_89204269755190");
		
		JPanel kundvagn = new JPanel();
		kundvagn.setBackground(Color.GREEN);
		centercardpanel.add(kundvagn, "name_89208888451515");
		
		JPanel sökresultat = new JPanel();
		centercardpanel.add(sökresultat, "name_79607360163502");
		
		JPanel betalning1 = new JPanel();
		centercardpanel.add(betalning1, "name_79733403728736");
		
		JPanel betalning2 = new JPanel();
		centercardpanel.add(betalning2, "name_79735858974329");
		
		JPanel betalning3 = new JPanel();
		centercardpanel.add(betalning3, "name_79737970396881");
		
		JPanel registrering = new JPanel();
		centercardpanel.add(registrering, "name_79797450475366");
		
		JPanel köpklart = new JPanel();
		centercardpanel.add(köpklart, "name_79883887619016");
		
		JPanel historik = new JPanel();
		centercardpanel.add(historik, "name_79945554551032");
		
		JPanel kvitto = new JPanel();
		centercardpanel.add(kvitto, "name_79968035692471");
		
		JPanel detaljvy = new JPanel();
		centercardpanel.add(detaljvy, "name_80016568515947");
		
	}

	public static JPanel getCards() {
		return  centercardpanel;
	}

}
