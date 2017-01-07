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
int phone_number;
static int lastnumber = 1234567;
String inBuilding;
int employeeID;
int pay = 0;

Person() {
name = "John Doe";
age = 40;
phone_number = lastnumber;
lastnumber++;
inBuilding = "Outside";
}

Person(String Name, int old, int phone, String building) { 
name = Name;
age = old;
phone_number = phone;
inBuilding = building;
}

public void getID(Person p) {
	System.out.printf("The employee number of %s is %d\n", name, employeeID);
	}

public void payEmployee(Person p) {
	System.out.printf("How much would you like to pay %s?\n", name);
	Scanner input = new Scanner(System.in);
	int money = input.nextInt();
	p.pay = money;
	}
}
