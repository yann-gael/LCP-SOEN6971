package view;

public interface IFurniture extends IDisplayable {
	public void setSize();
	public void getSize();
	
	public boolean isMoveable();
	
	public EFurnitureCat getType();
	public void setType(EFurnitureCat newType);
}
