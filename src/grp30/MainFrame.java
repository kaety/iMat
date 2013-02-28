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

import SpecialPanels.SlidingPanel;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.ListModel;

import cards.ConfirmedBuy;
import cards.DetailedFoodView;
import cards.GuestStart;
import cards.History;
import cards.Pay1;
import cards.Pay2;
import cards.Pay3;
import cards.Receipt;
import cards.Register;
import cards.SearchResults;
import cards.ShoppingCart;
import cards.UserStart;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;




public class MainFrame extends Observable implements Observer{
	private JFrame mf;
	private JPanel contentPane;
	private JTextField searchstring;
	private DefaultListModel<String> model1;
	private DefaultListModel<String> model2;
	private DefaultListModel<String> model3;
	private DefaultListModel<String> model4;
	private DefaultListModel<String> model5;
	private DefaultListModel<String> model6;
	private DefaultListModel<String> model7;
	private DefaultListModel<String> model8;
	private DefaultListModel<String> model9;
	private DefaultListModel<String> model10;
	private DefaultListModel<String> model11;
	private DefaultListModel<String> model12;
	private DefaultListModel<String> model13;
	private DefaultListModel<String> model14;
	private DefaultListModel<String> model15;
	private DefaultListModel<String> model16;
	private DefaultListModel<String> model17;
	private DefaultListModel<String> model18;
	private DefaultListModel<String> model19;
	private DefaultListModel<String> model20;
	private DefaultListModel<String> model21;
	private final JPanel centercardpanel;
	private final CardLayout cardLayout; 
	private DetailedFoodView details;
	private SearchResults searchResults;


	

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		
		mf=new JFrame();
		
		model1= new DefaultListModel();
		model2= new DefaultListModel();
		model3= new DefaultListModel();
		model4= new DefaultListModel();
		model5= new DefaultListModel();
		model6= new DefaultListModel();
		model7= new DefaultListModel();
		model8= new DefaultListModel();
		model9= new DefaultListModel();
		model10= new DefaultListModel();
		model11= new DefaultListModel();
		model12= new DefaultListModel();
		model13= new DefaultListModel();
		model14= new DefaultListModel();
		model15= new DefaultListModel();
		model16= new DefaultListModel();
		model17= new DefaultListModel();
		model18= new DefaultListModel();
		model19= new DefaultListModel();
		model20= new DefaultListModel();
		model21= new DefaultListModel();
		
		
		
		fillMyListsUp();
		
		
		
		
		centercardpanel = new JPanel();

		centercardpanel.setLayout(new CardLayout(0, 0));
		
		UserStart startUser = new UserStart();
		centercardpanel.add(startUser, "startUser");
	
		GuestStart startGuest = new GuestStart();
		centercardpanel.add(startGuest, "startGuest");
		
		ShoppingCart cart = new ShoppingCart();
		centercardpanel.add(cart, "cart");
		
		searchResults = new SearchResults();
		centercardpanel.add(searchResults, "searchResults");
		GroupLayout gl_searchResults = new GroupLayout(searchResults);
		gl_searchResults.setHorizontalGroup(
			gl_searchResults.createParallelGroup(Alignment.LEADING)
				.addGap(0, 970, Short.MAX_VALUE)
		);
		gl_searchResults.setVerticalGroup(
			gl_searchResults.createParallelGroup(Alignment.LEADING)
				.addGap(0, 404, Short.MAX_VALUE)
		);
		searchResults.setLayout(gl_searchResults);
		
		Pay1 pay1 = new Pay1();
		centercardpanel.add(pay1, "pay1");
		
		Pay2 pay2 = new Pay2();
		centercardpanel.add(pay2, "pay2");
		
		Pay3 pay3 = new Pay3();
		centercardpanel.add(pay3, "pay3");
		
		Register register = new Register();
		centercardpanel.add(register, "register");
		
		ConfirmedBuy confirmed = new ConfirmedBuy();
		centercardpanel.add(confirmed, "confirmed");
		
		History history = new History();
		centercardpanel.add(history, "history");
		
		Receipt receipt = new Receipt();
		centercardpanel.add(receipt, "receipt");
		
