package SpecialPanels;
import grp30.MainFrame;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.util.Observer;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Product;
import SpecialPanels.SearchResultPanel.MyObservable;
import javax.swing.ImageIcon;

public class SmallPanel extends JPanel {
	MyObservable m = new MyObservable();
	Product p;
	Color panelColor;
	private final Color highLightColor = Color.WHITE; //The color when mouse hover
	private final Color lightColor = Color.WHITE;      //Light striping color
	private final Color darkColor = new Color(234,234,234);		  //Dark -||-
	private final Action action = new SwingAction();
	JLabel lblLabel;
	private final Action action_1 = new SwingAction_1();
	/**
	 * Create the panel.
	 */
	public SmallPanel(boolean light, Product p, Observer o) {
		this.p = p;
		m.addObserver(o);
		if(light) setBackground(lightColor);
		else setBackground(darkColor);
		
		JButton btnA = new JButton("A 1");
		btnA.setAction(action_1);
		
		JButton btnA_1 = new JButton("A 2");
		btnA_1.setAction(action);
		
		lblLabel = new JLabel(p.getName());
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblLabel, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 1, Short.MAX_VALUE)
					.addComponent(btnA_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnA)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
					.addComponent(lblLabel)
					.addComponent(btnA, GroupLayout.DEFAULT_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addComponent(btnA_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
		);
		setLayout(groupLayout);

	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			//putValue(NAME, "R");
			putValue(SMALL_ICON,new ImageIcon(MainFrame.class.getResource("/resources/trashcan.gif")));
			putValue(SHORT_DESCRIPTION, "Ta bort varan från favoriter");
		}
		public void actionPerformed(ActionEvent e) {
			IMatDataHandler.getInstance().favorites().remove(p);
			m.setChanged();
			m.notifyObservers("fav");
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(SMALL_ICON,new ImageIcon(MainFrame.class.getResource("/resources/shopping_cart.gif")));
			putValue(SHORT_DESCRIPTION, "Lägg till i varukorgen");
		}
		public void actionPerformed(ActionEvent e) {
			IMatDataHandler.getInstance().getShoppingCart().addProduct(p);
		}
	}
	
	private static ImageIcon scaleIcon(ImageIcon icon, int width, int height){
		Image img = icon.getImage();
		Image newimg = img.getScaledInstance( width, height,  java.awt.Image.SCALE_SMOOTH ) ;  
		return new ImageIcon( newimg );
	}
}
