package cards;

import grp30.MainFrame;
import gui.IMatColors;
import gui.IMatFonts;

import java.awt.Color;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JLabel;

import se.chalmers.ait.dat215.project.Customer;
import se.chalmers.ait.dat215.project.IMatDataHandler;

import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.miginfocom.swing.MigLayout;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;

public class Pay1 extends JPanel {
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
	private JLabel lblFrnamn;
	private JLabel lblEfternamn;
	private JLabel lblHemtelefon;
	private JLabel lblAddress;
	private JLabel lblPostort;
	private JLabel lblPostnummer;
	private JLabel lblMobiltelefon;
	private JLabel lblEmail;
	private JLabel lblNewLabel;

	/**
	 * Create the panel.
	 */
	public Pay1(final MainFrame mf,final Pay3 pay3, final MyAccount myAccount) {
		
		setBackground(Color.WHITE);
		firstLabel = new JTextField();
		firstLabel.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				firstLabel.setText("");
			}
		});
		firstLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		firstLabel.setColumns(10);
		
		addressLabel = new JTextField();
		addressLabel.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				addressLabel.setText("");
			}
		});
		addressLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		addressLabel.setColumns(10);
		
		tNumberLabel = new JTextField();
		tNumberLabel.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tNumberLabel.setText("");
			}
		});
		tNumberLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tNumberLabel.setColumns(10);
		
		lastLabel = new JTextField();
		lastLabel.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				lastLabel.setText("");
			}
		});
		lastLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		lastLabel.setColumns(10);
		
		cityLabel = new JTextField();
		cityLabel.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				cityLabel.setText("");
			}
		});
		cityLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		cityLabel.setColumns(10);
		
		pCodeLabel = new JTextField();
		pCodeLabel.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				pCodeLabel.setText("");
			}
		});
		pCodeLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pCodeLabel.setColumns(10);
		
		homePhoneLabel = new JTextField();
		//homePhoneLabel.setText("Hemtelefon");
		homePhoneLabel.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				homePhoneLabel.setText("");
			}
		});
		mailLabel = new JTextField();
		mailLabel.setText("E-Mail");
		
		mailLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
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
			/*	firstLabel.setText("Förnamn");
				addressLabel.setText("Adress");
				lastLabel.setText("Efternamn");
				homePhoneLabel.setText("Hemtelefon");
				cityLabel.setText("Postadress");
				tNumberLabel.setText("Mobilnummer");
				pCodeLabel.setText("Postkod");
				mailLabel.setText("E-Mail"); */ //behövs ej tycker jag /Kristofer
				mailLabel.setText(IMatDataHandler.getInstance().getCustomer().getEmail());
				
				
				
			}
			
		
		JButton okButton = new JButton("G\u00E5 Vidare");
		okButton.setToolTipText("G\u00E5 vidare till betals\u00E4tt");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// CHECK FOR EMPTY FIELDS AND NOTIFY
				
			    
			    
			    String re1="([\\w-+]+(?:\\.[\\w-+]+)*@(?:[\\w-]+\\.)+[a-zA-Z]{2,7})"; //mail regexp
				
			    Pattern p2 = Pattern.compile(re1,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
				Matcher m5 = p2.matcher(mailLabel.getText());
				
				String nr="(\\d+)";	//nr regexp
				Pattern p3 = Pattern.compile(nr,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
			    Matcher m6 = p3.matcher(tNumberLabel.getText());
			    Matcher m7 = p3.matcher(homePhoneLabel.getText());
				
			    String pk1="(\\d)";	// Any Single Digit 1
			    String pk2="(\\d)";	// Any Single Digit 2
			    String pk3="(\\d)";	// Any Single Digit 3
			    String pk4="(\\s+)";	// White Space 1
			    String pk5="(\\d)";	// Any Single Digit 4
			    String pk6="(\\d)";	// Any Single Digit 5
			    
			    Pattern p4 = Pattern.compile(pk1+pk2+pk3+pk4+pk5+pk6,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
			    Matcher m8 = p4.matcher(pCodeLabel.getText());
			    boolean a = m5.find();
			    boolean b = m6.find();
			    boolean c = m7.find();
			    boolean d = m8.find();
			    
			    
				
				if (firstLabel.getText().equals("") || lastLabel.getText().equals("") || addressLabel.getText().equals("") || cityLabel.getText().equals("")
						|| !a || !b || !c
						|| !d) {
					if (firstLabel.getText().equals("")) {
						l1.setVisible(true);
					}
					if (addressLabel.getText().equals("")) {
						l2.setVisible(true);
					}
					if (!b) {
						l3.setVisible(true);
					}
					if (lastLabel.getText().equals("")) {
						l4.setVisible(true);
					}
					if (cityLabel.getText().equals("")) {
						l5.setVisible(true);
					}
					if (!a) {
						l6.setVisible(true);
					}
					if (!c) {
						l7.setVisible(true);
					}
					if (!d) {
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
					
					pay3.updateInfo();
					
					mf.swapCard("pay2");
					l1.setVisible(false);
					l2.setVisible(false);
					l3.setVisible(false);
					l4.setVisible(false);
					l5.setVisible(false);
					l6.setVisible(false);
					l7.setVisible(false);
					l8.setVisible(false);
					
					
				}
				
				
				
				
					
					
					
					
				
				
			}
		});
		okButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		l1 = new JLabel("");
		l1.setToolTipText("Felaktigt f\u00F6rnamn");
		l1.setIcon(new ImageIcon(Pay1.class.getResource("/resources/error.png")));
		l1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		l1.setForeground(Color.RED);
		l1.setVisible(false);
		
		l2 = new JLabel("");
		l2.setToolTipText("Ogiltlig adress");
		l2.setIcon(new ImageIcon(Pay1.class.getResource("/resources/error.png")));
		l2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		l2.setForeground(Color.RED);
		l2.setVisible(false);
		
		l3 = new JLabel("");
		l3.setToolTipText("Ogiltligt telefonnummer");
		l3.setIcon(new ImageIcon(Pay1.class.getResource("/resources/error.png")));
		l3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		l3.setForeground(Color.RED);
		l3.setVisible(false);
		
		l4 = new JLabel("");
		l4.setToolTipText("Felaktigt efternamn");
		l4.setIcon(new ImageIcon(Pay1.class.getResource("/resources/error.png")));
		l4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		l4.setForeground(Color.RED);
		l4.setVisible(false);
		
		l5 = new JLabel("");
		l5.setToolTipText("Ogiltlig postort");
		l5.setIcon(new ImageIcon(Pay1.class.getResource("/resources/error.png")));
		l5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		l5.setForeground(Color.RED);
		l5.setVisible(false);
		
		l8 = new JLabel("");
		l8.setToolTipText("<html>Ogiltligt postnummer<br />\r\nPostorten ska vara p\u00E5 formen XXX XX</html>");
		l8.setIcon(new ImageIcon(Pay1.class.getResource("/resources/error.png")));
		l8.setFont(new Font("Tahoma", Font.PLAIN, 12));
		l8.setForeground(Color.RED);
		l8.setVisible(false);
		setLayout(new MigLayout("", "[150][112px][10][29px][30][112px][10][29px][30][89px][10][14px]", "[44px][23px][22px][22px][22px][30px][22px][30px][22px][30px][25px]"));
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Pay1.class.getResource("/resources/pay1.png")));
		add(lblNewLabel, "cell 5 1");
		
		lblFrnamn = new JLabel("F\u00F6rnamn");
		lblFrnamn.setFont(IMatFonts.REGFONT);
		lblFrnamn.setForeground(IMatFonts.REGFONTCOLOR);
		add(lblFrnamn, "cell 1 3,aligny bottom");
		
		lblEfternamn = new JLabel("Efternamn");
		lblEfternamn.setFont(IMatFonts.REGFONT);
		lblEfternamn.setForeground(IMatFonts.REGFONTCOLOR);
		add(lblEfternamn, "cell 5 3,aligny bottom");
		
		lblEmail = new JLabel("E-Mail");
		lblEmail.setFont(IMatFonts.REGFONT);
		lblEmail.setForeground(IMatFonts.REGFONTCOLOR);
		add(lblEmail, "cell 9 3,aligny bottom");
		add(firstLabel, "cell 1 4,growx,aligny top");
		add(l1, "cell 3 4,growx,aligny center");
		
		
		mailLabel.setColumns(10);
		add(mailLabel, "cell 9 4,growx,aligny top");
		
		l6 = new JLabel("");
		l6.setToolTipText("Ogiltlig E-mail");
		l6.setIcon(new ImageIcon(Pay1.class.getResource("/resources/error.png")));
		l6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		l6.setForeground(Color.RED);
		l6.setVisible(false);
		add(l6, "cell 11 4,alignx left,aligny center");
		
		lblAddress = new JLabel("Address");
		lblAddress.setFont(IMatFonts.REGFONT);
		lblAddress.setForeground(IMatFonts.REGFONTCOLOR);
		add(lblAddress, "cell 1 5,aligny bottom");
		
		lblPostort = new JLabel("Postort");
		lblPostort.setFont(IMatFonts.REGFONT);
		lblPostort.setForeground(IMatFonts.REGFONTCOLOR);
		add(lblPostort, "cell 5 5,aligny bottom");
		
		lblPostnummer = new JLabel("Postnummer");
		lblPostnummer.setFont(IMatFonts.REGFONT);
		lblPostnummer.setForeground(IMatFonts.REGFONTCOLOR);
		add(lblPostnummer, "cell 9 5,aligny bottom");
		add(addressLabel, "cell 1 6,growx,aligny top");
		add(l2, "cell 3 6,growx,aligny center");
		
		lblMobiltelefon = new JLabel("Mobiltelefon");
		lblMobiltelefon.setFont(IMatFonts.REGFONT);
		lblMobiltelefon.setForeground(IMatFonts.REGFONTCOLOR);
		add(lblMobiltelefon, "cell 1 7,aligny bottom");
		
		lblHemtelefon = new JLabel("Hemtelefon");
		lblHemtelefon.setFont(IMatFonts.REGFONT);
		lblHemtelefon.setForeground(IMatFonts.REGFONTCOLOR);
		add(lblHemtelefon, "cell 5 7,aligny bottom");
		add(tNumberLabel, "cell 1 8,growx,aligny top");
		add(l3, "cell 3 8,growx,aligny center");
		add(lastLabel, "cell 5 4,growx,aligny top");
		add(cityLabel, "cell 5 6,growx,aligny top");
		add(l5, "cell 7 6,growx,aligny center");
		add(l4, "cell 7 4,growx,aligny center");
		add(pCodeLabel, "cell 9 6,growx,aligny top");
		add(l8, "cell 11 6,alignx left,aligny center");
		
		homePhoneLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		homePhoneLabel.setColumns(10);
		add(homePhoneLabel, "cell 5 8,growx,aligny top");
		
		l7 = new JLabel("");
		l7.setToolTipText("Ogiltligt telefonnummer");
		l7.setIcon(new ImageIcon(Pay1.class.getResource("/resources/error.png")));
		l7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		l7.setForeground(Color.RED);
		l7.setVisible(false);
		add(l7, "cell 7 8,alignx left,aligny center");
		add(okButton, "cell 9 10,alignx left,aligny top");

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
	
	public void updateMail(){
		mailLabel.setText(IMatDataHandler.getInstance().getUser().getUserName());
	}
}
