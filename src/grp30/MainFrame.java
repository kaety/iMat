package grp30;
import gui.IMatColors;
import gui.IMatFonts;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Order;
import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ProductCategory;
import se.chalmers.ait.dat215.project.ShoppingCartListener;
import SpecialPanels.FavouritesScrollPane;
import SpecialPanels.SearchResultPanel.MyObservable;
import SpecialPanels.SlidingPanel;
import cards.ConfirmedBuy;
import cards.DetailedFoodView;
import cards.GuestStart;
import cards.History;
import cards.MyAccount;
import cards.Pay1;
import cards.Pay2;
import cards.Pay3;
import cards.Receipt;
import cards.Register;
import cards.SearchResults;
import cards.ShoppingCart;
import cards.UserStart;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;





public class MainFrame extends Observable implements Observer, ShoppingCartListener{
	private JFrame mf;
	private JPanel contentPane;
	private JTextField searchstring;

	private final JPanel centercardpanel;
	private final CardLayout cardLayout; 
	
	private DetailedFoodView details;
	private SearchResults searchResults;
	private ShoppingCart cart;
	private FavouritesScrollPane favouritesScrollPane;
	private ConfirmedBuy confirmed;
	private Register register;
	private History history;
	private Receipt receipt;
	private GuestStart startGuest;
	private UserStart startUser;
	private MyAccount myAccount;
	
	private JLabel lblEjInloggad;
	private JLabel historyLabel;
	private JLabel changeLabel;
	private JLabel logOutLabel;
	private JPanel menuPanel;
	
	private Pay1 pay1;
	private Pay2 pay2;
	private Pay3 pay3;
	private JLabel lblSumma;
	private JLabel lblRegistreraDig;
	
