package model;

public interface IDisplayable extends IObservable {
	public IDisplayContent getDisplay();
	public void setDisplay(IDisplayContent typeOfDisplay);
	public IDisplayableDimension getTileDetails();
	public void setTiles(IDisplayableDimension tileDetails);
	public void checkAddition();
}