		details = new DetailedFoodView();
		centercardpanel.add(details, "details");
		
		
		
		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mf.setBounds(100, 100, 1200, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		mf.setContentPane(contentPane);
		
		mf.setVisible(true);
		
		
		
		//SLIDER
		final SlidingPanel carddropdownpanel = new SlidingPanel();
		carddropdownpanel.setBackground(Color.PINK);
		//carddropdownpanel.setVisible(false);
		carddropdownpanel.changeState();
		
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
						.addComponent(buttonpanel, GroupLayout.DEFAULT_SIZE, 1154, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(centercardpanel, GroupLayout.DEFAULT_SIZE, 970, Short.MAX_VALUE)
								.addComponent(carddropdownpanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(rightpanel, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE))
						.addComponent(foodandsearchpanel, 0, 0, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(toppanel, GroupLayout.DEFAULT_SIZE, 970, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(kundvagnspanel, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(kundvagnspanel, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
						.addComponent(toppanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(foodandsearchpanel, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(carddropdownpanel, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(centercardpanel, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE))
						.addComponent(rightpanel, GroupLayout.DEFAULT_SIZE, 618, Short.MAX_VALUE))
					.addGap(18)
					.addComponent(buttonpanel, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		carddropdownpanel.setLayout(new CardLayout(0, 0));
		
		final JPanel dropdown1 = new JPanel();
		dropdown1.setBackground(Color.PINK);
		carddropdownpanel.add(dropdown1, "foodbutton1");
		
		
		cardLayout = (CardLayout) (centercardpanel.getLayout());
		
		
		final JList list1 = new JList(model1);
		list1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				list1.clearSelection();
			}
		});

		list1.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {

				SetDetailView(list1, arg0);

			}
		});
		
		JLabel label = new JLabel("K\u00F6tt");
		
		final JList list2 = new JList(model2);
		list2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				list2.clearSelection();
			}
		});
	
