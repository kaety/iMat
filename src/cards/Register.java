package cards;

import grp30.MainFrame;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JPasswordField;

import se.chalmers.ait.dat215.project.IMatDataHandler;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Register extends JPanel {
	private JTextField mailField;
	private JTextField passField;
	private JLabel fel1;
	private JLabel fel3;

	/**
	 * Create the panel.
	 */
	public Register(final MainFrame mf, final Pay1 pay1) {
		
		setBackground(Color.WHITE);
		
		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(265)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 368, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(281, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(113)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(128, Short.MAX_VALUE))
		);
		
		mailField = new JTextField();
		mailField.setHorizontalAlignment(SwingConstants.CENTER);
		mailField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mailField.setColumns(10);
		
		passField = new JTextField();
		
		passField.setHorizontalAlignment(SwingConstants.CENTER);
		passField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		passField.setForeground(Color.BLACK);
		passField.setColumns(10);
		
		
		JLabel lblNewLabel = new JLabel("E-Mail:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1 = new JLabel("L\u00F6senord:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		fel1 = new JLabel("Ogiltlig EMAIL");
		fel1.setForeground(Color.RED);
		fel1.setVisible(false);
		
		fel3 = new JLabel("F\u00F6r kort L\u00F6senord, minst 8 tecken");
		fel3.setForeground(Color.RED);
		fel3.setVisible(false);
		
		JButton regButton = new JButton("Registrera");
		regButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(mailField.getText().equals("")  || passField.getText().length() < 8){
					
					if(mailField.getText().equals("")){
						fel1.setVisible(true);
						
					}
					if( passField.getText().length() < 8){
						fel3.setVisible(true);
					}
					
				}
				else{
					//SAVE USERNAME AND PASSWORD
					System.out.println(passField.getText());
					IMatDataHandler.getInstance().getUser().setUserName(mailField.getText());
					IMatDataHandler.getInstance().getUser().setPassword(passField.getText());
					IMatDataHandler.getInstance().getCustomer().setEmail(mailField.getText());
					mf.setUser();
					
					pay1.updateInfo();
					
					mf.swapCard("startUser");
					
					
				}
			}
		});
		
		
		
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(79)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(lblNewLabel_1)
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
											.addComponent(fel1)
											.addComponent(lblNewLabel)))
									.addGap(18)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(passField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(mailField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(regButton)
									.addGap(12))))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(fel3)))
					.addContainerGap(100, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(45)
					.addComponent(fel1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE, false)
						.addComponent(mailField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(4)
							.addComponent(lblNewLabel)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(fel3)
					.addGap(11)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE, false)
						.addComponent(passField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(4)
							.addComponent(lblNewLabel_1)))
					.addGap(18)
					.addComponent(regButton)
					.addContainerGap(64, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		setLayout(groupLayout);
		

	}
}
