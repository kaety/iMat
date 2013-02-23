package grp30;
import grp30.MatRes.MyObservable;

import java.util.Observable;
import java.util.Observer;

import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Product;


public class iMatController extends Observable implements Observer{
	private static iMatController instance = null;
	
	testFrame t;
	iMatModel m;
	
	public iMatController(){
		init();
	}
	
	public static void main(String[] args) {
		iMatController c = new iMatController();
		
	}
	
	private void init(){
		t = new testFrame();
		t.addObserver(this);
		m = new iMatModel();
		m.addObserver(t);
		}
	
	public void testBattanPressed(String input){
		m.tester(input);
	}
	
	public void searchFood(){
		m.getSearchResult();
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		if(arg0 instanceof testFrame){
			if(arg1 instanceof ButtonPressed) handleGuiPressed((ButtonPressed) arg1);
			else if(arg1 instanceof MatRes) addAsObserver((MatRes) arg1); 
		}
		else if(arg0 instanceof MyObservable){
			Product p = (Product) arg1;
			m.addToShoppingCart(p);
		}
		
	}
	
	private void handleGuiPressed(ButtonPressed but){
		if(but.getButtonId().equals("searchFood")) searchFood();
	}
	
	public void addAsObserver(MatRes o){
		o.addObserver(this);
	}
	
}
