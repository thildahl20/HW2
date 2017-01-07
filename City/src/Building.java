import java.util.ArrayList;
/**
 * This sets up a building class, which stores its name and address, as well as a vector of its occupants
 * @author thildahl20
 *
 */
public class Building {
String Name;
int address_num;
int lastaddress = 1000;
String address_place;
ArrayList<String> occupants = new ArrayList<String>();

Building() {}

/**
 * This sets up a mostly default building, with just a name
 * @param name
 */
Building(String name) {
Name = name;
address_num = lastaddress;
lastaddress = lastaddress + 4;
address_place = "First Avenue";}

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