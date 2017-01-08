import java.util.Scanner;

/**
 * This is the base person class, which keeps track of a person's name, age, building they are in, etc.
 * 
 * @author thildahl20
 *
 */
public class Person {
String name;
int age;
int phone_number
// This ensures that if multiple people are initialized without parameters, they will have different numbers
static int lastnumber = 1234567;
String inBuilding;
int employeeID;
int pay = 0;

/**
* This is the default constructor
*/
Person() {
name = "John Doe";
age = 40;
phone_number = lastnumber;
lastnumber++;
inBuilding = "Outside";
}

/**
*This constructor initializes all of the values for a person
*/
Person(String Name, int old, int phone, String building) { 
name = Name;
age = old;
phone_number = phone;
inBuilding = building;
}
/**
* This can change the building that the person is in
* @param person
* @param building
*/
setBuilding(Person p, String building) {
inBuilding = building;   
  }

	/**
	*This outputs the employee id number for a person
	*/
public void getID(Person p) {
	System.out.printf("The employee number of %s is %d\n", name, employeeID);
	}

	/**
	*This asks for a payment amount, then changes the pay value to that amount for a person
	*/
public void payEmployee(Person p) {
	System.out.printf("How much would you like to pay %s?\n", name);
	Scanner input = new Scanner(System.in);
	int money = input.nextInt();
	p.pay = money;
	}
}
