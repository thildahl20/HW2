import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * This creates an image object that can be dragged around the screen
 * One will be created for each person, and by storing that person, it can adjust the building occupants as it is moved
 * @author thildahl20
 * @version 1.2 This was added after the due date (I wasnt able to get objects to drag)
 */
public class CityController extends JComponent implements MouseMotionListener{
	int imageX, imageY;
	Image image;
	Person p;

	/**
	 * This is the constructor for a CityController, it initializes its image and person values
	 * @param img is the image
	 * @param x is the x location for the image
	 * @param y is the y loaction for the image
	 * @param people is the person associated with that image
	 */
	public CityController(Image img, int x, int y, Person people) {
		image = img;
		imageX = x;
		imageY = y;
		p = people;
		addMouseMotionListener(this);
	
	}
	
	public void mouseMoved(MouseEvent e) {}
	
	/**
	 * When the image is moved, change the x and y values to the dragged location
	 */
	public void mouseDragged(MouseEvent e) {
		imageX = e.getX();
		imageY = e.getY();
		repaint();
	}
	
	/**
	 * After the image has been moved, repaint with the new x and y images
	 * Then go to change building, to change the building occupants based on the image's new location
	 */
	public void paint(Graphics g) {
		g.drawImage(image, imageX, imageY, this);
		changeBuilding();
	}
	
	/**
	* For up to the number of buildings, check to see how many building button lengths the dragged object is in from the edge,
	* Then set that person's building place to the new locations' building, and change the buildings' occupants
	*/
	public void changeBuilding(){
		//Get the width of the frame and the building array for the city from CityView
		int imageWidth = getWidth();
		Building[] buildings = getBuilding();
		
		//Find out how many building buttons away from the edge it is
	for (int i = 0; i < buildings.length; i++) {
		if (imageX < imageWidth*(i+1))  {
			
			//Then check each building 
			for (int j = 0; j < buildings.length; j++)
				//Find the building that the person was in and remove them as an occupant
				if ( p.inBuilding == buildings[j].Name)
					buildings[j].removeOccupant(p);
			
			//Then using the number of building in from the edge, change the person's building and add them as an occupant
			p.inBuilding = buildings[i].Name;
			buildings[i].addOccupant(p);
			break;
		}
	}
	}
}
