package view;

public interface IDisplayable {
	public String getDisplay();
	public void setDisplay(String typeOfDisplay);
	public ILocation getLocation();
	public void setLocation(final ILocation newLocation);
}
