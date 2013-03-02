/**
 * 
 */
package gui;

import java.awt.Color;

/**
 * @author tortal
 * 
 */
public class IMatColors extends Color {
	private static final long serialVersionUID = 1L;

	// NON-LAZY INIT
	public static Color BASE = new Color(212, 87, 1);	//Orange-y
	public static Color BACKGROUND = Color.WHITE;

	
	//	Private no-args constructor
	private IMatColors() {
		super(255, 255, 255);
	}

}
