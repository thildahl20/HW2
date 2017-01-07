/**
 * This interface will allow various Persons, the teachers and police, to implement the same functions
 * These functions output the ID of an employee, or allow the employee to get paid
 * @author thildahl20
 *
 */
public interface Employee {
	void getID(Person p); 

	void payEmployee(Person p); 

	}