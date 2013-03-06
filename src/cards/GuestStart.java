package cards;

import grp30.MainFrame;
import gui.IMatColors;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

import net.miginfocom.swing.MigLayout;
import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Product;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GuestStart extends JPanel {
	private JLabel buyPicLabel1;
	private JLabel buyPicLabel2;
	private JLabel buyPicLabel3;
	/**
	 * Create the panel.
	 */
	public GuestStart(final MainFrame mf, final DetailedFoodView df) {
		
		
		setBackground(IMatColors.BASE);
		
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
		
		JLabel recipePicLabel1 = new JLabel(new ImageIcon("dist/resources/recept1.jpg"));
		recipePicLabel1.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel recipePicLabel2 = new JLabel(new ImageIcon("dist/resources/recept2.jpg"));
		recipePicLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel recipePicLabel3 = new JLabel(new ImageIcon("dist/resources/recept3.jpg"));
		recipePicLabel3.setHorizontalAlignment(SwingConstants.RIGHT);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(34)
					.addComponent(recipePicLabel1, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
					.addGap(71)
					.addComponent(recipePicLabel2, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
					.addGap(75)
					.addComponent(recipePicLabel3, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
					.addGap(49))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(83)
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(90))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(recipePicLabel2, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
						.addComponent(recipePicLabel3, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
						.addComponent(recipePicLabel1, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
					.addGap(26))
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblNewLabel = new JLabel("iMat Som ICA fast bättre!");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		
		JButton btnRegistreraDigRedan = new JButton("Registrera dig redan idag f\u00F6r finfina erbjudanden!");
		btnRegistreraDigRedan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mf.swapCard("register");
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
					.addGap(11))
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addGap(11)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addGap(319)
					.addComponent(btnRegistreraDigRedan)
					.addContainerGap(333, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(16)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnRegistreraDigRedan)
					.addPreferredGap(ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel_2.setLayout(new MigLayout("", "[269.00,grow][58.00][0.00][334.00,grow][grow]", "[grow][grow]"));
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(255, 255, 255));
		panel_2.add(panel_9, "cell 0 0,grow");
		
		//PRESS ON IMAGE
		
		buyPicLabel1 = new JLabel(IMatDataHandler.getInstance().getImageIcon(IMatDataHandler.getInstance().getProduct(34), 150, 150));
		buyPicLabel1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				df.setActiveProduct2(IMatDataHandler.getInstance().getProduct(34));
				mf.swapCard("details");
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				buyPicLabel1.setBorder(BorderFactory.createLineBorder(Color.black));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				buyPicLabel1.setBorder(BorderFactory.createLineBorder(Color.white));
			}
		});
		buyPicLabel1.setToolTipText("Tryck h\u00E4r f\u00F6r att se erbjudandet");
		GroupLayout gl_panel_9 = new GroupLayout(panel_9);
		gl_panel_9.setHorizontalGroup(
			gl_panel_9.createParallelGroup(Alignment.LEADING)
				.addComponent(buyPicLabel1, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
		);
		gl_panel_9.setVerticalGroup(
			gl_panel_9.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_9.createSequentialGroup()
					.addComponent(buyPicLabel1)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_9.setLayout(gl_panel_9);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(255, 255, 255));
		panel_2.add(panel_8, "cell 3 0,grow");
		
		buyPicLabel2 = new JLabel(IMatDataHandler.getInstance().getImageIcon(IMatDataHandler.getInstance().getProduct(78), 150, 150));
		buyPicLabel2.setToolTipText("Tryck h\u00E4r f\u00F6r att se erbjudandet");
		
		//PRESS ON IMAGE
		
		buyPicLabel2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				df.setActiveProduct2(IMatDataHandler.getInstance().getProduct(78));
				mf.swapCard("details");
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				buyPicLabel2.setBorder(BorderFactory.createLineBorder(Color.black));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				buyPicLabel2.setBorder(BorderFactory.createLineBorder(Color.white));
			}
		});
		buyPicLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_panel_8 = new GroupLayout(panel_8);
		gl_panel_8.setHorizontalGroup(
			gl_panel_8.createParallelGroup(Alignment.TRAILING)
				.addComponent(buyPicLabel2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
		);
		gl_panel_8.setVerticalGroup(
			gl_panel_8.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel_8.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(buyPicLabel2))
		);
		panel_8.setLayout(gl_panel_8);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(255, 255, 255));
		panel_2.add(panel_6, "cell 4 0,grow");
		
		buyPicLabel3 = new JLabel(IMatDataHandler.getInstance().getImageIcon(IMatDataHandler.getInstance().getProduct(55), 150, 150));
		buyPicLabel3.setToolTipText("Tryck h\u00E4r f\u00F6r att se erbjudandet");
		buyPicLabel3.addMouseListener(new MouseAdapter() {
			
			//PRESS ON IMAGE
			
			@Override
			public void mouseClicked(MouseEvent e) {
				df.setActiveProduct2(IMatDataHandler.getInstance().getProduct(55));
				mf.swapCard("details");
			}
			public void mouseEntered(MouseEvent arg0) {
				buyPicLabel3.setBorder(BorderFactory.createLineBorder(Color.black));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				buyPicLabel3.setBorder(BorderFactory.createLineBorder(Color.white));
			}
		});
		GroupLayout gl_panel_6 = new GroupLayout(panel_6);
		gl_panel_6.setHorizontalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addComponent(buyPicLabel3, GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
		);
		gl_panel_6.setVerticalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addComponent(buyPicLabel3, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
		);
		panel_6.setLayout(gl_panel_6);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(new Color(255, 255, 255));
		panel_2.add(panel_10, "cell 0 1,grow");
		Product p1 = IMatDataHandler.getInstance().getProduct(34);
		Product p2 = IMatDataHandler.getInstance().getProduct(55);
		Product p3 = IMatDataHandler.getInstance().getProduct(78);
		JLabel priceLabel1 = new JLabel(p1.getName() + " för " + p1.getPrice() + p1.getUnit());
		priceLabel1.setVerticalAlignment(SwingConstants.BOTTOM);
		priceLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_panel_10 = new GroupLayout(panel_10);
		gl_panel_10.setHorizontalGroup(
			gl_panel_10.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_10.createSequentialGroup()
					.addContainerGap()
					.addComponent(priceLabel1, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_10.setVerticalGroup(
			gl_panel_10.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_10.createSequentialGroup()
					.addContainerGap()
					.addComponent(priceLabel1)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_10.setLayout(gl_panel_10);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(255, 255, 255));
		panel_2.add(panel_7, "cell 3 1,grow");
		
		JLabel priceLabel2 = new JLabel(p3.getName() + " för " + p3.getPrice() + p3.getUnit());
		priceLabel2.setVerticalAlignment(SwingConstants.BOTTOM);
		priceLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_panel_7 = new GroupLayout(panel_7);
		gl_panel_7.setHorizontalGroup(
			gl_panel_7.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_7.createSequentialGroup()
					.addContainerGap()
					.addComponent(priceLabel2, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_7.setVerticalGroup(
			gl_panel_7.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_7.createSequentialGroup()
					.addContainerGap()
					.addComponent(priceLabel2)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_7.setLayout(gl_panel_7);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 255, 255));
		panel_2.add(panel_5, "cell 4 1,grow");
		
		JLabel priceLabel3 = new JLabel(p2.getName() + " för " + p2.getPrice() + p2.getUnit());
		priceLabel3.setVerticalAlignment(SwingConstants.BOTTOM);
		priceLabel3.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addContainerGap()
					.addComponent(priceLabel3, GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_5.setVerticalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addContainerGap()
					.addComponent(priceLabel3)
					.addContainerGap(14, Short.MAX_VALUE))
		);
		panel_5.setLayout(gl_panel_5);
		panel.setLayout(gl_panel);
		setLayout(groupLayout);

	}
}
	
