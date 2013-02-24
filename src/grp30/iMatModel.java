package grp30;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ShoppingItem;

public class iMatModel extends Observable{

	List<Product> searchResult;
	public iMatModel(){
	}
	
	public void tester(String input){
		RecipeGenerator g = new RecipeGenerator();
		setChanged();
		notifyObservers(g.getNewRecipe(input));
	}
	
	public void getSearchResult(){
		searchResult = IMatDataHandler.getInstance().getProducts();
		setChanged();
		notifyObservers(searchResult);
	}
	
	public void addToShoppingCart(ShoppingItem i){
		IMatDataHandler.getInstance().getShoppingCart().addItem(i);
		setChanged();
		notifyObservers(IMatDataHandler.getInstance().getShoppingCart());
	}
	
}
