package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import javafx.scene.layout.Border;
import model.IBuilding;
import model.IDisplayContent;
import model.IDisplayable;
import model.IDisplayableDimension;
import model.IEvent;
import model.IFloor;
import model.IObserver;
import model.IRoom;
import model.ITile;
import tests.CreationalTests;

public class ButtonGrid implements IObserver {

	JFrame frame = new JFrame(); // creates frame
	JPanel[][] grid; // names the grid of buttons
	int height, width;
	static IDisplayable building;
	static CreationalTests ct;

	public ButtonGrid(int height, int width) {
		this.height = height;
		this.width = width;
		frame.setLayout(new GridLayout(height, width)); // set layout
		grid = new JPanel[height][width]; // allocate the size of grid
		for(int i = 0; i<21;i++) {
			for(int j = 0; j<21;j++) {
				grid[i][j] = new JPanel();
				frame.add(grid[i][j]);
			}
		}
	}

	public static void main(String[] args) {
		ct = new CreationalTests();
		building = ct.createBuilding();
		checkForUpdate();
	}

	private static void checkForUpdate() {

		Iterator<IDisplayable> floors = ((IBuilding) building).getFloors();
		while (floors.hasNext()) {
			IDisplayable floor = floors.next();
			floor.checkAddition();

			Iterator<IDisplayable> rooms = ((IFloor) floor).getRooms();
			while (rooms.hasNext()) {
				IDisplayable room = rooms.next();
				room.checkAddition();

				Iterator<IDisplayable> furns = ((IRoom) room).getFurniture();
				while (furns.hasNext()) {
					IDisplayable furn = furns.next();
					furn.checkAddition();
				}
			}
		}
	}

	@Override
	public void update(IDisplayable observable, IEvent event) {
		IDisplayableDimension tileDet = observable.getTileDetails();
		IDisplayContent disp = observable.getDisplay();

		Integer startX = tileDet.getX();
		Integer startY = tileDet.getY();
		Integer ht = tileDet.getHeight();
		Integer wd = tileDet.getWidth();

		for (int i = 0; i < ht; i++) {
			for (int j = 0; j < wd; j++) {
				//grid[startY - i][j + startX] = new JPanel(); // creates new panel
				grid[startY - i][j + startX].setBackground(disp.getBackground());
				grid[startY - i][j + startX].setBorder(BorderFactory.createBevelBorder(1));
				//frame.add(grid[startY - i][j + startX]); // adds panel to frame
			}
		}
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(840, 840));
		frame.pack(); // sets appropriate size for frame
		frame.setVisible(true); // makes frame visible
	}

	@Override
	public void update(ITile observable) {
		// TODO Auto-generated method stub

	}
}