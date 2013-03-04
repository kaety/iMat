package SpecialPanels;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Order;
import se.chalmers.ait.dat215.project.ShoppingItem;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;

public class HistoryPanel extends JPanel{
	private final Action action = new SwingAction();
	Order o;
	public HistoryPanel(Order o, boolean b) {
		Color c;
		if(b)  c = new Color(240,240,240);
		else c = Color.WHITE;
		setBackground(c);
		setLayout(new GridLayout(1, 0, 0, 0));
		this.o = o;
		JLabel lblNewLabel_1 = new JLabel(o.getDate() + "");
		add(lblNewLabel_1);
		
		ArrayList<ShoppingItem> l = (ArrayList<ShoppingItem>) o.getItems(); 
		double d = 0.0;
		for(ShoppingItem i : l){
			d += i.getTotal();
		}
		
		JLabel lblNewLabel = new JLabel(d + ":-");
		add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(c);
		add(panel);
		
		JButton btnLggTill = new JButton("L\u00E4gg TIll");
		btnLggTill.setAction(action);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(83)
					.addComponent(btnLggTill, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnLggTill)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Lägg Till");
			putValue(SHORT_DESCRIPTION, "Lägg ordern i kundvagnen");
		}
		public void actionPerformed(ActionEvent e) {
			ArrayList<ShoppingItem> l = (ArrayList<ShoppingItem>) o.getItems(); 
			for(ShoppingItem i : l){
				IMatDataHandler.getInstance().getShoppingCart().addItem(i);
			}
		}
	}
}
