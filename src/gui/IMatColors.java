/**
 * 
 */
package gui;

import java.awt.Color;
import java.awt.Font;

/**
 * @author grp30
 * 
 */
public final class IMatColors {
	private static final long serialVersionUID = 1L;

	// NON-LAZY INIT
	
	/** Base Color. All other colors should be related to the base color. */
	public static final Color BASE = new Color(212, 87, 1);

	/**	Lighter version of Base color */
	public static final Color BASE_LIGHT = new Color(254, 202, 114);
	
	/** Background */
	public static final Color BACKGROUND = Color.WHITE;
	
	/** Prevent construction */
	private IMatColors(){
		//Do nothing.
	}

}
