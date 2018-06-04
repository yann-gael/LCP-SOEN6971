package viewIMPL;

import java.util.ArrayList;
import java.util.Iterator;

import view.IDisplayable;
import view.IEvent;
import view.IObserver;
import view.ITile;

public class ImplObserver implements IObserver {
	String toShow[][] = new String[100][100];

	public ImplObserver() {
		for(int i = 0; i < 100; i++)
		{
			for(int j = 0; j < 100; j++)
			{
				toShow[i][j] = "NA";
			}
		}
	}
	
	@Override
	public void update(ITile observable) {
		Integer x = observable.getTileX();
		Integer y = observable.getTileY();
		ArrayList<IDisplayable> listOfObjects = observable.getObjectsOnTiles();
		
		Iterator<IDisplayable> itr = listOfObjects.iterator();
		toShow[x][y] = "";
		while(itr.hasNext()) {
			toShow[x][y] += "," + itr.next().getDisplay();
		}
		 
		System.out.println("*********************************************");
		for(int i = 0; i < 100; i++)
		{
			for(int j = 0; j < 100; j++)
			{
				System.out.printf("%-15s[%s]\n", "", toShow[i][j]);
			}
		}
		System.out.println("*********************************************");
	}

	@Override
	public void update(IDisplayable observable, IEvent event) {
		return;
	}
	
}
