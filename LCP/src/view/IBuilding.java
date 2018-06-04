package view;

import java.util.Iterator;

public interface IBuilding extends IDisplayable {
	
	public void addOccupant(final IDisplayable occupant);
	public void removeOccupant(final IDisplayable occupant);
	public Iterator<IDisplayable> getOccupants();
	
	public void addPet(final IDisplayable pet);
	public void removePet(final IDisplayable pet);
	public Iterator<IDisplayable> getPets();
	
	public void addFloor(final IDisplayable floor);
	public void removeFloor(final IDisplayable floor);
	public Iterator<IDisplayable> getFloors();
	public Integer getNumFloors();
	
	public void initTiles(ITile[][] tiles);
	public Iterator<ITile> getTiles();
}
