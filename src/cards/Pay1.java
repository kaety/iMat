package cards;

import java.awt.Color;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;

public class Pay1 extends JPanel {
	private JTextField firstLabel;
	private JTextField addressLabel;
	private JTextField tNumberLabel;
	private JTextField lastLabel;
	private JTextField cityLabel;
	private JTextField mailLabel;
	private JTextField pNumbLabel;
	private JTextField pCodeLabel;

	/**
	 * Create the panel.
	 */
	public Pay1() {
		
		setBackground(Color.WHITE);
		
		firstLabel = new JTextField();
		firstLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		firstLabel.setText("F\u00F6rnamn");
		firstLabel.setColumns(10);
		
		addressLabel = new JTextField();
		addressLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		addressLabel.setText("Address");
		addressLabel.setColumns(10);
		
		tNumberLabel = new JTextField();
		tNumberLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tNumberLabel.setText("Telefon");
		tNumberLabel.setColumns(10);
		
		lastLabel = new JTextField();
		lastLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lastLabel.setText("Efternamn");
		lastLabel.setColumns(10);
		
		cityLabel = new JTextField();
		cityLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cityLabel.setText("Postaddress");
		cityLabel.setColumns(10);
		
		mailLabel = new JTextField();
		mailLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		mailLabel.setText("E-Mail");
		mailLabel.setColumns(10);
		
		pNumbLabel = new JTextField();
		pNumbLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		pNumbLabel.setText("Personnummer");
		pNumbLabel.setColumns(10);
		
		pCodeLabel = new JTextField();
		pCodeLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		pCodeLabel.setText("Postnummer");
		pCodeLabel.setColumns(10);
		
		JButton okButton = new JButton("G\u00E5 Vidare");
		okButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel label = new JLabel("1/3");
		label.setFont(new Font("Tahoma", Font.PLAIN, 19));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(41)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(firstLabel, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
						.addComponent(addressLabel, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
						.addComponent(tNumberLabel, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lastLabel, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(pNumbLabel, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE))
						.addComponent(mailLabel, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addComponent(okButton)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(cityLabel, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(pCodeLabel, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(37, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(200)
					.addComponent(label)
					.addContainerGap(223, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(label)
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(firstLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lastLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(pNumbLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(addressLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(cityLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(pCodeLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(tNumberLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(mailLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(65)
					.addComponent(okButton)
					.addContainerGap(53, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
}
