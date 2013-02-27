package cards;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;

public class Pay3 extends JPanel {

	/**
	 * Create the panel.
	 */
	public Pay3() {
		
		setBackground(Color.WHITE);
		
		JLabel nameLabel = new JLabel("Per Thoresson");
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel addressLabel = new JLabel("Fj\u00E4rde L\u00E5nggatan 26");
		addressLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel cityLabel = new JLabel("41327 G\u00F6teborg");
		cityLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel numberLabel = new JLabel("0735924885");
		numberLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblTotalsumma = new JLabel("Totalsumma:");
		lblTotalsumma.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel totalLabel = new JLabel("7562:-");
		totalLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton confirmButton = new JButton("Bekr\u00E4fta");
		confirmButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton backButton = new JButton("Tillbaka");
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(38)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(nameLabel)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(numberLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(cityLabel, GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE))
									.addGap(126)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblTotalsumma)
										.addComponent(totalLabel)))
								.addComponent(addressLabel, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(25)
							.addComponent(backButton)
							.addGap(249)
							.addComponent(confirmButton)))
					.addContainerGap(20, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(36)
					.addComponent(nameLabel)
					.addGap(18)
					.addComponent(addressLabel)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(cityLabel)
						.addComponent(lblTotalsumma))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(numberLabel)
						.addComponent(totalLabel))
					.addGap(63)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(backButton)
						.addComponent(confirmButton))
					.addContainerGap(68, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}

}