	private boolean loggedIn;
	/**
	 * Create the frame.
	 */
	public MainFrame() {
		mf=new JFrame();
		IMatDataHandler.getInstance().getShoppingCart().addShoppingCartListener(this);
		
		
		
		
		
		centercardpanel = new JPanel();

		centercardpanel.setLayout(new CardLayout(0, 0));
	
		startGuest = new GuestStart(this);
		startUser = new UserStart();
		
		lblEjInloggad = new JLabel("Logga In");
		lblEjInloggad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		menuPanel = new JPanel();
		menuPanel.setVisible(false);
		
		//NEW VISITOR
		if(IMatDataHandler.getInstance().getUser().getUserName().equals("")){
			
			centercardpanel.add(startGuest, "startGuest");
			centercardpanel.add(startUser, "startUser");
		}
		else{
			//WELLKNOWN USER
			lblEjInloggad.setText(IMatDataHandler.getInstance().getUser().getUserName());
			centercardpanel.add(startUser, "startUser");
			centercardpanel.add(startGuest, "startGuest");
			menuPanel.setVisible(true);
			
		}
		
		
		
		cart = new ShoppingCart(this);
		centercardpanel.add(cart, "cart");
		
		searchResults = new SearchResults(this);
		centercardpanel.add(searchResults, "searchResults");
		
		pay3 = new Pay3(this);
		centercardpanel.add(pay3, "pay3");
		
		pay1 = new Pay1(this,pay3, this.myAccount);
		centercardpanel.add(pay1, "pay1");
		if(!IMatDataHandler.getInstance().getUser().getUserName().equals("")){
		pay1.updateInfo();
		}
		
		
		pay2 = new Pay2(this);
		centercardpanel.add(pay2, "pay2");
		
		
		register = new Register(this, pay1);
		centercardpanel.add(register, "register");
		
		confirmed = new ConfirmedBuy(this);
		centercardpanel.add(confirmed, "confirmed");
		
		history = new History();
		centercardpanel.add(history, "history");
		
		receipt = new Receipt();
		centercardpanel.add(receipt, "receipt");
		
		details = new DetailedFoodView(this);
		centercardpanel.add(details, "details");
		
		myAccount = new MyAccount(this,pay1);
		centercardpanel.add(myAccount, "myAccount");
		
		
		
		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mf.setBounds(100, 100, 1200, 900);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		mf.setContentPane(contentPane);
		
		mf.setVisible(true);
		
		
		
		//SLIDER
		final SlidingPanel carddropdownpanel = new SlidingPanel();
		carddropdownpanel.setBackground(Color.white);
		//carddropdownpanel.setVisible(false);
		carddropdownpanel.changeState();
		
		JPanel rightpanel = new JPanel();
		rightpanel.setBackground(IMatColors.BASE);
		
		JPanel buttonpanel = new JPanel();
		buttonpanel.setBackground(Color.WHITE);
		
		
		JPanel kundvagnspanel = new JPanel();
		kundvagnspanel.setBackground(IMatColors.BACKGROUND);
		
		JPanel menuBarPanel = new JPanel();
		menuBarPanel.setBackground(Color.WHITE);
		
		JPanel toppanel = new JPanel();
		toppanel.setBackground(new Color(255, 255, 255));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(buttonpanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1154, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(centercardpanel, GroupLayout.DEFAULT_SIZE, 872, Short.MAX_VALUE)
								.addComponent(carddropdownpanel, GroupLayout.DEFAULT_SIZE, 872, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(rightpanel, GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE))
						.addComponent(menuBarPanel, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addComponent(toppanel, GroupLayout.DEFAULT_SIZE, 857, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(kundvagnspanel, GroupLayout.PREFERRED_SIZE, 291, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(toppanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(kundvagnspanel, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(menuBarPanel, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(carddropdownpanel, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(centercardpanel, GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE))
						.addComponent(rightpanel, GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE))
					.addGap(10)
					.addComponent(buttonpanel, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(10))
		);
		carddropdownpanel.setLayout(new CardLayout(0, 0));
		
		final JPanel dropdown1 = new JPanel();
		dropdown1.setBackground(IMatColors.BASE);
		carddropdownpanel.add(dropdown1, "foodbutton1");
		
		
		cardLayout = (CardLayout) (centercardpanel.getLayout());
		
		JPanel panel_3 = new JPanel();
		panel_3.setOpaque(false);
		
		JPanel panel_4 = new JPanel();
		panel_4.setOpaque(false);
		GroupLayout gl_dropdown1 = new GroupLayout(dropdown1);
		gl_dropdown1.setHorizontalGroup(
			gl_dropdown1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_dropdown1.createSequentialGroup()
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(663, Short.MAX_VALUE))
		);
		gl_dropdown1.setVerticalGroup(
			gl_dropdown1.createParallelGroup(Alignment.TRAILING)
				.addComponent(panel_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
				.addComponent(panel_4, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
		);
		
		final JLabel lblFisk = new JLabel("Fisk");
		lblFisk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pressed("FISH");
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblFisk.setFont(IMatFonts.MARKEDFONT);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblFisk.setFont(IMatFonts.CATEGORYFONT);
			}
		});
		lblFisk.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblFisk.setForeground(Color.WHITE);
		lblFisk.setHorizontalAlignment(SwingConstants.CENTER);
		lblFisk.setFont(IMatFonts.CATEGORYFONT);
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(30)
					.addComponent(lblFisk))
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(30)
					.addComponent(lblFisk))
		);
		panel_4.setLayout(gl_panel_4);
		
		final JLabel label = new JLabel("K\u00F6tt");
		label.setCursor(new Cursor(Cursor.HAND_CURSOR));
		label.setForeground(Color.WHITE);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(IMatFonts.CATEGORYFONT);
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(30)
					.addComponent(label))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(30)
					.addComponent(label))
		);
		panel_3.setLayout(gl_panel_3);
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				pressed("MEAT");
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				label.setFont(IMatFonts.MARKEDFONT);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				label.setFont(IMatFonts.CATEGORYFONT);
			}
		});
		dropdown1.setLayout(gl_dropdown1);
		
		final JPanel dropdown2 = new JPanel();
		dropdown2.setBackground(IMatColors.BASE);
		carddropdownpanel.add(dropdown2, "foodbutton2");
		
		JButton lblKl = new JButton("K\u00E5l");
		lblKl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pressed("CABBAGE");
			}
		});
		
		JButton lblCitrusfrukt = new JButton("Citrusfrukter");
		lblCitrusfrukt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pressed("CITRUS_FRUIT");
			}
		});
		
		JButton lblNewLabel_1 = new JButton("B\u00E4r");
		lblNewLabel_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pressed("BERRY");
			}
		});
		
		JButton lblNewLabel_2 = new JButton("Exotiska frukter");
		lblNewLabel_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pressed("EXOTIC_FRUIT");
			}
		});
		
		JButton lblNewLabel_3 = new JButton("Frukt");
		lblNewLabel_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pressed("FRUIT");
			}
		});
		
		JButton lblrter = new JButton("Gr\u00F6nsaker");
		lblrter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pressed("VEGETABLE_FRUIT");
			}
		});
		
		JButton lblNewLabel_4 = new JButton("Meloner");
		lblNewLabel_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pressed("MELONS");
			}
		});
		
		JButton lblRotfrukter = new JButton("Rotfrukter");
		lblRotfrukter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pressed("ROOT_VEGETABLE");
				
			}
		});
		
		JPanel panel_5 = new JPanel();
		panel_5.setOpaque(false);
		GroupLayout gl_dropdown2 = new GroupLayout(dropdown2);
		gl_dropdown2.setHorizontalGroup(
			gl_dropdown2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_dropdown2.createSequentialGroup()
					.addGroup(gl_dropdown2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_dropdown2.createSequentialGroup()
							.addGap(202)
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_3)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblrter)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_4)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblRotfrukter))
						.addGroup(gl_dropdown2.createSequentialGroup()
							.addGap(178)
							.addComponent(lblKl, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblCitrusfrukt))
						.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(190, Short.MAX_VALUE))
		);
		gl_dropdown2.setVerticalGroup(
			gl_dropdown2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_dropdown2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_dropdown2.createParallelGroup(Alignment.BASELINE, false)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_2)
						.addComponent(lblNewLabel_3)
						.addComponent(lblrter)
						.addComponent(lblNewLabel_4)
						.addComponent(lblRotfrukter))
					.addGroup(gl_dropdown2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_dropdown2.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
							.addComponent(lblKl)
							.addContainerGap())
						.addGroup(gl_dropdown2.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblCitrusfrukt)
							.addContainerGap())))
				.addComponent(panel_5, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
		);
		dropdown2.setLayout(gl_dropdown2);
		
		final JPanel dropdown3 = new JPanel();
		dropdown3.setBackground(IMatColors.BASE);
		carddropdownpanel.add(dropdown3, "foodbutton3");
		
		JButton lblMejeriprodukter = new JButton("Mejeriprodukter");
		lblMejeriprodukter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pressed("DAIRIES");
			}
		});
		GroupLayout gl_dropdown3 = new GroupLayout(dropdown3);
		gl_dropdown3.setHorizontalGroup(
			gl_dropdown3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_dropdown3.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblMejeriprodukter)
					.addContainerGap(851, Short.MAX_VALUE))
		);
		gl_dropdown3.setVerticalGroup(
			gl_dropdown3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_dropdown3.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblMejeriprodukter)
					.addContainerGap(62, Short.MAX_VALUE))
		);
		dropdown3.setLayout(gl_dropdown3);
		
		final JPanel dropdown4 = new JPanel();
		dropdown4.setBackground(IMatColors.BASE);
		carddropdownpanel.add(dropdown4, "foodbutton4");
		
		JButton lblBrd = new JButton("Br\u00F6d");
		lblBrd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pressed("BREAD");
			}
		});
		
		JButton lblMjlsockerSalt = new JButton("Mj\u00F6l, Socker & Salt");
		lblMjlsockerSalt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pressed("FLOUR_SUGAR_SALT");
			}
		});
		
		JButton lblNewLabel_5 = new JButton("Pasta");
		lblNewLabel_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pressed("PASTA");
			}
		});
		
		JButton lblPotatisRis = new JButton("Potatis & Ris");
		lblPotatisRis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pressed("POTATO_RICE");
			}
		});
		
		JButton lblrter_1 = new JButton("\u00D6rter");
		lblrter_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pressed("HERB");
			}
		});
		GroupLayout gl_dropdown4 = new GroupLayout(dropdown4);
		gl_dropdown4.setHorizontalGroup(
			gl_dropdown4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_dropdown4.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblBrd)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblMjlsockerSalt)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_5)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblPotatisRis)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblrter_1)
					.addContainerGap(549, Short.MAX_VALUE))
		);
		gl_dropdown4.setVerticalGroup(
			gl_dropdown4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_dropdown4.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_dropdown4.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBrd)
						.addComponent(lblMjlsockerSalt)
						.addComponent(lblNewLabel_5)
						.addComponent(lblPotatisRis)
						.addComponent(lblrter_1))
					.addContainerGap(62, Short.MAX_VALUE))
		);
		dropdown4.setLayout(gl_dropdown4);
		
		final JPanel dropdown5 = new JPanel();
		dropdown5.setBackground(IMatColors.BASE);
		carddropdownpanel.add(dropdown5, "foodbutton5");
		
		JButton lblKallaDrycker = new JButton("Kylda Drycker");
		lblKallaDrycker.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pressed("COLD_DRINKS");
			}
		});
		
		JButton lblVarmaDrycker = new JButton("Varma Drycker");
		lblVarmaDrycker.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pressed("HOT_DRINKS");
			}
		});
		GroupLayout gl_dropdown5 = new GroupLayout(dropdown5);
		gl_dropdown5.setHorizontalGroup(
			gl_dropdown5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_dropdown5.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblKallaDrycker)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblVarmaDrycker)
					.addContainerGap(752, Short.MAX_VALUE))
		);
		gl_dropdown5.setVerticalGroup(
			gl_dropdown5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_dropdown5.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_dropdown5.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblKallaDrycker)
						.addComponent(lblVarmaDrycker))
					.addContainerGap(174, Short.MAX_VALUE))
		);
		dropdown5.setLayout(gl_dropdown5);
		
		final JPanel dropdown6 = new JPanel();
		dropdown6.setBackground(IMatColors.BASE);
		carddropdownpanel.add(dropdown6, "foodbutton6");
		
		JButton lblNtterFrn = new JButton("N\u00F6tter & Fr\u00F6n");
		lblNtterFrn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pressed("NUTS_AND_SEEDS");
			}
		});
		
		JButton snacks = new JButton("Snacks");
		snacks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pressed("SWEET");
			}
		});
		snacks.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JButton lblrtorBnor = new JButton("\u00C4rtor & B\u00F6nor");
		lblrtorBnor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pressed("POD");
			}
		});
		GroupLayout gl_dropdown6 = new GroupLayout(dropdown6);
		gl_dropdown6.setHorizontalGroup(
			gl_dropdown6.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_dropdown6.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNtterFrn)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblrtorBnor)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(snacks)
					.addContainerGap(685, Short.MAX_VALUE))
		);
		gl_dropdown6.setVerticalGroup(
			gl_dropdown6.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_dropdown6.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_dropdown6.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNtterFrn)
						.addComponent(lblrtorBnor)
						.addComponent(snacks))
					.addGap(183))
		);
		dropdown6.setLayout(gl_dropdown6);
		
		JLabel lblNewLabel = new JLabel("Favoriter");
		
		favouritesScrollPane = new FavouritesScrollPane(this);
		GroupLayout gl_rightpanel = new GroupLayout(rightpanel);
		gl_rightpanel.setHorizontalGroup(
			gl_rightpanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_rightpanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_rightpanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(favouritesScrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
						.addComponent(lblNewLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_rightpanel.setVerticalGroup(
			gl_rightpanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_rightpanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(favouritesScrollPane, GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
					.addContainerGap())
		);
		rightpanel.setLayout(gl_rightpanel);
		
		JButton cartbutton = new JButton("");
		cartbutton.setIconTextGap(2);
		cartbutton.setFocusable(false);
		cartbutton.setRolloverEnabled(false);
		cartbutton.setRequestFocusEnabled(false);
		cartbutton.setIcon(new ImageIcon(MainFrame.class.getResource("/resources/shopping_cart.png")));
		cartbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cart.shoppingCartChanged2();
				cardLayout.show(centercardpanel, "cart");
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		
		
		lblEjInloggad.setForeground(new Color(204, 153, 0));
		GroupLayout gl_kundvagnspanel = new GroupLayout(kundvagnspanel);
		gl_kundvagnspanel.setHorizontalGroup(
			gl_kundvagnspanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_kundvagnspanel.createSequentialGroup()
					.addGroup(gl_kundvagnspanel.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
						.addComponent(lblEjInloggad, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(cartbutton))
		);
		gl_kundvagnspanel.setVerticalGroup(
			gl_kundvagnspanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_kundvagnspanel.createSequentialGroup()
					.addGroup(gl_kundvagnspanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_kundvagnspanel.createSequentialGroup()
							.addGap(7)
							.addComponent(cartbutton))
						.addGroup(gl_kundvagnspanel.createSequentialGroup()
							.addComponent(lblEjInloggad)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(new GridLayout(2, 2, 10, 1));
		
		JLabel lblAntalVaror = new JLabel("Antal varor:");
		lblAntalVaror.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblAntalVaror);
		
		lblSumma = new JLabel(IMatDataHandler.getInstance().getShoppingCart().getItems().size() + " varor");
		panel.add(lblSumma);
		
		JLabel lblSumma_1 = new JLabel("Summa:");
		lblSumma_1.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblSumma_1);
		
		lblRegistreraDig = new JLabel(IMatDataHandler.getInstance().getShoppingCart().getTotal() + ":-");
		lblRegistreraDig.setHorizontalAlignment(SwingConstants.LEFT);
		lblRegistreraDig.setForeground(new Color(0, 0, 0));
		panel.add(lblRegistreraDig);
		kundvagnspanel.setLayout(gl_kundvagnspanel);
		
		JLabel lblKontakt = new JLabel("GRP30 DAT215 AB");
		lblKontakt.setForeground(Color.BLACK);
		
		JLabel lblTelefon = new JLabel("Telefon:");
		lblTelefon.setForeground(Color.GRAY);
		
		JLabel lblTom = new JLabel("Innehar IT-skattsedel");
		lblTom.setForeground(Color.GRAY);
		
		JLabel label_2 = new JLabel("031 - 42 42 42");
		label_2.setForeground(Color.GRAY);
		GroupLayout gl_buttonpanel = new GroupLayout(buttonpanel);
		gl_buttonpanel.setHorizontalGroup(
			gl_buttonpanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_buttonpanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblKontakt)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblTom)
					.addGap(18)
					.addComponent(lblTelefon)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(786, Short.MAX_VALUE))
		);
		gl_buttonpanel.setVerticalGroup(
			gl_buttonpanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_buttonpanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_buttonpanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblKontakt)
						.addComponent(lblTom)
						.addComponent(lblTelefon)
						.addComponent(label_2))
					.addContainerGap(49, Short.MAX_VALUE))
		);
		buttonpanel.setLayout(gl_buttonpanel);

		JButton kottFiskButton = new JButton("");
		kottFiskButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		kottFiskButton.setBorder(null);
		kottFiskButton.setRolloverIcon(new ImageIcon(MainFrame.class.getResource("/resources/kott_fisk_active.png")));
		kottFiskButton.setPressedIcon(new ImageIcon(MainFrame.class.getResource("/resources/kott_fisk_active.png")));
		kottFiskButton.setIcon(new ImageIcon(MainFrame.class.getResource("/resources/kott_fisk.png")));
		kottFiskButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (dropdown1.isVisible()) {
					carddropdownpanel.changeState();
				}
				
				else {
					CardLayout cardLayout = (CardLayout) (carddropdownpanel
							.getLayout());
					cardLayout.show(carddropdownpanel, "foodbutton1");
					
			}}
		});

		JButton fruktGronsakerButton = new JButton("");
		fruktGronsakerButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		fruktGronsakerButton.setBorder(null);
		fruktGronsakerButton.setIcon(new ImageIcon(MainFrame.class.getResource("/resources/frukt_gronsaker.png")));
		fruktGronsakerButton.setPressedIcon(new ImageIcon(MainFrame.class.getResource("/resources/frukt_gronsaker_active.png")));
		fruktGronsakerButton.setRolloverIcon(new ImageIcon(MainFrame.class.getResource("/resources/frukt_gronsaker_active.png")));
		fruktGronsakerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (dropdown2.isVisible()) {
					carddropdownpanel.changeState();
				
			}else {
					CardLayout cardLayout = (CardLayout) (carddropdownpanel
							.getLayout());
					cardLayout.show(carddropdownpanel, "foodbutton2");
					

			}}
		});
		
		JButton mejeriButton = new JButton("");
		mejeriButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mejeriButton.setPressedIcon(new ImageIcon(MainFrame.class.getResource("/resources/mejeri_active.png")));
		mejeriButton.setRolloverIcon(new ImageIcon(MainFrame.class.getResource("/resources/mejeri_active.png")));
		mejeriButton.setIcon(new ImageIcon(MainFrame.class.getResource("/resources/mejeri.png")));
		mejeriButton.setBorder(null);
		mejeriButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (dropdown3.isVisible()) {
					carddropdownpanel.changeState();
				} else {

					CardLayout cardLayout = (CardLayout) (carddropdownpanel
							.getLayout());
					cardLayout.show(carddropdownpanel, "foodbutton3");
					

				}
				
			}
		});
		
		JButton dryckButton = new JButton("");
		dryckButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dryckButton.setRolloverIcon(new ImageIcon(MainFrame.class.getResource("/resources/dryck_active.png")));
		dryckButton.setPressedIcon(new ImageIcon(MainFrame.class.getResource("/resources/dryck_active.png")));
		dryckButton.setIcon(new ImageIcon(MainFrame.class.getResource("/resources/dryck.png")));
		dryckButton.setBorder(null);
		dryckButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (dropdown5.isVisible()) {
					carddropdownpanel.changeState();
				} else {

					CardLayout cardLayout = (CardLayout) (carddropdownpanel
							.getLayout());
					cardLayout.show(carddropdownpanel, "foodbutton5");
					
				}

			}
		});
		
		JButton basvarorButton = new JButton("");
		basvarorButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		basvarorButton.setRolloverIcon(new ImageIcon(MainFrame.class.getResource("/resources/basvaror_active.png")));
		basvarorButton.setPressedIcon(new ImageIcon(MainFrame.class.getResource("/resources/basvaror_active.png")));
		basvarorButton.setIcon(new ImageIcon(MainFrame.class.getResource("/resources/basvaror.png")));
		basvarorButton.setBorder(null);
		basvarorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (dropdown4.isVisible()) {
					carddropdownpanel.changeState();

				} else {

					CardLayout cardLayout = (CardLayout) (carddropdownpanel
							.getLayout());
					cardLayout.show(carddropdownpanel, "foodbutton4");
					
				}
			}
		});
		
		JButton ovrigaVarorButton = new JButton("");
		ovrigaVarorButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ovrigaVarorButton.setPressedIcon(new ImageIcon(MainFrame.class.getResource("/resources/ovrigt_active.png")));
		ovrigaVarorButton.setRolloverIcon(new ImageIcon(MainFrame.class.getResource("/resources/ovrigt_active.png")));
		ovrigaVarorButton.setIcon(new ImageIcon(MainFrame.class.getResource("/resources/ovrigt.png")));
		ovrigaVarorButton.setBorder(null);
		ovrigaVarorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (dropdown6.isVisible()) {
					carddropdownpanel.changeState();
				} else {

					CardLayout cardLayout = (CardLayout) (carddropdownpanel
							.getLayout());
					cardLayout.show(carddropdownpanel, "foodbutton6");
				
				}
			}
		});
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(MainFrame.class.getResource("/resources/right_menu_corner.png")));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(IMatColors.BASE);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(IMatColors.BASE);
		GroupLayout groupLayout = new GroupLayout(menuBarPanel);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(kottFiskButton, 106, 106, GroupLayout.PREFERRED_SIZE)
					.addComponent(fruktGronsakerButton, 164, 164, GroupLayout.PREFERRED_SIZE)
					.addComponent(mejeriButton, 69, 69, GroupLayout.PREFERRED_SIZE)
					.addComponent(basvarorButton, 92, 92, GroupLayout.PREFERRED_SIZE)
					.addComponent(dryckButton, 66, 66, GroupLayout.PREFERRED_SIZE)
					.addComponent(ovrigaVarorButton, 70, 70, GroupLayout.PREFERRED_SIZE)
					.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE)
					.addComponent(label_1))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(kottFiskButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(fruktGronsakerButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(mejeriButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(basvarorButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(dryckButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(ovrigaVarorButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(label_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addContainerGap())
		);
		
		searchstring = new JTextField();
		searchstring.setBorder(new LineBorder(Color.GRAY));
		searchstring.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				searchstring.setText("");
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (searchstring.getText().equals(""))
				searchstring.setText(" S\u00F6k i butiken...");
			}
		});
		searchstring.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				
				int key = arg0.getKeyCode();
			    if (key == KeyEvent.VK_ENTER){
			    	
			    	searchResults.displayFoodList((ArrayList<Product>) IMatDataHandler.getInstance().findProducts(searchstring.getText()));
					cardLayout.show(centercardpanel, "searchResults");
			    	searchstring.setText("");
				}
			}
		});
		searchstring.setText(" S\u00F6k i butiken...");
		searchstring.setColumns(10);
		
		JButton btnSearch = new JButton("S\u00F6k");
		btnSearch.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				searchResults.displayFoodList((ArrayList<Product>) IMatDataHandler.getInstance().findProducts(searchstring.getText()));
				cardLayout.show(centercardpanel, "searchResults");
		    	searchstring.setText(" S\u00F6k i butiken...");
				
				
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap(40, Short.MAX_VALUE)
					.addComponent(searchstring, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSearch, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
					.addGap(6))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSearch, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(searchstring, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE))
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		menuBarPanel.setLayout(groupLayout);
		
		JLabel lblImat = new JLabel("");
		lblImat.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblImat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(IMatDataHandler.getInstance().getUser().getUserName().equals("")){
					cardLayout.show(centercardpanel, "startGuest");
				}
				else{
					cardLayout.show(centercardpanel, "startUser");
				}
			}
		});
		lblImat.setIcon(new ImageIcon(MainFrame.class.getResource("/resources/main_logotype.png")));
		lblImat.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblImat.setBackground(Color.WHITE);
		lblImat.setHorizontalAlignment(SwingConstants.CENTER);
		
		menuPanel.setBackground(Color.WHITE);
		GroupLayout gl_toppanel = new GroupLayout(toppanel);
		gl_toppanel.setHorizontalGroup(
			gl_toppanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_toppanel.createSequentialGroup()
					.addComponent(lblImat)
					.addPreferredGap(ComponentPlacement.RELATED, 434, Short.MAX_VALUE)
					.addComponent(menuPanel, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_toppanel.setVerticalGroup(
			gl_toppanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_toppanel.createSequentialGroup()
					.addGap(5)
					.addComponent(lblImat, GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE))
				.addGroup(gl_toppanel.createSequentialGroup()
					.addComponent(menuPanel, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(41, Short.MAX_VALUE))
		);
		
		logOutLabel = new JLabel("Logga Ut");
		logOutLabel.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				setUser2("Logga In");
				swapCard("startGuest");
				menuPanel.setVisible(false);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				super.mouseEntered(e);
				logOutLabel.setForeground(IMatColors.BASE);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				super.mouseExited(e);
				logOutLabel.setForeground(Color.BLACK);
				
			}
		});
		logOutLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		logOutLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		changeLabel = new JLabel("Mitt Konto");
		changeLabel.setForeground(Color.BLACK);
		changeLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myAccount.updateInfo();
				swapCard("myAccount");
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				super.mouseEntered(e);
				changeLabel.setForeground(IMatColors.BASE);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				super.mouseExited(e);
				changeLabel.setForeground(Color.BLACK);
				
			}
			
		});
		changeLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		changeLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		historyLabel = new JLabel("Historik");
		historyLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				swapCard("history");
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				super.mouseEntered(e);
				historyLabel.setForeground(IMatColors.BASE);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				super.mouseExited(e);
				historyLabel.setForeground(Color.BLACK);
				
			}
		});
		historyLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		historyLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupLayout gl_menuPanel = new GroupLayout(menuPanel);
		gl_menuPanel.setHorizontalGroup(
			gl_menuPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_menuPanel.createSequentialGroup()
					.addContainerGap(58, Short.MAX_VALUE)
					.addComponent(changeLabel)
					.addGap(18)
					.addComponent(historyLabel)
					.addGap(18)
					.addComponent(logOutLabel)
					.addContainerGap())
		);
		gl_menuPanel.setVerticalGroup(
			gl_menuPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_menuPanel.createSequentialGroup()
					.addGroup(gl_menuPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(logOutLabel)
						.addComponent(historyLabel)
						.addComponent(changeLabel))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		menuPanel.setLayout(gl_menuPanel);
		toppanel.setLayout(gl_toppanel);
		
		
		 mf.addWindowListener(new java.awt.event.WindowAdapter() {
			    @Override
			    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
			    	IMatDataHandler.getInstance().shutDown();    
			    }
			});
		
		
		
		contentPane.setLayout(gl_contentPane);
		
	}


	


	public void pressed(String category) {
		searchResults.displayFoodList((ArrayList<Product>) IMatDataHandler.getInstance().getProducts(ProductCategory.valueOf(category)));
		cardLayout.show(centercardpanel, "searchResults");
		
	}
	public void setFavList(){
		favouritesScrollPane.addFavourites();
		searchResults.setFavoritesButtons();
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		if((arg0 instanceof MyObservable) && (arg1 instanceof String)) setFavList();
		if((arg0 instanceof MyObservable) && (arg1 instanceof Product)){
			details.setActiveProduct((Product) arg1);
			cardLayout.show(centercardpanel, "details");
		}
	}





	public CardLayout getCardLayout() {
		return cardLayout;
	}
	
	 public void swapCard(String key) {
	      cardLayout.show(centercardpanel, key);
	   }

	 public void lastReceipt(Order o){
		 receipt.setReceipt(o);
	 }

	 public void setUser(){
		 lblEjInloggad.setText(IMatDataHandler.getInstance().getUser().getUserName());
		 menuPanel.setVisible(true);
		 
	 }
	 
	 public void setUser2(String s){
		 lblEjInloggad.setText(s);
		 
	 }


	@Override
	public void shoppingCartChanged() {
		lblSumma.setText(IMatDataHandler.getInstance().getShoppingCart().getItems().size() + " varor");
		lblRegistreraDig.setText(IMatDataHandler.getInstance().getShoppingCart().getTotal() + ":-");
	}
}
