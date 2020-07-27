package pt.iul.ista.poo.farm.objects;

import pt.iul.ista.poo.gui.ImageTile;
import pt.iul.ista.poo.utils.Point2D;

public abstract class FarmObject implements ImageTile{

	private Point2D position;
	private int layer;
	private String imageName;

	public FarmObject(Point2D p, int layer, String imageName) {
		this.position = p;
		this.layer = layer;
		this.imageName = imageName;
	}
	
	
	public void setImage(String imageName){
		this.imageName = imageName;
	}
	
	public String getImageName(){
		return this.imageName;
	}
	
	public void setPosition(Point2D p){
		position = p;
	}
			
	public abstract boolean allowObject();

	@Override
	public String getName() {
		return imageName;
	}

	@Override
	public Point2D getPosition() {
		return position;
	}

	@Override
	public int getLayer() {
		return layer;
	}
	
	
	
}
