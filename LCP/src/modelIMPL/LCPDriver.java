package modelIMPL;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import factory.Factory;
import model.IBuilding;
import model.IDisplayContent;
import model.IDisplayable;
import model.IDisplayableDimension;
import model.IEvent;
import model.IFloor;
import model.ILCPDriver;
import model.IObservable;
import model.IObserver;
import model.IRoom;
import model.ITile;

public class LCPDriver implements ILCPDriver, IObservable {
	private final Integer HORIZONTAL_SIZE = 840;
	private final Integer VERTICAL_SIZE = 840;
	private final Integer TILE_MATRIX_SIZE = 21; /* 21 x 21 */
	/*
	private final Integer numFloors = 3;
	private final Integer roomsFF = 1;
	private final Integer roomsSF = 3;
	private final Integer roomsTF = 2;
	*/
	
	private IBuilding building;
	private ArrayList<IObserver> observers;
	/* Floor = 3, Rest room = 4  = Total tiles = 7 in 1 floor = 21 in 3 floors*/

	@Override
	public final Integer getNumTilesHorizontally() {
		return this.HORIZONTAL_SIZE;
	}
	
	@Override
	public final Integer getNumTilesVertically() {
		return this.VERTICAL_SIZE;
	}
	
	public LCPDriver() {
		this.building = null;
		this.observers = new ArrayList<IObserver>();
	}
	
	@Override
	public void initBuilding() {
		IDisplayContent buildingDisplay = this.building.getDisplay();
		buildingDisplay.setDisplay("Building");
		buildingDisplay.setBackground(new Color(0,0,255));
	}
	
	private final void createBuilding() {
		IDisplayContent buildingDisplay = new DisplayContent();
		IBuilding building = (IBuilding) Factory.getInstance().getBuilding(buildingDisplay);
		this.building = building;
		initBuilding();
	}

	private final void initTiles() {
		ITile tiles[][] = Factory.getInstance().getTiles(HORIZONTAL_SIZE, VERTICAL_SIZE, TILE_MATRIX_SIZE);
		this.building.initTiles(tiles);
	}

	private final void initFloors() {
		IDisplayContent floorDisplay = new DisplayContent();
		floorDisplay.setDisplay("Floor");
		//brown
		floorDisplay.setBackground(new Color(165,42,42));
		
		IDisplayableDimension objTileDetails = new DisplayableDimension(6, 0, 3, 21);
		Integer floorNumber = 1;
		IDisplayable floorOne = Factory.getInstance().getFloor(floorNumber, floorDisplay, objTileDetails);
		
		IDisplayableDimension objTileDetails2 = new DisplayableDimension(13, 0, 3, 21);
		Integer floorNumber2 = 2;
		IDisplayable floorTwo = Factory.getInstance().getFloor(floorNumber2, floorDisplay, objTileDetails2);
		
		IDisplayableDimension objTileDetails3 = new DisplayableDimension(20, 0, 3, 21);
		Integer floorNumber3 = 3;
		IDisplayable floorThree = Factory.getInstance().getFloor(floorNumber3, floorDisplay, objTileDetails3);
		
		for(int i = 0; i < this.observers.size(); i++)
		{
			floorOne.addObserver(this.observers.get(i));
			floorTwo.addObserver(this.observers.get(i));
			floorThree.addObserver(this.observers.get(i));
		}
		
		this.building.addFloor(floorOne);
		this.building.addFloor(floorTwo);
		this.building.addFloor(floorThree);
	}

