package viewIMPL;

import java.awt.Point;

import view.ILocation;

public class Location implements ILocation {
	private Point xyPosition;

	public Location(Point xyPosition) {
		this.xyPosition = xyPosition;
	}
	
	public Location() {
		this.xyPosition = new Point(0,0);
	}
}
