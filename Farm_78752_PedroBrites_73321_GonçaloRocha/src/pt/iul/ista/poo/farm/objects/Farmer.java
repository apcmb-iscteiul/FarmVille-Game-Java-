package pt.iul.ista.poo.farm.objects;

import pt.iul.ista.poo.farm.Farm;
import pt.iul.ista.poo.utils.Direction;
import pt.iul.ista.poo.utils.Point2D;

	
public class Farmer extends FarmObject{
	
	private boolean space;
	
	public Farmer(Point2D p){
		super(p, 3, "farmer");
		this.space = false;
	}
	
	public boolean getSpace() {
		return space;
	}

	public void setSpace(boolean space) {
		this.space = space;
	}

	public void move(Point2D p){
			if(canImove(p))
				setPosition(p);
	}
	
	public void wakeUp(Direction direction) {

		Point2D p = this.getPosition().plus(direction.asVector());
		if(space)
			performAction(p);
		else

			move(p);
		
			
		
	}
	
	private void performAction(Point2D p) {
		FarmObject obj = Farm.getInstance().findObject(p);
		
		if(obj != null) {
			if(obj instanceof Land && obj.getImageName()=="land")
				((Land) obj).plow();
			else if(obj instanceof Land && obj.getImageName()=="plowed")
				((Land) obj).plant();
			else if( obj instanceof Tomato){
					((Tomato)obj).setFrozen_Boosted(false);
			}
			else if(obj instanceof Cabage){
					((Cabage)obj).setFrozen_Boosted(true);
			}
		}
		space = false;
	}
		
	private boolean canImove(Point2D p){	
		FarmObject obj= Farm.getInstance().findObject(p);

		if( obj != null && obj.allowObject())
			return true;
		return false;
	}

	@Override
	public boolean allowObject() {
		return false;
	}
}
