package pt.iul.ista.poo.farm.objects;

import pt.iul.ista.poo.utils.Point2D;

public abstract class Vegetable extends FarmObject {

	private int life;
	private boolean frozen_boosted;
	private int counter;
	
	public Vegetable(Point2D p, String imageName, int life, boolean care) {
		super(p, 2, imageName);
		this.life=life;
		this.frozen_boosted = false;
		this.counter = 0;
	}

	
	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}
	
	

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public boolean isFrozen_Boosted() {
		return frozen_boosted;
	}



	public void setFrozen_Boosted(boolean frozen) {
		this.frozen_boosted = frozen;
	}


	@Override
	public boolean allowObject() {
		return false;
	}
	
	abstract void freezer_BoostChecker();

}
