package grp30;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.Timer;

import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.ShoppingCartListener;
import se.chalmers.ait.dat215.project.ShoppingItem;

public class DynamicLabel extends JLabel implements ActionListener{
	private Timer tim;
	public DynamicLabel(int delay){// 800 - 1500 recommended
		tim = new Timer(delay, this);
		setVisible(false);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		setVisible(false);
		tim.stop();
	}
	
	public void showLabel(String s){
		setText(s + " tillagt!");
		setVisible(true);
		tim.restart();
		tim.start();
	}
	
}
