package grp30;

import java.awt.EventQueue;
import java.util.Observable;
import java.util.Observer;


import SpecialPanels.SearchResultPanel;
import SpecialPanels.SearchResultPanel.MyObservable;

import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ShoppingItem;


public class iMatController extends Observable implements Observer{
	
	//this should be deleted //Kryztof
	//private static iMatController instance = null;
	
	testFrame t;
	iMatModel m;
	MainFrame mf;
	
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
		//trying the Inglorious Bastard Observer pattern on MainFrame
		mf = new MainFrame();
		m.addObserver(mf);
		mf.addObserver(this);
		}
	
	public void testBattanPressed(String input){
		m.tester(input);
	}
	
	public void searchFood(){
		m.getSearchResult();
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		
		if(arg0 instanceof testFrame || arg0 instanceof MainFrame){
			if(arg1 instanceof ButtonPressed) handleGuiPressed((ButtonPressed) arg1);
			else if(arg1 instanceof SearchResultPanel) addAsObserver((SearchResultPanel) arg1); 
		}
		else if(arg0 instanceof MyObservable){
			ShoppingItem i = (ShoppingItem) arg1;
			m.addToShoppingCart(i);
		}
		
	}
	
	private void handleGuiPressed(ButtonPressed but){
		
		
		if(but.getButtonId().equals("searchFood")) searchFood();
	}
	




	public void addAsObserver(SearchResultPanel o){
		o.addObserver(this);
	}
	
}
