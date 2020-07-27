package pt.iul.ista.poo.farm.objects;

import java.util.Random;

import pt.iul.ista.poo.farm.Farm;
import pt.iul.ista.poo.farm.Interactable;
import pt.iul.ista.poo.utils.Point2D;

public class Land extends FarmObject implements Interactable{

	public Land(Point2D p, String imageName) {
		super(p, 0, imageName);
	}

	public void plow(){
		this.setImage("plowed");
	}

	public void plant() {	
		Random r = new Random();
		int i = r.nextInt(2);

		if(i==0)
			Farm.getInstance().getAuxMap().add(new Tomato (this.getPosition() , "small_tomato" , false));
		if(i==1)
			Farm.getInstance().getAuxMap().add(new Cabage (this.getPosition() , "small_cabage", false));
	}

	@Override
	public boolean allowObject() {
		return true;
	}


}
