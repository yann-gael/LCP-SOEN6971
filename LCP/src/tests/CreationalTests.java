package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import factory.Factory;
import view.IBuilding;
import view.IDisplayable;
import view.ITile;
import viewIMPL.ImplObserver;

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
		IDisplayable building = Factory.getInstance().getBuilding(1);
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
		IFloor floorOne = Factory.getInstance()
	}
}