		list2.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				SetDetailView(list2, arg0);
			}
		});
		
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
						.addComponent(list2, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE))
					.addGap(419))
		);
		gl_dropdown1.setVerticalGroup(
			gl_dropdown1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_dropdown1.createSequentialGroup()
					.addGroup(gl_dropdown1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(lblFisk))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_dropdown1.createParallelGroup(Alignment.LEADING)
						.addComponent(list2, GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
						.addComponent(list1, GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE))
					.addGap(34))
		);
		dropdown1.setLayout(gl_dropdown1);
		
		final JPanel dropdown2 = new JPanel();
		dropdown2.setBackground(Color.RED);
		carddropdownpanel.add(dropdown2, "foodbutton2");
		
		final JList list3 = new JList(model3);
		list3.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				list3.clearSelection();
			}
		});
	
		list3.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				SetDetailView(list3, arg0);
			}
		});
		
		JLabel lblKl = new JLabel("K\u00E5l");
		
		JLabel lblCitrusfrukt = new JLabel("Citrusfrukter");
		
		final JList list4 = new JList(model4);
		list4.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				list4.clearSelection();
			}
		});
	
		list4.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				SetDetailView(list4, arg0);
			}
		});
		
		final JList list5 = new JList(model5);
		list5.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				list5.clearSelection();
			}
		});
	
		list5.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				SetDetailView(list5, arg0);
			}
		});
		
		final JList list6 = new JList(model6);
		list6.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				list6.clearSelection();
			}
		});
	
		list6.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				SetDetailView(list6, arg0);
			}
		});
		
		final JList list7 = new JList(model7);
		list7.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				list7.clearSelection();
			}
		});
	
		list7.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				SetDetailView(list7, arg0);
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("B\u00E4r");
		
		JLabel lblNewLabel_2 = new JLabel("Exotiska frukter");
		
		JLabel lblNewLabel_3 = new JLabel("Frukt");
		
		final JList list8 = new JList(model8);
		list8.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				list8.clearSelection();
			}
		});
	
		list8.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				SetDetailView(list8, arg0);
			}
		});
		
		JLabel lblrter = new JLabel("Gr\u00F6nsaker");
		
		final JList list9 = new JList(model9);
		list9.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				list9.clearSelection();
			}
		});
	
		list9.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				SetDetailView(list9, arg0);
			}
		});
		
		JLabel lblNewLabel_4 = new JLabel("Meloner");
		
		final JList list10 = new JList(model10);
		list10.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				list10.clearSelection();
			}
		});
	
		list10.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				SetDetailView(list10, arg0);
			}
		});
		
		JLabel lblRotfrukter = new JLabel("Rotfrukter");
		GroupLayout gl_dropdown2 = new GroupLayout(dropdown2);
		gl_dropdown2.setHorizontalGroup(
			gl_dropdown2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_dropdown2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_dropdown2.createParallelGroup(Alignment.LEADING)
						.addComponent(lblKl, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(list3, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_dropdown2.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCitrusfrukt)
						.addComponent(list4, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_dropdown2.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1)
						.addComponent(list5, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_dropdown2.createParallelGroup(Alignment.LEADING)
						.addComponent(list6, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_dropdown2.createParallelGroup(Alignment.LEADING)
						.addComponent(list7, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_dropdown2.createParallelGroup(Alignment.LEADING)
						.addComponent(lblrter)
						.addComponent(list8, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_dropdown2.createParallelGroup(Alignment.LEADING)
						.addComponent(list9, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_dropdown2.createParallelGroup(Alignment.LEADING)
						.addComponent(lblRotfrukter)
						.addComponent(list10, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(34, Short.MAX_VALUE))
		);
		gl_dropdown2.setVerticalGroup(
			gl_dropdown2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_dropdown2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_dropdown2.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(lblKl, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_dropdown2.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblCitrusfrukt, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(gl_dropdown2.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(gl_dropdown2.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblrter, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblRotfrukter)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_dropdown2.createParallelGroup(Alignment.BASELINE)
						.addComponent(list3, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
						.addComponent(list4, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
						.addComponent(list5, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
						.addComponent(list6, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
						.addComponent(list7, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
						.addComponent(list8, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
						.addComponent(list9, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
						.addComponent(list10, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE))
					.addContainerGap())
		);
		dropdown2.setLayout(gl_dropdown2);
		
		final JPanel dropdown3 = new JPanel();
		dropdown3.setBackground(Color.ORANGE);
		carddropdownpanel.add(dropdown3, "foodbutton3");
		
		final JList list11 = new JList(model11);
		list11.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				list11.clearSelection();
			}
		});
	
		list11.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				SetDetailView(list11, arg0);
			}
		});
		
		JLabel lblMejeriprodukter = new JLabel("Mejeriprodukter");
		GroupLayout gl_dropdown3 = new GroupLayout(dropdown3);
		gl_dropdown3.setHorizontalGroup(
			gl_dropdown3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_dropdown3.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_dropdown3.createParallelGroup(Alignment.LEADING)
						.addComponent(list11, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMejeriprodukter))
					.addContainerGap(785, Short.MAX_VALUE))
		);
		gl_dropdown3.setVerticalGroup(
			gl_dropdown3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_dropdown3.createSequentialGroup()
					.addGap(5)
					.addComponent(lblMejeriprodukter)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(list11, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		dropdown3.setLayout(gl_dropdown3);
		
		final JPanel dropdown4 = new JPanel();
		dropdown4.setBackground(Color.GREEN);
		carddropdownpanel.add(dropdown4, "foodbutton4");
		
		final JList list12 = new JList(model12);
		list12.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				list12.clearSelection();
			}
		});
	
		list12.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				SetDetailView(list12, arg0);
			}
		});
		
		JLabel lblBrd = new JLabel("Br\u00F6d");
		
		final JList list13 = new JList(model13);
		list13.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				list13.clearSelection();
			}
		});
	
		list13.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				SetDetailView(list13, arg0);
			}
		});
		
		JLabel lblMjlsockerSalt = new JLabel("Mj\u00F6l, Socker & Salt");
		
		final JList list14 = new JList(model14);
		list14.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				list14.clearSelection();
			}
		});
	
		list14.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				SetDetailView(list14, arg0);
			}
		});
		
		JLabel lblNewLabel_5 = new JLabel("Pasta");
		
		final JList list15 = new JList(model15);
		list15.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				list15.clearSelection();
			}
		});
	
		list15.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				SetDetailView(list15, arg0);
			}
		});
		
		JLabel lblPotatisRis = new JLabel("Potatis & Ris");
		
		final JList list16 = new JList(model16);
		list16.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				list16.clearSelection();
			}
		});
	
		list16.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				SetDetailView(list16, arg0);
			}
		});
		
		JLabel lblrter_1 = new JLabel("\u00D6rter");
		GroupLayout gl_dropdown4 = new GroupLayout(dropdown4);
		gl_dropdown4.setHorizontalGroup(
			gl_dropdown4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_dropdown4.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_dropdown4.createParallelGroup(Alignment.LEADING)
						.addComponent(list12, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblBrd))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_dropdown4.createParallelGroup(Alignment.LEADING)
						.addComponent(list13, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMjlsockerSalt))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_dropdown4.createParallelGroup(Alignment.LEADING)
						.addComponent(list14, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_5))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_dropdown4.createParallelGroup(Alignment.LEADING)
						.addComponent(list15, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPotatisRis))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_dropdown4.createParallelGroup(Alignment.LEADING)
						.addComponent(lblrter_1)
						.addComponent(list16, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(353, Short.MAX_VALUE))
		);
		gl_dropdown4.setVerticalGroup(
			gl_dropdown4.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_dropdown4.createSequentialGroup()
					.addGap(4)
					.addGroup(gl_dropdown4.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBrd)
						.addComponent(lblMjlsockerSalt)
						.addComponent(lblNewLabel_5)
						.addComponent(lblPotatisRis)
						.addComponent(lblrter_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_dropdown4.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_dropdown4.createParallelGroup(Alignment.BASELINE)
							.addComponent(list14, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
							.addComponent(list15, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
							.addComponent(list16, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_dropdown4.createParallelGroup(Alignment.BASELINE)
							.addComponent(list12, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
							.addComponent(list13, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)))
					.addContainerGap())
		);
		dropdown4.setLayout(gl_dropdown4);
		
		final JPanel dropdown5 = new JPanel();
		dropdown5.setBackground(Color.MAGENTA);
		carddropdownpanel.add(dropdown5, "foodbutton5");
		
		final JList list17 = new JList(model17);
		list17.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				list17.clearSelection();
			}
		});
	
		list17.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				SetDetailView(list17, arg0);
			}
		});
		
		final JList list18 = new JList(model18);
		list18.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				list18.clearSelection();
			}
		});
	
		list18.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				SetDetailView(list18, arg0);
			}
		});
		
		JLabel lblKallaDrycker = new JLabel("Kylda Drycker");
		
		JLabel lblVarmaDrycker = new JLabel("Varma Drycker");
		GroupLayout gl_dropdown5 = new GroupLayout(dropdown5);
		gl_dropdown5.setHorizontalGroup(
			gl_dropdown5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_dropdown5.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_dropdown5.createParallelGroup(Alignment.LEADING)
						.addComponent(lblKallaDrycker)
						.addComponent(list17, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_dropdown5.createParallelGroup(Alignment.LEADING)
						.addComponent(list18, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblVarmaDrycker))
					.addContainerGap(734, Short.MAX_VALUE))
		);
		gl_dropdown5.setVerticalGroup(
			gl_dropdown5.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_dropdown5.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_dropdown5.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblKallaDrycker)
						.addComponent(lblVarmaDrycker))
					.addPreferredGap(ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
					.addGroup(gl_dropdown5.createParallelGroup(Alignment.LEADING, false)
						.addComponent(list17, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(list18, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE))
					.addGap(31))
		);
		dropdown5.setLayout(gl_dropdown5);
		
		final JPanel dropdown6 = new JPanel();
		dropdown6.setBackground(Color.WHITE);
		carddropdownpanel.add(dropdown6, "foodbutton6");
		
		final JList list19 = new JList(model19);
		list19.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				list19.clearSelection();
			}
		});
	
		list19.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				SetDetailView(list19, arg0);
			}
		});
		
		final JList list20 = new JList(model20);
		list20.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				list20.clearSelection();
			}
		});
	
		list20.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				SetDetailView(list20, arg0);
			}
		});
		
		final JList list21 = new JList(model21);
		list21.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				list21.clearSelection();
			}
		});
	
		list21.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				SetDetailView(list21, arg0);
			}
		});
		
		JLabel lblNtterFrn = new JLabel("N\u00F6tter & Fr\u00F6n");
		
		JLabel snacks = new JLabel("Snacks");
		snacks.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JLabel lblrtorBnor = new JLabel("\u00C4rtor & B\u00F6nor");
		GroupLayout gl_dropdown6 = new GroupLayout(dropdown6);
		gl_dropdown6.setHorizontalGroup(
			gl_dropdown6.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_dropdown6.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_dropdown6.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNtterFrn)
						.addComponent(list19, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_dropdown6.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_dropdown6.createSequentialGroup()
							.addComponent(lblrtorBnor)
							.addGap(50))
						.addGroup(gl_dropdown6.createSequentialGroup()
							.addComponent(list20, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)))
					.addGroup(gl_dropdown6.createParallelGroup(Alignment.LEADING)
						.addComponent(snacks)
						.addComponent(list21, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(616, Short.MAX_VALUE))
		);
		gl_dropdown6.setVerticalGroup(
			gl_dropdown6.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_dropdown6.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_dropdown6.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNtterFrn)
						.addComponent(snacks)
						.addComponent(lblrtorBnor))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_dropdown6.createParallelGroup(Alignment.BASELINE)
						.addComponent(list19, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
						.addComponent(list20, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
						.addComponent(list21, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		dropdown6.setLayout(gl_dropdown6);
		
		JLabel lblNewLabel = new JLabel("Favoriter");
		GroupLayout gl_rightpanel = new GroupLayout(rightpanel);
		gl_rightpanel.setHorizontalGroup(
			gl_rightpanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_rightpanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_rightpanel.setVerticalGroup(
			gl_rightpanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_rightpanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(448, Short.MAX_VALUE))
		);
		rightpanel.setLayout(gl_rightpanel);
		
		JLabel profilLink = new JLabel("namn namnsson");
		
		JButton cartbutton = new JButton("Kundvagn");
		cartbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				cardLayout.show(centercardpanel, "cart");
				
				
			}
		});
		GroupLayout gl_kundvagnspanel = new GroupLayout(kundvagnspanel);
		gl_kundvagnspanel.setHorizontalGroup(
			gl_kundvagnspanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_kundvagnspanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_kundvagnspanel.createParallelGroup(Alignment.LEADING)
						.addComponent(profilLink, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
						.addComponent(cartbutton, Alignment.TRAILING))
					.addContainerGap())
		);
		gl_kundvagnspanel.setVerticalGroup(
			gl_kundvagnspanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_kundvagnspanel.createSequentialGroup()
					.addGap(7)
					.addComponent(cartbutton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(profilLink, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(41, Short.MAX_VALUE))
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
			    	System.out.println("S�ker p�: "+searchstring.getText());
			    	
			    	//searchResults.displayFoodList((ArrayList<Product>) IMatDataHandler.getInstance().findProducts(searchstring.getText()));
			    	
			    	
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
					.addPreferredGap(ComponentPlacement.RELATED, 296, Short.MAX_VALUE)
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


	public void SetDetailView(JList list, ListSelectionEvent arg0) {

		String name;
		if(arg0.getValueIsAdjusting() == false && !list.isSelectionEmpty() ){
		
		name= (String) list.getSelectedValue();
		
		cardLayout.show(centercardpanel, "details");
		List<Product> pro = IMatDataHandler.getInstance().findProducts(name);
		details.setActiveProduct(pro.get(0));
		}
	}





	@Override
	public void update(Observable arg0, Object arg1) {
			
	}
	
	public void fillMyListsUp(){
		addToModel("MEAT",model1);
		addToModel("FISH",model2);
		addToModel("CABBAGE",model3);
		addToModel("CITRUS_FRUIT",model4);
		addToModel("BERRY",model5);
		addToModel("EXOTIC_FRUIT",model6);
		addToModel("FRUIT",model7);
		addToModel("VEGETABLE_FRUIT",model8);
		addToModel("MELONS",model9);
		addToModel("ROOT_VEGETABLE",model10);
		addToModel("DAIRIES",model11);
		addToModel("BREAD",model12);
		addToModel("FLOUR_SUGAR_SALT",model13);
		addToModel("PASTA",model14);
		addToModel("POTATO_RICE",model15);
		addToModel("HERB",model16);
		addToModel("COLD_DRINKS",model17);
		addToModel("HOT_DRINKS",model18);
		addToModel("NUTS_AND_SEEDS",model19);
		addToModel("POD",model20);
		addToModel("SWEET",model21);
		
	}
	
	public void addToModel(String category, DefaultListModel model){
		for(Product p: IMatDataHandler.getInstance().getProducts(ProductCategory.valueOf(category))){
			model.addElement(p.getName());
		}
	}
}
