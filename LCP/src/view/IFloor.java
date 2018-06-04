package view;

import java.util.Iterator;

public interface IFloor extends IDisplayable {
	public void setFloorNum(Integer floorNum);
	public Integer getFloorNum();
	
	public void addRoom(final IDisplayable room);
	public void removeRoom(final IDisplayable room);
	public Iterator<IDisplayable> getRooms();
	
}
