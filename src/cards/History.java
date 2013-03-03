package cards;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import SpecialPanels.HistoryScrollPane;

public class History extends JPanel {

	/**
	 * Create the panel.
	 */
	public History() {
		
		setBackground(Color.BLUE);
		
		HistoryScrollPane historyScrollPane = new HistoryScrollPane();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(historyScrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(historyScrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
		);
		setLayout(groupLayout);

	}
}
