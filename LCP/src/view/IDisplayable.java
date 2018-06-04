package view;

import viewIMPL.ObjectOnTile;

public interface IDisplayable {
	public IDisplayContent getDisplay();
	public void setDisplay(IDisplayContent typeOfDisplay);
	public IObjectOnTile getTileDetails();
	public void setTiles(IObjectOnTile tileDetails);
}
