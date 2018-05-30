package view;

import java.util.Iterator;

public interface IBuilding extends IDisplayable {
	public void addRoom(final IRoom room);
	public void removeRoom(final IRoom room);
	public Iterator<IDisplayable> getRoom();
	
	public void addOccupant(final IPerson occupant);
	public void removeOccupant(final IPerson occupant);
	public Iterator<IDisplayable> getOccupants();
	
	public void addPet(final IPet pet);
	public void removePet(final IPet pet);
	public Iterator<IDisplayable> getPets();
	
	public void setNumFloors(final Integer numFloors);
	public Integer getNumFloors();
}
