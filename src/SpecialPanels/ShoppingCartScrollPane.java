package SpecialPanels;

import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.ShoppingCartListener;
import se.chalmers.ait.dat215.project.ShoppingItem;

public class ShoppingCartScrollPane extends JPanel implements ShoppingCartListener{
	JScrollPane scrollPane;
	Box box;
	public ShoppingCartScrollPane() {
		box = Box.createVerticalBox();
		IMatDataHandler.getInstance().getShoppingCart().addShoppingCartListener(this);
		scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setViewportView(box);
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
		);
		setLayout(groupLayout);
	}
	
	public void repaintShoppingCart(){
		box.removeAll();
		ArrayList<ShoppingItem> l = (ArrayList<ShoppingItem>) IMatDataHandler.getInstance().getShoppingCart().getItems();
		boolean b = true;
		for(ShoppingItem i : l){
			box.add(new ShoppingCartPanel(i,b));
			b = !b;
		}
		revalidate();
		repaint();
	}

	@Override
	public void shoppingCartChanged() {
		repaintShoppingCart();
	}
	
}
