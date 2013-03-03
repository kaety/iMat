package cards;

import grp30.MainFrame;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import se.chalmers.ait.dat215.project.IMatDataHandler;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Pay3 extends JPanel {
	private JLabel nameLabel;
	private JLabel addressLabel;
	private JLabel cityLabel;
	private JLabel numberLabel;
	private JLabel totalLabel;
	
	
	
	/**
	 * Create the panel.
	 */
	public Pay3(final MainFrame mf) {
		
		setBackground(Color.WHITE);
		
		nameLabel = new JLabel();
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		addressLabel = new JLabel();
		addressLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		cityLabel = new JLabel();
		cityLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		numberLabel = new JLabel();
		numberLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblTotalsumma = new JLabel("Totalsumma:");
		lblTotalsumma.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		totalLabel = new JLabel();
		totalLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton confirmButton = new JButton("Bekr\u00E4fta");
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mf.swapCard("confirmed");
			}
		});
		confirmButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton backButton = new JButton("Tillbaka");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mf.swapCard("pay2");
			}
		});
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

	public void updateInfo() {
		nameLabel.setText(IMatDataHandler.getInstance().getCustomer().getFirstName()+" "+
		IMatDataHandler.getInstance().getCustomer().getLastName());
		addressLabel.setText(IMatDataHandler.getInstance().getCustomer().getAddress());
		cityLabel.setText(IMatDataHandler.getInstance().getCustomer().getPostCode()+" "+
				IMatDataHandler.getInstance().getCustomer().getPostAddress());
		numberLabel.setText(IMatDataHandler.getInstance().getCustomer().getMobilePhoneNumber());
		totalLabel.setText(IMatDataHandler.getInstance().getShoppingCart().getTotal()+"");
	}

}
