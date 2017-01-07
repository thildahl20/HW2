import java.util.Scanner;
/**
 * This is a class to set up a teacher, which is an extension of person
 * Also includes certification, grade level and employee ID
 * @author thildahl20
 *
 */
public class Teacher extends Person implements Employee {
int gradeLevel;
String certification;
int employeeID;
int pay = 0;
/**
 * This will set up a teacher with all of their value being chosen: name, age, etc.
 * @param Name
 * @param old
 * @param phone
 * @param building
 * @param grade
 * @param certify
 * @param id
 */
Teacher(String Name, int old, int phone, String building, int grade, String certify, int id) { 
name = Name;
age = old;
phone_number = phone;
inBuilding = building;
gradeLevel = grade;
certification = certify;
employeeID = id;
}
/**
 * This gives the teacher's employeeID upon being called
 */
public void getID(Person p) {
	System.out.printf("The employee number of %s is %d\n", name, employeeID);
	}
/**
 * This will ask for the employee's payment amount and adjust their pay value
 */
public void payEmployee(Person p) {
System.out.printf("How much would you like to pay %s?\n", name);
Scanner input = new Scanner(System.in);
int money = input.nextInt();
p.pay = money;
}

}