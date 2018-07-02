package model;

public interface ILCPDriver {
	public void initBuilding();
	public IDisplayable getBuilding();
	public Integer getNumTilesHorizontally();
	public Integer getNumTilesVertically();
}
