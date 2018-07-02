package tests;

import java.awt.Color;

//import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

import org.junit.jupiter.api.Test;

import factory.Factory;
import model.IBuilding;
import model.IDisplayContent;
import model.IDisplayable;
import model.IDisplayableDimension;
import model.IFloor;
import model.IObserver;
import model.IRoom;
import model.ITile;
import modelIMPL.DisplayContent;
import modelIMPL.DisplayableDimension;
import view.ButtonGrid;

public class CreationalTests {
	public static final Integer horizontalSize = 840;
	public static final Integer verticalSize = 840;
	public static final Integer tileMatrixSize = 21; /* 21 x 21 */
	public static final Integer numFloors = 3;
	public static final Integer roomsFF = 1;
	public static final Integer roomsSF = 3;
	public static final Integer roomsTF = 2;
	/* Floor = 3, Rest room = 4  = Total tiles = 7 in 1 floor = 21 in 3 floors*/
	
	private IDisplayable building;
	private IObserver observer;

	public CreationalTests() {
		this.building = null;
		this.observer = new ButtonGrid(21,21);
		//this.observer = new ImplObserver();
	}
	
	@Test
	void testBuilding() {
		IDisplayContent buildingDisplay = new DisplayContent();
		buildingDisplay.setDisplay("Building");
		buildingDisplay.setBackground(new Color(0,0,255));
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
		IDisplayContent floorDisplay1 = new DisplayContent();
		floorDisplay1.setDisplay("Floor1");
		//brown
		floorDisplay1.setBackground(new Color(165,42,42));
		
		IDisplayableDimension objTileDetails = new DisplayableDimension(6, 0, 3, 21);
		Integer floorNumber = 1;
		IDisplayable floorOne = Factory.getInstance().getFloor(floorNumber, floorDisplay1, objTileDetails);
		floorOne.addObserver(this.observer);
		
		
		IDisplayContent floorDisplay2 = new DisplayContent();
		floorDisplay2.setDisplay("Floor2");
		//brown
		floorDisplay2.setBackground(new Color(165,42,42));
		IDisplayableDimension objTileDetails2 = new DisplayableDimension(13, 0, 3, 21);
		Integer floorNumber2 = 2;
		IDisplayable floorTwo = Factory.getInstance().getFloor(floorNumber2, floorDisplay2, objTileDetails2);
		floorTwo.addObserver(this.observer);
		
		IDisplayContent floorDisplay3 = new DisplayContent();
		floorDisplay3.setDisplay("Floor3");
		//brown
		floorDisplay3.setBackground(new Color(165,42,42));
		IDisplayableDimension objTileDetails3 = new DisplayableDimension(20, 0, 3, 21);
		Integer floorNumber3 = 3;
		IDisplayable floorThree = Factory.getInstance().getFloor(floorNumber3, floorDisplay3, objTileDetails3);
		floorThree.addObserver(this.observer);
		
		((IBuilding)this.building).addFloor(floorOne);
		((IBuilding)this.building).addFloor(floorTwo);
		((IBuilding)this.building).addFloor(floorThree);
	}
	
