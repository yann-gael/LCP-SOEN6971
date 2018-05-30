package viewIMPL;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import view.IBuilding;
import view.IDisplayable;
import view.IPerson;
import view.IPet;
import view.IRoom;

public class Building extends Displayable implements IBuilding {

	private List<IDisplayable> listOfRooms;
	private List<IDisplayable> listOfOccupants;
	private List<IDisplayable> listOfPets;
	private Integer numOfFloors;

	public Building(){
		super();
		this.listOfRooms = new ArrayList<IDisplayable>();
		this.listOfOccupants = new ArrayList<IDisplayable>();
		this.listOfPets = new ArrayList<IDisplayable>();
	}
	
	@Override
	public void addRoom(IRoom room) {
		this.listOfRooms.add(room);
	}

	@Override
	public void removeRoom(IRoom room) {
		this.listOfRooms.remove(room);
	}

	@Override
	public Iterator<IDisplayable> getRoom() {
		return this.listOfRooms.iterator();
	}

	@Override
	public void addOccupant(IPerson occupant) {
		this.listOfOccupants.add(occupant);
	}

	@Override
	public void removeOccupant(IPerson occupant) {
		this.listOfOccupants.remove(occupant);
	}

	@Override
	public Iterator<IDisplayable> getOccupants() {
		return this.listOfOccupants.iterator();
	}

	@Override
	public void addPet(IPet pet) {
		this.listOfPets.add(pet);
	}

	@Override
	public void removePet(IPet pet) {
		this.listOfPets.remove(pet);
	}

	@Override
	public Iterator<IDisplayable> getPets() {
		return this.listOfPets.iterator();
	}

	@Override
	public void setNumFloors(Integer numFloors) {
		this.numOfFloors = numFloors;
	}

	@Override
	public Integer getNumFloors() {
		return this.numOfFloors;
	}

}
