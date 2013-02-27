package grp30;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Box;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ShoppingCart;
import se.chalmers.ait.dat215.project.ShoppingItem;

import javax.swing.JList;
import javax.swing.AbstractListModel;

import SpecialPanels.SearchResultPanel;
import SpecialPanels.SlidingPanel;
import SpecialPanels.SearchScrollPane;

public class testFrame extends Observable implements Observer{
	int kk = 0;
	private JFrame frame;
	SearchScrollPane searchScrollPane;
	JLabel lblAmount;
	private final Action action = new HidePinkMenu();
	private final Action action_1 = new TestBattan();
	private final Action action_2 = new searchAll();
	DynamicLabel dnmclblHerro;
	SlidingPanel slidingPanel;
	
	//
	private boolean ididThis=false;

	/**
	 * Launch the application.
	 */

		/*EventQueue.invokeLater(new Runnable() {*/
			public void run() {
				try {
					//testFrame window = new testFrame();
					initialize();
					this.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		/*});*/


	/**
	 * Create the application.
	 */
	public testFrame() {
		//initialize();
		run();
		frame.pack();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 617, 560);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Integer[] derp = {1,2,3};
		
		JButton btnB = new JButton("Herro");
		btnB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnB.setAction(action);
		
		JButton btnB_1 = new JButton("B 2");
		btnB_1.setAction(action_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		
		slidingPanel = new SlidingPanel();
		slidingPanel.setBackground(Color.ORANGE);
		JButton btnD = new JButton("D 1");
		
		JButton btnD_1 = new JButton("D 2");
		
		JButton btnD_2 = new JButton("D 3");
		GroupLayout gl_slidingPanel = new GroupLayout(slidingPanel);
		gl_slidingPanel.setHorizontalGroup(
			gl_slidingPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_slidingPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_slidingPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_slidingPanel.createSequentialGroup()
							.addComponent(btnD)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnD_2))
						.addComponent(btnD_1))
					.addContainerGap(280, Short.MAX_VALUE))
		);
		gl_slidingPanel.setVerticalGroup(
			gl_slidingPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_slidingPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_slidingPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnD)
						.addComponent(btnD_2))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnD_1)
					.addContainerGap(50, Short.MAX_VALUE))
		);
		slidingPanel.setLayout(gl_slidingPanel);
		
		JButton btnA = new JButton("A 1");
		
		JButton btnA_1 = new JButton("A 2");
		
		lblAmount = new JLabel("amount");
		JLabel lblTotal = new JLabel("Total:");
		
		dnmclblHerro = new DynamicLabel(1200);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnA)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnA_1)
					.addPreferredGap(ComponentPlacement.RELATED, 208, Short.MAX_VALUE)
					.addComponent(dnmclblHerro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblTotal)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblAmount)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnA)
							.addComponent(btnA_1))
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblAmount)
							.addComponent(lblTotal)
							.addComponent(dnmclblHerro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		searchScrollPane = new SearchScrollPane(this);
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnB)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnB_1)
					.addGap(506))
				.addComponent(slidingPanel, GroupLayout.DEFAULT_SIZE, 740, Short.MAX_VALUE)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 740, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(searchScrollPane, GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(slidingPanel, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(searchScrollPane, GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnB)
						.addComponent(btnB_1))
					.addContainerGap())
		);
//		slidingPanel.changeState();
		frame.getContentPane().setLayout(groupLayout);
	}
	private class HidePinkMenu extends AbstractAction {
		public HidePinkMenu() {
			putValue(NAME, "Show/hide Menu");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			slidingPanel.changeState();
		}
	}
	@Override
	public void update(Observable o, Object arg) {
		//conflict with update in mainframe both get the notify
		if(arg instanceof ArrayList<?> && ididThis) displayFoodList((ArrayList<Product>) arg);
		else if(arg instanceof ShoppingCart) newPurchase(IMatDataHandler.getInstance().getShoppingCart());
		else if(arg instanceof ShoppingItem) dnmclblHerro.showLabel(((ShoppingItem)arg).getProduct().getName() + " (" + ((ShoppingItem)arg).getAmount() + ")");
		ididThis=false;
	}
	private class TestBattan extends AbstractAction {
		public TestBattan() {
			putValue(NAME, "Give me recipe");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			//cont.testBattanPressed(txtPotatis.getText());
			
		}
	}
	private class searchAll extends AbstractAction {
		public searchAll() {
			putValue(NAME, "Get all products");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			searchFood();
		}
	}
	private void searchFood(){
		ButtonPressed b = new ButtonPressed("searchFood");
		setChanged();
		ididThis=true;
		notifyObservers(b);
		
	}
	
	private void newPurchase(ShoppingCart sc){
		Double tot = sc.getTotal();
		lblAmount.setText(tot.toString());
		dnmclblHerro.showLabel(sc.getItems().get(sc.getItems().size()-1).getProduct().getName());
	}
	
	private void displayFoodList(ArrayList<Product> foodlist){
		searchScrollPane.setListData(foodlist);
	}
}