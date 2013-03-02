package SpecialPanels;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ShoppingItem;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;

public class ShoppingCartPanel extends JPanel{
	private JTextField textField;
	private JTextField textField_1;
	ShoppingItem p;
	Color lightColor = Color.LIGHT_GRAY;
	Color darkColor = Color.white;
	boolean b;
	private final Action action = new SwingAction();
	public ShoppingCartPanel(final ShoppingItem p, boolean b) {
		this.b = b;
		this.p = p;
		if(b)setBackground(lightColor);
		else setBackground(darkColor);
		JLabel lblNewLabel = new JLabel(p.getProduct().getName());
		JLabel lblNewLabel_1 = new JLabel(p.getProduct().getUnitSuffix() + " för " + p.getProduct().getPrice() + " " + p.getProduct().getUnit());
		
		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode() == KeyEvent.VK_ENTER){
					IMatDataHandler.getInstance().getShoppingCart().removeItem(p);
					p.setAmount(Double.parseDouble(textField_1.getText()));
					IMatDataHandler.getInstance().getShoppingCart().addItem(p);
				}
			}
		});
		textField_1.setColumns(4);
		textField_1.setText(p.getAmount() +"");
		
		JButton btnTaBort = new JButton("Ta Bort");
		btnTaBort.setAction(action);
		
		JLabel lblNewLabel_2 = new JLabel(p.getTotal() + " kr");
		
		JLabel lblTotalt = new JLabel("Totalt:");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
					.addComponent(lblTotalt)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_2)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnTaBort)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(btnTaBort)
						.addComponent(lblNewLabel_2)
						.addComponent(lblTotalt))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Ta Bort");
			putValue(SHORT_DESCRIPTION, "Ta bort varan från kundvagnen");
		}
		public void actionPerformed(ActionEvent e) {
			IMatDataHandler.getInstance().getShoppingCart().removeItem(p);
		}
	}
}
