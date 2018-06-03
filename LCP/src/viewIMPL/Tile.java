package viewIMPL;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import view.ILocationPoints;
import view.ITile;

public class Tile implements ITile {
	private ILocationPoints location;
	private ITile left;
	private ITile right;
	private ITile up;
	private ITile down;
	private Integer tileXNum;
	private Integer tileYNum;
	
	public Tile() {
		location = null;
		left = null;
		right = null;
		up = null;
		down = null;
		tileXNum = null;
		tileYNum = null;
	}
	
	@Override
	public void setLocation(ILocationPoints loc) {
		this.location = loc;
	}
	
	@Override
	public void setLeft(ITile left) {
		this.left = left;
	}
	
	@Override
	public void setRight(ITile right) {
		this.right = right;
	}
	
	@Override
	public void setUp(ITile up) {
		this.up = up;
	}
	
	@Override
	public void setDown(ITile down) {
		this.down = down;
	}
	
	@Override
	public void setTileX(Integer X) {
		this.tileXNum = X;
	}
	
	@Override
	public void setTileY(Integer Y) {
		this.tileYNum = Y;
	}
	
	@Override
	public ILocationPoints getLocation() {
		return this.location;
	}
	
	@Override
	public ITile getLeft() {
		return this.left;
	}
	
	@Override
	public ITile getRight() {
		return this.right;
	}
	
	@Override
	public ITile getUp() {
		return this.up;
	}
	
	@Override
	public ITile getDown() {
		return this.down;
	}
	
	@Override
	public Integer getTileX() {
		return this.tileXNum;
	}
	
	@Override
	public Integer getTileY() {
		return this.tileYNum;
	}
	
}
