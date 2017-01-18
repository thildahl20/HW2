import java.awt.*;
import javax.swing.*;

/**
 * This class creates a button object that keeps track of the person associated with that button in order to later recall information on that person when the button is pressed
 * @author thildahl20
 *
 */
public class TristansButton extends JButton{
	private Person person;
	/**
	 * Constructor that takes the button Icon and the person
	 * @param Icon the image on the button
	 * @param p the person associated with the button
	 */
	public TristansButton (ImageIcon Icon, Person p){
		super(Icon);
		person = p;
	}
	/**
	 * Can get the person associated with the button via this function
	 * @return person
	 */
	public Person getPerson() {
		return person;
	}
}

