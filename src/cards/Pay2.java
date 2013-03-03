package cards;

import grp30.MainFrame;

import java.awt.Color;

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
	

	/**
	 * Create the panel.
	 */
	public Pay2(final MainFrame mf) {
		
		setBackground(Color.WHITE);
		
		JLabel label = new JLabel("2/3");
		label.setFont(new Font("Tahoma", Font.PLAIN, 19));
		
		chckbx1 = new JCheckBox("Visa/Mastercard");
		buttonGroup.add(chckbx1);
		chckbx1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		//chckbx1.setSelected(true);
		
		chckbx2 = new JCheckBox("American Express");
		buttonGroup.add(chckbx2);
		chckbx2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		chckbx3 = new JCheckBox("Maestro");
		buttonGroup.add(chckbx3);
		chckbx3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		cardNumberLabel = new JTextField();
		cardNumberLabel.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				cardNumberLabel.setText("");
			}
		});
		cardNumberLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		cardNumberLabel.setColumns(10);
		
		cvcLabel = new JTextField();
		cvcLabel.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				cvcLabel.setText("");
			}
		});
		cvcLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		cvcLabel.setColumns(10);
		
		nameLabel = new JTextField();
		nameLabel.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				nameLabel.setText("");
			}
		});
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		nameLabel.setColumns(10);
		
		yyCombo = new JComboBox();
		yyCombo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		yyCombo.setModel(new DefaultComboBoxModel(new String[] {"\u00C5\u00C5", "13", "14", "15", "16", "17", "18"}));
		
		mmCombo = new JComboBox();
		mmCombo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		mmCombo.setModel(new DefaultComboBoxModel(new String[] {"MM", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		
		
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
		
		
		
		JButton backButton = new JButton("Tillbaka");
		backButton.setToolTipText("Tillbaka till address");
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mf.swapCard("pay1");
			}
		});
		
		cardFail = new JLabel("FEL");
		cardFail.setForeground(Color.RED);
		cardFail.setVisible(false);
		
		cvcFail = new JLabel("FEL");
		cvcFail.setForeground(Color.RED);
		cvcFail.setVisible(false);
		
		nameFail = new JLabel("FEL");
		nameFail.setForeground(Color.RED);
		nameFail.setVisible(false);
		
		dateFail = new JLabel("FEL");
		dateFail.setForeground(Color.RED);
		dateFail.setVisible(false);
		
		lblFel = new JLabel("Fel");
		lblFel.setForeground(Color.RED);
		lblFel.setVisible(false);
		
		// TODO more checks
		JButton okButton = new JButton("G\u00E5 Vidare");
		okButton.setToolTipText("G\u00E5 vidare till bekr\u00E4ftning");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (cardNumberLabel.getText().equals("") ||
						cardNumberLabel.getText().equals("Kortnummer") ||
						cvcLabel.getText().equals("cvc") ||
						nameLabel.getText().equals("Fullst‰ndigtnamn")
						|| cvcLabel.getText().equals("")
						|| nameLabel.getText().equals("")
						|| yyCombo.getSelectedItem().equals("≈≈")
						|| mmCombo.getSelectedItem().equals("MM") ||
						buttonGroup.isSelected(null)) {
					if (cardNumberLabel.getText().equals("") || cardNumberLabel.getText().equals("Kortnummer")) {
						cardFail.setVisible(true);
					}
					if (cvcLabel.getText().equals("") || cvcLabel.getText().equals("cvc")) {
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
					
					mf.swapCard("pay3");
					}catch(NumberFormatException e){
						cvcFail.setVisible(true);
					}
					
				}
			}
		});
		okButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(163)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(cvcLabel, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(cvcFail, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
											.addGap(14)
											.addComponent(yyCombo, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
											.addComponent(mmCombo, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(cardNumberLabel, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(cardFail, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(nameLabel, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(dateFail, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
										.addComponent(nameFail, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
									.addGap(106))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(backButton, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, 212, Short.MAX_VALUE)
											.addComponent(okButton))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(chckbx1, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
											.addComponent(chckbx2, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
											.addGap(29)
											.addComponent(chckbx3, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblFel, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(332)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)))
					.addGap(170))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(chckbx1)
						.addComponent(chckbx2)
						.addComponent(chckbx3)
						.addComponent(lblFel))
					.addGap(47)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(cardNumberLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(nameLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(cardFail)
						.addComponent(nameFail))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(cvcLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(mmCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(yyCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(cvcFail)
						.addComponent(dateFail))
					.addGap(46)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(okButton)
						.addComponent(backButton))
					.addContainerGap(121, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
}
