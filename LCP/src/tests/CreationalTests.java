package tests;

//import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;
import org.junit.jupiter.api.Test;

import factory.Factory;
import view.IBuilding;
import view.IDisplayContent;
import view.IDisplayable;
import view.IFloor;
import view.IObjectOnTile;
import view.IObserver;
import view.IRoom;
import view.ITile;
import viewIMPL.DisplayContent;
import viewIMPL.ImplObserver;
import viewIMPL.ObjectOnTile;

class CreationalTests {
	public static final Integer horizontalSize = 840;
	public static final Integer verticalSize = 840;
	public static final Integer tileMatrixSize = 21; /* 21 x 21 */
	public static final Integer numFloors = 3;
	public static final Integer roomsFF = 1;
	public static final Integer roomsSF = 3;
	public static final Integer roomsTF = 2;
	/* Floor = 3, Rest room = 4  = Total tiles = 7 in 1 floor = 21 in 3 floors*/
	
	IDisplayable building;
	IObserver observer;

	public CreationalTests() {
		this.building = null;
		this.observer = new ImplObserver();
	}
	
	@Test
	void testBuilding() {
		IDisplayContent buildingDisplay = new DisplayContent();
		buildingDisplay.setDisplay("Building");
		IDisplayable building = Factory.getInstance().getBuilding(buildingDisplay);
		this.building = building;
		System.out.println(building.getDisplay());
	}
	
	@Test
	void testTiles() {
		testBuilding();
		ITile tiles[][] = Factory.getInstance().getTiles(horizontalSize, verticalSize, tileMatrixSize);
		/*
		for(int i = 0; i < tileMatrixSize; i++) {
			for(int j = 0; j < tileMatrixSize; j++) {
				System.out.print(
						tiles[i][j].getTileY().toString() + 
						"," + 
						tiles[i][j].getTileX().toString() + 
						" ");
			}
			System.out.println("");
		}
		*/
		((IBuilding)this.building).initTiles(tiles);
	}
	
	@Test
	void testFloors() {
		testTiles();
		IDisplayContent floorDisplay = new DisplayContent();
		floorDisplay.setDisplay("Floor");
		
		IObjectOnTile objTileDetails = new ObjectOnTile(6, 0, 3, 21);
		Integer floorNumber = 1;
		IDisplayable floorOne = Factory.getInstance().getFloor(floorNumber, floorDisplay, objTileDetails);
		floorOne.addObserver(this.observer);
		
		IObjectOnTile objTileDetails2 = new ObjectOnTile(13, 0, 3, 21);
		Integer floorNumber2 = 2;
		IDisplayable floorTwo = Factory.getInstance().getFloor(floorNumber2, floorDisplay, objTileDetails2);
		floorTwo.addObserver(this.observer);
		
		IObjectOnTile objTileDetails3 = new ObjectOnTile(20, 0, 3, 21);
		Integer floorNumber3 = 3;
		IDisplayable floorThree = Factory.getInstance().getFloor(floorNumber3, floorDisplay, objTileDetails3);
		floorThree.addObserver(this.observer);
		
		((IBuilding)this.building).addFloor(floorOne);
		((IBuilding)this.building).addFloor(floorTwo);
		((IBuilding)this.building).addFloor(floorThree);
	}
	
