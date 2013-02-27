package SpecialPanels;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ShoppingItem;


public class SearchResultPanel extends JPanel implements MouseListener{
	/**
	 * Create the panel.
	 */
	private Color panelColor;
	private final Color highLightColor = Color.WHITE;
	private Product product;
	JButton btnBattan;
	JPanel imagePanel;
	JPanel selectorPanel;
	final protected int imageDimension = 100;

	public SearchResultPanel(Product p, boolean lightPanel) {
		product = p;
		setBorder(new LineBorder(new Color(0, 0, 0)));
		if(lightPanel) panelColor = Color.LIGHT_GRAY;
		else panelColor = Color.DARK_GRAY;
		setBackground(panelColor);
	    addMouseListener(this);
		JLabel lblFood = new JLabel(p.getName());
		ImageIcon icon = IMatDataHandler.getInstance().getImageIcon(p, imageDimension, imageDimension);
		
		imagePanel = new JPanel();
		selectorPanel = new JPanel();
		imagePanel.setBackground(panelColor);
		selectorPanel.setBackground(panelColor);
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addComponent(imagePanel, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblFood)
					.addPreferredGap(ComponentPlacement.RELATED, 165, Short.MAX_VALUE)
					.addComponent(selectorPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(imagePanel, GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblFood, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(90, Short.MAX_VALUE))
				.addComponent(selectorPanel, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
		);
		
		btnBattan = new JButton("battan");
		btnBattan.setAction(action);
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "5", "10"}));
		GroupLayout gl_selectorPanel = new GroupLayout(selectorPanel);
		gl_selectorPanel.setHorizontalGroup(
			gl_selectorPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_selectorPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_selectorPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnBattan)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_selectorPanel.setVerticalGroup(
			gl_selectorPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_selectorPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnBattan)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(48, Short.MAX_VALUE))
		);
		selectorPanel.setLayout(gl_selectorPanel);
		JLabel lblImage = new JLabel(icon);
		imagePanel.add(lblImage);
		lblImage.setText("");
		setLayout(groupLayout);

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		setBackground(highLightColor);
		imagePanel.setBackground(highLightColor);
		selectorPanel.setBackground(highLightColor);
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		setBackground(panelColor);
		imagePanel.setBackground(panelColor);
		selectorPanel.setBackground(panelColor);
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
    public static class MyObservable extends Observable {
        @Override
        public void setChanged() {
            super.setChanged();
        }
    }
    private final MyObservable observable = new MyObservable();
    private final Action action = new SwingAction();
    
    public void addObserver(Observer o){
    	observable.addObserver(o);
    }
	
	public Product getProduct() {
		return product;
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Lägg Till");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			ShoppingItem i = new ShoppingItem(product);
			observable.setChanged();
			observable.notifyObservers(i);
		}
	}
}
