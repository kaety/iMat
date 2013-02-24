package grp30;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.util.Observer;

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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField searchstring;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		final JPanel carddropdownpanel = new JPanel();
		carddropdownpanel.setBackground(Color.PINK);
		carddropdownpanel.setVisible(false);
		
		JPanel rightpanel = new JPanel();
		rightpanel.setBackground(Color.GRAY);
		
		JPanel buttonpanel = new JPanel();
		buttonpanel.setBackground(Color.GRAY);
		
		JPanel centercardpanel = new JPanel();
		centercardpanel.setBackground(Color.GRAY);
		
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
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(buttonpanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(toppanel, 0, 0, Short.MAX_VALUE)
								.addComponent(centercardpanel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 785, Short.MAX_VALUE)
								.addComponent(carddropdownpanel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(foodandsearchpanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(kundvagnspanel, GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
								.addComponent(rightpanel, GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE))))
					.addContainerGap(23, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(toppanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(foodandsearchpanel, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
						.addComponent(kundvagnspanel, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(carddropdownpanel, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(centercardpanel, GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE))
						.addComponent(rightpanel, GroupLayout.PREFERRED_SIZE, 486, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(buttonpanel, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		carddropdownpanel.setLayout(new CardLayout(0, 0));
		
		final JPanel dropdown1 = new JPanel();
		dropdown1.setBackground(Color.PINK);
		carddropdownpanel.add(dropdown1, "foodbutton1");
		
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

		JButton foodButton1 = new JButton("k\u00F6tt");
		foodButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (carddropdownpanel.isVisible() && dropdown1.isVisible()) {

					carddropdownpanel.setVisible(false);

				} else {
					carddropdownpanel.setVisible(true);
					CardLayout cardLayout = (CardLayout) (carddropdownpanel
							.getLayout());
					cardLayout.show(carddropdownpanel, "foodbutton1");
				}
			}
		});

		JButton foodButton2 = new JButton("fisk");
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
		
		JButton btnNewButton_2 = new JButton("mejeri");
		btnNewButton_2.addActionListener(new ActionListener() {
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
		
		JButton btnNewButton_3 = new JButton("b\u00E4r");
		btnNewButton_3.addActionListener(new ActionListener() {
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
		
		JButton btnNewButton_4 = new JButton("n\u00F6tter");
		btnNewButton_4.addActionListener(new ActionListener() {
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
		
		JButton btnNewButton_5 = new JButton("folk\u00F6l");
		btnNewButton_5.addActionListener(new ActionListener() {
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
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(6)
					.addComponent(foodButton1, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(foodButton2, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_3, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_4, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_5, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(searchstring, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(38, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(searchstring, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(foodButton1)
						.addComponent(foodButton2)
						.addComponent(btnNewButton_2)
						.addComponent(btnNewButton_3)
						.addComponent(btnNewButton_4)
						.addComponent(btnNewButton_5))
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
		centercardpanel.setLayout(new CardLayout(0, 0));
		
		JPanel varuvy = new JPanel();
		varuvy.setBackground(Color.YELLOW);
		centercardpanel.add(varuvy, "name_89197531763174");
		
		JPanel registrering = new JPanel();
		registrering.setBackground(Color.BLUE);
		centercardpanel.add(registrering, "name_89204269755190");
		
		JPanel kundvagn = new JPanel();
		kundvagn.setBackground(Color.GREEN);
		centercardpanel.add(kundvagn, "name_89208888451515");
		contentPane.setLayout(gl_contentPane);
	}
}
