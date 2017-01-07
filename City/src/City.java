/**
* This is the central class where I build the objects to test the program, using the other classes
* @author Tristan Hildahl
*/
public class City {

	/**
	 * This is the test function, where I go through many of the processes fulfilled by the classes
	 */
	public static void main(String[] args) {
		//This initializes all of the people: can be set as Person, teacher, kid or police
		Person[] people = {new Person(), new Person("Will James", 27, 9092345, "Northtown Mall"), new Teacher("June Hawthorne", 37, 3274411, "Holmes Elementary", 3, "Whitworth University", 12234),
				new Teacher("Rudy Montgomery", 54, 7778945, "Mead High School", 9,  "University of Washington", 44435), new Police("Keaton Safe", 32, 3332456, "City Hall", 323, Police.policeRole.Chief), 
				new Kid("Jackson Gally", 13, 7779988, "Holmes Elementary", "Reese's")      };
		
		//This initializes all of the buildings: can be a building, city hall or school
		Building[] buildings = { new Building("Northtown Mall"), new City_Hall("City Hall", 4332, "Maple Blvd."), new School("Holmes Elementary", 1122, "A Street") };


	
	//Outputs all of the people objects created in the array
	for (int i = 0; i < people.length; i++)
	System.out.printf("%s\n", people[i].name);
		
	//Outputs all of the building objects created in the array
	for (int j = 0; j < buildings.length; j++)
		System.out.printf("%s\n", buildings[j].Name);
	
	//This shows that the each person recalls in what building they are in
	System.out.printf("\n%s is in the building %s\n\n", people[2].name, people[2].inBuilding);
	
	//This will set set up all of the occupants in each building, by comparing the people's locations to the buildings
	//Then it will go to outOccupants which outputs all of the people in each building
	for (int i = 0; i < buildings.length; i++)
	{buildings[i].setOccupants(people);
		buildings[i].outOccupants();}
	
	//This allows one to access an employee's ID and then pay the employee, which is recorded with the person
	people[3].getID(people[3]);
	people[3].payEmployee(people[3]);
	System.out.printf("\nThe amount of money %s has been paid is %d", people[3].name, people[3].pay);
	}

}
