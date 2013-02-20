import com.jgoodies.forms.layout.CellConstraints.Alignment;


public class testFrame extends Observable implements Observer{
	Box box;
	int kk = 0;
	private JFrame frame;
	JScrollPane scrollPane;
	JPanel pinkPanel;
	JLabel lblMcpenispants;
	private final Action action = new HidePinkMenu();
	private final Action action_1 = new TestBattan();
	private JTextField txtPotatis;
	private final Action action_2 = new addNewPanel();

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
		frame.setBounds(100, 100, 450, 399);
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
		
		pinkPanel = new JPanel();
		pinkPanel.setBackground(Color.PINK);
		pinkPanel.setVisible(false);
		
		scrollPane = new JScrollPane();
		box = Box.createVerticalBox();
		scrollPane.setViewportView(box);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
				.addComponent(pinkPanel, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnB)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnB_1)
					.addGap(200))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pinkPanel, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnB)
						.addComponent(btnB_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		JButton btnC = new JButton("C 1");
		btnC.setAction(action_1);
		
		lblMcpenispants = new JLabel("");
		
		txtPotatis = new JTextField();
		txtPotatis.setText("Potatis");
		txtPotatis.setColumns(10);
		GroupLayout gl_pinkPanel = new GroupLayout(pinkPanel);
		gl_pinkPanel.setHorizontalGroup(
			gl_pinkPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pinkPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtPotatis, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnC)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblMcpenispants)
					.addContainerGap(154, Short.MAX_VALUE))
		);
		gl_pinkPanel.setVerticalGroup(
			gl_pinkPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pinkPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pinkPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtPotatis, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnC)
						.addComponent(lblMcpenispants))
					.addContainerGap(12, Short.MAX_VALUE))
		);
		pinkPanel.setLayout(gl_pinkPanel);
		
		JButton btnA = new JButton("A 1");
		
		JButton btnA_1 = new JButton("A 2");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnA)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnA_1)
					.addContainerGap(280, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnA)
						.addComponent(btnA_1))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		frame.getContentPane().setLayout(groupLayout);
	}
	private class HidePinkMenu extends AbstractAction {
		public HidePinkMenu() {
			putValue(NAME, "Show/hide Menu");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			pinkPanel.setVisible(!pinkPanel.isVisible());
		}
	}
	@Override
	public void update(Observable o, Object arg) {
		lblMcpenispants.setText((String) arg);
	}
	private class TestBattan extends AbstractAction {
		public TestBattan() {
			putValue(NAME, "Give me recipe");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			iMatController.getInstance().testBattanPressed(txtPotatis.getText());
			
		}
	}
	private class addNewPanel extends AbstractAction {
		public addNewPanel() {
			putValue(NAME, "add new Jpanel");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			addPanel();
		}
	}
	private void addPanel(){
		Integer k = kk++;
		MatRes mm = new MatRes("Food " + k.toString());
		box.add(mm);
		scrollPane.validate();
	}
}
