package grp30;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class SlidingPanel extends JPanel implements ActionListener{

	Timer tim;
	private boolean outSlided;
	private int fullSize; // FIX TO BE SET DYN
	private int scrollSteps = 6;
	boolean first;
	
	public SlidingPanel(){
		tim = new Timer(10,this);
		setSize(getWidth(), getHeight());
		outSlided = true;
		first = false;
		setVisible(true);
	}
	
	public void changeState(){
		tim.restart();
		tim.start();
	}
	
	private void slideIn(){
		if(getHeight() > fullSize) fullSize = getHeight();
		if(getHeight() > scrollSteps) setSize(getWidth(),getSize().height-scrollSteps);
		else{
			tim.stop();
			setVisible(false);
			repaint();
			first = true;
			outSlided = !outSlided;
		}
	}
	
	//This fucker right here may be making the panel a bit bigger than its original
	//size. May have to fix that...
	private void slideOut(){
		if(getSize().height < fullSize){
			setSize(getSize().width,getHeight()+scrollSteps);
		}
		else{
			tim.stop();
			outSlided = !outSlided;
		}
	}
	
	private void erize(){
		if(outSlided){
				slideIn();
		}
		else{
			slideOut();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//This shit right here is needed because setVisible automagically
		//sets size to Default size. For some reason it needs to be redrawn
		//before it can be resized to 0 again :S
		if(first){
			if(!isVisible()) setVisible(true);
			else{
				setSize(getWidth(), 0);
				first = false;
			}

		}
		erize();
	}

}
