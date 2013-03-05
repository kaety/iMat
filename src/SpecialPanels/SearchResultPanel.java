
package SpecialPanels;
import grp30.MainFrame;
import gui.IMatColors;

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
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ShoppingItem;
import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Component;
import java.awt.Image;

import javax.swing.Box;
import javax.swing.SwingConstants;


public class SearchResultPanel extends JPanel implements MouseListener{
	/**
	 * Create the panel.
	 */
	private final int[] prices = {1, 2, 3, 5, 10};
	private Color panelColor;
	private final Color highLightColor = Color.WHITE;
	private Product product;
	JButton btnBattan;
	JPanel imagePanel;
	JPanel selectorPanel;
	final protected int imageDimension = 100;
	JComboBox comboBox;
	JPanel middlePanel;
	JLabel lblPrice;
	JButton favbut;
	JLabel lblTryckPProdukten;
	public SearchResultPanel(Product p, boolean lightPanel) {
		setBorder(new LineBorder(new Color(255, 255, 255)));
		product = p;
		if(lightPanel) panelColor = Color.white;
		else panelColor = new Color(234,234,234);
		setBackground(panelColor);
	    addMouseListener(this);
		ImageIcon icon = IMatDataHandler.getInstance().getImageIcon(p, imageDimension, imageDimension);
		
		imagePanel = new JPanel();
		selectorPanel = new JPanel();
		imagePanel.setBackground(panelColor);
		selectorPanel.setBackground(panelColor);
		
		
		
		
		middlePanel = new JPanel();
		//favbut = new JButton();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(imagePanel, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(middlePanel, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(selectorPanel, GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addComponent(imagePanel, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(selectorPanel, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 86, Short.MAX_VALUE)
						.addComponent(middlePanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE))
					.addContainerGap())
		);
		JLabel lblFood = new JLabel(p.getName());
		lblFood.setFont(new Font("Tahoma", Font.BOLD, 18));
		middlePanel.setBackground(panelColor);
		
		lblTryckPProdukten = new JLabel("Tryck h\u00E4r f\u00F6r mer information");
		lblTryckPProdukten.setForeground(new Color(102, 153, 153));
		lblTryckPProdukten.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblTryckPProdukten.setVisible(false);
		GroupLayout gl_middlePanel = new GroupLayout(middlePanel);
		gl_middlePanel.setHorizontalGroup(
			gl_middlePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_middlePanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_middlePanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblFood)
						.addComponent(lblTryckPProdukten))
					.addContainerGap(41, Short.MAX_VALUE))
		);
		gl_middlePanel.setVerticalGroup(
			gl_middlePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_middlePanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblFood)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblTryckPProdukten)
					.addContainerGap(223, Short.MAX_VALUE))
		);
		middlePanel.setLayout(gl_middlePanel);
		btnBattan = new JButton("battan");
		btnBattan.setAction(action);
		comboBox = new JComboBox();
		initCombobox();
		
		lblPrice = new JLabel(product.getPrice() + " " +  product.getUnit());
		lblPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 13));
		favbut = new JButton();
		isFavbut();
		favbut.setAction(action_1);
		GroupLayout gl_selectorPanel = new GroupLayout(selectorPanel);
		gl_selectorPanel.setHorizontalGroup(
			gl_selectorPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_selectorPanel.createSequentialGroup()
					.addContainerGap(54, Short.MAX_VALUE)
					.addComponent(favbut)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblPrice, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnBattan)
					.addContainerGap())
		);
		gl_selectorPanel.setVerticalGroup(
			gl_selectorPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_selectorPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_selectorPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(favbut)
						.addGroup(gl_selectorPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnBattan)
							.addComponent(lblPrice, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(49, Short.MAX_VALUE))
		);
		selectorPanel.setLayout(gl_selectorPanel);
		JLabel lblImage = new JLabel(icon);
		imagePanel.add(lblImage);
		lblImage.setText("");
		setLayout(groupLayout);
		isFavbut();
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	private void initCombobox(){
		String[] s = new String[prices.length];
		for(int i = 0; i < prices.length; i++){
			s[i] = prices[i] + " " + product.getUnitSuffix();
		}
		comboBox.setModel(new DefaultComboBoxModel(s));
	}
	
	@Override
	public void mouseEntered(MouseEvent arg0) {
		this.setBorder(new LineBorder(Color.black, 1, true));
		lblTryckPProdukten.setVisible(true);
		/* Changed to just a border instead of change of colours.
		setBackground(highLightColor);
		imagePanel.setBackground(highLightColor);
		selectorPanel.setBackground(highLightColor);
		middlePanel.setBackground(highLightColor);
		*/
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		this.setBorder(new LineBorder(Color.white, 1, true));
		lblTryckPProdukten.setVisible(false);
		/*
		setBackground(panelColor);
		imagePanel.setBackground(panelColor);
		selectorPanel.setBackground(panelColor);
		middlePanel.setBackground(panelColor);
		*/
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		observable.setChanged();
		observable.notifyObservers(product);
		
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
    private final Action action_1 = new SwingAction_1();
    
    public void addObserver(Observer o){
    	observable.addObserver(o);
    }
	
	public Product getProduct() {
		return product;
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Lägg Till");
			putValue(SHORT_DESCRIPTION, "Lägg i varukorgen");
		}
		public void actionPerformed(ActionEvent e) {
			ShoppingItem i = new ShoppingItem(product, prices[comboBox.getSelectedIndex()]);
			IMatDataHandler.getInstance().getShoppingCart().addItem(i);
			
			//observable.setChanged();
			//observable.notifyObservers(i);
		}
	}
	
	public void isFavbut(){
		if(IMatDataHandler.getInstance().favorites().contains(product)){
//			favbut.setText("FAV");
			favbut.setIcon(scaleIcon(new ImageIcon(MainFrame.class.getResource("/resources/goldstar.png")),30,30));
		}
		else{
//			favbut.setText("NO FAV");
			favbut.setIcon(scaleIcon(new ImageIcon(MainFrame.class.getResource("/resources/greystar.png")),30,30));
		}
	}
	
	private String returnFav(){
		if(IMatDataHandler.getInstance().favorites().contains(product)) return("FAV");
		else return("NO FAV");
	}
	
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			//putValue(NAME, returnFav());
			if(IMatDataHandler.getInstance().isFavorite(product)) putValue(LARGE_ICON_KEY, scaleIcon(new ImageIcon(MainFrame.class.getResource("/resources/goldstar.png")),30,30));
			else putValue(LARGE_ICON_KEY, scaleIcon(new ImageIcon(MainFrame.class.getResource("/resources/greystar.png")),30,30));
			putValue(SHORT_DESCRIPTION, "Lägg till/ta bort från favoriter");
		}
		public void actionPerformed(ActionEvent e) {
			if(IMatDataHandler.getInstance().favorites().contains(product)){
				IMatDataHandler.getInstance().favorites().remove(product);
//				favbut.setText("NO FAV");
				favbut.setIcon(scaleIcon(new ImageIcon(MainFrame.class.getResource("/resources/greystar.png")),30,30));
			}
			else{
				IMatDataHandler.getInstance().favorites().add(product);
//				favbut.setText("FAV");
				favbut.setIcon(scaleIcon(new ImageIcon(MainFrame.class.getResource("/resources/goldstar.png")),30,30));
			}
			repaint();
			observable.setChanged();
			observable.notifyObservers("fav");
			System.out.println(IMatDataHandler.getInstance().favorites());
		}
	}
	
	private static ImageIcon scaleIcon(ImageIcon icon, int width, int height){
		Image img = icon.getImage();
		Image newimg = img.getScaledInstance( width, height,  java.awt.Image.SCALE_SMOOTH ) ;  
		return new ImageIcon( newimg );
	}
}
