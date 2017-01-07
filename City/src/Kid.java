/**
 * This class creates a kid object, which extends Person
 * The kid class also keeps track of their favorite candy
 * @author thildahl20
 *
 */
public class Kid extends Person {
String favCandy;

/**
 * This is for a default kid
 */
Kid() {
name = "John Doe";
age = 40;
phone_number = lastnumber;
lastnumber++;
inBuilding = "Outside";
favCandy = "Snickers";
}
/**
 * This sets up a Kid person with all of its values chosen: name, age, etc.
 * @param Name
 * @param old
 * @param phone
 * @param building
 * @param candy
 */
Kid(String Name, int old, int phone, String building, String candy) { 
name = Name;
age = old;
phone_number = phone;
inBuilding = building;
favCandy = candy;
}
}