package SpecialPanels;


import java.util.ArrayList;
import java.util.Observer;

import javax.swing.Box;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import se.chalmers.ait.dat215.project.Product;

public class SearchScrollPane extends JPanel {
	private Box box;
	JScrollPane scrollPane;
	Observer o;
	ArrayList<SearchResultPanel> products;
	/**
	 * Create the panel.
	 */
	public SearchScrollPane(Observer o) {
		this.o = o;
		products = new ArrayList<SearchResultPanel>();
		box = Box.createVerticalBox();
		scrollPane = new JScrollPane();
		scrollPane.setViewportView(box);
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
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
		box.removeAll();
		products.clear();
		boolean b = true;
		for(Product p : foodlist){
			SearchResultPanel mm = new SearchResultPanel(p,b);
			mm.addObserver(o);
			box.add(mm);
			products.add(mm);
			b = !b;
		}
		scrollPane.validate();
	}
	
	public void setFavoritesButtons(){
		box.removeAll();
		for(SearchResultPanel srp : products){
			srp.isFavbut();
			box.add(srp);
		}
		scrollPane.revalidate();
		scrollPane.repaint();
	}
	
	public int getListLength(){
		int i = box.getComponents().length;
		return i;
	}
}
