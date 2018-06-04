package view;

import java.util.Iterator;

public interface IBuilding extends IDisplayable {
	
	public void addOccupant(final IPerson occupant);
	public void removeOccupant(final IPerson occupant);
	public Iterator<IDisplayable> getOccupants();
	
	public void addPet(final IPet pet);
	public void removePet(final IPet pet);
	public Iterator<IDisplayable> getPets();
	
	public void addFloor(final IFloor floor);
	public void removeFloor(final IFloor floor);
	public Iterator<IDisplayable> getFloors();
	public Integer getNumFloors();
	
	public void setTiles(ITile[][] tiles);
	public Iterator<ITile> getTiles();
}
