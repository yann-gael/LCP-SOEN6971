package model;

public interface IPerson extends IDisplayable {	
	public void setName(final String newName);
	public String getName();
	public IRoom getRoom();
	public void setRoom(IRoom room);
}
