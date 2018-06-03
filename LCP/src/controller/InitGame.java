package controller;

import factory.Factory;
import view.IDisplayable;

public class InitGame implements IInitGame {
	
	private IDisplayable building;
	
	@Override
	public void initBuilding() {
		this.building = Factory.getInstance().getBuilding();
	}

	@Override
	public void initFloors() {
		
	}

	@Override
	public void initRooms() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initFurniture() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initOccupant() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void runAI() {
		// TODO Auto-generated method stub
		
	}

}
