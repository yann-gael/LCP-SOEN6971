package viewIMPL;

import view.IDisplayable;
import view.ILocation;

public class Displayable implements IDisplayable {

	private ILocation displayableLocation;
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
	public ILocation getLocation() {
		return this.displayableLocation;
	}

	@Override
	public void setLocation(ILocation newLocation) {
		this.displayableLocation = newLocation;
	}

}
