package viewIMPL;

import java.util.ArrayList;
import java.util.Iterator;
import view.IDisplayable;
import view.IFloor;

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
	public void addRoom(IDisplayable room) {
		this.listOfRooms.add(room);
	}

	@Override
	public void removeRoom(IDisplayable room) {
		this.listOfRooms.remove(room);
	}

	@Override
	public Iterator<IDisplayable> getRooms() {
		return this.listOfRooms.iterator();
	}
}
