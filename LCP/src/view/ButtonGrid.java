package view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.BoxLayout;
import javax.swing.JTextField;
import model.IBuilding;
import model.IDisplayContent;
import model.IDisplayable;
import model.IDisplayableDimension;
import model.IEvent;
import model.IFloor;
import model.ILCPDriver;
import model.IObserver;
import model.IRoom;
import model.ITile;
import modelIMPL.LCPDriver;

public class ButtonGrid implements IObserver {

	private JFrame frame; // creates frame
	private JPanel[][] grid; // names the grid of buttons
	private int height, width;
	private IDisplayable building;
	
	private ILCPDriver lcpDriver;

	public ButtonGrid() {
		this.frame = new JFrame();
		this.lcpDriver = new LCPDriver();
		this.lcpDriver.addObserver(this);
		initGridDimensions();
		initGrid();
	}
	
	private void initGridDimensions() {
		this.height = this.lcpDriver.getNumTilesVertically();
		this.width = this.lcpDriver.getNumTilesVertically();
		return;
	}
	
	private void initGrid() {
		this.frame.setLayout(new GridLayout(height, width)); // set layout
		this.grid = new JPanel[height][width]; // allocate the size of grid
		
		for(int i = 0; i<21;i++) {
			for(int j = 0; j<21;j++) {
				this.grid[i][j] = new JPanel();
				this.grid[i][j].setLayout(new BoxLayout(this.grid[i][j], BoxLayout.LINE_AXIS));
				this.frame.add(grid[i][j]);
			}
		}
	}

	public IDisplayable getBuilding() {
		return this.lcpDriver.getBuilding();
	}
	
	public static void main(String[] args) {
		
		ButtonGrid btg = new ButtonGrid();
		
		btg.building = btg.getBuilding();
		btg.checkForUpdate();
		btg.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		btg.frame.setPreferredSize(new Dimension(840, 840));
		btg.frame.pack(); // sets appropriate size for frame
		btg.frame.setVisible(true); // makes frame visible
	}

	private void checkForUpdate() {

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
				grid[startY - i][j + startX].setBackground(disp.getBackground());
				grid[startY - i][j + startX].setBorder(BorderFactory.createBevelBorder(1));
				//display text name for reference 
		        JTextField text1 = new JTextField(); 
		        text1.setText(disp.getDisplay()); 
		        text1.setOpaque(false);         
		        grid[startY - i][j + startX].add(text1);
		        System.out.println(grid[startY - i][j + startX].getBackground());
			}
		}
		
	}

	@Override
	public void update(ITile observable) {
		
	}
}