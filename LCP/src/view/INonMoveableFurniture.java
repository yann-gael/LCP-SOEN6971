package view;

public interface INonMoveableFurniture extends IFurniture {
	public void setLocation(final ILocation newLocation);
	public ILocation getLocation();
}
