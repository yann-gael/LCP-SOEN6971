package tests;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Iterator;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import factory.*;
import model.IBuilding;
import model.IDisplayContent;
import model.IDisplayable;
import model.IFloor;
import model.IRoom;
import model.ITile;
import modelIMPL.Building;
import modelIMPL.DisplayContent;
import tests.*;
public class ButtonGrid {
 
        JFrame frame=new JFrame(); //creates frame
        JPanel[][] grid; //names the grid of buttons
 
        public ButtonGrid(int width, int length){ //constructor
                frame.setLayout(new GridLayout(width,length)); //set layout
                grid=new JPanel[width][length]; //allocate the size of grid
//                CreationalTests ct = new CreationalTests();
////                IBuilding building =  ct.createBuilding();
//               // ITile[][] listOfTiles = building.getTiles();
//                IDisplayContent buildingDisplay = new DisplayContent();
//        		buildingDisplay.setDisplay("Building");
//        		IDisplayable building = Factory.getInstance().getBuilding(buildingDisplay);
//        		this.building = building;
//                
//                ct.testFurniture();
//        		Iterator<IDisplayable> floors = ((IBuilding)this.building).getFloors();
//        		while(floors.hasNext()) {
//        			IDisplayable floor = floors.next();
//        			floor.checkAddition();
//        			
//        			Iterator<IDisplayable> rooms = ((IFloor) floor).getRooms();
//        			while(rooms.hasNext()) {
//        				IDisplayable room = rooms.next();
//        				room.checkAddition();
//        				
//        				Iterator<IDisplayable> furns = ((IRoom) room).getFurniture();
//        				while(furns.hasNext()) {
//        					IDisplayable furn = furns.next();
//        					furn.checkAddition();
//        				}
//        			}
//        		}
//                
                
                for(int y=0; y<length; y++){
                        for(int x=0; x<width; x++){
                                grid[x][y]=new JPanel(); //creates new button     
                                frame.add(grid[x][y]); //adds button to grid
                                Random rand = new Random();
                                float r = rand.nextFloat();
                                float g = rand.nextFloat();
                                float b = rand.nextFloat();
                                Color randomColor = new Color(r, g, b);
                                grid[x][y].setBackground(randomColor);

                        }
                }
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setPreferredSize(new Dimension(840, 840));
                frame.pack(); //sets appropriate size for frame
                frame.setVisible(true); //makes frame visible
        }
        public static void main(String[] args) {
                new ButtonGrid(21,21);//makes new ButtonGrid with 2 parameters
        }
}