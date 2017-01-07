import java.util.Scanner;

/**
 * This is the police class, which is an extension of the person class
 * @author Tristan Hildahl
 */
public class Police extends Person implements Employee{
	public enum policeRole {Patrol, Sargent, Captain, Chief};
	policeRole Role;

	int pay = 0;
	int employeeID;
	int lastid = 1;
/**
 * This initializes a police person with generic traits
 */
	Police() {

	name = "John Doe";
	age = 40;
	phone_number = lastnumber;
	lastnumber++;
	inBuilding = "Outside";
	Role = policeRole.Patrol;
	employeeID = lastid;
	lastid++;
	}
/**
 * This initializes a police person with chosen values for name age etc.
 */
	Police(String Name, int old, int phone, String building, int id, policeRole role ) { 
	name = Name;
	age = old;
	phone_number = phone;
	inBuilding = building;
	employeeID = id;
	Role = role;

	}
	/**
	 * This will output the employee's id number upon being called
	 */
	public void getID(Person p) {
		System.out.printf("The employee number of %s is %d\n", name, employeeID);
		}
	/**
	 * This will ask for the payment towards the police person and will change their pay to the input amount
	 */
	public void payEmployee(Person p) {
		System.out.printf("How much would you like to pay %s?\n", name);
		Scanner input = new Scanner(System.in);
		int money = input.nextInt();
		p.pay = money;
		}
	}
