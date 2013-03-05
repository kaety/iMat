package cards;

import grp30.MainFrame;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuestStart extends JPanel {

	/**
	 * Create the panel.
	 */
	public GuestStart(final MainFrame mf, final DetailedFoodView df) {
		
		setBackground(Color.WHITE);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel.setBackground(Color.WHITE);
		
		JLabel recipePicLabel1 = new JLabel("Bild");
		recipePicLabel1.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel recipePicLabel2 = new JLabel("Bild");
		recipePicLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel recipePicLabel3 = new JLabel("Bild");
		recipePicLabel3.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel label_3 = new JLabel("Recept");
		label_3.setVerticalAlignment(SwingConstants.TOP);
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 432, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(25)
					.addComponent(recipePicLabel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(167)
					.addComponent(recipePicLabel2, GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE)
					.addGap(169)
					.addComponent(recipePicLabel3, GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE)
					.addGap(23))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(172)
					.addComponent(label_3, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
					.addGap(172))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 114, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(label_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(40)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(recipePicLabel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(recipePicLabel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(recipePicLabel2, GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE))
					.addGap(46))
		);
		panel.setLayout(gl_panel);
		
		JLabel lblSomIcaFast = new JLabel("Som ICA, fast b\u00E4ttre!");
		lblSomIcaFast.setHorizontalAlignment(SwingConstants.CENTER);
		lblSomIcaFast.setVerticalAlignment(SwingConstants.TOP);
		lblSomIcaFast.setFont(new Font("Tahoma", Font.PLAIN, 29));
		
		JLabel picLabel1 = new JLabel("BILD");
		picLabel1.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel picLabel3 = new JLabel("BILD");
		picLabel3.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel picLabel2 = new JLabel("BILD");
		picLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnRegistreraDaj = new JButton("Registrera dig, cykel p\u00E5 k\u00F6pet! Extra erbjudande endast idag!");
		btnRegistreraDaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mf.swapCard("register");
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(12)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 726, Short.MAX_VALUE)
					.addGap(8))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(84)
					.addComponent(lblSomIcaFast, GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
					.addGap(98))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(45)
					.addComponent(picLabel1, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
					.addGap(137)
					.addComponent(picLabel2, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
					.addGap(146)
					.addComponent(picLabel3, GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
					.addGap(58))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(197)
					.addComponent(btnRegistreraDaj, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(220))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblSomIcaFast)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnRegistreraDaj)
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(picLabel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(picLabel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(picLabel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(64)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 114, Short.MAX_VALUE)
					.addContainerGap())
		);
		setLayout(groupLayout);

	}
}
