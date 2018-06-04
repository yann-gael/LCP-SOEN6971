package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import factory.Factory;
import view.IBuilding;
import view.IDisplayContent;
import view.IDisplayable;
import view.IFloor;
import view.IObjectOnTile;
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

	public CreationalTests() {
		this.building = null;
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
		((IBuilding)this.building).setTiles(tiles);
	}
	
	@Test
	void testFloors() {
		testTiles();
		IDisplayContent floorDisplay = new DisplayContent();
		floorDisplay.setDisplay("Floor");
		
		IObjectOnTile objTileDetails = new ObjectOnTile(6, 0, 3, 21);
		Integer floorNumber = 1;
		IFloor floorOne = Factory.getInstance().getFloor(floorNumber, floorDisplay, objTileDetails);
		
		IObjectOnTile objTileDetails2 = new ObjectOnTile(13, 0, 3, 21);
		Integer floorNumber2 = 2;
		IFloor floorTwo = Factory.getInstance().getFloor(floorNumber2, floorDisplay, objTileDetails2);
		
		IObjectOnTile objTileDetails3 = new ObjectOnTile(20, 0, 3, 21);
		Integer floorNumber3 = 3;
		IFloor floorThree = Factory.getInstance().getFloor(floorNumber3, floorDisplay, objTileDetails3);
		
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
		IRoom room1 = Factory.getInstance().getRoom(roomDisplay, objTileDetails1);
		
		IObjectOnTile objTileDetails2 = new ObjectOnTile(10, 0, 4, 9);
		IRoom room2 = Factory.getInstance().getRoom(roomDisplay, objTileDetails2);
		
		IObjectOnTile objTileDetails3 = new ObjectOnTile(10, 9, 4, 7);
		IRoom room3 = Factory.getInstance().getRoom(roomDisplay, objTileDetails3);
		
		IObjectOnTile objTileDetails4 = new ObjectOnTile(10, 16, 4, 5);
		IRoom room4 = Factory.getInstance().getRoom(roomDisplay, objTileDetails4);
		
		IObjectOnTile objTileDetails5 = new ObjectOnTile(17, 0, 4, 12);
		IRoom room5 = Factory.getInstance().getRoom(roomDisplay, objTileDetails5);
		
		IObjectOnTile objTileDetails6 = new ObjectOnTile(17, 12, 4, 9);
		IRoom room6 = Factory.getInstance().getRoom(roomDisplay, objTileDetails6);
		
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
}