	public void initRooms() {
		IDisplayContent roomDisplay = new DisplayContent();
		roomDisplay.setDisplay("Room");
		//light gray
		roomDisplay.setBackground(new Color(169,169,169));
		
		IDisplayableDimension objTileDetails1 = new DisplayableDimension(3, 0, 4, 21);
		IDisplayable room1 = Factory.getInstance().getRoom(roomDisplay, objTileDetails1);
		
		IDisplayContent roomDisplay1 = new DisplayContent();
		//green
		roomDisplay.setDisplay("Room2");
		roomDisplay.setBackground(new Color(0,255,0));
		IDisplayableDimension objTileDetails2 = new DisplayableDimension(10, 0, 4, 9);
		IDisplayable room2 = Factory.getInstance().getRoom(roomDisplay1, objTileDetails2);
		
		IDisplayableDimension objTileDetails3 = new DisplayableDimension(10, 9, 4, 7);
		IDisplayable room3 = Factory.getInstance().getRoom(roomDisplay, objTileDetails3);
		
		IDisplayableDimension objTileDetails4 = new DisplayableDimension(10, 16, 4, 5);
		IDisplayable room4 = Factory.getInstance().getRoom(roomDisplay, objTileDetails4);
		
		IDisplayableDimension objTileDetails5 = new DisplayableDimension(17, 0, 4, 12);
		IDisplayable room5 = Factory.getInstance().getRoom(roomDisplay, objTileDetails5);
		
		IDisplayableDimension objTileDetails6 = new DisplayableDimension(17, 12, 4, 9);
		IDisplayable room6 = Factory.getInstance().getRoom(roomDisplay, objTileDetails6);
		
		for(int i = 0; i < this.observers.size(); i++)
		{
			room1.addObserver(this.observers.get(i));
			room2.addObserver(this.observers.get(i));
			room3.addObserver(this.observers.get(i));
			room4.addObserver(this.observers.get(i));
			room5.addObserver(this.observers.get(i));
			room6.addObserver(this.observers.get(i));
		}
		
		Iterator<IDisplayable> itrFloors = this.building.getFloors();
		int ctr = 0;
		while(itrFloors.hasNext()) {
			IFloor tmpFloor = (IFloor)itrFloors.next();
			if(ctr == 0) {
				tmpFloor.addRoom(room1);
			}
			else if(ctr == 1) {
				tmpFloor.addRoom(room2);
				tmpFloor.addRoom(room3);
			}
			else if(ctr == 2) {
				tmpFloor.addRoom(room4);
				tmpFloor.addRoom(room5);
				tmpFloor.addRoom(room6);
			}
			ctr += 1;
		}
	}

