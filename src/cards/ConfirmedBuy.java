package cards;

import grp30.MainFrame;

import java.awt.Color;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConfirmedBuy extends JPanel {

	/**
	 * Create the panel.
	 */
	public ConfirmedBuy(final MainFrame mf) {
		
		setBackground(Color.WHITE);
		
		JLabel lblNewLabel = new JLabel("Tack f\u00F6r din best\u00E4llning!");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		JLabel lblDittKvittoHar = new JLabel("Ditt kvitto har skickats till din mail men");
		lblDittKvittoHar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblDuKanven = new JLabel("du kan \u00E4ven se det");
		lblDuKanven.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton lblNewLabel_1 = new JButton("H\u00E4r");
		lblNewLabel_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mf.swapCard("receipt");
			}
		});
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton lblLoggaUt = new JButton("Logga Ut");
		lblLoggaUt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mf.swapCard("startGuest");
			}
		});
		lblLoggaUt.setForeground(Color.BLUE);
		lblLoggaUt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(67)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
					.addGap(61))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(106)
					.addComponent(lblDittKvittoHar, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
					.addGap(113))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(146)
					.addComponent(lblDuKanven, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_1)
					.addGap(160))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(192)
					.addComponent(lblLoggaUt, GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
					.addGap(195))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(20)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblDittKvittoHar, GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDuKanven, GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)
						.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(50)
					.addComponent(lblLoggaUt, GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)
					.addGap(125))
		);
		setLayout(groupLayout);

	}
}
