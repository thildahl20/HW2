import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import javax.swing.*;

/**
* This is the main class for HW3 where I set up people and buildings, create a frame with a button for each that can output info when pressed
* It also includes an image for each person that can be dragged around, while changing the person's building location based on their x-value
* @author thildahl20
* @version 1.2 
* 
* (Before the due date I was able to create the buttons with the options panes, but I was unable to get the objects to drag. 
* I decided to wait to turn it in until it was finished, sorry for turning it in so late)
*/
public class CityView implements ActionListener{
	JFrame frame;
	int imageWidth = 85;
	Image icon;
	Person[] people;
	Building[] buildings;
	
	/**
	 * This is the starting function, it initializes the people and buildings, then sets up a window and creates buttons for each one
	 * @param args
	 */
	public static void main(String[] args) {
		//This initializes all of the people: can be set as Person, teacher, kid or police
		Person[] people = {new Person(), new Person("Will James", 27, 9092345, "Northtown Mall"), new Teacher("June Hawthorne", 37, 3274411, "Holmes Elementary", 3, "Whitworth University", 12234),
				new Teacher("Rudy Montgomery", 54, 7778945, "Mead High School", 9,  "University of Washington", 44435), new Police("Keaton Safe", 32, 3332456, "City Hall", 323, Police.policeRole.Chief), 
				new Police("Harrison Justice", 23, 3332245, "Mead High School", 323, Police.policeRole.Sargent), new Kid("Jackson Gally", 13, 7779988, "Holmes Elementary", "Reese's"), new Kid("Julie Montgomery", 5, 4447789, "Outside", "Oreo's")     };
		
		//This initializes all of the buildings: can be a building, city hall or school
		Building[] buildings = { new Building("Northtown Mall"), new Building("Outside"), new City_Hall("City Hall", 4332, "Maple Blvd."), new School("Holmes Elementary", 1122, "A Street"), new School("Mead High School", 3456, "Hawthorne rd.")  };
		
		CityView cv = new CityView(people, buildings);
		//This sets up the occupants of the builings using the people's locations
		cv.setPeople(buildings, people);
		
		//This creates a button for each building
		for (int i = 0; i < buildings.length; i++) {
		cv.createBuilding(buildings[i], people);
		}
		//This creates a button and a label for each person, listed in an order by their building
		for (int i = 0; i < buildings.length; i++)
		cv.createPeople(people, buildings[i]);

	}
	
	/**
	 * This creates a frame: it is used to set up the interface
	 */
	public CityView(Person[] p, Building[] bld){
		people = p;
		buildings = bld;
		frame = new JFrame("City");
		frame.setBounds(100, 100, 750, 750);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout());
		frame.setVisible(true);

