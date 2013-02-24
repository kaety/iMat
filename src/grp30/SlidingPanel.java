package grp30;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class SlidingPanel extends JPanel implements ActionListener{

	Timer tim;
	private boolean outSlided;
	private int fullSize; // FIX TO BE SET DYN
	private int scrollSteps = 3;
	
	public SlidingPanel(){
		tim = new Timer(10,this);
		setSize(getWidth(), getHeight());
		outSlided = true;
	}
	
	public void changeState(){
		tim.restart();
		tim.start();
	}
	
	private void erize(){
		if(outSlided){
			if(getHeight() > fullSize) fullSize = getHeight();
			if(getSize().height > 0) setSize(getSize().width,getSize().height-scrollSteps);
			else{
				tim.stop();
				outSlided = !outSlided;
			}
		}
		else{
			if(getSize().height < fullSize) setSize(getSize().width,getHeight()+scrollSteps);
			else{
				tim.stop();
				outSlided = !outSlided;
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		erize();
	}

}
