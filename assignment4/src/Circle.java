/**
 * Assignment 4: Circle
 * @author James Nhan
 * Version: 1.0
 */

import java.awt.Color;

/**
 * Circle
 * This class consists of the definition of a Circle shape based on the
 * Oval class
 * 
 * @author James Nhan
 * @since 1.0
 * @see Oval
 * @see Shape
 */
public class Circle extends Oval {
	/**
	 * A constructor to set the position and size of the Circle
	 * 
	 * @param x				- The x coordinate of the Circle
	 * @param y				- The y coordinate of the Circle
	 * @param w				- The radius of the Circle
	 * @author James Nhan
	 * @since 1.0
	 * @see	Oval
	 */
	public Circle(int x, int y, int r) {
		this.x = x;
		this.y = y;
		this.width = r;
		this.height = r;
	}

	/**
	 * A constructor to set the color, position, and size of the Circle
	 * 
	 * @param color			- The color of the lines
	 * @param x				- The x coordinate of the Circle
	 * @param y				- The y coordinate of the Circle
	 * @param w				- The radius of the Circle
	 * @author James Nhan
	 * @since 1.0
	 * @see	Oval
	 */
	public Circle(Color color, int x, int y, int r) {
		this.color = color;
		this.x = x;
		this.y = y;
		this.width = r;
		this.height = r;
	}
}
