package cards;

import grp30.MainFrame;

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

	/**
	 * Create the panel.
	 */
	public Pay1(final MainFrame mf,final Pay3 pay3) {
		
		setBackground(Color.WHITE);
		
		firstLabel = new JTextField();
		firstLabel.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				firstLabel.setText("");
			}
		});
		firstLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		firstLabel.setColumns(10);
		
		addressLabel = new JTextField();
		addressLabel.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				addressLabel.setText("");
			}
		});
		addressLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		addressLabel.setColumns(10);
		
		tNumberLabel = new JTextField();
		tNumberLabel.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tNumberLabel.setText("");
			}
		});
		tNumberLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		tNumberLabel.setColumns(10);
		
		lastLabel = new JTextField();
		lastLabel.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				lastLabel.setText("");
			}
		});
		lastLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		lastLabel.setColumns(10);
		
		cityLabel = new JTextField();
		cityLabel.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				cityLabel.setText("");
			}
		});
		cityLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		cityLabel.setColumns(10);
		
		mailLabel = new JTextField();
		mailLabel.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				mailLabel.setText("");
			}
		});
		mailLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		mailLabel.setColumns(10);
		
		homePhoneLabel = new JTextField();
		homePhoneLabel.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				homePhoneLabel.setText("");
			}
		});
		homePhoneLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		homePhoneLabel.setColumns(10);
		
		pCodeLabel = new JTextField();
		pCodeLabel.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				pCodeLabel.setText("");
			}
		});
		pCodeLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		pCodeLabel.setText("Postnummer");
		pCodeLabel.setColumns(10);
			//IF we have first name, we have also other info
			if(!IMatDataHandler.getInstance().getCustomer().getFirstName().equals("")){
			firstLabel.setText(IMatDataHandler.getInstance().getCustomer().getFirstName());
			addressLabel.setText(IMatDataHandler.getInstance().getCustomer().getAddress());
			tNumberLabel.setText(IMatDataHandler.getInstance().getCustomer().getMobilePhoneNumber());
			lastLabel.setText(IMatDataHandler.getInstance().getCustomer().getLastName());
			mailLabel.setText(IMatDataHandler.getInstance().getCustomer().getEmail());
			homePhoneLabel.setText(IMatDataHandler.getInstance().getCustomer().getPhoneNumber());
			cityLabel.setText(IMatDataHandler.getInstance().getCustomer().getPostAddress());
			pCodeLabel.setText(IMatDataHandler.getInstance().getCustomer().getPostCode());}
			else{
				firstLabel.setText("F�rnamn");
				addressLabel.setText("Adress");
				lastLabel.setText("Efternamn");
				homePhoneLabel.setText("Hemtelefon");
				mailLabel.setText("E-Mail");
				cityLabel.setText("Postadress");
				tNumberLabel.setText("Mobilnummer");
				pCodeLabel.setText("Postkod");
				
				
			}
			
			
			
			
			
		

		
		JButton okButton = new JButton("G\u00E5 Vidare");
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
					
					pay3.updateInfo();
					
					mf.swapCard("pay2");
					
				}
				
				
				
				
					
					
					
					
				
				
			}
		});
		okButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel label = new JLabel("1/3");
		label.setFont(new Font("Tahoma", Font.PLAIN, 19));
		
		l1 = new JLabel("Fel");
		l1.setForeground(Color.RED);
		l1.setVisible(false);
		
		l2 = new JLabel("Fel");
		l2.setForeground(Color.RED);
		l2.setVisible(false);
		
		l3 = new JLabel("Fel");
		l3.setForeground(Color.RED);
		l3.setVisible(false);
		
		l4 = new JLabel("Fel");
		l4.setForeground(Color.RED);
		l4.setVisible(false);
		
		l5 = new JLabel("Fel");
		l5.setForeground(Color.RED);
		l5.setVisible(false);
		
		l6 = new JLabel("Fel");
		l6.setForeground(Color.RED);
		l6.setVisible(false);
		
		l7 = new JLabel("Fel");
		l7.setForeground(Color.RED);
		l7.setVisible(false);
		
		l8 = new JLabel("Fel");
		l8.setForeground(Color.RED);
		l8.setVisible(false);
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(41)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(firstLabel, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(l1))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(addressLabel, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(l2, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(tNumberLabel, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(l3)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lastLabel, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(mailLabel, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
								.addGap(18))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(cityLabel, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
								.addGap(18))))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(18)
									.addComponent(l5, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(18)
									.addComponent(l4, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(homePhoneLabel, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
										.addComponent(pCodeLabel, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(l8, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
										.addComponent(l7))
									.addGap(25))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(okButton)
									.addContainerGap(132, Short.MAX_VALUE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(l6)
							.addContainerGap())))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(200)
					.addComponent(label)
					.addContainerGap(344, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(label)
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(firstLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(l1)
						.addComponent(l7)
						.addComponent(homePhoneLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lastLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(l4))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(addressLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(l2)
						.addComponent(l8)
						.addComponent(pCodeLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(cityLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(l5))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(tNumberLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(l3)
						.addComponent(mailLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(l6))
					.addGap(65)
					.addComponent(okButton)
					.addContainerGap(45, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
}
