package viewIMPL;

import java.util.ArrayList;
import java.util.Iterator;

import view.IDisplayContent;
import view.IDisplayable;
import view.IEvent;
import view.IObjectOnTile;
import view.IObserver;

public class Displayable implements IDisplayable {

	private IObjectOnTile tileDetails;
	private IDisplayContent displayDetails;
	private ArrayList<IObserver> observers;

	public Displayable() {
		this.observers = new ArrayList<IObserver>();
	}
	
	@Override
	public IDisplayContent getDisplay() {
		return this.displayDetails;		
	}
	
	@Override
	public void setDisplay(IDisplayContent displayDetails) {
		this.displayDetails = displayDetails;
	}

	@Override
	public IObjectOnTile getTileDetails() {
		return tileDetails;
	}

	@Override
	public void setTiles(IObjectOnTile tileDetails) {
		this.tileDetails = tileDetails;
	}

	@Override
	public void notifyObservers(IEvent event) {
		Iterator<IObserver> itrObservers = this.observers.iterator();
		while(itrObservers.hasNext()) {
			IObserver o = itrObservers.next();
			o.update(this, event);
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
	public void checkAddition() {
		Event addedToTile = new Event("ADDED_TO_TILE");
		this.notifyObservers(addedToTile);
	}
}
