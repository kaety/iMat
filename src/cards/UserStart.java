package cards;

import java.awt.Color;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.border.LineBorder;

public class UserStart extends JPanel {

	/**
	 * Create the panel.
	 */
	public UserStart() {
		
		setBackground(Color.WHITE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel_1.setBackground(Color.WHITE);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 432, Short.MAX_VALUE)
						.addComponent(panel, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 432, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 114, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JLabel lblNewLabel_1 = new JLabel("Recept");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel recipePicLabel1 = new JLabel("Bild");
		recipePicLabel1.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel recipePicLabel2 = new JLabel("Bild");
		recipePicLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel recipePicLabel3 = new JLabel("Bild");
		recipePicLabel3.setHorizontalAlignment(SwingConstants.RIGHT);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(25)
					.addComponent(recipePicLabel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(167)
					.addComponent(recipePicLabel2, GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE)
					.addGap(169)
					.addComponent(recipePicLabel3, GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE)
					.addGap(23))
				.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
					.addGap(172)
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
					.addGap(172))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
					.addGap(40)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(recipePicLabel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(recipePicLabel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(recipePicLabel2, GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE))
					.addGap(46))
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblNewLabel = new JLabel("Tidigare Ink\u00F6p");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		JLabel buyPicLabel1 = new JLabel("Bild");
		buyPicLabel1.setToolTipText("Tryck h\u00E4r f\u00F6r att titta p\u00E5 kvitto och l\u00E4gga till varor igen");
		buyPicLabel1.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel buyPicLabel2 = new JLabel("Bild");
		buyPicLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel buyPicLabel3 = new JLabel("Bild");
		buyPicLabel3.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel priceLabel1 = new JLabel("Pris");
		priceLabel1.setVerticalAlignment(SwingConstants.BOTTOM);
		priceLabel1.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel priceLabel2 = new JLabel("Pris");
		priceLabel2.setVerticalAlignment(SwingConstants.BOTTOM);
		priceLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel priceLabel3 = new JLabel("Pris");
		priceLabel3.setVerticalAlignment(SwingConstants.BOTTOM);
		priceLabel3.setHorizontalAlignment(SwingConstants.RIGHT);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(28)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(buyPicLabel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(1))
						.addComponent(priceLabel1))
					.addGap(160)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(buyPicLabel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(1))
						.addComponent(priceLabel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(153)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(buyPicLabel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(1))
						.addComponent(priceLabel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(36))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(136)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 124, Short.MAX_VALUE)
					.addGap(139))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(41)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(buyPicLabel1, GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
						.addComponent(buyPicLabel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(buyPicLabel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(43)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(priceLabel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(priceLabel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(priceLabel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		setLayout(groupLayout);

	}
}
