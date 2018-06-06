package modelIMPL;

import model.INonMoveableFurniture;

public class NonMoveableFurniture extends Furniture implements INonMoveableFurniture {

	public NonMoveableFurniture() {
		super();
		this.isMovable = false;
	}
}
