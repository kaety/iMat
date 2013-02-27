package grp30;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class RecipeGenerator {
	
	List<String> prefix;
	List<String> suffix;

	public RecipeGenerator(){
		prefix = new LinkedList<String>();
		suffix = new LinkedList<String>();
		addPrefix();
		addSuffix();
	}
	
	public String getNewRecipe(String ingredient){
		Random r = new Random();
		int i = r.nextInt(2);
		if(i == 0){
			int k = r.nextInt(prefix.size());
			return prefix.get(k) + ingredient;
		}
		else{
			int k = r.nextInt(prefix.size());
			return ingredient + suffix.get(k);
		}
	}
	
	private void addPrefix(){
		prefix.add("Hemlagad ");
		prefix.add("Stuvad ");
		prefix.add("Stekt ");
		prefix.add("Ugnsgratinerad ");
		prefix.add("Baconinlindad ");
		prefix.add("Soltorkad ");
		prefix.add("Sm�rstekt ");
	}
	
	private void addSuffix(){
		suffix.add("mos");
		suffix.add("grat�ng");
		suffix.add("paj");
		suffix.add("pastej");
		suffix.add("pudding");
		suffix.add("pl�ttar");
		suffix.add("mackor");
	}
	
}
