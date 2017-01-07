
/**
 * This class is an extension of building
 * @author thildahl20
 *
 */
public class School extends Building {
	
	/**
	 * This sets up a school with known information
	 * @param name
	 * @param num
	 * @param address
	 */
School(String name, int num, String address) {
Name = name;
address_num = num;
address_place = address;
}

/**
 * This function will input the array of all of the people in the city, check each person to that location, and if they are in that location, expand the occupant vector to store their name
 */
public void setOccupants(Person[] p){

for (int i = 0; i < p.length; i++)
if (Name == p[i].inBuilding)
occupants.add(p[i].name);

}

/**
 * This outputs all of the people in a given location
 */
public void outOccupants(){
	System.out.printf("The people in %s are: %s\n", Name, occupants);

}

}
