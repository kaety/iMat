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

public class Pay2 extends JPanel {
	private JTextField cardNumberLabel;
	private JTextField cvcLabel;
	private JTextField nameLabel;

	/**
	 * Create the panel.
	 */
	public Pay2(final MainFrame mf) {
		
		setBackground(Color.WHITE);
		
		JLabel label = new JLabel("2/3");
		label.setFont(new Font("Tahoma", Font.PLAIN, 19));
		
		JCheckBox chckbxVisamastercard = new JCheckBox("Visa/Mastercard");
		chckbxVisamastercard.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chckbxVisamastercard.setSelected(true);
		
		JCheckBox chckbxFaktura = new JCheckBox("Faktura");
		chckbxFaktura.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JCheckBox chckbxAvbetalning = new JCheckBox("Avbetalning");
		chckbxAvbetalning.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		cardNumberLabel = new JTextField();
		cardNumberLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cardNumberLabel.setText("Kortnummer");
		cardNumberLabel.setColumns(10);
		
		cvcLabel = new JTextField();
		cvcLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cvcLabel.setText("cvc");
		cvcLabel.setColumns(10);
		
		nameLabel = new JTextField();
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		nameLabel.setText("Fullst\u00E4ndigt namn");
		nameLabel.setColumns(10);
		
		JComboBox yyCombo = new JComboBox();
		yyCombo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		yyCombo.setModel(new DefaultComboBoxModel(new String[] {"\u00C5\u00C5", "13", "14", "15", "16", "17", "18"}));
		
		JComboBox mmCombo = new JComboBox();
		mmCombo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		mmCombo.setModel(new DefaultComboBoxModel(new String[] {"MM", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		
		JButton okButton = new JButton("G\u00E5 Vidare");
		okButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton backButton = new JButton("Tillbaka");
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mf.swapCard("pay1");
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(200)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(33)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(chckbxVisamastercard)
									.addGap(26)
									.addComponent(chckbxFaktura, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
									.addGap(29)
									.addComponent(chckbxAvbetalning, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
									.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
										.addComponent(cvcLabel, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(yyCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(mmCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
										.addComponent(cardNumberLabel, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(nameLabel, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))))))
					.addContainerGap(53, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(23)
					.addComponent(backButton, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
					.addGap(236)
					.addComponent(okButton)
					.addContainerGap(33, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(chckbxVisamastercard)
						.addComponent(chckbxFaktura)
						.addComponent(chckbxAvbetalning))
					.addGap(47)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(cardNumberLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(nameLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(cvcLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(mmCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(yyCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(37)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(okButton)
						.addComponent(backButton))
					.addContainerGap(60, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
}
