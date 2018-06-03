package viewIMPL;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import factory.Factory;
import view.IBuilding;
import view.IDisplayable;
import view.IFloor;
import view.IPerson;
import view.IPet;
import view.ITile;

public class Building extends Displayable implements IBuilding {

	private List<IDisplayable> listOfOccupants;
	private List<IDisplayable> listOfPets;
	private List<IDisplayable> listOfFloors;
	private ArrayList<ITile> listOfTiles;
	private Integer numOfFloors;

	public Building(){
		super();
		this.listOfFloors = new ArrayList<IDisplayable>();
		this.listOfOccupants = new ArrayList<IDisplayable>();
		this.listOfPets = new ArrayList<IDisplayable>();
		this.listOfTiles = new ArrayList<ITile>();
		this.initTiles(1000, 1000, 100);
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

	@Override
	public void addFloor(IFloor floor) {
		this.listOfFloors.add(floor);
	}

	@Override
	public void removeFloor(IFloor floor) {
		this.listOfFloors.remove(floor);
	}

	@Override
	public Iterator<IDisplayable> getFloors() {
		return this.listOfFloors.iterator();
	}

	private void initTiles(Integer horizontalSize, Integer verticalSize, Integer totalTiles) {
		Factory.getInstance().initTiles(listOfTiles, horizontalSize, verticalSize, totalTiles);
	}
}
