package model;

import view.ButtonGrid;

public interface ILCPDriver extends IObservable{
	public void initBuilding();
	public IDisplayable getBuilding();
	public Integer getNumTilesHorizontally();
	public Integer getNumTilesVertically();
	public void movePerson();
	public void checkForUpdate();
}
