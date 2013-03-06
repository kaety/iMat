package SpecialPanels;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultListSelectionModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;

import net.miginfocom.swing.MigLayout;
import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Order;
import se.chalmers.ait.dat215.project.ShoppingItem;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

public class HistoryPanel extends JPanel{
	private final Action action = new SwingAction();
	Order o;
	public HistoryPanel(Order o, boolean b) {
		Color c;
		if(b)  c = new Color(240,240,240);
		else c = Color.WHITE;
		setBackground(c);
		this.o = o;
		setLayout(new MigLayout("", "[119.00px,grow][12.00px,grow][135.00,grow][156px]", "[74.00px,grow]"));
		
		ArrayList<ShoppingItem> l = (ArrayList<ShoppingItem>) o.getItems(); 
		double d = 0.0;
		for(ShoppingItem i : l){
			d += i.getTotal();
		}
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(c);
		add(panel_1, "cell 0 0,grow");
		panel_1.setLayout(new MigLayout("", "[][][][][]", "[]"));
		JLabel lblNewLabel_1 = new JLabel(o.getDate() + "");
		panel_1.add(lblNewLabel_1, "cell 0 0");
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(c);
		add(panel_2, "cell 1 0,grow");
		panel_2.setLayout(new MigLayout("", "[][][]", "[]"));
		
		JLabel lblNewLabel = new JLabel(d + ":-");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		panel_2.add(lblNewLabel, "cell 0 0 3 1");
		ArrayList<ShoppingItem> aa =(ArrayList<ShoppingItem>) o.getItems();
		ArrayList<String> ab = new ArrayList<String>();
		for(ShoppingItem i : aa){
			ab.add(i.getProduct().getName() + " (" + i.getAmount() + i.getProduct().getUnitSuffix() + ") " );
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		add(scrollPane, "cell 2 0,growx,aligny top");
		
		JList list = new JList();
		list.setEnabled(false);
		scrollPane.setViewportView(list);
		JPanel panel = new JPanel();
		panel.setBackground(c);
		add(panel, "cell 3 0,grow");
		list.setListData(ab.toArray());
		JButton btnLggTill = new JButton("L\u00E4gg TIll");
		btnLggTill.setAction(action);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(53, Short.MAX_VALUE)
					.addComponent(btnLggTill, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnLggTill)
					.addContainerGap(63, Short.MAX_VALUE))
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
