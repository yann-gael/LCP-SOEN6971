package view;

import java.util.Iterator;

public interface IFloor extends IDisplayable {
	public void setFloorNum(Integer floorNum);
	public Integer getFloorNum();
	
	public void addRoom(final IRoom room);
	public void removeRoom(final IRoom room);
	public Iterator<IDisplayable> getRoom();
	
}
