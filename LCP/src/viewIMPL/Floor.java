package viewIMPL;

import java.util.Iterator;
import java.util.List;

import view.IDisplayable;
import view.IFloor;
import view.ITile;
import view.IRoom;

public class Floor implements IFloor {

	private List<IDisplayable> listOfRooms;
	
	@Override
	public void setFloorNum(Integer floorNum) {
		
	}

	@Override
	public Integer getFloorNum() {
		return null;
	}

	@Override
	public String getDisplay() {
		return null;
	}

	@Override
	public void setDisplay(String typeOfDisplay) {
		
	}

	@Override
	public ITile getLocation() {
		return null;
	}

	@Override
	public void setLocation(ITile newLocation) {
		
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
}
