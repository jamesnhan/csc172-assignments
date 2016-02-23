/**
 * Mark Haselhoff
 * mhaselho@nwciowa.edu
 */

import java.awt.*;

/**
 * Shape
 * This class consists of the definition of a generic Shape
 */
public abstract class Shape {
	// These members should be protected because this class can be the base for
	// another type of shape
	
	/**
	 * The color of the Shape
	 */
	protected Color color;

	/**
	 * A constructor to default the color to black
	 * 
	 * @since 1.0
	 */
	public Shape() {
		color = Color.black;
	}

	/**
	 * A constructor to set the color
	 * 
	 * @param color			- The color of the shape
	 * @since 1.0
	 */
	public Shape(Color color) {
		this.color = color;
	}

	/**
	 * An abstract method for an interface implementation
	 * 
	 * @param page			- The Graphics object to draw on
	 * @since 1.0
	 */
	public abstract void draw(Graphics page);
}
