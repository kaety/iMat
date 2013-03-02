package cards;

import java.util.Observer;
import java.util.ArrayList;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import se.chalmers.ait.dat215.project.Product;
import SpecialPanels.SearchScrollPane;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

public class SearchResults extends JPanel{
	SearchScrollPane searchScrollPane;
	JLabel lblIngaVarorHittades;
	public SearchResults(Observer o) {
		setBackground(Color.CYAN);
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)
		);
		
		searchScrollPane = new SearchScrollPane(o);
		
		JLabel lblSkresultat = new JLabel("S\u00F6kresultat:");
		lblSkresultat.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		lblIngaVarorHittades = new JLabel("Inga varor hittades!");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblSkresultat)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblIngaVarorHittades)
					.addContainerGap(332, Short.MAX_VALUE))
				.addComponent(searchScrollPane, GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSkresultat)
						.addComponent(lblIngaVarorHittades))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(searchScrollPane, GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		setLayout(groupLayout);
	}
	
	public void displayFoodList(ArrayList<Product> p){
		lblIngaVarorHittades.setVisible(false);
		searchScrollPane.setVisible(true);
		searchScrollPane.setListData(p);
		if(searchScrollPane.getListLength() == 0){
			searchScrollPane.setVisible(false);
			lblIngaVarorHittades.setVisible(true);
		}
	}
	
	public void setFavoritesButtons(){
		searchScrollPane.setFavoritesButtons();
	}
}
