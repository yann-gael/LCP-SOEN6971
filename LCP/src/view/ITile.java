package view;

import java.util.ArrayList;

public interface ITile extends IObservable {
	public void setLocation(ILocationPoints loc);
	public void setLeft(ITile left);
	public void setRight(ITile right);
	public void setUp(ITile up);
	public void setDown(ITile down);
	public void setTileX(Integer X);
	public void setTileY(Integer Y);
	public void setObjectsOnTiles(ArrayList<IDisplayable> objectsOnTiles);
	
	public ILocationPoints getLocation();
	public ITile getLeft();
	public ITile getRight();
	public ITile getUp();
	public ITile getDown();
	public Integer getTileX();
	public Integer getTileY();
	public ArrayList<IDisplayable> getObjectsOnTiles();
}
