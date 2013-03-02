package cards;

import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JList;
import javax.swing.JPanel;

import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.ShoppingCartListener;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import SpecialPanels.ShoppingCartScrollPane;

public class ShoppingCart extends JPanel implements ShoppingCartListener{
	JLabel lblNumpr;
	JLabel lblSum;
	public ShoppingCart(){
		IMatDataHandler.getInstance().getShoppingCart().addShoppingCartListener(this);
		setBackground(Color.GREEN);
		
		JButton btnTillKassan = new JButton("Till Kassan");
		
		JPanel panel = new JPanel();
		
		ShoppingCartScrollPane shoppingCartScrollPane = new ShoppingCartScrollPane();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(shoppingCartScrollPane, GroupLayout.DEFAULT_SIZE, 653, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap(582, Short.MAX_VALUE)
							.addComponent(btnTillKassan))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 653, Short.MAX_VALUE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(shoppingCartScrollPane, GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnTillKassan)
					.addContainerGap())
		);
		
		JLabel lblAntalVaror = new JLabel("Antal Varor:");
		
		lblNumpr = new JLabel("0");
		
		JLabel lblPrisTot = new JLabel("Pris Tot:");
		
		lblSum = new JLabel("0");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAntalVaror)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNumpr)
					.addPreferredGap(ComponentPlacement.RELATED, 251, Short.MAX_VALUE)
					.addComponent(lblPrisTot)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblSum)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAntalVaror)
						.addComponent(lblNumpr)
						.addComponent(lblSum)
						.addComponent(lblPrisTot))
					.addContainerGap(12, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		setLayout(groupLayout);

	}
	
	private void refreshList(){
		lblNumpr.setText(IMatDataHandler.getInstance().getShoppingCart().getItems().size() + " st varor");
		lblSum.setText(IMatDataHandler.getInstance().getShoppingCart().getTotal() + " kr");
	}
	
	@Override
	public void shoppingCartChanged() {
		refreshList();
		
	}
}
