package viewIMPL;

import java.util.ArrayList;
import java.util.Iterator;

import view.IDisplayable;
import view.ITile;

public class Displayable implements IDisplayable {

	private ITile displayableLocation;
	private String typeOfDisplay;
	private ArrayList<ITile> tiles;

	@Override
	public String getDisplay() {
		return this.typeOfDisplay;		
	}
	
	@Override
	public void setDisplay(String typeOfDisplay) {
		this.typeOfDisplay = typeOfDisplay;
	}

	@Override
	public ITile getLocation() {
		return this.displayableLocation;
	}

	@Override
	public void setLocation(ITile newLocation) {
		this.displayableLocation = newLocation;
	}

	@Override
	public Iterator<ITile> getTiles() {
		return tiles.iterator();
	}

	@Override
	public void setTiles(ArrayList<ITile> tiles) {
		this.tiles = tiles;
	}

}
