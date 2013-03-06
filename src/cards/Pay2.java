package cards;

import grp30.MainFrame;
import gui.IMatColors;

import java.awt.Color;

import java.util.regex.*;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.ButtonGroup;

import se.chalmers.ait.dat215.project.IMatDataHandler;
import net.miginfocom.swing.MigLayout;
import javax.swing.ImageIcon;

public class Pay2 extends JPanel {
	private JTextField cardNumberLabel;
	private JTextField cvcLabel;
	private JTextField nameLabel;
	
	private JLabel cardFail;
	private JLabel cvcFail;
	private JLabel nameFail;
	private JLabel dateFail;
	private JLabel lblFel;
	private JComboBox yyCombo;
	private JComboBox mmCombo;
	private JCheckBox chckbx1;
	private JCheckBox chckbx2;
	private JCheckBox chckbx3;
	
	
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel lblKortnummer;
	private JLabel lblCvckod;
	private JLabel lblFullstndigtNamn;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	

	/**
	 * Create the panel.
	 */
	public Pay2(final MainFrame mf,final Pay3 pay3) {
		
		setBackground(Color.WHITE);
		
		setLayout(new MigLayout("", "[140][112px][10][60px][][30][][60px][10][][29px][30][89px][10][14px]", "[44px][23px][22px][22px][22px][30px][22px][30px][22px][30px][25px]"));
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Pay2.class.getResource("/resources/pay2.png")));
		add(lblNewLabel_1, "cell 5 1");
		
		chckbx1 = new JCheckBox("Visa/Mastercard");
		buttonGroup.add(chckbx1);
		chckbx1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(chckbx1, "cell 1 3,alignx left,aligny top");
		chckbx1.setSelected(true);
		
		chckbx2 = new JCheckBox("American Express");
		buttonGroup.add(chckbx2);
		chckbx2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(chckbx2, "cell 5 3,alignx center,aligny top");
		
		chckbx3 = new JCheckBox("Maestro");
		buttonGroup.add(chckbx3);
		chckbx3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(chckbx3, "cell 9 3,growx,aligny top");
		
		lblFel = new JLabel("Fel");
		lblFel.setForeground(Color.RED);
		lblFel.setVisible(false);
		add(lblFel, "cell 11 3,alignx left,aligny center");
		
		cardNumberLabel = new JTextField();
		cardNumberLabel.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				cardNumberLabel.setText("");
			}
		});
		
		lblKortnummer = new JLabel("Kortnummer");
		add(lblKortnummer, "cell 1 4,aligny bottom");
		
		lblFullstndigtNamn = new JLabel("Fullst\u00E4ndigt Namn");
		add(lblFullstndigtNamn, "cell 5 4,aligny bottom");
		cardNumberLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		cardNumberLabel.setColumns(10);
		add(cardNumberLabel, "cell 1 5,growx,aligny top");
		
		cardFail = new JLabel("FEL");
		cardFail.setForeground(Color.RED);
		cardFail.setVisible(false);
		add(cardFail, "cell 3 5,alignx left,aligny center");
		
		nameLabel = new JTextField();
		nameLabel.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				nameLabel.setText("");
			}
		});
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		nameLabel.setColumns(10);
		add(nameLabel, "cell 5 5,growx,aligny top");
		
		nameFail = new JLabel("FEL");
		nameFail.setForeground(Color.RED);
		nameFail.setVisible(false);
		add(nameFail, "cell 7 5,alignx left,aligny center");
		
		
		JButton backButton = new JButton("Tillbaka");
		backButton.setToolTipText("Tillbaka till address");
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mf.swapCard("pay1");
			}
		});
		
		cvcLabel = new JTextField();
		cvcLabel.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				cvcLabel.setText("");
			}
		});
		
		lblCvckod = new JLabel("CVC-kod");
		lblCvckod.setToolTipText("<html>CVC-kod \u00E4r en extra s\u00E4kerhets\u00E5tg\u00E4rd, som <br />\r\nanv\u00E4nds n\u00E4r man handlar med kort och den som <br />\r\nska ha betalt inte kan se kortet. <br />\r\n<br />\r\nP\u00E5 Visa el Mastercard \u00E4r koden lika med de tre <br />\r\nsista siffrorna som \u00E4r tryckta i namnteckningsf\u00E4ltet <br />\r\np\u00E5 kortets baksida.</html>");
		lblCvckod.setIcon(new ImageIcon(Pay2.class.getResource("/resources/qmark.png")));
		add(lblCvckod, "cell 1 6,aligny bottom");
		
		lblNewLabel = new JLabel("Utg\u00E5ngsdatum");
		add(lblNewLabel, "cell 5 6,aligny bottom");
		cvcLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		cvcLabel.setColumns(10);
		add(cvcLabel, "cell 1 7,growx,aligny top");
		
		cvcFail = new JLabel("FEL");
		cvcFail.setForeground(Color.RED);
		cvcFail.setVisible(false);
		add(cvcFail, "cell 3 7,alignx left,aligny center");
		
		yyCombo = new JComboBox();
		yyCombo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		yyCombo.setModel(new DefaultComboBoxModel(new String[] {"\u00C5\u00C5", "13", "14", "15", "16", "17", "18"}));
		add(yyCombo, "flowx,cell 5 7,alignx left,aligny top");
		
		dateFail = new JLabel("FEL");
		dateFail.setForeground(Color.RED);
		dateFail.setVisible(false);
		add(dateFail, "cell 7 7,alignx left,aligny center");
		add(backButton, "cell 1 10,alignx left,aligny top");
		
		
		if(!IMatDataHandler.getInstance().getCreditCard().getCardNumber().equals("")){
			
			cardNumberLabel.setText(IMatDataHandler.getInstance().getCreditCard().getCardNumber());
			cvcLabel.setText(Integer.toString(IMatDataHandler.getInstance().getCreditCard().getVerificationCode()));
			nameLabel.setText(IMatDataHandler.getInstance().getCreditCard().getHoldersName());
			if(IMatDataHandler.getInstance().getCreditCard().getCardType().equals("A")){
				chckbx1.setSelected(true);
			}
			else if(IMatDataHandler.getInstance().getCreditCard().getCardType().equals("B")){
				chckbx2.setSelected(true);
			}
			else{
				chckbx3.setSelected(true);
			}
		
		
		}else{
			cardNumberLabel.setText("Kortnummer");
			cvcLabel.setText("cvc");
			nameLabel.setText("Fullst\u00E4ndigt namn");
			
			
		}
		
		// TODO more checks
		JButton okButton = new JButton("G\u00E5 Vidare");
		okButton.setToolTipText("G\u00E5 vidare till bekr\u00E4ftning");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				

			    String re1="(\\d)";	// Any Single Digit 1
			    String re2="(\\d)";	// Any Single Digit 2
			    String re3="(\\d)";	// Any Single Digit 3

			    Pattern p = Pattern.compile(re1+re2+re3,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
			    Matcher m = p.matcher(cvcLabel.getText());
				boolean cvcmatch=m.find();
				
				String re4="(\\d+)";	// Integer Number 

				    Pattern p2 = Pattern.compile(re4,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
				    Matcher m2 = p2.matcher(cardNumberLabel.getText());
				    boolean cardmatch=m2.find();
				
				
				if (!cardmatch ||!cvcmatch ||
						nameLabel.getText().equals("Fullst‰ndigt namn")
						|| nameLabel.getText().equals("")
						|| yyCombo.getSelectedItem().equals("≈≈")
						|| mmCombo.getSelectedItem().equals("MM") ||
						buttonGroup.isSelected(null)) {
					if (!cardmatch) {
						cardFail.setVisible(true);
					}
					if (!cvcmatch) {
						cvcFail.setVisible(true);
					}
					if (nameLabel.getText().equals("") || nameLabel.getText().equals("Fullst‰ndigt namn")) {
						nameFail.setVisible(true);
					}
					if (yyCombo.getSelectedItem().equals("≈≈")
							|| mmCombo.getSelectedItem().equals("MM")) {
						dateFail.setVisible(true);
					}
					if (buttonGroup.isSelected(null)) {
						lblFel.setVisible(true);
					}
				}else {
					//store values and continue
					try{
					IMatDataHandler.getInstance().getCreditCard().setCardNumber(cardNumberLabel.getText());
					IMatDataHandler.getInstance().getCreditCard().setVerificationCode(Integer.parseInt(cvcLabel.getText()));
					IMatDataHandler.getInstance().getCreditCard().setHoldersName(nameLabel.getText());
					IMatDataHandler.getInstance().getCreditCard().setCardNumber(cardNumberLabel.getText());
					IMatDataHandler.getInstance().getCreditCard().setValidYear(Integer.parseInt(yyCombo.getSelectedItem().toString()));
					IMatDataHandler.getInstance().getCreditCard().setValidMonth(Integer.parseInt(mmCombo.getSelectedItem().toString()));
					
					if(chckbx1.isSelected()){
						IMatDataHandler.getInstance().getCreditCard().setCardType("A");
					}
					else if(chckbx2.isSelected()){
						IMatDataHandler.getInstance().getCreditCard().setCardType("B");
					}
					else{
						IMatDataHandler.getInstance().getCreditCard().setCardType("C");
					}
					pay3.checkForUser();
					pay3.erasePassword();
					mf.swapCard("pay3");
					cvcFail.setVisible(false);
					dateFail.setVisible(false);
					cardFail.setVisible(false);
					nameFail.setVisible(false);
					}catch(NumberFormatException e){
						cvcFail.setVisible(true);
					}
					
				}
			}
		});
		okButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(okButton, "cell 9 10,alignx right,aligny top");
		
		mmCombo = new JComboBox();
		mmCombo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		mmCombo.setModel(new DefaultComboBoxModel(new String[] {"MM", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		add(mmCombo, "cell 5 7,alignx right,aligny top");

	}
}
