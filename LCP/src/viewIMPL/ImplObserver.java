package viewIMPL;

import view.IDisplayContent;
import view.IDisplayable;
import view.IEvent;
import view.IObjectOnTile;
import view.IObserver;
import view.ITile;

public class ImplObserver implements IObserver {
	String toShow[][] = new String[21][21];

	public ImplObserver() {
		for(int i = 0; i < 21; i++)
		{
			for(int j = 0; j < 21; j++)
			{
				toShow[i][j] = "";
			}
		}
	}
	
	@Override
	public void update(ITile observable) {
		
	}

	@Override
	public void update(IDisplayable observable, IEvent event) {
		IObjectOnTile tileDet = observable.getTileDetails();
		IDisplayContent disp = observable.getDisplay();
		
		Integer startX = tileDet.getX();
		Integer startY = tileDet.getY();
		Integer ht = tileDet.getHeight();
		Integer wd = tileDet.getWidth();
		
		for(int i = startY; i < ht; i++) {
			for(int j = startX; j < wd; j++) {
				toShow[i][j] += disp.getDisplay();
			}
		}
		 
		System.out.println("*********************************************");
		for(int i = 0; i < 21; i++)
		{
			for(int j = 0; j < 21; j++)
			{
				System.out.print(toShow[i][j] + ", ");
			}
			System.out.println();
		}
		System.out.println("*********************************************");
		return;
	}
	
}
