package view;

import java.util.ArrayList;
import java.util.Iterator;

public interface IDisplayable {
	public String getDisplay();
	public void setDisplay(String typeOfDisplay);
	public ITile getLocation();
	public void setLocation(final ITile newLocation);
	public Iterator<ITile> getTiles();
	public void setTiles(final ArrayList<ITile> tiles);
}
