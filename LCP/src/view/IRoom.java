package view;

import java.util.Iterator;

public interface IRoom extends IDisplayable{
	public void addFurniture(final IFurniture furniture);
	public void removeFurniture(final IFurniture furniture);
	public Iterator<IDisplayable> getFurniture();
	
	public String getName();
	public void setName(final String newName);
	
}
