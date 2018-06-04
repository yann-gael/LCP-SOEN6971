package viewIMPL;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import view.IDisplayable;
import view.IFloor;
import view.IRoom;

public class Floor extends Displayable implements IFloor {

	private ArrayList<IDisplayable> listOfRooms;
	private Integer floorNumber;
	
	public Floor() {
		this.listOfRooms = new ArrayList<IDisplayable>();
		floorNumber = null;
	}
	
	@Override
	public void setFloorNum(Integer floorNum) {
		floorNumber = floorNum;
	}

	@Override
	public Integer getFloorNum() {
		return floorNumber;
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
