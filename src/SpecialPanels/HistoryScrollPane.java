package SpecialPanels;

import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Order;

public class HistoryScrollPane extends JPanel{
	Box box;
	boolean b;
	public HistoryScrollPane() {
		b = false;
		box = Box.createVerticalBox();
		JScrollPane scrollPane = new JScrollPane();
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
	
	public void placeHistory(){
		box.removeAll();
		boolean b = false;
		ArrayList<Order> l = (ArrayList<Order>) IMatDataHandler.getInstance().getOrders();
		for(Order o : l){
			HistoryPanel p = new HistoryPanel(o,b);
			box.add(p);
		}
	}
	
}
