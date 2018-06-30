//package view;
//
//import java.awt.Dimension;
//import java.awt.GridLayout;
//
//import javax.swing.BoxLayout;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
//
//import model.IBuilding;
//import model.IDisplayable;
//import model.ITile;
//import tests.CreationalTests;
//
//public class Basic extends JFrame{
//
//	public static void main(String[] args) {
//		JFrame mainFrame = new JFrame();// creating instance of JFrame
//		
//		JPanel mainPanel = new JPanel();
//		
//		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
//		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
//		
//		CreationalTests ct = new CreationalTests();
//		IBuilding building = ct.createBuilding();
//		 ITile[][] listOfTiles = building.getTiles();
//		 
//		 
//		 
//		 
//		 
//		 
//		
//		/*// map panel embedded inside sub bottom panel's left bottom corner
//				JPanel LeftGridMapPane = new JPanel();
//
//				LeftGridMapPane.setLayout((new GridLayout(width_height.x, width_height.y, 1, 1)));
//				LeftGridMapPane.setMaximumSize(new Dimension(750, 500));
//				// LeftGridMapPane.setBorder(BorderFactory.createLineBorder(Color.BLACK,
//				// 2));
//				LeftGridMapPane.setBorder(BorderFactory.createEmptyBorder());
//		
//		
//		mainFrame.add(mainPanel);
//		
//		
//		
//		
//		
//		
//
//		JButton b = new JButton("click");// creating instance of JButton
//		b.setBounds(130, 100, 100, 40);// x axis, y axis, width, height
//
//		mainFrame.add(b);// adding button in JFrame
//
//		mainFrame.setSize(400, 500);// 400 width and 500 height
//		mainFrame.setLayout(null);// using no layout managers
//		mainFrame.setVisible(true);// making the frame visible
//*/	}
//
//}
