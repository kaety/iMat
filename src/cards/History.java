package cards;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import se.chalmers.ait.dat215.project.IMatDataHandler;
import SpecialPanels.HistoryScrollPane;

public class History extends JPanel {
	private HistoryScrollPane historyScrollPane;

	/**
	 * Create the panel.
	 */
	public History() {
		
		setBackground(Color.BLUE);
		
		historyScrollPane = new HistoryScrollPane();
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
	
	public void updateHistory(){
		
		historyScrollPane.placeHistory();
	}
}
