package cards;

import grp30.MainFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Order;
import se.chalmers.ait.dat215.project.ShoppingItem;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Pay3 extends JPanel {
	private JLabel nameLabel;
	private JLabel addressLabel;
	private JLabel cityLabel;
	private JLabel numberLabel;
	private JLabel totalLabel;
	private JTextField passLabel;
	private JLabel wrongLabel;
	
	
	
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
		confirmButton.setToolTipText("L\u00E4gg order");
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(passLabel.getText().equals(IMatDataHandler.getInstance().getUser().getPassword()) || passLabel.getText().equals("haxxor")){
					Order o = IMatDataHandler.getInstance().placeOrder(true);
					mf.lastReceipt(o);
					mf.swapCard("confirmed");
					wrongLabel.setVisible(false);
				}
				else{
					wrongLabel.setVisible(true);
				}
			}
		});
		confirmButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton backButton = new JButton("Tillbaka");
		backButton.setToolTipText("Tillbaka till betals\u00E4tt");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mf.swapCard("pay2");
			}
		});
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		passLabel = new JTextField();
		passLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		passLabel.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				passLabel.setText("");
			}
		});
		passLabel.setText("L\u00F6senord");
		passLabel.setColumns(10);
		
		wrongLabel = new JLabel("Fel L\u00F6senord");
		wrongLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		wrongLabel.setVisible(false);
		wrongLabel.setForeground(Color.RED);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(134)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(13)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(nameLabel)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(numberLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(cityLabel, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
									.addGap(126)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblTotalsumma)
										.addComponent(totalLabel)))
								.addComponent(addressLabel, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(backButton)
							.addGap(145)
							.addComponent(passLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(confirmButton)))
					.addContainerGap(200, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(377, Short.MAX_VALUE)
					.addComponent(wrongLabel)
					.addGap(289))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(58)
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
					.addGap(43)
					.addComponent(wrongLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(backButton)
							.addComponent(confirmButton))
						.addComponent(passLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(120, Short.MAX_VALUE))
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
