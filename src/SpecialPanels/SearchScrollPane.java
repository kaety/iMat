package SpecialPanels;


import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import se.chalmers.ait.dat215.project.Product;

public class SearchScrollPane extends JPanel {
	Box box;
	JScrollPane scrollPane;
	/**
	 * Create the panel.
	 */
	public SearchScrollPane() {
		box = Box.createVerticalBox();
		scrollPane = new JScrollPane();
		scrollPane.setViewportView(box);
		
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
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
	
	public void setListData(ArrayList<Product> foodlist){
		boolean b = true;
		for(Product p : foodlist){
			SearchResultPanel mm = new SearchResultPanel(p,b);
//			setChanged();
//			notifyObservers(mm);
			box.add(mm);
			b = !b;
		}
		scrollPane.validate();
	}
}
