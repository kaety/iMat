package SpecialPanels;

import java.util.ArrayList;
import java.util.Observer;

import javax.swing.Box;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Product;

public class FavouritesScrollPane extends JScrollPane{
	boolean b;
	private Box box;
	Observer o;
	public FavouritesScrollPane(Observer o) {
		this.o = o;
		setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		b = false;
		box = Box.createVerticalBox();
		setViewportView(box);
		setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	}
	
	public void addFavourites(){
		box.removeAll();
		b = true;
		ArrayList<Product> fav= (ArrayList<Product>) IMatDataHandler.getInstance().favorites();
		if(fav.size() != 0){
			for(Product p : fav){
				b = !b;
				SmallPanel sp = new SmallPanel(b,p,o);
				box.add(sp);
			}
		}
		validate();
		repaint();
	}

}