	@Test
	void testRooms() {
		testFloors();
		IDisplayContent roomDisplay1 = new DisplayContent();
		roomDisplay1.setDisplay("Room1");
		//light gray
		roomDisplay1.setBackground(new Color(169,169,169));
		
		IDisplayableDimension objTileDetails1 = new DisplayableDimension(3, 0, 4, 21);
		IDisplayable room1 = Factory.getInstance().getRoom(roomDisplay1, objTileDetails1);
		room1.addObserver(this.observer);
		
		IDisplayContent roomDisplay2 = new DisplayContent();
		//green
		roomDisplay2.setDisplay("Room2");
		roomDisplay2.setBackground(new Color(0,255,0));
		IDisplayableDimension objTileDetails2 = new DisplayableDimension(10, 0, 4, 9);
		IDisplayable room2 = Factory.getInstance().getRoom(roomDisplay2, objTileDetails2);
		room2.addObserver(this.observer);
		
		IDisplayContent roomDisplay3 = new DisplayContent();
		roomDisplay3.setDisplay("Room3");
		//purple
		roomDisplay3.setBackground(new Color(153, 102, 255));
		IDisplayableDimension objTileDetails3 = new DisplayableDimension(10, 9, 4, 7);
		IDisplayable room3 = Factory.getInstance().getRoom(roomDisplay3, objTileDetails3);
		room3.addObserver(this.observer);
		
		IDisplayContent roomDisplay4 = new DisplayContent();
		roomDisplay4.setDisplay("Room4");
		//turquoise blue
		roomDisplay4.setBackground(new Color(51, 204, 204));
		IDisplayableDimension objTileDetails4 = new DisplayableDimension(10, 16, 4, 5);
		IDisplayable room4 = Factory.getInstance().getRoom(roomDisplay4, objTileDetails4);
		room4.addObserver(this.observer);
		
		
		IDisplayContent roomDisplay5 = new DisplayContent();
		roomDisplay5.setDisplay("Room5");
		//light yellow
		roomDisplay5.setBackground(new Color(255, 255, 153));
		IDisplayableDimension objTileDetails5 = new DisplayableDimension(17, 0, 4, 12);
		IDisplayable room5 = Factory.getInstance().getRoom(roomDisplay5, objTileDetails5);
		room5.addObserver(this.observer);
		
		IDisplayContent roomDisplay6 = new DisplayContent();
		roomDisplay6.setDisplay("Room6");
		//purple
		roomDisplay6.setBackground(new Color(153, 102, 255));
		IDisplayableDimension objTileDetails6 = new DisplayableDimension(17, 12, 4, 9);
		IDisplayable room6 = Factory.getInstance().getRoom(roomDisplay6, objTileDetails6);
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
				tmpFloor.addRoom(room4);
			}
			else if(ctr == 2) {
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
		//shade of brown and green
		stoveDisp.setBackground(new Color(153, 153, 102));
		
		IDisplayableDimension stoveTileDetails = new DisplayableDimension(17, 0, 3, 1);
		IDisplayable stove = Factory.getInstance().getNonMoveableFurniture(stoveDisp, stoveTileDetails);
		stove.addObserver(this.observer);
		
		IDisplayContent fridgeDisp = new DisplayContent();
		fridgeDisp.setDisplay("Fridge");
		// shade of white and blue
		fridgeDisp.setBackground(new Color(153, 204, 255));
		
		IDisplayableDimension fridgeTileDetails = new DisplayableDimension(17, 1, 3, 2);
		IDisplayable fridge = Factory.getInstance().getNonMoveableFurniture(fridgeDisp, fridgeTileDetails);
		fridge.addObserver(this.observer);
		
		IDisplayContent cupboardDisp = new DisplayContent();
		cupboardDisp.setDisplay("CupBoard");
		//Chocolate
		cupboardDisp.setBackground(new Color(210,105,30));
		IDisplayableDimension cupboardTileDetails1 = new DisplayableDimension(14, 1, 1, 2);
		IDisplayable cupBoard1 = Factory.getInstance().getNonMoveableFurniture(cupboardDisp, cupboardTileDetails1);
		cupBoard1.addObserver(this.observer);
		IDisplayableDimension cupboardTileDetails2 = new DisplayableDimension(15, 3, 2, 2);
		IDisplayable cupBoard2 = Factory.getInstance().getNonMoveableFurniture(cupboardDisp, cupboardTileDetails2);
		cupBoard2.addObserver(this.observer);
		IDisplayableDimension cupboardTileDetails3 = new DisplayableDimension(15, 5, 2, 2);
		IDisplayable cupBoard3 = Factory.getInstance().getNonMoveableFurniture(cupboardDisp, cupboardTileDetails3);
		cupBoard3.addObserver(this.observer);
		IDisplayableDimension cupboardTileDetails4 = new DisplayableDimension(17, 3, 3, 4);
		IDisplayable cupBoard4 = Factory.getInstance().getNonMoveableFurniture(cupboardDisp, cupboardTileDetails4);
		cupBoard4.addObserver(this.observer);
		
		IDisplayContent windowDisp = new DisplayContent();
		windowDisp.setDisplay("Window");
		//skyblue
		windowDisp.setBackground(new Color(135,206,235));
		IDisplayableDimension windowTileDetails = new DisplayableDimension(15, 7, 2, 2);
		IDisplayable kitchenWindow = Factory.getInstance().getNonMoveableFurniture(windowDisp, windowTileDetails);
		kitchenWindow.addObserver(this.observer);
		
		IDisplayContent tableDisp = new DisplayContent();
		tableDisp.setDisplay("Table");
		//maroon
		tableDisp.setBackground(new Color(128,0,0));
		IDisplayableDimension tableTileDetails = new DisplayableDimension(15, 7, 1, 2);
		IDisplayable kitchenTable = Factory.getInstance().getNonMoveableFurniture(tableDisp, tableTileDetails);
		kitchenTable.addObserver(this.observer);
		
		IDisplayContent waterDisp = new DisplayContent();
		waterDisp.setDisplay("Water");
		//AliceBlue
		waterDisp.setBackground(new Color(240,248,255));
		IDisplayableDimension waterTileDetails = new DisplayableDimension(17, 10, 2, 1);
		IDisplayable water = Factory.getInstance().getNonMoveableFurniture(waterDisp, waterTileDetails);
		water.addObserver(this.observer);
		
		IDisplayContent stairDiagonalDisp = new DisplayContent();
		stairDiagonalDisp.setDisplay("StairDiag");
		//Peru
		stairDiagonalDisp.setBackground(new Color(205,133,63));
		IDisplayableDimension stairDiagTileDetails = new DisplayableDimension(15, 10, 2, 1);
		IDisplayable stairDiag = Factory.getInstance().getNonMoveableFurniture(stairDiagonalDisp, stairDiagTileDetails);
		stairDiag.addObserver(this.observer);
		
		IDisplayContent stairDownDisp = new DisplayContent();
		stairDownDisp.setDisplay("StairDown");
		//Peru
		stairDownDisp.setBackground(new Color(205,133,63));
		IDisplayableDimension stairDownTileDetails = new DisplayableDimension(17, 11, 4, 1);
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
	
	//yet to figure out where to write this to create a template
	public IDisplayable createBuilding() {
		testFurniture();
		return this.building;
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
