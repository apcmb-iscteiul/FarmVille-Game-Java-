package pt.iul.ista.poo.farm;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import pt.iul.ista.poo.farm.objects.Cabage;
import pt.iul.ista.poo.farm.objects.FarmObject;
import pt.iul.ista.poo.farm.objects.Farmer;
import pt.iul.ista.poo.farm.objects.Land;
import pt.iul.ista.poo.farm.objects.Sheep;
import pt.iul.ista.poo.farm.objects.Tomato;
import pt.iul.ista.poo.farm.objects.Vegetable;
import pt.iul.ista.poo.gui.ImageMatrixGUI;
import pt.iul.ista.poo.gui.ImageTile;
import pt.iul.ista.poo.utils.Direction;
import pt.iul.ista.poo.utils.Point2D;


public class Farm implements Observer  {

	//private static final String SAVE_FNAME = "config/savedGame";
	private Sheep meme;
	private static final int MIN_X = 5;
	private static final int MIN_Y = 5;
	private static Farm INSTANCE;
	private static int max_x = 5;
	private static int max_y = 7;
	private Farmer farmer;
	private ArrayList<FarmObject> auxMap= new ArrayList<FarmObject>();   

	private Farm(int max_x, int max_y) {
		if (max_x < MIN_X || max_y < MIN_Y)
			throw new IllegalArgumentException();

		INSTANCE = this;
		ImageMatrixGUI.setSize(max_x, max_y);
		loadScenario();
	}

	public List<FarmObject> getAuxMap(){
		return auxMap;
	}

	private void registerAll() {

		farmer = new Farmer(new Point2D(0,0));
		meme = new Sheep(new Point2D(3,5));

		auxMap.add(farmer); 
		auxMap.add(meme);
		for(int i=0; i<max_x;i++){
			for(int j=0; j<max_y;j++){
				auxMap.add(new Land(new Point2D(i,j) , "land"));
			}
			}
		
		copyMap();
		ImageMatrixGUI.getInstance().update();
		
	}				

	private void loadScenario() {
		registerAll();
	}

	private void copyMap(){
		for(FarmObject a: auxMap)
			ImageMatrixGUI.getInstance().addImage(a);	
	}

	public FarmObject findObject(Point2D p){
		FarmObject obj = null;
		int layer=0;

		for(FarmObject a: auxMap){
			if(p.equals(a.getPosition()) && a.getLayer() >= layer){
				obj= a;
			}
		}
		return obj;
	}


	private void checkCycle(){

		for(FarmObject a: auxMap){
			if(a instanceof Tomato){
				((Tomato)a).freezer_BoostChecker();
			}
			else if(a instanceof Cabage){
				((Cabage)a).freezer_BoostChecker();
			}
		}
	}



	public void all(){
		checkCycle();
		copyMap();
	}

	public void sysouts(){
		
		for(FarmObject a : auxMap){
			System.out.println(a.getImageName() + a.getLayer());
		}
	}
	@Override
	public void update(Observable gui, Object a) {
		int key = (Integer) a;

		
		switch(key){
		case KeyEvent.VK_UP:
		case KeyEvent.VK_DOWN:
		case KeyEvent.VK_RIGHT:
		case KeyEvent.VK_LEFT:
			farmer.wakeUp(Direction.directionFor(key));
			farmer.setSpace(false);  break;
		case KeyEvent.VK_SPACE: farmer.setSpace(true); break;
		} 

		all();
		ImageMatrixGUI.getInstance().setStatusMessage("Points: ");
		ImageMatrixGUI.getInstance().update();
	}

	// Não precisa de alterar nada a partir deste ponto
	private void play() {
		ImageMatrixGUI.getInstance().addObserver(this);
		ImageMatrixGUI.getInstance().go();
	}

	public static Farm getInstance() {
		assert (INSTANCE != null);
		return INSTANCE;
	}
	public static void main(String[] args) {
		Farm f = new Farm(max_x, max_y);
		f.play();
	}
}
