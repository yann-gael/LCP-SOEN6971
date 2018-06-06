package modelIMPL;

import model.IMoveableFurniture;

public class MoveableFurniture extends Furniture implements IMoveableFurniture {

	public MoveableFurniture() {
		super();
		this.isMovable = true;
	}
}
