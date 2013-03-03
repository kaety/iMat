package grp30;
import gui.IMatColors;

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
		
		lblEjInloggad = new JLabel("Ej inloggad...");
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
		
		pay1 = new Pay1(this,pay3);
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
		
		myAccount = new MyAccount(this,pay3);
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
		
		JPanel foodandsearchpanel = new JPanel();
		foodandsearchpanel.setBackground(IMatColors.BASE);
		
		JPanel toppanel = new JPanel();
		toppanel.setBackground(new Color(255, 255, 255));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(buttonpanel, GroupLayout.DEFAULT_SIZE, 1154, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(centercardpanel, GroupLayout.DEFAULT_SIZE, 970, Short.MAX_VALUE)
								.addComponent(carddropdownpanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(rightpanel, GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE))
						.addComponent(foodandsearchpanel, 0, 0, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
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
					.addComponent(foodandsearchpanel, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(carddropdownpanel, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(centercardpanel, GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE))
						.addComponent(rightpanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(18)
					.addComponent(buttonpanel, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		carddropdownpanel.setLayout(new CardLayout(0, 0));
		
		final JPanel dropdown1 = new JPanel();
		dropdown1.setBackground(IMatColors.BASE);
		carddropdownpanel.add(dropdown1, "foodbutton1");
		
		
		cardLayout = (CardLayout) (centercardpanel.getLayout());
		
		JButton label = new JButton("K\u00F6tt");
		label.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pressed("MEAT");
				
				
			}
		});
		
		JButton lblFisk = new JButton("Fisk");
		lblFisk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pressed("FISH");
			}
		});
		GroupLayout gl_dropdown1 = new GroupLayout(dropdown1);
		gl_dropdown1.setHorizontalGroup(
			gl_dropdown1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_dropdown1.createSequentialGroup()
					.addContainerGap()
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(lblFisk, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(793, Short.MAX_VALUE))
		);
		gl_dropdown1.setVerticalGroup(
			gl_dropdown1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_dropdown1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_dropdown1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFisk)
						.addComponent(label))
					.addContainerGap(38, Short.MAX_VALUE))
		);
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
		GroupLayout gl_dropdown2 = new GroupLayout(dropdown2);
		gl_dropdown2.setHorizontalGroup(
			gl_dropdown2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_dropdown2.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblKl, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblCitrusfrukt)
					.addPreferredGap(ComponentPlacement.RELATED)
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
					.addComponent(lblRotfrukter)
					.addContainerGap(288, Short.MAX_VALUE))
		);
		gl_dropdown2.setVerticalGroup(
			gl_dropdown2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_dropdown2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_dropdown2.createParallelGroup(Alignment.BASELINE, false)
						.addComponent(lblKl)
						.addComponent(lblCitrusfrukt)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_2)
						.addComponent(lblNewLabel_3)
						.addComponent(lblrter)
						.addComponent(lblNewLabel_4)
						.addComponent(lblRotfrukter))
					.addContainerGap(174, Short.MAX_VALUE))
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
		/*	@Override
			public void focusLost(FocusEvent e) {
				searchstring.setText("Search...");
			}*/
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
		searchstring.setText("Search...");
		searchstring.setColumns(10);

		JButton foodButton1 = new JButton("K\u00F6tt & Fisk");
		foodButton1.addActionListener(new ActionListener() {
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

		JButton foodButton2 = new JButton("Frukt & Gr\u00F6nsaker");
		foodButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (dropdown2.isVisible()) {
					carddropdownpanel.changeState();
				
			}else {
					CardLayout cardLayout = (CardLayout) (carddropdownpanel
							.getLayout());
					cardLayout.show(carddropdownpanel, "foodbutton2");
					

			}}
		});
		
		JButton foodbutton3 = new JButton("Mejeri");
		foodbutton3.addActionListener(new ActionListener() {
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
		
		JButton foodbutton4 = new JButton("Dryck");
		foodbutton4.addActionListener(new ActionListener() {
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
		
		JButton foodbutton5 = new JButton("Basvaror");
		foodbutton5.addActionListener(new ActionListener() {
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
		
		JButton foodbutton6 = new JButton("\u00D6vrigt");
		foodbutton6.addActionListener(new ActionListener() {
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
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				searchResults.displayFoodList((ArrayList<Product>) IMatDataHandler.getInstance().findProducts(searchstring.getText()));
				cardLayout.show(centercardpanel, "searchResults");
		    	searchstring.setText("Search...");
				
				
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
					.addPreferredGap(ComponentPlacement.RELATED, 243, Short.MAX_VALUE)
					.addComponent(searchstring, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSearch)
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
						.addComponent(searchstring, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSearch))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		foodandsearchpanel.setLayout(groupLayout);
		
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
				setUser2("Utloggad");
				swapCard("startGuest");
				menuPanel.setVisible(false);
			}
		});
		logOutLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		logOutLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		changeLabel = new JLabel("Mina Uppgifter");
		changeLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myAccount.updateInfo();
				swapCard("myAccount");
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
