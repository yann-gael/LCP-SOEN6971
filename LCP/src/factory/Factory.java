package factory;

import java.awt.Point;

import view.IBuilding;
import view.IDisplayable;
import view.IFurniture;
import view.IPerson;
import view.IPet;
import view.IRoom;
import viewIMPL.Building;
import viewIMPL.Location;
import viewIMPL.MoveableFurniture;
import viewIMPL.NonMoveableFurniture;
import viewIMPL.Person;
import viewIMPL.Pet;
import viewIMPL.Room;

public class Factory {

	private static class FactoryUniqueInstanceHolder{
		private static Factory THE_UNIQUE_FACTORY = new Factory();
	}
	
	public static Factory getInstance() {
		return FactoryUniqueInstanceHolder.THE_UNIQUE_FACTORY;
	}
	
	public IDisplayable getBuilding() {

		IBuilding building = new Building();
		building.setLocation(new Location());
		building.addOccupant(this.getPerson());
		building.addPet(this.getPet());
		building.addRoom(this.getRoom());
		building.setDisplay("Building");
		return building;

	}

	private IPerson getPerson() {
		IPerson person = new Person();
		person.setLocation(new Location(new Point(5, 6)));
		return person;
	}

	private IPet getPet() {
		IPet pet = new Pet();
		pet.setLocation(new Location(new Point(6, 7)));
		return pet;
	}

	private IRoom getRoom() {
		IRoom room = new Room();
		room.addFurniture(this.getMoveableFurniture());
		room.addFurniture(this.getNonMoveableFurniture());
		return room;
	}

	private IFurniture getMoveableFurniture() {
		IFurniture furniture = new MoveableFurniture();
		furniture.setLocation(new Location(new Point(1, 2)));
		return furniture;
	}

	private IFurniture getNonMoveableFurniture() {
		IFurniture furniture = new NonMoveableFurniture();
		furniture.setLocation(new Location(new Point(2, 3)));
		return furniture;
	}

}
