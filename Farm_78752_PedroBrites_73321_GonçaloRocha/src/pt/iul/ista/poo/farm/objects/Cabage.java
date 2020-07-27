package pt.iul.ista.poo.farm.objects;

import pt.iul.ista.poo.utils.Point2D;

public class Cabage extends Vegetable{

	public Cabage(Point2D p, String imageName, boolean care) {
		super(p, imageName, 0, false);
	}

	@Override
	public boolean allowObject() {
		return false;
	}



	@Override
	public void freezer_BoostChecker() {

		if(!isFrozen_Boosted()){
			this.setLife(this.getLife() + 1);
		}

		else if(isFrozen_Boosted()){
			this.setLife(this.getLife() + 2);
		}

		if(this.getLife() >= 15){
			this.setImage("cabage");

		}

		if(this.getLife() >= 25){
			this.setImage("bad_cabage");
		}
	}


}

