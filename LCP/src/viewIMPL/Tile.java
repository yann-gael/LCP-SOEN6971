package viewIMPL;

import java.util.ArrayList;
import java.util.Iterator;

import view.IDisplayable;
import view.IEvent;
import view.ILocationPoints;
import view.IObservable;
import view.IObserver;
import view.ITile;

public class Tile implements ITile, IObservable {
	private ILocationPoints location;
	private ITile left;
	private ITile right;
	private ITile up;
	private ITile down;
	private Integer tileXNum;
	private Integer tileYNum;
	private ArrayList<IDisplayable> objectsOnTiles;

	private ArrayList<IObserver> observers;
	
	
	public Tile() {
		location = null;
		left = null;
		right = null;
		up = null;
		down = null;
		tileXNum = null;
		tileYNum = null;
		setObjectsOnTiles(new ArrayList<IDisplayable>());
	}
	
	@Override
	public void setLocation(ILocationPoints loc) {
		this.location = loc;
	}
	
	@Override
	public void setLeft(ITile left) {
		this.left = left;
	}
	
	@Override
	public void setRight(ITile right) {
		this.right = right;
	}
	
	@Override
	public void setUp(ITile up) {
		this.up = up;
	}
	
	@Override
	public void setDown(ITile down) {
		this.down = down;
	}
	
	@Override
	public void setTileX(Integer X) {
		this.tileXNum = X;
	}
	
	@Override
	public void setTileY(Integer Y) {
		this.tileYNum = Y;
	}
	
	@Override
	public ILocationPoints getLocation() {
		return this.location;
	}
	
	@Override
	public ITile getLeft() {
		return this.left;
	}
	
	@Override
	public ITile getRight() {
		return this.right;
	}
	
	@Override
	public ITile getUp() {
		return this.up;
	}
	
	@Override
	public ITile getDown() {
		return this.down;
	}
	
	@Override
	public Integer getTileX() {
		return this.tileXNum;
	}
	
	@Override
	public Integer getTileY() {
		return this.tileYNum;
	}

	@Override
	public void notifyObservers(IEvent event) {
		Iterator<IObserver> itr = this.observers.iterator();
		while(itr.hasNext())
		{
			IObserver obs = itr.next();
			obs.update(this);
		}
	}

	@Override
	public void addObserver(IObserver observer) {
		this.observers.add(observer);
	}

	@Override
	public void removeObserver(IObserver observer) {
		this.observers.remove(observer);
	}

	@Override
	public Iterator<IObserver> getObserver() {
		return this.observers.iterator();
	}

	@Override
	public ArrayList<IDisplayable> getObjectsOnTiles() {
		return objectsOnTiles;
	}
	
	@Override
	public void setObjectsOnTiles(ArrayList<IDisplayable> objectsOnTiles) {
		this.objectsOnTiles = objectsOnTiles;
	}
	
}
