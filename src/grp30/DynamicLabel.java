package grp30;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.Timer;

public class DynamicLabel extends JLabel implements ActionListener{
	private int delay; // 800 - 1500 recommended
	private Timer tim;
	public DynamicLabel(int delay){
		tim = new Timer(delay, this);
		setVisible(false);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		setVisible(false);
		tim.stop();
	}
	
	public void showLabel(String s){
		setText(s + " added!");
		setVisible(true);
		tim.restart();
		tim.start();
	}
	
	
}
