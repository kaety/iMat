package cards;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;

public class DetailedFoodView extends JPanel {

	/**
	 * Create the panel.
	 */
	public DetailedFoodView() {
		
		setBackground(Color.WHITE);
		
		JLabel picLabel = new JLabel("BILD");
		picLabel.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel priceLabel = new JLabel("Pris");
		priceLabel.setHorizontalAlignment(SwingConstants.LEFT);
		
		JPanel panel = new JPanel();
		
		JLabel productLabel = new JLabel("Matvara");
		productLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		productLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblNringsinnehll = new JLabel("N\u00E4ringsinneh\u00E5ll:");
		lblNringsinnehll.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JButton hideProduct = new JButton("D\u00F6lj vara");
		
		JButton backButton = new JButton("Tillbaka");
		
		JButton addButton = new JButton("L\u00E4gg Till");
		
		JComboBox ammountCombo = new JComboBox();
		ammountCombo.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9"}));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(99)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(priceLabel)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(picLabel)
							.addGap(107)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(productLabel)
								.addComponent(lblNringsinnehll))))
					.addContainerGap(135, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(hideProduct)
					.addGap(236)
					.addComponent(ammountCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(addButton, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(backButton)
					.addContainerGap(351, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(backButton)
							.addPreferredGap(ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
							.addComponent(picLabel))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(productLabel, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
							.addGap(11)
							.addComponent(lblNringsinnehll)))
					.addGap(55)
					.addComponent(priceLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(hideProduct, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(addButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(ammountCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel recipeLabel1 = new JLabel("Recept");
		recipeLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(recipeLabel1);
		
		JLabel recipeLabel2 = new JLabel("Recept");
		recipeLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(recipeLabel2);
		
		JLabel recipeLabel3 = new JLabel("Recept");
		recipeLabel3.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(recipeLabel3);
		setLayout(groupLayout);

	}
}
