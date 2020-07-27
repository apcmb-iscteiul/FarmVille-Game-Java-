package pt.iul.ista.poo.farm.objects;

import pt.iul.ista.poo.utils.Point2D;

public class Sheep extends FarmObject{

	public Sheep(Point2D p) {
		super(p, 3, "sheep");
	}

	@Override
	public boolean allowObject() {
		return false;
	}
}
