import javax.swing.*;

/**
 * This class creates a button object that keeps track of the icon and building associated with it
 * @author thildahl20
 *
 */
public class BuildingButton extends JButton{
	private Building building;
	/**
	 * Constructor that takes the button Icon and the building
	 * @param Icon
	 * @param bld
	 */
	public BuildingButton (ImageIcon Icon, Building bld) {
		super(Icon);
		building = bld;
	}
	/**
	 * Can get the building associated with the button via this function
	 * @return
	 */
	public Building getBuilding() {
		return building;
	}
}