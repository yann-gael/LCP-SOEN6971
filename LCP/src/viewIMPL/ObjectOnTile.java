package viewIMPL;

import view.IObjectOnTile;

public class ObjectOnTile implements IObjectOnTile {
	Integer Y;
	Integer X;
	Integer Height;
	Integer Width;
	
	public ObjectOnTile(Integer Y, Integer X, Integer Height, Integer Width) {
		this.Y = Y;
		this.X = X;
		this.Height = Height;
		this.Width = Width;
	}
	
	@SuppressWarnings("unused")
	private ObjectOnTile() {}
	
	@Override
	public Integer getX() {
		return X;
	}
	
	@Override
	public Integer getY() {
		return Y;
	}
	
	@Override
	public Integer getHeight() {
		return Height;
	}
	
	@Override
	public Integer getWidth() {
		return Width;
	}
}
