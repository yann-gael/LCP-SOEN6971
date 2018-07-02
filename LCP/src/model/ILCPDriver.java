package model;

public interface ILCPDriver extends IObservable{
	public void initBuilding();
	public IDisplayable getBuilding();
	public Integer getNumTilesHorizontally();
	public Integer getNumTilesVertically();
}
