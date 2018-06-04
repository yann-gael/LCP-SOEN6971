package controller;

import factory.Factory;
import view.IDisplayContent;
import view.IDisplayable;
import viewIMPL.DisplayContent;

public class InitGame implements IInitGame {
	private final Integer numFloors = 1;
	
	private IDisplayable building;
	
	@Override
	public void initBuilding() {
		IDisplayContent buildingDisplay = new DisplayContent();
		buildingDisplay.setDisplay("Building");
		this.building = Factory.getInstance().getBuilding(buildingDisplay);
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
