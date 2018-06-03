package factory;

import java.awt.Point;

import view.IBuilding;
import view.IDisplayable;
import view.IFloor;
import view.IFurniture;
import view.ILocationPoints;
import view.IPerson;
import view.IPet;
import view.IRoom;
import view.ITile;
import viewIMPL.Building;
import viewIMPL.ConstConfig;
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
import java.util.Map;
import java.util.Map.Entry;

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
		building.addOccupant(this.getPerson());
		building.addPet(this.getPet());
		
		for(Integer i = 0; i < numFloors; i++)
		{
			/* ONLY FOR VIEW TEST */
			if(i == 0) {
				ArrayList<ITile> tiles = new ArrayList<ITile>();
				Iterator<ITile> allTiles = building.getTiles();
				
				Iterator mapItr = ConstConfig.locFirstFloor.entrySet().iterator();
				
				while(mapItr.hasNext()) {
					Map.Entry itrObj = (Map.Entry) mapItr.next();
					Integer reqX = (Integer) itrObj.getKey();
					Integer reqY = (Integer) itrObj.getValue();
					while(allTiles.hasNext()) {
						if((allTiles.next().getTileX() == reqX) && (allTiles.next().getTileY() == reqY))
						{
							
						}
					}
				}
			}
			/* ONLY FOR VIEW TEST */
			IFloor tmpFloor = this.getFloor(i);
			tmpFloor.setDisplay(i.toString() + "F");
			building.addFloor(tmpFloor);
		}
		
		building.setDisplay("Building");
		return building;

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
		while (tiles.size() < totalTiles) {
			addTile(tiles, horizontalSize, verticalSize, totalTiles);
		}
	}
	
	private void addTile(ArrayList<ITile> tiles, Integer horizontalSize, 
			Integer verticalSize, Integer totalTiles) {
		
		Integer tileHeight = horizontalSize / totalTiles;
		Integer tileWidth = verticalSize / totalTiles;
		
		if(checkTileComposition(horizontalSize, verticalSize, totalTiles) == false) {
			return;
		}
		
		if(tiles.size() == totalTiles) {
			System.out.println("Error: addTile: Maximum possible number of tiles already exist");
		}
		
		for(int i = 0; i < tiles.size(); i++) {
			if(tiles.size() == 0) {
				ITile tmpTile = new Tile();
				tmpTile.setLocation(new LocationPoints(tileHeight, tileWidth));
				tmpTile.setTileX(0);
				tmpTile.setTileY(0);
				tiles.add(tmpTile);
			}
			else {
				Integer maxTilesHorizontally = horizontalSize / tileHeight;
				ITile prevTile = tiles.get(tiles.size() - 1);
				
				if(prevTile.getTileX() < maxTilesHorizontally) {
					ITile tmpTile = new Tile();
					tmpTile.setLocation(new LocationPoints(prevTile.getLocation().getNEPoint(), 
							tileHeight, tileWidth));
					tmpTile.setLeft(prevTile);
					prevTile.setRight(tmpTile);
					if(prevTile.getUp() != null) {
						tmpTile.setUp(prevTile.getUp().getRight());
						prevTile.getUp().getRight().setDown(tmpTile);
					}
					tmpTile.setTileX(prevTile.getTileX() + 1);
					tmpTile.setTileY(prevTile.getTileY());
					tiles.add(tmpTile);
				}
				else if(prevTile.getTileX() == maxTilesHorizontally) {
					while(prevTile.getLeft() != null) {
						prevTile = prevTile.getLeft();
					}
					
					ITile tmpTile = new Tile();
					tmpTile.setLocation(new LocationPoints(prevTile.getLocation().getSWPoint(), 
							tileHeight, tileWidth));
					tmpTile.setUp(prevTile);
					prevTile.setDown(tmpTile);
					tmpTile.setTileX(prevTile.getTileX());
					tmpTile.setTileY(prevTile.getTileY() + 1);
					tiles.add(tmpTile);
				}
				
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
