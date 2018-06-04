package view;

import viewIMPL.ObjectOnTile;

public interface IDisplayable {
	public String getDisplay();
	public void setDisplay(String typeOfDisplay);
	public IObjectOnTile getTileDetails();
	public void setTiles(IObjectOnTile tileDetails);
}
