package viewIMPL;

import view.IFurniture;

public class Furniture extends Displayable implements IFurniture {

	private Integer size;
	private String name;
	protected boolean isMovable;
	
	public Furniture() {
		super();
	}

	@Override
	public void setSize(Integer size) {
		this.size = size;
	}

	@Override
	public Integer getSize() {
		return this.size;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return this.name;
	}

}
