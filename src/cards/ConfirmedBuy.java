package cards;

import grp30.MainFrame;
import gui.IMatColors;
import gui.IMatFonts;

import java.awt.Color;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Dimension;
import javax.swing.UIManager;
import java.awt.Cursor;

public class ConfirmedBuy extends JPanel {

	/**
	 * Create the panel.
	 */
	public ConfirmedBuy(final MainFrame mf) {
		
		setBackground(Color.WHITE);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(IMatColors.BASE, 3, true));
		panel.setBackground(Color.WHITE);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(116, Short.MAX_VALUE))
		);
		
		JLabel dittKvittoText = new JLabel("Kvittens har skickats till din E-mail.");
		dittKvittoText.setHorizontalAlignment(SwingConstants.CENTER);
		dittKvittoText.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel tackForBestallningText = new JLabel("Tack f\u00F6r din best\u00E4llning!");
		tackForBestallningText.setHorizontalAlignment(SwingConstants.CENTER);
		tackForBestallningText.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
						.addComponent(dittKvittoText, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
						.addComponent(tackForBestallningText, GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(tackForBestallningText, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(dittKvittoText, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(86, Short.MAX_VALUE))
		);
		
		final JLabel goToReceipLabel = new JLabel("Klicka h\u00E4r f\u00F6r att se kvitto");
		goToReceipLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		goToReceipLabel.setHorizontalAlignment(SwingConstants.CENTER);
		goToReceipLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				super.mouseEntered(arg0);
				goToReceipLabel.setForeground(IMatColors.BASE_LIGHT);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				super.mouseExited(e);
				goToReceipLabel.setForeground(IMatColors.BASE);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				mf.swapCard("receipt");
			}
			
		});
		goToReceipLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		goToReceipLabel.setForeground(IMatColors.BASE);
		panel_1.add(goToReceipLabel);
		panel.setLayout(gl_panel);
		setLayout(groupLayout);

	}
}