		//URL imgURL;
		//Toolkit toolkit = Toolkit.getDefaultToolkit();
		//imgURL = getClass().getResource("/resources/grass.jpg");
		//icon = toolkit.createImage(imgURL);
		//icon = icon.getScaledInstance(600,  450,  Image.SCALE_SMOOTH);
		//frame.add(icon);

	}
	
	/**
	 * This allows controller to get the width of one building button: can be used to distinguish how many builds
	 * @return the image width
	 */
	public int getWidth() {
		return imageWidth;
	}
	
	/**
	 * This allows controller to get the array of buildings in the city in order to reset the occupants depending on where the images are dragged
	 * @return the array of buildings
	 */
	public Building[] getBuilding() {
		return buildings;
	}
	
	/**
	 * This takes a building and creates a button for that building and one for each person inside that building
	 * @param bld the building that is being used for the button
	 * @param people all of the people that could be in the building
	 */
	private void createBuilding(Building bld, Person[] people){
		JPanel panel = new JPanel();
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		
		try {
			URL imgURL;
			
			/**
			 * This will check the building type, and choose an appropriate image: school, city hall, etc
			 */
			if (bld instanceof School)
				imgURL = getClass().getResource("/resources/school.jpg");
			else if (bld instanceof City_Hall)
				imgURL = getClass().getResource("/resources/cityhall.png");
			else 
				imgURL = getClass().getResource("/resources/building.png");
			
			Image img = toolkit.createImage(imgURL);
			img = img.getScaledInstance(imageWidth, imageWidth,  Image.SCALE_SMOOTH);
			ImageIcon icon = new ImageIcon(img);
			BuildingButton button = new BuildingButton(icon, bld);
			button.addActionListener(this);
			panel.add(button);

		}
		catch (Exception ex) {;}
		frame.add(panel);
		frame.revalidate();
	}
		/**
		 * This will check each person, and if they are currently in the building create a button for that person
		 */
	public void createPeople(Person[] people, Building bld){
		JPanel panel = new JPanel();

		Toolkit toolkit = Toolkit.getDefaultToolkit();

		//This makes the people appear on screen in order based on their initial building location
		for (int i = 0; i < people.length; i++){
			if (people[i].inBuilding == bld.Name){
			try {
				URL imgperson;
	
				/**
				 * This checks to see whether the person is a teacher, police, etc, and chooses a proper image for the type
				 */
				if (people[i] instanceof Police)
					imgperson = getClass().getResource("/resources/police.jpg");
				else if (people[i] instanceof Teacher)
					imgperson = getClass().getResource("/resources/teacher.png");
				else if (people[i] instanceof Kid)
					imgperson = getClass().getResource("/resources/boy.jpg");
				else 
					imgperson = getClass().getResource("/resources/person.png");
			
				Image img = toolkit.createImage(imgperson);
				img = img.getScaledInstance(65, 65,  Image.SCALE_SMOOTH);
				ImageIcon icon = new ImageIcon(img);
				
				//Using that image, create a button that can be used to display info on the person
				TristansButton button = new TristansButton(icon, people[i]);
				
				//Also create an image that can be dragged around the screen, while recording its x and y value
				//(This was added after the due date)
				CityController image = new CityController(img, (int)(imageWidth*(i+1)*.5), 500, people[i]);
				
				button.addActionListener(this);
				panel.add(button);
				frame.add(image);
				
			}
			catch (Exception ex) {;}
			}
		}
		
		frame.add(panel);
		frame.revalidate();
	}
	
	/* Old version where I tried a gridbag layout: can ignore
	private void addgb(Component c, int x, int y) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = x;
		gbc.gridy = y;
		frame.add(c, gbc);
	}
	*/
	
	/**
	 * This will set the occupants in the buildings, by taking all of the people and comparing their locations
	 * @param buildings all of the buildings in the city
	 * @param people all of the people in the city
	 */
	private void setPeople(Building[] buildings, Person[] people){
		for (int i = 0; i < buildings.length; i++)
			buildings[i].setOccupants(people);
	}
	
	/**
	 * When a button for a building or person is pressed it creates a dialogue box that shows information about it
	 */
	public void actionPerformed(ActionEvent e) {
		/**
		 * If the button is for a person, get that person
		 */
		
		if (e.getSource() instanceof TristansButton) {
			TristansButton t = (TristansButton)e.getSource();
			Person p = t.getPerson();
			JOptionPane pane = null;
			
			/**
			 * Then depending on the type of person: police, teacher, etc output a statement describing them in a new box
			 */
			if (p instanceof Teacher) {
				String x = String.format("This is a teacher named %s that teaches grade level %d.", p.name, ((Teacher) p).gradeLevel);
				pane.showMessageDialog(frame, x);
			}
			else if (p instanceof Police) {
				String x = String.format("This is a police officer named %s with rank %s.", p.name, ((Police) p).Role);
				pane.showMessageDialog(frame, x);
			}
			else if (p instanceof Kid){
				String x = String.format("This is a kid named %s whose favorite candy is %s.", p.name, ((Kid) p).favCandy);
				pane.showMessageDialog(frame, x);
			}
			else {
				String x = String.format("This is a person whose name is %s and is %d years old.", p.name, p.age);
				pane.showMessageDialog(frame, x);
			}
			}
		/**
		*if the button is for a building, get that type of building
		*/
		else if (e.getSource() instanceof BuildingButton){
			BuildingButton B = (BuildingButton)e.getSource();
			Building b = B.getBuilding();
			JOptionPane pane = null;
				
			if (b instanceof City_Hall) {
				String x = String.format("This is a city hall. Its current occupants are %s.", b.occupants);
				pane.showMessageDialog(frame, x);
			}
			else if (b instanceof School){
				String x = String.format("This is %s. Its current occupants are %s", b.Name, b.occupants);
				pane.showMessageDialog(frame, x);
			}
			else {
				String x = String.format("This location is %s. Its current occupants are %s",b.Name, b.occupants);
				pane.showMessageDialog(frame, x);
			}
		}
		}

}