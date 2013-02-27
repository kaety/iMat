package grp30;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.DefaultListModel;
import javax.swing.JLayeredPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ProductCategory;

import cards.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JTextPane;
import javax.swing.JList;

public class MainFrame extends Observable implements Observer{
	private JFrame mf;
	private JPanel contentPane;
	private JTextField searchstring;
	private JList list1;
	private DefaultListModel<String> model1= new DefaultListModel();
	private JList list2;
	private DefaultListModel<String> model2= new DefaultListModel();
	private int noFood = 0;
	/**
	 * Create the frame.
	 */
	public MainFrame() {
		mf=new JFrame();
		JPanel centercardpanel = new JPanel();
		
		centercardpanel.setLayout(new CardLayout(0, 0));
		
		JPanel startUser = new UserStart();
		centercardpanel.add(startUser, "startUser");
		
		JPanel startGuest = new GuestStart();
		centercardpanel.add(startGuest, "startGuest");
		
		JPanel cart = new ShoppingCart();
		centercardpanel.add(cart, "cart");
		
		JPanel searchResults = new SearchResults();
		centercardpanel.add(searchResults, "searchResults");
		
		JPanel pay1 = new Pay1();
		centercardpanel.add(pay1, "pay1");
		
		JPanel pay2 = new Pay2();
		centercardpanel.add(pay2, "pay2");
		
		JPanel pay3 = new Pay3();
		centercardpanel.add(pay3, "pay3");
		
		JPanel register = new Register();
		centercardpanel.add(register, "register");
		
		JPanel confirmed = new ConfirmedBuy();
		centercardpanel.add(confirmed, "confirmed");
		
		JPanel history = new History();
		centercardpanel.add(history, "history");
		
		JPanel receipt = new Receipt();
		centercardpanel.add(receipt, "receipt");
		
		JPanel details = new DetailedFoodView();
		centercardpanel.add(details, "details");
		
		
		
		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mf.setBounds(100, 100, 1024, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		mf.setContentPane(contentPane);
		
		mf.setVisible(true);
		
		
		
		
		final JPanel carddropdownpanel = new JPanel();
		carddropdownpanel.setBackground(Color.PINK);
		carddropdownpanel.setVisible(false);
		
		JPanel rightpanel = new JPanel();
		rightpanel.setBackground(Color.GRAY);
		
		JPanel buttonpanel = new JPanel();
		buttonpanel.setBackground(Color.GRAY);
		
		
		JPanel kundvagnspanel = new JPanel();
		kundvagnspanel.setBackground(Color.GRAY);
		
		JPanel foodandsearchpanel = new JPanel();
		foodandsearchpanel.setBackground(Color.GRAY);
		
		JPanel toppanel = new JPanel();
		toppanel.setBackground(Color.GRAY);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(buttonpanel, GroupLayout.DEFAULT_SIZE, 978, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(carddropdownpanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(centercardpanel, GroupLayout.DEFAULT_SIZE, 794, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(rightpanel, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE))
						.addComponent(foodandsearchpanel, 0, 0, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(toppanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(kundvagnspanel, GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(kundvagnspanel, GroupLayout.PREFERRED_SIZE, 63, Short.MAX_VALUE)
						.addComponent(toppanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(foodandsearchpanel, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(carddropdownpanel, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(centercardpanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(rightpanel, GroupLayout.PREFERRED_SIZE, 486, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(buttonpanel, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		carddropdownpanel.setLayout(new CardLayout(0, 0));
		
		final JPanel dropdown1 = new JPanel();
		dropdown1.setBackground(Color.PINK);
		carddropdownpanel.add(dropdown1, "foodbutton1");
		
		
		//testing
		list1 = new JList(model1);
		
		JLabel label = new JLabel("K\u00F6tt");
		
		list2 = new JList(model2);
		
		JLabel lblFisk = new JLabel("Fisk");
		GroupLayout gl_dropdown1 = new GroupLayout(dropdown1);
		gl_dropdown1.setHorizontalGroup(
			gl_dropdown1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_dropdown1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_dropdown1.createParallelGroup(Alignment.LEADING)
						.addComponent(label)
						.addComponent(list1, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_dropdown1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblFisk)
						.addComponent(list2, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE))
					.addGap(370))
		);
		gl_dropdown1.setVerticalGroup(
			gl_dropdown1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_dropdown1.createSequentialGroup()
					.addGroup(gl_dropdown1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(lblFisk))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_dropdown1.createParallelGroup(Alignment.BASELINE)
						.addComponent(list1, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
						.addComponent(list2, GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE))
					.addContainerGap(58, Short.MAX_VALUE))
		);
		dropdown1.setLayout(gl_dropdown1);
		
		final JPanel dropdown2 = new JPanel();
		dropdown2.setBackground(Color.RED);
		carddropdownpanel.add(dropdown2, "foodbutton2");
		
		final JPanel dropdown3 = new JPanel();
		dropdown3.setBackground(Color.ORANGE);
		carddropdownpanel.add(dropdown3, "foodbutton3");
		
		final JPanel dropdown4 = new JPanel();
		dropdown4.setBackground(Color.GREEN);
		carddropdownpanel.add(dropdown4, "foodbutton4");
		
		final JPanel dropdown5 = new JPanel();
		dropdown5.setBackground(Color.MAGENTA);
		carddropdownpanel.add(dropdown5, "foodbutton5");
		
		final JPanel dropdown6 = new JPanel();
		dropdown6.setBackground(Color.BLUE);
		carddropdownpanel.add(dropdown6, "foodbutton6");
		GroupLayout gl_rightpanel = new GroupLayout(rightpanel);
		gl_rightpanel.setHorizontalGroup(
			gl_rightpanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 174, Short.MAX_VALUE)
		);
		gl_rightpanel.setVerticalGroup(
			gl_rightpanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 486, Short.MAX_VALUE)
		);
		rightpanel.setLayout(gl_rightpanel);
		
		JLabel profilLink = new JLabel("namn namnsson");
		
		JLabel kundvagnLink = new JLabel("Kundvagn");
		GroupLayout gl_kundvagnspanel = new GroupLayout(kundvagnspanel);
		gl_kundvagnspanel.setHorizontalGroup(
			gl_kundvagnspanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_kundvagnspanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(profilLink)
					.addGap(18)
					.addComponent(kundvagnLink)
					.addContainerGap(21, Short.MAX_VALUE))
		);
		gl_kundvagnspanel.setVerticalGroup(
			gl_kundvagnspanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_kundvagnspanel.createSequentialGroup()
					.addGap(21)
					.addGroup(gl_kundvagnspanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(kundvagnLink, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(profilLink))
					.addContainerGap(68, Short.MAX_VALUE))
		);
		kundvagnspanel.setLayout(gl_kundvagnspanel);
		
		JLabel lblKontakt = new JLabel("Kontakt:");
		
		JLabel lblTelefon = new JLabel("Telefon:");
		
		JLabel lblTom = new JLabel("Tom Doodle ");
		GroupLayout gl_buttonpanel = new GroupLayout(buttonpanel);
		gl_buttonpanel.setHorizontalGroup(
			gl_buttonpanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_buttonpanel.createSequentialGroup()
					.addContainerGap(712, Short.MAX_VALUE)
					.addGroup(gl_buttonpanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblTelefon)
						.addComponent(lblKontakt))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblTom)
					.addGap(147))
		);
		gl_buttonpanel.setVerticalGroup(
			gl_buttonpanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_buttonpanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_buttonpanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblKontakt)
						.addComponent(lblTom))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblTelefon)
					.addContainerGap(29, Short.MAX_VALUE))
		);
		buttonpanel.setLayout(gl_buttonpanel);
		
