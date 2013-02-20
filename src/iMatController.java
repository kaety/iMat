
public class iMatController {
	private static iMatController instance = null;
	
	testFrame t;
	iMatModel m;
	
	protected iMatController(){
		init();
	}
	
	public static iMatController getInstance(){
		 if(instance == null) {
	         instance = new iMatController();
	      }
	      return instance;
	}
	
	public static void main(String[] args) {
		iMatController c = new iMatController();
		
	}
	
	private void init(){
		t = new testFrame();
		m = new iMatModel();
		m.addObserver(t);
	}
	
	public void testBattanPressed(String input){
		m.tester(input);
	}
	
}
