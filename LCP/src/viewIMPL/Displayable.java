package viewIMPL;

import view.IDisplayable;
import view.ITile;

public class Displayable implements IDisplayable {

	private ITile displayableLocation;
	private String typeOfDisplay;

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

}
