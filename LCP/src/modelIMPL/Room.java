package modelIMPL;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.IDisplayable;
import model.IRoom;

public class Room extends Displayable implements IRoom {

	private List<IDisplayable> listOfFurniture;
	private String roomName;
	private List<IDisplayable> listOfPerson;

	public Room() {
		super();
		this.listOfFurniture = new ArrayList<IDisplayable>();
		this.listOfPerson = new ArrayList<IDisplayable>();
	}

	@Override
	public void addFurniture(IDisplayable furniture) {
		this.listOfFurniture.add(furniture);
	}

	@Override
	public void removeFurniture(IDisplayable furniture) {
		this.listOfFurniture.remove(furniture);
	}

	@Override
	public Iterator<IDisplayable> getFurniture() {
		return this.listOfFurniture.iterator();
	}

	@Override
	public String getName() {
		return this.roomName;
	}

	@Override
	public void setName(String newName) {
		this.roomName = newName;
	}

	@Override
	public void addPerson(IDisplayable person) {
		this.listOfPerson.add(person);
	}

	@Override
	public void removePerson(IDisplayable person) {
		this.listOfPerson.remove(person);
	}

	@Override
	public Iterator<IDisplayable> getPersons() {
		return this.listOfPerson.iterator();
	}

}
