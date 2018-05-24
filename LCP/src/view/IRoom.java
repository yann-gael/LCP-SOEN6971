package view;

import java.util.Iterator;

public interface IRoom extends IBuilding{
	public void addFurniture(final IFurniture furniture);
	public void removeFurniture(final IFurniture furniture);
	public Iterator<IFurniture> getFurniture();
	
	public String getName();
	public void setName(final String newName);
	
	public Integer getFloor();
	public void setFloor(final Integer floor);
}
