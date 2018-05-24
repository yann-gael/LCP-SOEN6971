package view;

public interface IMoveableFurniture extends IFurniture {	
	public void setLocation(final ILocation newLocation);
	public ILocation getLocation();
}
