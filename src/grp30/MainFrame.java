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
import net.miginfocom.swing.MigLayout;
import java.awt.Insets;





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
		final JPanel carddropdownpanel = new JPanel();
		carddropdownpanel.setBackground(Color.white);
		carddropdownpanel.setVisible(false);
		
		
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
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(buttonpanel, GroupLayout.DEFAULT_SIZE, 1154, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(carddropdownpanel, GroupLayout.DEFAULT_SIZE, 872, Short.MAX_VALUE)
								.addComponent(centercardpanel, GroupLayout.DEFAULT_SIZE, 872, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(rightpanel, GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE))
						.addComponent(menuBarPanel, 0, 0, Short.MAX_VALUE)
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
					.addComponent(menuBarPanel, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(carddropdownpanel, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(centercardpanel, GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE))
						.addComponent(rightpanel, GroupLayout.DEFAULT_SIZE, 665, Short.MAX_VALUE))
					.addGap(10)
					.addComponent(buttonpanel, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(10))
		);
		carddropdownpanel.setLayout(new CardLayout(0, 0));
		
		final JPanel dropdown1 = new JPanel();
		dropdown1.setBackground(IMatColors.BASE);
		carddropdownpanel.add(dropdown1, "foodbutton1");
		
		
		cardLayout = (CardLayout) (centercardpanel.getLayout());
		dropdown1.setLayout(new MigLayout("", "[25px][116px][31px]", "[25][][][17px]"));
		
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
		dropdown1.add(lblFisk, "cell 1 1,alignx left,aligny top");
		
		final JLabel label = new JLabel("K\u00F6tt");
		label.setCursor(new Cursor(Cursor.HAND_CURSOR));
		label.setForeground(Color.WHITE);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(IMatFonts.CATEGORYFONT);
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
		dropdown1.add(label, "cell 2 1,alignx left,aligny top");
		
		final JPanel dropdown2 = new JPanel();
		dropdown2.setBackground(IMatColors.BASE);
		carddropdownpanel.add(dropdown2, "foodbutton2");
		dropdown2.setLayout(new MigLayout("", "[15px][80px][130px][150px][65px][60px][100px][113px][81px]", "[25][][][17px]"));
		
		final JLabel citrusLabel = new JLabel("Citrusfrukter");
		citrusLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		citrusLabel.setForeground(IMatFonts.CATEGORYCOLOR);
		citrusLabel.setHorizontalAlignment(SwingConstants.CENTER);
		citrusLabel.setFont(IMatFonts.CATEGORYFONT);
		citrusLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				pressed("CITRUS_FRUIT");
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				citrusLabel.setFont(IMatFonts.MARKEDFONT);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				citrusLabel.setFont(IMatFonts.CATEGORYFONT);
			}
		});
		
		
		final JLabel fruitLabel = new JLabel("Frukt");
		fruitLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		fruitLabel.setForeground(IMatFonts.CATEGORYCOLOR);
		fruitLabel.setHorizontalAlignment(SwingConstants.CENTER);
		fruitLabel.setFont(IMatFonts.CATEGORYFONT);
		fruitLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				pressed("FRUIT");
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				fruitLabel.setFont(IMatFonts.MARKEDFONT);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				fruitLabel.setFont(IMatFonts.CATEGORYFONT);
			}
		});
		dropdown2.add(fruitLabel, "cell 1 1,alignx left,aligny top");
		dropdown2.add(citrusLabel, "cell 2 1,alignx left,aligny top");
		
		final JLabel exoticLabel = new JLabel("Exotiska frukter");
		exoticLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		exoticLabel.setForeground(IMatFonts.CATEGORYCOLOR);
		exoticLabel.setHorizontalAlignment(SwingConstants.CENTER);
		exoticLabel.setFont(IMatFonts.CATEGORYFONT);
		exoticLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				pressed("EXOTIC_FRUIT");
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				exoticLabel.setFont(IMatFonts.MARKEDFONT);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				exoticLabel.setFont(IMatFonts.CATEGORYFONT);
			}
		});
		dropdown2.add(exoticLabel, "cell 3 1,alignx left,aligny top");
		
		final JLabel berryLabel = new JLabel("B\u00E4r");
		berryLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		berryLabel.setForeground(IMatFonts.CATEGORYCOLOR);
		berryLabel.setHorizontalAlignment(SwingConstants.CENTER);
		berryLabel.setFont(IMatFonts.CATEGORYFONT);
		berryLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				pressed("BERRY");
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				berryLabel.setFont(IMatFonts.MARKEDFONT);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				berryLabel.setFont(IMatFonts.CATEGORYFONT);
			}
		});
		dropdown2.add(berryLabel, "cell 4 1,alignx left,aligny top");
		
		final JLabel lblKl = new JLabel("K\u00E5l");
		lblKl.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblKl.setForeground(IMatFonts.CATEGORYCOLOR);
		lblKl.setHorizontalAlignment(SwingConstants.CENTER);
		lblKl.setFont(IMatFonts.CATEGORYFONT);
		lblKl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				pressed("CABBAGE");
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblKl.setFont(IMatFonts.MARKEDFONT);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblKl.setFont(IMatFonts.CATEGORYFONT);
			}
		});
		dropdown2.add(lblKl, "cell 5 1,alignx left,aligny top");
		
		final JLabel melonLabel = new JLabel("Meloner");
		melonLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		melonLabel.setForeground(IMatFonts.CATEGORYCOLOR);
		melonLabel.setHorizontalAlignment(SwingConstants.CENTER);
		melonLabel.setFont(IMatFonts.CATEGORYFONT);
		melonLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				pressed("MELONS");
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				melonLabel.setFont(IMatFonts.MARKEDFONT);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				melonLabel.setFont(IMatFonts.CATEGORYFONT);
			}
		});
		dropdown2.add(melonLabel, "cell 6 1,alignx left,aligny top");
		
		final JLabel rootLabel = new JLabel("Rotfrukter");
		rootLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		rootLabel.setForeground(IMatFonts.CATEGORYCOLOR);
		rootLabel.setHorizontalAlignment(SwingConstants.CENTER);
		rootLabel.setFont(IMatFonts.CATEGORYFONT);
		rootLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				pressed("ROOT_VEGETABLE");
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				rootLabel.setFont(IMatFonts.MARKEDFONT);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				rootLabel.setFont(IMatFonts.CATEGORYFONT);
			}
		});
		dropdown2.add(rootLabel, "cell 7 1,alignx left,aligny top");
		
		final JLabel vegLabel = new JLabel("Gr\u00F6nsaker");
		vegLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		vegLabel.setForeground(IMatFonts.CATEGORYCOLOR);
		vegLabel.setHorizontalAlignment(SwingConstants.CENTER);
		vegLabel.setFont(IMatFonts.CATEGORYFONT);
		vegLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				pressed("VEGETABLE_FRUIT");
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				vegLabel.setFont(IMatFonts.MARKEDFONT);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				vegLabel.setFont(IMatFonts.CATEGORYFONT);
			}
		});
		dropdown2.add(vegLabel, "cell 8 1,alignx left,aligny top");
		
		final JPanel dropdown3 = new JPanel();
		dropdown3.setBackground(IMatColors.BASE);
		carddropdownpanel.add(dropdown3, "foodbutton3");
		dropdown3.setLayout(new MigLayout("", "[25][][112px]", "[25][][][17px]"));
		
		final JLabel milkLabel = new JLabel("Mejeriprodukter");
		milkLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		milkLabel.setForeground(IMatFonts.CATEGORYCOLOR);
		milkLabel.setHorizontalAlignment(SwingConstants.CENTER);
		milkLabel.setFont(IMatFonts.CATEGORYFONT);
		milkLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				pressed("DAIRIES");
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				milkLabel.setFont(IMatFonts.MARKEDFONT);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				milkLabel.setFont(IMatFonts.CATEGORYFONT);
			}
		});
		dropdown3.add(milkLabel, "cell 1 1,alignx left,aligny top");
		
		final JPanel dropdown4 = new JPanel();
		dropdown4.setBackground(IMatColors.BASE);
		carddropdownpanel.add(dropdown4, "foodbutton4");
		dropdown4.setLayout(new MigLayout("", "[35][119px][214px][113px][172px][82px]", "[25][][][17px]"));
		
		final JLabel breadLabel = new JLabel("Br\u00F6d");
		breadLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		breadLabel.setForeground(IMatFonts.CATEGORYCOLOR);
		breadLabel.setHorizontalAlignment(SwingConstants.CENTER);
		breadLabel.setFont(IMatFonts.CATEGORYFONT);
		breadLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				pressed("BREAD");
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				breadLabel.setFont(IMatFonts.MARKEDFONT);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				breadLabel.setFont(IMatFonts.CATEGORYFONT);
			}
		});
		dropdown4.add(breadLabel, "cell 1 1,alignx left,aligny top");
		
		final JLabel flourLabel = new JLabel("Mj\u00F6l, Socker & Salt");
		flourLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		flourLabel.setForeground(IMatFonts.CATEGORYCOLOR);
		flourLabel.setHorizontalAlignment(SwingConstants.CENTER);
		flourLabel.setFont(IMatFonts.CATEGORYFONT);
		flourLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				pressed("FLOUR_SUGAR_SALT");
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				flourLabel.setFont(IMatFonts.MARKEDFONT);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				flourLabel.setFont(IMatFonts.CATEGORYFONT);
			}
		});
		dropdown4.add(flourLabel, "cell 2 1,alignx left,aligny top");
		
		final JLabel pastaLabel = new JLabel("Pasta");
		pastaLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pastaLabel.setForeground(IMatFonts.CATEGORYCOLOR);
		pastaLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pastaLabel.setFont(IMatFonts.CATEGORYFONT);
		pastaLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				pressed("PASTA");
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				pastaLabel.setFont(IMatFonts.MARKEDFONT);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				pastaLabel.setFont(IMatFonts.CATEGORYFONT);
			}
		});
		dropdown4.add(pastaLabel, "cell 3 1,alignx left,aligny top");
		
		final JLabel potatoLabel = new JLabel("Potatis & Ris");
		potatoLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		potatoLabel.setForeground(IMatFonts.CATEGORYCOLOR);
		potatoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		potatoLabel.setFont(IMatFonts.CATEGORYFONT);
		potatoLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				pressed("POTATO_RICE");
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				potatoLabel.setFont(IMatFonts.MARKEDFONT);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				potatoLabel.setFont(IMatFonts.CATEGORYFONT);
			}
		});
		dropdown4.add(potatoLabel, "cell 4 1,alignx left,aligny top");
		
		final JLabel herbsLabel = new JLabel("\u00D6rter");
		herbsLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		herbsLabel.setForeground(IMatFonts.CATEGORYCOLOR);
		herbsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		herbsLabel.setFont(IMatFonts.CATEGORYFONT);
		herbsLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				pressed("HERB");
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				herbsLabel.setFont(IMatFonts.MARKEDFONT);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				herbsLabel.setFont(IMatFonts.CATEGORYFONT);
			}
		});
		dropdown4.add(herbsLabel, "cell 5 1,alignx left,aligny top");
		
		final JPanel dropdown5 = new JPanel();
		dropdown5.setBackground(IMatColors.BASE);
		carddropdownpanel.add(dropdown5, "foodbutton5");
		dropdown5.setLayout(new MigLayout("", "[25][180px][102px]", "[25][][][17px]"));
		
		final JLabel coldLabel = new JLabel("Kylda Drycker");
		coldLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		coldLabel.setForeground(IMatFonts.CATEGORYCOLOR);
		coldLabel.setHorizontalAlignment(SwingConstants.CENTER);
		coldLabel.setFont(IMatFonts.CATEGORYFONT);
		coldLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				pressed("COLD_DRINKS");
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				coldLabel.setFont(IMatFonts.MARKEDFONT);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				coldLabel.setFont(IMatFonts.CATEGORYFONT);
			}
		});
		dropdown5.add(coldLabel, "cell 1 1,alignx left,aligny top");
		
		final JLabel warmLabel = new JLabel("Varma Drycker");
		warmLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		warmLabel.setForeground(IMatFonts.CATEGORYCOLOR);
		warmLabel.setHorizontalAlignment(SwingConstants.CENTER);
		warmLabel.setFont(IMatFonts.CATEGORYFONT);
		warmLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				pressed("HOT_DRINKS");
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				warmLabel.setFont(IMatFonts.MARKEDFONT);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				warmLabel.setFont(IMatFonts.CATEGORYFONT);
			}
		});
		dropdown5.add(warmLabel, "cell 2 1,alignx left,aligny top");
		
		final JPanel dropdown6 = new JPanel();
		dropdown6.setBackground(IMatColors.BASE);
		carddropdownpanel.add(dropdown6, "foodbutton6");
		dropdown6.setLayout(new MigLayout("", "[25px][182px][184px][73px]", "[25px][][][17px]"));
		
		final JLabel nutLabel = new JLabel("N\u00F6tter & Fr\u00F6n");
		nutLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		nutLabel.setForeground(IMatFonts.CATEGORYCOLOR);
		nutLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nutLabel.setFont(IMatFonts.CATEGORYFONT);
		nutLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				pressed("NUTS_AND_SEEDS");
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				nutLabel.setFont(IMatFonts.MARKEDFONT);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				nutLabel.setFont(IMatFonts.CATEGORYFONT);
			}
		});
		dropdown6.add(nutLabel, "cell 1 1,alignx left,aligny top");
		
		final JLabel beanLabel = new JLabel("\u00C4rtor & B\u00F6nor");
		beanLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		beanLabel.setForeground(IMatFonts.CATEGORYCOLOR);
		beanLabel.setHorizontalAlignment(SwingConstants.CENTER);
		beanLabel.setFont(IMatFonts.CATEGORYFONT);
		beanLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				pressed("POD");
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				beanLabel.setFont(IMatFonts.MARKEDFONT);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				beanLabel.setFont(IMatFonts.CATEGORYFONT);
			}
		});
		dropdown6.add(beanLabel, "cell 2 1,alignx left,aligny top");
		
		final JLabel snacksLabel = new JLabel("Snacks");
		snacksLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		snacksLabel.setForeground(IMatFonts.CATEGORYCOLOR);
		snacksLabel.setHorizontalAlignment(SwingConstants.CENTER);
		snacksLabel.setFont(IMatFonts.CATEGORYFONT);
		snacksLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				pressed("SWEET");
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				snacksLabel.setFont(IMatFonts.MARKEDFONT);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				snacksLabel.setFont(IMatFonts.CATEGORYFONT);
			}
		});
		snacksLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		dropdown6.add(snacksLabel, "cell 3 1,alignx left,aligny top");
		
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
				
				if (carddropdownpanel.isVisible() && dropdown1.isVisible()) {
					 	
					          carddropdownpanel.setVisible(false);
					  	
					       } else {
						  	
					         carddropdownpanel.setVisible(true);
					
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

				if (carddropdownpanel.isVisible() && dropdown2.isVisible()) {
				 	
			          carddropdownpanel.setVisible(false);
			  	
			       } else {
				  	
			         carddropdownpanel.setVisible(true);
			
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
				if (carddropdownpanel.isVisible() && dropdown3.isVisible()) {
				 	
			          carddropdownpanel.setVisible(false);
			  	
			       } else {
				  	
			         carddropdownpanel.setVisible(true);
			
			CardLayout cardLayout = (CardLayout) (carddropdownpanel
					.getLayout());
			cardLayout.show(carddropdownpanel, "foodbutton3");
			
				
			}}
		});
		
		JButton dryckButton = new JButton("");
		dryckButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dryckButton.setRolloverIcon(new ImageIcon(MainFrame.class.getResource("/resources/dryck_active.png")));
		dryckButton.setPressedIcon(new ImageIcon(MainFrame.class.getResource("/resources/dryck_active.png")));
		dryckButton.setIcon(new ImageIcon(MainFrame.class.getResource("/resources/dryck.png")));
		dryckButton.setBorder(null);
		dryckButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (carddropdownpanel.isVisible() && dropdown4.isVisible()) {
				 	
			          carddropdownpanel.setVisible(false);
			  	
			       } else {
				  	
			         carddropdownpanel.setVisible(true);
			
			CardLayout cardLayout = (CardLayout) (carddropdownpanel
					.getLayout());
			cardLayout.show(carddropdownpanel, "foodbutton4");
			       }}
		});
		
		JButton basvarorButton = new JButton("");
		basvarorButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		basvarorButton.setRolloverIcon(new ImageIcon(MainFrame.class.getResource("/resources/basvaror_active.png")));
		basvarorButton.setPressedIcon(new ImageIcon(MainFrame.class.getResource("/resources/basvaror_active.png")));
		basvarorButton.setIcon(new ImageIcon(MainFrame.class.getResource("/resources/basvaror.png")));
		basvarorButton.setBorder(null);
		basvarorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (carddropdownpanel.isVisible() && dropdown5.isVisible()) {
				 	
			          carddropdownpanel.setVisible(false);
			  	
			       } else {
				  	
			         carddropdownpanel.setVisible(true);
			
			CardLayout cardLayout = (CardLayout) (carddropdownpanel
					.getLayout());
			cardLayout.show(carddropdownpanel, "foodbutton5");
			
			}}
		});
		
		JButton ovrigaVarorButton = new JButton("");
		ovrigaVarorButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ovrigaVarorButton.setPressedIcon(new ImageIcon(MainFrame.class.getResource("/resources/ovrigt_active.png")));
		ovrigaVarorButton.setRolloverIcon(new ImageIcon(MainFrame.class.getResource("/resources/ovrigt_active.png")));
		ovrigaVarorButton.setIcon(new ImageIcon(MainFrame.class.getResource("/resources/ovrigt.png")));
		ovrigaVarorButton.setBorder(null);
		ovrigaVarorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (carddropdownpanel.isVisible() && dropdown6.isVisible()) {
				 	
			          carddropdownpanel.setVisible(false);
			  	
			       } else {
				  	
			         carddropdownpanel.setVisible(true);
			
			CardLayout cardLayout = (CardLayout) (carddropdownpanel
					.getLayout());
			cardLayout.show(carddropdownpanel, "foodbutton6");
			       }}
			
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
