package view;

import java.awt.Point;

public interface ILocationPoints {
	public void setPositions(Integer tileHeight, Integer tileWidth);
	public Double getNEX();
	public Point getSWPoint();
	public Point getNEPoint();
}
