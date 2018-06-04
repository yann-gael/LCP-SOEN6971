package factory;

import view.IDisplayable;
import view.IFloor;
import view.IFurniture;
import view.IPerson;
import view.IPet;
import view.IRoom;
import view.ITile;
import viewIMPL.Building;
import viewIMPL.Floor;
import viewIMPL.LocationPoints;
import viewIMPL.Tile;
import viewIMPL.MoveableFurniture;
import viewIMPL.NonMoveableFurniture;
import viewIMPL.Person;
import viewIMPL.Pet;
import viewIMPL.Room;
import java.util.ArrayList;
import java.util.Iterator;

public class Factory {
	
	private static class FactoryUniqueInstanceHolder{
		private static Factory THE_UNIQUE_FACTORY = new Factory();
	}
	
	public static Factory getInstance() {
		return FactoryUniqueInstanceHolder.THE_UNIQUE_FACTORY;
	}
	
	public IDisplayable getBuilding(Integer numFloors) {

		Building building = new Building();
		//building.setLocation(new Tile());
		/*
		building.addOccupant(this.getPerson());
		building.addPet(this.getPet());
		
		for(Integer i = 0; i < numFloors; i++)
		{
			IFloor tmpFloor = this.getFloor(i);
			tmpFloor.setDisplay(i.toString() + "F");
			building.addFloor(tmpFloor);
		}
		*/
		building.setDisplay("Building");
		return building;
		
	}

	public ITile[][] getTiles(Integer horizontalSize, Integer verticalSize, Integer totalTiles) {
		ITile[][] tiles = null;
		if(checkTileComposition(horizontalSize, verticalSize, totalTiles) == true) {
			tiles = new ITile[totalTiles][totalTiles];
			ArrayList<ITile> tmpTiles = new ArrayList<ITile>();
			initTiles(tmpTiles, horizontalSize, verticalSize, totalTiles);
			int ctr = 0;
			for(int i = 0; i < totalTiles; i++) {
				for(int j = 0; j < totalTiles; j++) {
					tiles[i][j] = tmpTiles.get(ctr);
					ctr++;
				}
			}
		}
		return tiles;
	}
	
	private IFloor getFloor(Integer floorNum) {
		IFloor floor = new Floor();
		floor.setFloorNum(floorNum);
		floor.setDisplay("Floor");
		return floor;
	}
	
	private IPerson getPerson() {
		IPerson person = new Person();
		//person.setLocation(new Tiles(new Point(5, 6)));
		person.setDisplay("Person");
		return person;
	}

	private IPet getPet() {
		IPet pet = new Pet();
		//pet.setLocation(new Tiles(new Point(6, 7)));
		pet.setDisplay("Pet");
		return pet;
	}

	public IRoom getRoom() {
		IRoom room = new Room();
		room.addFurniture(this.getMoveableFurniture());
		room.addFurniture(this.getNonMoveableFurniture());
		room.setDisplay("Room");
		return room;
	}

	private IFurniture getMoveableFurniture() {
		IFurniture furniture = new MoveableFurniture();
		//furniture.setLocation(new Tiles(new Point(1, 2)));
		furniture.setDisplay("MFurniture");
		return furniture;
	}

	private IFurniture getNonMoveableFurniture() {
		IFurniture furniture = new NonMoveableFurniture();
		//furniture.setLocation(new Tiles(new Point(2, 3)));
		furniture.setDisplay("NMFurniture");
		return furniture;
	}
	
	public void initTiles(ArrayList<ITile> tiles, Integer horizontalSize, 
			Integer verticalSize, Integer totalTiles) {
		while (tiles.size() < (totalTiles * totalTiles) - 1) {
			addTile(tiles, horizontalSize, verticalSize, totalTiles);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private void addTile(ArrayList<ITile> tiles, Integer horizontalSize, 
			Integer verticalSize, Integer totalTiles) {
		
		Integer tileHeight = horizontalSize / totalTiles;
		Integer tileWidth = verticalSize / totalTiles;
		
		if(checkTileComposition(horizontalSize, verticalSize, totalTiles) == false) {
			return;
		}
		
		if(tiles.size() == (totalTiles * totalTiles)) {
			System.out.println("Error: addTile: Maximum possible number of tiles already exist");
		}
		
		if(tiles.size() == 0) {
			ITile tmpTileOne = new Tile();
			tmpTileOne.setLocation(new LocationPoints(tileHeight, tileWidth));
			tmpTileOne.setTileX(0);
			tmpTileOne.setTileY(0);
			tiles.add(tmpTileOne);
			
			for(int i = 0; i < totalTiles - 1; i++) {
				ITile prevTile = tiles.get(tiles.size() - 1);
				ITile tmpTile = new Tile();
				tmpTile.setLocation(new LocationPoints(prevTile.getLocation().getNEPoint(), 
						tileHeight, tileWidth));
				
				tmpTile.setLeft(prevTile);
				prevTile.setRight(tmpTile);
				tmpTile.setTileX(prevTile.getTileX() + 1);
				tmpTile.setTileY(prevTile.getTileY());
				tiles.add(tmpTile);
			}
		}
		else {
			ITile topTile = null;
			if(tiles.size() >= totalTiles) {
				/* There is tiles at top */
				topTile = tiles.get(0);
				while(topTile.getDown() != null) {
					topTile = topTile.getDown();
				}
			}
			else {
				System.out.println("TOP NOT FOUND");
			}
			
			for(int i = 0; i < totalTiles; i++) {
				ITile tmpTile = new Tile();
				if(topTile.getTileX() != 0) {
					ITile prevTile = tiles.get(tiles.size() - 1);
					tmpTile.setLeft(prevTile);
					prevTile.setRight(tmpTile);
				}
				
				tmpTile.setUp(topTile);
				topTile.setDown(tmpTile);
				tmpTile.setTileX(topTile.getTileX());
				tmpTile.setTileY(topTile.getTileY() + 1);
				topTile = topTile.getRight();
				tiles.add(tmpTile);
			}
		}
	}

	private Boolean checkTileComposition(Integer horizontalSize, 
			Integer verticalSize, Integer totalTiles) {
		Double tileWidth = horizontalSize.doubleValue() / totalTiles.doubleValue();
		Double tileHeight = verticalSize.doubleValue() / totalTiles.doubleValue(); 
		
		if((((horizontalSize / tileWidth) * tileWidth) == horizontalSize) &&
				(((verticalSize / tileHeight) * tileHeight) == verticalSize)) {
			return true;
		}
		System.out.println("Error: Tiles: Invalid Composition");
		return false;
	}
	
}
