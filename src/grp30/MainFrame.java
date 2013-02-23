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
		
		JPanel carddropdownpanel = new JPanel();
		carddropdownpanel.setBackground(Color.PINK);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		
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
								.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE))))
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
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 486, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(buttonpanel, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		carddropdownpanel.setLayout(new CardLayout(0, 0));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 174, Short.MAX_VALUE)
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 486, Short.MAX_VALUE)
		);
		panel_1.setLayout(gl_panel_1);
		GroupLayout gl_kundvagnspanel = new GroupLayout(kundvagnspanel);
		gl_kundvagnspanel.setHorizontalGroup(
			gl_kundvagnspanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 174, Short.MAX_VALUE)
		);
		gl_kundvagnspanel.setVerticalGroup(
			gl_kundvagnspanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 114, Short.MAX_VALUE)
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
		searchstring.setText("Search...");
		searchstring.setColumns(10);
		
		JButton btnNewButton = new JButton("k\u00F6tt");
		
		JButton btnNewButton_1 = new JButton("fisk");
		
		JButton btnNewButton_2 = new JButton("mejeri");
		
		JButton btnNewButton_3 = new JButton("b\u00E4r");
		
		JButton btnNewButton_4 = new JButton("n\u00F6tter");
		
		JButton btnNewButton_5 = new JButton("folk\u00F6l");
		GroupLayout groupLayout = new GroupLayout(foodandsearchpanel);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(6)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
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
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1)
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
		contentPane.setLayout(gl_contentPane);
	}
}
