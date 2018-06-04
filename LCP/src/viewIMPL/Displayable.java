package viewIMPL;

import view.IDisplayable;
import view.IObjectOnTile;

public class Displayable implements IDisplayable {

	private IObjectOnTile tileDetails;
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
	public IObjectOnTile getTileDetails() {
		return tileDetails;
	}

	@Override
	public void setTiles(IObjectOnTile tileDetails) {
		this.tileDetails = tileDetails;
	}

}