	@Test
	void testRooms() {
		testFloors();
		IDisplayContent roomDisplay = new DisplayContent();
		roomDisplay.setDisplay("Room");
		
		IObjectOnTile objTileDetails1 = new ObjectOnTile(3, 0, 4, 21);
		IDisplayable room1 = Factory.getInstance().getRoom(roomDisplay, objTileDetails1);
		room1.addObserver(this.observer);
		
		IObjectOnTile objTileDetails2 = new ObjectOnTile(10, 0, 4, 9);
		IDisplayable room2 = Factory.getInstance().getRoom(roomDisplay, objTileDetails2);
		room2.addObserver(this.observer);
		
		IObjectOnTile objTileDetails3 = new ObjectOnTile(10, 9, 4, 7);
		IDisplayable room3 = Factory.getInstance().getRoom(roomDisplay, objTileDetails3);
		room3.addObserver(this.observer);
		
		IObjectOnTile objTileDetails4 = new ObjectOnTile(10, 16, 4, 5);
		IDisplayable room4 = Factory.getInstance().getRoom(roomDisplay, objTileDetails4);
		room4.addObserver(this.observer);
		
		IObjectOnTile objTileDetails5 = new ObjectOnTile(17, 0, 4, 12);
		IDisplayable room5 = Factory.getInstance().getRoom(roomDisplay, objTileDetails5);
		room5.addObserver(this.observer);
		
		IObjectOnTile objTileDetails6 = new ObjectOnTile(17, 12, 4, 9);
		IDisplayable room6 = Factory.getInstance().getRoom(roomDisplay, objTileDetails6);
		room6.addObserver(this.observer);
		
		Iterator<IDisplayable> itrFloors = ((IBuilding)this.building).getFloors();
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
	
	@Test
	public void testFurniture() {
		testRooms();

		IDisplayContent stoveDisp = new DisplayContent();
		stoveDisp.setDisplay("Stove");
		IObjectOnTile stoveTileDetails = new ObjectOnTile(17, 0, 3, 1);
		IDisplayable stove = Factory.getInstance().getNonMoveableFurniture(stoveDisp, stoveTileDetails);
		stove.addObserver(this.observer);
		
		IDisplayContent fridgeDisp = new DisplayContent();
		fridgeDisp.setDisplay("Fridge");
		IObjectOnTile fridgeTileDetails = new ObjectOnTile(17, 1, 3, 2);
		IDisplayable fridge = Factory.getInstance().getNonMoveableFurniture(fridgeDisp, fridgeTileDetails);
		fridge.addObserver(this.observer);
		
		IDisplayContent cupboardDisp = new DisplayContent();
		cupboardDisp.setDisplay("CupBoard");
		IObjectOnTile cupboardTileDetails1 = new ObjectOnTile(14, 1, 1, 2);
		IDisplayable cupBoard1 = Factory.getInstance().getNonMoveableFurniture(cupboardDisp, cupboardTileDetails1);
		cupBoard1.addObserver(this.observer);
		IObjectOnTile cupboardTileDetails2 = new ObjectOnTile(15, 3, 2, 2);
		IDisplayable cupBoard2 = Factory.getInstance().getNonMoveableFurniture(cupboardDisp, cupboardTileDetails2);
		cupBoard2.addObserver(this.observer);
		IObjectOnTile cupboardTileDetails3 = new ObjectOnTile(15, 5, 2, 2);
		IDisplayable cupBoard3 = Factory.getInstance().getNonMoveableFurniture(cupboardDisp, cupboardTileDetails3);
		cupBoard3.addObserver(this.observer);
		IObjectOnTile cupboardTileDetails4 = new ObjectOnTile(17, 3, 3, 4);
		IDisplayable cupBoard4 = Factory.getInstance().getNonMoveableFurniture(cupboardDisp, cupboardTileDetails4);
		cupBoard4.addObserver(this.observer);
		
		IDisplayContent windowDisp = new DisplayContent();
		windowDisp.setDisplay("Window");
		IObjectOnTile windowTileDetails = new ObjectOnTile(15, 7, 2, 2);
		IDisplayable kitchenWindow = Factory.getInstance().getNonMoveableFurniture(windowDisp, windowTileDetails);
		kitchenWindow.addObserver(this.observer);
		
		IDisplayContent tableDisp = new DisplayContent();
		tableDisp.setDisplay("Table");
		IObjectOnTile tableTileDetails = new ObjectOnTile(15, 7, 1, 2);
		IDisplayable kitchenTable = Factory.getInstance().getNonMoveableFurniture(tableDisp, tableTileDetails);
		kitchenTable.addObserver(this.observer);
		
		IDisplayContent waterDisp = new DisplayContent();
		waterDisp.setDisplay("Water");
		IObjectOnTile waterTileDetails = new ObjectOnTile(17, 10, 2, 1);
		IDisplayable water = Factory.getInstance().getNonMoveableFurniture(waterDisp, waterTileDetails);
		water.addObserver(this.observer);
		
		IDisplayContent stairDiagonalDisp = new DisplayContent();
		stairDiagonalDisp.setDisplay("StairDiag");
		IObjectOnTile stairDiagTileDetails = new ObjectOnTile(15, 10, 2, 1);
		IDisplayable stairDiag = Factory.getInstance().getNonMoveableFurniture(stairDiagonalDisp, stairDiagTileDetails);
		stairDiag.addObserver(this.observer);
		
		IDisplayContent stairDownDisp = new DisplayContent();
		stairDownDisp.setDisplay("StairDown");
		IObjectOnTile stairDownTileDetails = new ObjectOnTile(17, 11, 4, 1);
		IDisplayable stairDown = Factory.getInstance().getNonMoveableFurniture(stairDownDisp, stairDownTileDetails);
		stairDown.addObserver(this.observer);
		
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
	
	@Test
	void testCheckAddition() {
		testFurniture();
		Iterator<IDisplayable> floors = ((IBuilding)this.building).getFloors();
		while(floors.hasNext()) {
			IDisplayable floor = floors.next();
			floor.checkAddition();
			
			Iterator<IDisplayable> rooms = ((IFloor) floor).getRooms();
			while(rooms.hasNext()) {
				IDisplayable room = rooms.next();
				room.checkAddition();
				
				Iterator<IDisplayable> furns = ((IRoom) room).getFurniture();
				while(furns.hasNext()) {
					IDisplayable furn = furns.next();
					furn.checkAddition();
				}
			}
		}
	}
}
