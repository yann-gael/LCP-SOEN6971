package view;

public interface IDisplayable {
	public String getDisplay();
	public void setDisplay(String typeOfDisplay);
	public ITile getLocation();
	public void setLocation(final ITile newLocation);
}
