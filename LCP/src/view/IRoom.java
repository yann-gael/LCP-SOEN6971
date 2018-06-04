package view;

import java.util.Iterator;

public interface IRoom extends IDisplayable{
	public void addFurniture(final IDisplayable furniture);
	public void removeFurniture(final IDisplayable furniture);
	public Iterator<IDisplayable> getFurniture();
	
	public String getName();
	public void setName(final String newName);
	
}
