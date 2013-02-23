import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Product;


public class MatRes extends JPanel implements MouseListener{

	/**
	 * Create the panel.
	 */
	private Color panelColor;
	private final Color highLightColor = Color.WHITE;
	private Product product;

	public MatRes(Product p, boolean lightPanel) {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		if(lightPanel) panelColor = Color.LIGHT_GRAY;
		else panelColor = Color.DARK_GRAY;
		setBackground(panelColor);
	    addMouseListener(this);
		JLabel lblFood = new JLabel(p.getName());
		
		JButton btnBattan = new JButton("battan");
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "5", "10"}));
		
		
		//ImageIcon icon = createImageIcon(System.getProperty("user.home") + "\\.dat215\\imat\\images\\" + p.getImageName(),p.getName());
		ImageIcon icon = IMatDataHandler.getInstance().getImageIcon(p);
		JLabel lblImage = new JLabel(icon);
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblImage)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblFood)
					.addPreferredGap(ComponentPlacement.RELATED, 302, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBattan))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblImage)
							.addComponent(lblFood))
						.addComponent(btnBattan))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(238, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		setBackground(highLightColor);
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		setBackground(panelColor);
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public Product getProduct() {
		return product;
	}
}
