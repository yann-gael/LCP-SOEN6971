package viewIMPL;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import view.IDisplayable;
import view.IRoom;

public class Room extends Displayable implements IRoom {

	private List<IDisplayable> listOfFurniture;
	private String roomName;

	public Room() {
		super();
		this.listOfFurniture = new ArrayList<IDisplayable>();
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

}
