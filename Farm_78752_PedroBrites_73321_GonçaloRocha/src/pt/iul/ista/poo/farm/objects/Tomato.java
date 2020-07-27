package pt.iul.ista.poo.farm.objects;

import pt.iul.ista.poo.utils.Point2D;

public class Tomato extends Vegetable{



	public Tomato(Point2D p, String imageName, boolean care) {
		super(p, imageName, 0, false);


	}



	@Override
	public boolean allowObject() {
		return false;
	}


	@Override
	public void freezer_BoostChecker() {



		if(!isFrozen_Boosted() && this.getLife() - this.getCounter() < 10){
			this.setLife(this.getLife() + 1);
		}


		if(this.getLife() - this.getCounter() >= 10){
			setFrozen_Boosted(true);
			this.setCounter(this.getLife());
		}

		if(this.getLife() == 15 && !this.isFrozen_Boosted()){
			this.setImage("tomato");

		}

		else if(this.getLife() == 25 && !this.isFrozen_Boosted() ){
			this.setImage("bad_tomato");
		}

	}



}
