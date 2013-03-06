package cards;

import grp30.MainFrame;
import gui.IMatFonts;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import se.chalmers.ait.dat215.project.IMatDataHandler;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import net.miginfocom.swing.MigLayout;

public class MyAccount extends JPanel {


	private JTextField firstLabel;
	private JTextField addressLabel;
	private JTextField tNumberLabel;
	private JTextField lastLabel;
	private JTextField cityLabel;
	private JTextField mailLabel;
	private JTextField homePhoneLabel;
	private JTextField pCodeLabel;
	private JLabel l1;
	private JLabel l2;
	private JLabel l3;
	private JLabel l4;
	private JLabel l5;
	private JLabel l6;
	private JLabel l7;
	private JLabel l8;
	private JLabel lblndraUppgifter;

	/**
	 * Create the panel.
	 */
	public MyAccount(final MainFrame mf,final Pay1 pay1) {
		
		firstLabel = new JTextField();
		firstLabel.setFont(IMatFonts.NORMALFONT);
		lastLabel = new JTextField();
		lastLabel.setFont(IMatFonts.NORMALFONT);
		addressLabel = new JTextField();
		addressLabel.setFont(IMatFonts.NORMALFONT);
		cityLabel = new JTextField();
		cityLabel.setFont(IMatFonts.NORMALFONT);
		pCodeLabel = new JTextField();
		pCodeLabel.setFont(IMatFonts.NORMALFONT);
		tNumberLabel = new JTextField();
		tNumberLabel.setFont(IMatFonts.NORMALFONT);
		homePhoneLabel = new JTextField();
		homePhoneLabel.setFont(IMatFonts.NORMALFONT);
		mailLabel = new JTextField();
		mailLabel.setFont(IMatFonts.NORMALFONT);
		
		setBackground(Color.WHITE);
			//IF we have first name, we have also other info
			if(!IMatDataHandler.getInstance().getCustomer().getFirstName().equals("")){
				
				firstLabel.setText(IMatDataHandler.getInstance().getCustomer().getFirstName());
				addressLabel.setText(IMatDataHandler.getInstance().getCustomer().getAddress());
				tNumberLabel.setText(IMatDataHandler.getInstance().getCustomer().getMobilePhoneNumber());
				lastLabel.setText(IMatDataHandler.getInstance().getCustomer().getLastName());
				mailLabel.setText(IMatDataHandler.getInstance().getCustomer().getEmail());
				homePhoneLabel.setText(IMatDataHandler.getInstance().getCustomer().getPhoneNumber());
				cityLabel.setText(IMatDataHandler.getInstance().getCustomer().getPostAddress());
				pCodeLabel.setText(IMatDataHandler.getInstance().getCustomer().getPostCode());
			
			}else{
				firstLabel.setText("Förnamn");
				addressLabel.setText("Adress");
				lastLabel.setText("Efternamn");
				homePhoneLabel.setText("Hemtelefon");
				cityLabel.setText("Postadress");
				tNumberLabel.setText("Mobilnummer");
				pCodeLabel.setText("Postkod");
				mailLabel.setText("E-Mail");
				
				
				
			}
		setLayout(new MigLayout("", "[91px][112px][29px][61px][112px][21px][36px][145px][4px][14px]", "[40px][22px][22px][22px][10px][22px][22px][10px][22px][22px][][]"));
		
		lblndraUppgifter = new JLabel("\u00C4ndra Uppgifter");
		lblndraUppgifter.setFont(new Font("Tahoma", Font.PLAIN, 24));
		add(lblndraUppgifter, "cell 3 0 2 1,alignx right");
		
		JLabel lblNewLabel = new JLabel("F\u00F6rnamn");
		lblNewLabel.setFont(IMatFonts.REGFONT);
		lblNewLabel.setForeground(IMatFonts.REGFONTCOLOR);
		add(lblNewLabel, "cell 1 2,alignx left,aligny center");
		
		JLabel lblNewLabel_3 = new JLabel("Efternamn");
		lblNewLabel_3.setFont(IMatFonts.REGFONT);
		lblNewLabel_3.setForeground(IMatFonts.REGFONTCOLOR);
		add(lblNewLabel_3, "cell 4 2,alignx left,aligny center");
		
		firstLabel.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				firstLabel.setText("");
			}
		});
		
		JLabel lblNewLabel_5 = new JLabel("E-Mail");
		lblNewLabel_5.setFont(IMatFonts.REGFONT);
		lblNewLabel_5.setForeground(IMatFonts.REGFONTCOLOR);
		add(lblNewLabel_5, "cell 7 2,alignx left,aligny center");
		firstLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		firstLabel.setColumns(10);
		add(firstLabel, "cell 1 3,growx,aligny top");
		
		l1 = new JLabel("Fel");
		l1.setForeground(Color.RED);
		l1.setVisible(false);
		add(l1, "cell 2 3,growx,aligny center");
		
		lastLabel.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				lastLabel.setText("");
			}
		});
		
		lastLabel.setColumns(10);
		add(lastLabel, "cell 4 3,growx,aligny top");
		
		l4 = new JLabel("Fel");
		l4.setForeground(Color.RED);
		l4.setVisible(false);
		add(l4, "cell 5 3,growx,aligny center");

		
		mailLabel.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				mailLabel.setText("");
			}
		});
		
		mailLabel.setColumns(10);
		add(mailLabel, "cell 7 3,growx,aligny top");
		
		l6 = new JLabel("Fel");
		l6.setForeground(Color.RED);
		l6.setVisible(false);
		add(l6, "cell 9 3,alignx left,aligny center");
		
		JLabel lblNewLabel_1 = new JLabel("Adress");
		lblNewLabel_1.setFont(IMatFonts.REGFONT);
		lblNewLabel_1.setForeground(IMatFonts.REGFONTCOLOR);
		add(lblNewLabel_1, "cell 1 5,alignx left,aligny center");
		
		addressLabel.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				addressLabel.setText("");
			}
		});
		
		JLabel lblNewLabel_4 = new JLabel("Postort");
		lblNewLabel_4.setFont(IMatFonts.REGFONT);
		lblNewLabel_4.setForeground(IMatFonts.REGFONTCOLOR);
		add(lblNewLabel_4, "cell 4 5,alignx left,aligny center");
		
		l5 = new JLabel("Fel");
		l5.setForeground(Color.RED);
		l5.setVisible(false);
		add(l5, "cell 5 5,growx,aligny center");
		
		JLabel lblNewLabel_7 = new JLabel("Postnummer");
		lblNewLabel_7.setFont(IMatFonts.REGFONT);
		lblNewLabel_7.setForeground(IMatFonts.REGFONTCOLOR);
		add(lblNewLabel_7, "cell 7 5,alignx left,aligny center");

		addressLabel.setColumns(10);
		add(addressLabel, "cell 1 6,growx,aligny top");
		
		l2 = new JLabel("Fel");
		l2.setForeground(Color.RED);
		l2.setVisible(false);
		add(l2, "cell 2 6,growx,aligny center");
		
		cityLabel.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				cityLabel.setText("");
			}
		});
		
		cityLabel.setColumns(10);
		add(cityLabel, "cell 4 6,growx,aligny top");
		
		pCodeLabel.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				pCodeLabel.setText("");
			}
		});

		pCodeLabel.setText("Postnummer");
		pCodeLabel.setColumns(10);
		add(pCodeLabel, "cell 7 6,alignx left,aligny top");
		
		l8 = new JLabel("Fel");
		l8.setForeground(Color.RED);
		l8.setVisible(false);
		add(l8, "cell 9 6,alignx left,aligny center");
		
		JLabel lblNewLabel_2 = new JLabel("Telefonnummer");
		lblNewLabel_2.setFont(IMatFonts.REGFONT);
		lblNewLabel_2.setForeground(IMatFonts.REGFONTCOLOR);
		add(lblNewLabel_2, "cell 1 8,alignx left,aligny center");
		
		tNumberLabel.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tNumberLabel.setText("");
			}
		});
		
		JLabel lblNewLabel_6 = new JLabel("Hemtelefon");
		lblNewLabel_6.setFont(IMatFonts.REGFONT);
		lblNewLabel_6.setForeground(IMatFonts.REGFONTCOLOR);
		add(lblNewLabel_6, "cell 4 8,alignx left,aligny center");
		
		tNumberLabel.setColumns(10);
		add(tNumberLabel, "cell 1 9,growx,aligny top");
		
		l3 = new JLabel("Fel");
		l3.setForeground(Color.RED);
		l3.setVisible(false);
		add(l3, "cell 2 9,growx,aligny center");
		
		
		JButton okButton = new JButton("Uppdatera");
		okButton.setToolTipText("");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// CHECK FOR EMPTY FIELDS AND NOTIFY
				// TODO more checks
				if (firstLabel.getText().equals("")
						|| addressLabel.getText().equals("")
						|| tNumberLabel.getText().equals("")
						|| lastLabel.getText().equals("")
						|| cityLabel.getText().equals("")
						|| mailLabel.getText().equals("")
						|| homePhoneLabel.getText().equals("")
						|| pCodeLabel.getText().equals("")) {
					if (firstLabel.getText().equals("")) {
						l1.setVisible(true);
					}
					if (addressLabel.getText().equals("")) {
						l2.setVisible(true);
					}
					if (tNumberLabel.getText().equals("")) {
						l3.setVisible(true);
					}
					if (lastLabel.getText().equals("")) {
						l4.setVisible(true);
					}
					if (cityLabel.getText().equals("")) {
						l5.setVisible(true);
					}
					if (mailLabel.getText().equals("")) {
						l6.setVisible(true);
					}
					if (homePhoneLabel.getText().equals("")) {
						l7.setVisible(true);
					}
					if (pCodeLabel.getText().equals("")) {
						l8.setVisible(true);
					}
				} else {
					// Store values and Continue
					
					IMatDataHandler.getInstance().getCustomer().setFirstName(firstLabel.getText());
					IMatDataHandler.getInstance().getCustomer().setAddress(addressLabel.getText());
					IMatDataHandler.getInstance().getCustomer().setMobilePhoneNumber(tNumberLabel.getText());
					IMatDataHandler.getInstance().getCustomer().setLastName(lastLabel.getText());
					IMatDataHandler.getInstance().getCustomer().setEmail(mailLabel.getText());
					IMatDataHandler.getInstance().getCustomer().setPhoneNumber(homePhoneLabel.getText());
					IMatDataHandler.getInstance().getCustomer().setPostAddress(cityLabel.getText());
					IMatDataHandler.getInstance().getCustomer().setPostCode(pCodeLabel.getText());
					
					mf.swapCard("startUser");
					pay1.updateInfo();
					
					
				}
				
				
				
				
					
					
					
					
				
				
			}
		});
		
		l7 = new JLabel("Fel");
		l7.setForeground(Color.RED);
		l7.setVisible(false);
		
		homePhoneLabel.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				homePhoneLabel.setText("");
			}
		});
		
		homePhoneLabel.setColumns(10);
		add(homePhoneLabel, "cell 4 9,growx,aligny top");
		add(l7, "cell 5 9,alignx left,aligny center");
		okButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(okButton, "cell 7 11,alignx left,aligny top");

	}
	

	public void updateInfo() {
		firstLabel.setText(IMatDataHandler.getInstance().getCustomer().getFirstName());
		lastLabel.setText(IMatDataHandler.getInstance().getCustomer().getLastName());
		addressLabel.setText(IMatDataHandler.getInstance().getCustomer().getAddress());
		tNumberLabel.setText(IMatDataHandler.getInstance().getCustomer().getMobilePhoneNumber());
		cityLabel.setText(IMatDataHandler.getInstance().getCustomer().getPostAddress());
		mailLabel.setText(IMatDataHandler.getInstance().getCustomer().getEmail());
		homePhoneLabel.setText(IMatDataHandler.getInstance().getCustomer().getPhoneNumber());
		pCodeLabel.setText(IMatDataHandler.getInstance().getCustomer().getPostCode());
		
	}
}
