package cards;


import grp30.MainFrame;
import grp30.RecipeGenerator;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Product;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DetailedFoodView extends JPanel {
	Product activeProduct;
	/**
	 * Create the panel.
	 */
	JLabel picLabel;
	JLabel priceLabel;
	JPanel panel;
	JLabel productLabel;
	
	JLabel recipeLabel1;
	JLabel recipeLabel2;
	JLabel recipeLabel3;
	private JTextPane txtpnPerGram;
	
	public DetailedFoodView(final MainFrame mf) {
		
		setBackground(Color.WHITE);
		
		picLabel = new JLabel();
		picLabel.setText("BILD");
		picLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		priceLabel = new JLabel("Pris");
		priceLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		priceLabel.setHorizontalAlignment(SwingConstants.LEFT);
		
		panel = new JPanel();
		
		productLabel = new JLabel("Matvara");
		productLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		productLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblNringsinnehll = new JLabel("N\u00E4ringsinneh\u00E5ll:");
		lblNringsinnehll.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNringsinnehll.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JButton backButton = new JButton("Tillbaka");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mf.swapCard("searchResults");
			}
		});
		
		JButton addButton = new JButton("L\u00E4gg Till");
		
		JComboBox ammountCombo = new JComboBox();
		ammountCombo.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9"}));
		
		JLabel lblNewLabel = new JLabel("Produktbeskrivning:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JTextPane txtpnLoremIpsumDolor = new JTextPane();
		txtpnLoremIpsumDolor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtpnLoremIpsumDolor.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin nisl neque, ultricies a pellentesque eget, ullamcorper ut lacus. Fusce ac sapien erat, quis viverra lacus.");
		
		txtpnPerGram = new JTextPane();
		txtpnPerGram.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtpnPerGram.setText("Per 100 gram\r\n\r\nKcal/KJ\t260/900\r\nProtein\t12 gr\r\nKolhydrater\t8 gr\r\nFett\t10 gr\r\n");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 727, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(picLabel, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(18)
									.addComponent(backButton)
									.addGap(82)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(22)
											.addComponent(priceLabel))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(productLabel)
											.addGap(82)
											.addComponent(ammountCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(addButton, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)))
									.addGap(33))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(10)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(txtpnLoremIpsumDolor, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel))
									.addPreferredGap(ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(txtpnPerGram, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNringsinnehll))
									.addGap(3)))))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(productLabel)
								.addComponent(addButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(ammountCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(priceLabel)
							.addGap(32)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel)
								.addComponent(lblNringsinnehll))
							.addGap(11)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(txtpnLoremIpsumDolor, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtpnPerGram, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE))
							.addGap(28))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(backButton)
								.addComponent(picLabel, GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		recipeLabel1 = new JLabel("Recept");
		recipeLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(recipeLabel1);
		
		recipeLabel2 = new JLabel("Recept");
		recipeLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(recipeLabel2);
		
		recipeLabel3 = new JLabel("Recept");
		recipeLabel3.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(recipeLabel3);
		setLayout(groupLayout);

	}
	
	public void setActiveProduct(Product p){
		picLabel.setIcon(IMatDataHandler.getInstance().getImageIcon(p, 170, 170));
		priceLabel.setText(p.getPrice() + "kr / "+ p.getUnitSuffix());
		productLabel.setText(p.getName());
		RecipeGenerator r = new RecipeGenerator();
		recipeLabel1.setText(r.getNewRecipe(p.getName()));
		recipeLabel2.setText(r.getNewRecipe(p.getName()));
		recipeLabel3.setText(r.getNewRecipe(p.getName()));
	}
}
