package grp30;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ProductCategory;
import se.chalmers.ait.dat215.project.ShoppingItem;

public class iMatModel extends Observable{
	
	IMatDataHandler handler;
	
	List<Product> searchResult;
	public iMatModel(){
		handler = IMatDataHandler.getInstance();
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

	public void getFoodQuery1() {
		List<Product> food1= new ArrayList<Product>();
		List<String>  food1name= new ArrayList<String>();
		ProductCategory meat = ProductCategory.valueOf("MEAT");
		ProductCategory fish = ProductCategory.valueOf("FISH");
		food1.addAll(handler.getProducts(meat));
		food1.addAll(handler.getProducts(fish));
		for(Product p: food1){
			food1name.add(p.getName());
		}
		setChanged();
		
		notifyObservers(food1name);
		
	}
	
}
