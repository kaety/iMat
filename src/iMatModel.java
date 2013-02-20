

public class iMatModel extends Observable{

	public iMatModel(){
	}
	
	public void tester(String input){
		RecipeGenerator g = new RecipeGenerator();
		setChanged();
		notifyObservers(g.getNewRecipe(input));
	}
	
}
