package cards;

import grp30.MainFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

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
import javax.swing.JPasswordField;
import net.miginfocom.swing.MigLayout;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class Pay3 extends JPanel {
	private JLabel nameLabel;
	private JLabel addressLabel;
	private JLabel cityLabel;
	private JLabel numberLabel;
	private JLabel totalLabel;
	private JTextField passLabel;
	private JLabel wrongLabel;
	private JLabel lblBekrftaLsenord;
	private JLabel lblNewLabel;
	
	
	
	/**
	 * Create the panel.
	 */
	public Pay3(final MainFrame mf, final History history) {
		
		setBackground(Color.WHITE);
		setLayout(new MigLayout("", "[150][112px][10][29px][30][112px][10][49px][10][89px][40][14px]", "[44px][23px][22px][22px][22px][22px][22px][30px][22px][40px][25px]"));
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Pay3.class.getResource("/resources/pay3.png")));
		add(lblNewLabel, "cell 5 1");
		
		nameLabel = new JLabel();
		nameLabel.setText("Namn");
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(nameLabel, "cell 1 3,growx,aligny center");
		
		addressLabel = new JLabel();
		addressLabel.setText("address");
		addressLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(addressLabel, "cell 1 4,alignx left,aligny center");
		
		cityLabel = new JLabel();
		cityLabel.setText("Stad");
		cityLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(cityLabel, "cell 1 5,growx,aligny center");
		
		JLabel lblTotalsumma = new JLabel("Totalsumma:");
		lblTotalsumma.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblTotalsumma, "cell 5 5,alignx left,aligny center");
		
		numberLabel = new JLabel();
		numberLabel.setText("telefon");
		numberLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(numberLabel, "cell 1 6,growx,aligny center");
		
		totalLabel = new JLabel();
		totalLabel.setText("totalsumma");
		totalLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(totalLabel, "cell 5 6,alignx left,aligny center");
		
		JButton backButton = new JButton("Tillbaka");
		backButton.setToolTipText("Tillbaka till betals\u00E4tt");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mf.swapCard("pay2");
			}
		});
		

		
		wrongLabel = new JLabel("Fel L\u00F6senord");
		wrongLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		wrongLabel.setVisible(false);
		wrongLabel.setForeground(Color.RED);
		add(wrongLabel, "cell 7 9,alignx left,aligny bottom");
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(backButton, "cell 1 10,alignx left,aligny center");
		
		
		JButton confirmButton = new JButton("L\u00E4gg Order");
		confirmButton.setToolTipText("L\u00E4gg order");
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
				if(IMatDataHandler.getInstance().getUser().getPassword().equals(passLabel.getText())){
					Order o = IMatDataHandler.getInstance().placeOrder(true);
					mf.lastReceipt(o);
					mf.swapCard("confirmed");
					history.updateHistory();
					wrongLabel.setVisible(false);
				}
				else{
					wrongLabel.setVisible(true);
				}
			}
		});
		
		passLabel = new JTextField();
		passLabel.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				passLabel.setText("");
			}
		});
		
		lblBekrftaLsenord = new JLabel("Bekr\u00E4fta L\u00F6senord:");
		add(lblBekrftaLsenord, "cell 5 10,alignx right");
		passLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		passLabel.setText("L\u00F6senord");
		passLabel.setColumns(10);
		add(passLabel, "cell 7 10,alignx right,aligny center");
		confirmButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(confirmButton, "cell 9 10,alignx left,aligny center");

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
	
	public void erasePassword(){
		passLabel.setText("");
	}
	
	public void checkForUser(){
		if(IMatDataHandler.getInstance().getUser().getUserName().equals("")){
			passLabel.setVisible(false);
			lblBekrftaLsenord.setVisible(false);
		}
		else{
			passLabel.setVisible(true);
			lblBekrftaLsenord.setVisible(true);
		}
	}
}