		searchstring = new JTextField();
		searchstring.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				searchstring.setText("");
			}
			@Override
			public void focusLost(FocusEvent e) {
				searchstring.setText("Search...");
			}
		});
		searchstring.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				
				int key = arg0.getKeyCode();
			    if (key == KeyEvent.VK_ENTER){
			    	System.out.println("Söker på: "+searchstring.getText());
			    	searchstring.setText("");
				}
			}
		});
		searchstring.setText("Search...");
		searchstring.setColumns(10);

		JButton foodButton1 = new JButton("K\u00F6tt & Fisk");
		foodButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				List<Product> food1= new ArrayList<Product>();
				List<Product> food2= new ArrayList<Product>();
				if (carddropdownpanel.isVisible() && dropdown1.isVisible()) {

					carddropdownpanel.setVisible(false);

				} else {
					carddropdownpanel.setVisible(true);
					CardLayout cardLayout = (CardLayout) (carddropdownpanel
							.getLayout());
					cardLayout.show(carddropdownpanel, "foodbutton1");
					if(noFood==0){
						noFood++;
					ProductCategory meat = ProductCategory.valueOf("MEAT");
					ProductCategory fish = ProductCategory.valueOf("FISH");
					
					food1.addAll(IMatDataHandler.getInstance().getProducts(meat));
					food2.addAll(IMatDataHandler.getInstance().getProducts(fish));
					}
				
					for(Product p: food1){
						model1.addElement(p.getName());
					}
					
					for(Product p: food2){
						model2.addElement(p.getName());
					}
				}
			}
		});

		JButton foodButton2 = new JButton("Frukt & Gr\u00F6nsaker");
		foodButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (carddropdownpanel.isVisible() && dropdown2.isVisible()) {

					carddropdownpanel.setVisible(false);

				} else {
					carddropdownpanel.setVisible(true);

					CardLayout cardLayout = (CardLayout) (carddropdownpanel
							.getLayout());
					cardLayout.show(carddropdownpanel, "foodbutton2");
				}

			}
		});
		
		JButton foodbutton3 = new JButton("Mejeri");
		foodbutton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (carddropdownpanel.isVisible() && dropdown3.isVisible()) {

					carddropdownpanel.setVisible(false);

				} else {
					carddropdownpanel.setVisible(true);

					CardLayout cardLayout = (CardLayout) (carddropdownpanel
							.getLayout());
					cardLayout.show(carddropdownpanel, "foodbutton3");
				}

			
				
			}
		});
		
		JButton foodbutton4 = new JButton("Dryck");
		foodbutton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (carddropdownpanel.isVisible() && dropdown4.isVisible()) {

					carddropdownpanel.setVisible(false);

				} else {
					carddropdownpanel.setVisible(true);

					CardLayout cardLayout = (CardLayout) (carddropdownpanel
							.getLayout());
					cardLayout.show(carddropdownpanel, "foodbutton4");
				}

			}
		});
		
		JButton foodbutton5 = new JButton("Basvaror");
		foodbutton5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (carddropdownpanel.isVisible() && dropdown5.isVisible()) {

					carddropdownpanel.setVisible(false);

				} else {
					carddropdownpanel.setVisible(true);

					CardLayout cardLayout = (CardLayout) (carddropdownpanel
							.getLayout());
					cardLayout.show(carddropdownpanel, "foodbutton5");
				}
			}
		});
		
		JButton foodbutton6 = new JButton("\u00D6vrigt");
		foodbutton6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (carddropdownpanel.isVisible() && dropdown6.isVisible()) {

					carddropdownpanel.setVisible(false);

				} else {
					carddropdownpanel.setVisible(true);

					CardLayout cardLayout = (CardLayout) (carddropdownpanel
							.getLayout());
					cardLayout.show(carddropdownpanel, "foodbutton6");
				}
			}
		});
		GroupLayout groupLayout = new GroupLayout(foodandsearchpanel);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(6)
					.addComponent(foodButton1, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(foodButton2, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(foodbutton3, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(foodbutton5, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(foodbutton4, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(foodbutton6, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 144, Short.MAX_VALUE)
					.addComponent(searchstring, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(foodButton1)
						.addComponent(foodButton2)
						.addComponent(foodbutton5)
						.addComponent(foodbutton3)
						.addComponent(foodbutton4)
						.addComponent(foodbutton6)
						.addComponent(searchstring, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		foodandsearchpanel.setLayout(groupLayout);
		
		JLabel lblImat = new JLabel("iMAT");
		lblImat.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblImat.setBackground(Color.WHITE);
		lblImat.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_toppanel = new GroupLayout(toppanel);
		gl_toppanel.setHorizontalGroup(
			gl_toppanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_toppanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblImat, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(686, Short.MAX_VALUE))
		);
		gl_toppanel.setVerticalGroup(
			gl_toppanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_toppanel.createSequentialGroup()
					.addGap(5)
					.addComponent(lblImat, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(26, Short.MAX_VALUE))
		);
		toppanel.setLayout(gl_toppanel);
		
		
		
		
		contentPane.setLayout(gl_contentPane);
	}


	@Override
	public void update(Observable arg0, Object arg1) {
		
		
		
	}


		
	
}
