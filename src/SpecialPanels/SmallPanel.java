package SpecialPanels;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;

public class SmallPanel extends JPanel {
	Color panelColor;
	private final Color highLightColor = Color.WHITE; //The color when mouse hover
	private final Color lightColor = Color.PINK;      //Light striping color
	private final Color darkColor = Color.CYAN;		  //Dark -||-
	/**
	 * Create the panel.
	 */
	public SmallPanel(boolean light) {
		if(light) setBackground(lightColor);
		else setBackground(darkColor);
		
		JButton btnA = new JButton("A 1");
		
		JButton btnA_1 = new JButton("A 2");
		
		JLabel lblLabel = new JLabel("Label");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblLabel)
					.addPreferredGap(ComponentPlacement.RELATED, 290, Short.MAX_VALUE)
					.addComponent(btnA_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnA))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
					.addComponent(btnA, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
					.addComponent(btnA_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addComponent(lblLabel))
		);
		setLayout(groupLayout);

	}
}