	private final void initFurnitures() {
		IDisplayContent stoveDisp = new DisplayContent();
		stoveDisp.setDisplay("Stove");
		stoveDisp.setBackground(new Color(211,211,211));
		
		IDisplayableDimension stoveTileDetails = new DisplayableDimension(17, 0, 1, 1);
		IDisplayable stove = Factory.getInstance().getNonMoveableFurniture(stoveDisp, stoveTileDetails);
		
		IDisplayContent fridgeDisp = new DisplayContent();
		fridgeDisp.setDisplay("Fridge");
		fridgeDisp.setBackground(new Color(255,250,250));
		
		IDisplayableDimension fridgeTileDetails = new DisplayableDimension(17, 1, 3, 2);
		IDisplayable fridge = Factory.getInstance().getNonMoveableFurniture(fridgeDisp, fridgeTileDetails);
		
		IDisplayContent cupboardDisp1 = new DisplayContent();
		cupboardDisp1.setDisplay("CupBoard1");
		cupboardDisp1.setBackground(new Color(210,105,30));
		IDisplayableDimension cupboardTileDetails1 = new DisplayableDimension(14, 1, 1, 2);
		IDisplayable cupBoard1 = Factory.getInstance().getNonMoveableFurniture(cupboardDisp1, cupboardTileDetails1);
		
		IDisplayContent cupboardDisp2 = new DisplayContent(); 
	    cupboardDisp2.setDisplay("CupBoard2"); 
	    //Chocolate 
	    cupboardDisp2.setBackground(new Color(210,105,30)); 
		IDisplayableDimension cupboardTileDetails2 = new DisplayableDimension(15, 3, 2, 2);
		IDisplayable cupBoard2 = Factory.getInstance().getNonMoveableFurniture(cupboardDisp2, cupboardTileDetails2);
		
		IDisplayContent cupboardDisp3 = new DisplayContent(); 
	    cupboardDisp3.setDisplay("CupBoard3"); 
	    //Chocolate 
	    cupboardDisp3.setBackground(new Color(210,105,30));
		IDisplayableDimension cupboardTileDetails3 = new DisplayableDimension(15, 5, 2, 2);
		IDisplayable cupBoard3 = Factory.getInstance().getNonMoveableFurniture(cupboardDisp3, cupboardTileDetails3);
		
		IDisplayContent cupboardDisp4 = new DisplayContent(); 
	    cupboardDisp4.setDisplay("CupBoard4"); 
	    //same as fridge 
	    cupboardDisp4.setBackground(new Color(153, 204, 255)); 
		IDisplayableDimension cupboardTileDetails4 = new DisplayableDimension(17, 3, 1, 4);
		IDisplayable cupBoard4 = Factory.getInstance().getNonMoveableFurniture(cupboardDisp4, cupboardTileDetails4);
		
		IDisplayContent windowDisp = new DisplayContent();
		windowDisp.setDisplay("Window");
		windowDisp.setBackground(new Color(135,206,235));
		IDisplayableDimension windowTileDetails = new DisplayableDimension(16, 7, 2, 2);
		IDisplayable kitchenWindow = Factory.getInstance().getNonMoveableFurniture(windowDisp, windowTileDetails);
		
		IDisplayContent tableDisp = new DisplayContent();
		tableDisp.setDisplay("Table");
		tableDisp.setBackground(new Color(128,0,0));
		IDisplayableDimension tableTileDetails = new DisplayableDimension(17, 7, 1, 2);
		IDisplayable kitchenTable = Factory.getInstance().getNonMoveableFurniture(tableDisp, tableTileDetails);
		
		IDisplayContent waterDisp = new DisplayContent();
		waterDisp.setDisplay("Water");
		waterDisp.setBackground(new Color(240,248,255));
		IDisplayableDimension waterTileDetails = new DisplayableDimension(17, 10, 2, 1);
		IDisplayable water = Factory.getInstance().getNonMoveableFurniture(waterDisp, waterTileDetails);
		
		IDisplayContent stairDiagonalDisp = new DisplayContent();
		stairDiagonalDisp.setDisplay("StairDiag");
		stairDiagonalDisp.setBackground(new Color(205,133,63));
		IDisplayableDimension stairDiagTileDetails = new DisplayableDimension(15, 10, 2, 1);
		IDisplayable stairDiag = Factory.getInstance().getNonMoveableFurniture(stairDiagonalDisp, stairDiagTileDetails);
		
		IDisplayContent stairDownDisp = new DisplayContent();
		stairDownDisp.setDisplay("StairDown");
		stairDownDisp.setBackground(new Color(205,133,63));
		IDisplayableDimension stairDownTileDetails = new DisplayableDimension(17, 11, 4, 1);
		IDisplayable stairDown = Factory.getInstance().getNonMoveableFurniture(stairDownDisp, stairDownTileDetails);
		
		for(int i = 0; i < this.observers.size(); i++)
		{
			stove.addObserver(this.observers.get(i));
			stairDown.addObserver(this.observers.get(i));
			stairDiag.addObserver(this.observers.get(i));
			water.addObserver(this.observers.get(i));
			kitchenTable.addObserver(this.observers.get(i));
			kitchenWindow.addObserver(this.observers.get(i));
			cupBoard1.addObserver(this.observers.get(i));
			cupBoard2.addObserver(this.observers.get(i));
			cupBoard3.addObserver(this.observers.get(i));
			cupBoard4.addObserver(this.observers.get(i));
			fridge.addObserver(this.observers.get(i));
		}
		
		Iterator<IDisplayable> itr = ((IBuilding)this.building).getFloors();
		itr.next();
		itr.next();
		IFloor floor3 = (IFloor)itr.next();
		Iterator<IDisplayable> itrRoomsTF = floor3.getRooms();
		IRoom roomF3R1 = (IRoom) itrRoomsTF.next();
		roomF3R1.addFurniture(stove);
		roomF3R1.addFurniture(fridge);
		roomF3R1.addFurniture(cupBoard1);
		roomF3R1.addFurniture(cupBoard2);
		roomF3R1.addFurniture(cupBoard3);
		roomF3R1.addFurniture(cupBoard4);
		roomF3R1.addFurniture(kitchenWindow);
		roomF3R1.addFurniture(kitchenTable);
		roomF3R1.addFurniture(water);
		roomF3R1.addFurniture(stairDiag);
		roomF3R1.addFurniture(stairDown);
	}

	@Override
	public final IDisplayable getBuilding() {
		this.createBuilding();
		this.initTiles();
		this.initFloors();
		this.initRooms();
		this.initFurnitures();
		return this.building;
	}

	@Override
	public final void notifyObservers(IEvent event) {
		return;
	}

	@Override
	public final void addObserver(IObserver observer) {
		if(observer != null)
			this.observers.add(observer);
	}

	@Override
	public void removeObserver(IObserver observer) {
		if(observer != null)
			this.observers.remove(observer);
	}

	@Override
	public Iterator<IObserver> getObserver() {
		return this.observers.iterator();
	}

}
