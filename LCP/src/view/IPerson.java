package view;

public interface IPerson extends IDisplayable {
	public ILocation getLocation();
	public void setLocation(final ILocation newLocation);
	
	public void setName(final String newName);
	public String getName();
}
