package view;

public interface IDisplayable extends IObservable {
	public IDisplayContent getDisplay();
	public void setDisplay(IDisplayContent typeOfDisplay);
	public IObjectOnTile getTileDetails();
	public void setTiles(IObjectOnTile tileDetails);
	public void checkAddition();
}
