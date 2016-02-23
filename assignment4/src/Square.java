/**
 * Assignment 4: Square
 * @author James Nhan
 * Version: 1.0
 */

import java.awt.Color;

/**
 * Square
 * This class consists of the definition of a Square shape based on the
 * Rectangle class
 * 
 * @author James Nhan
 * @since 1.0
 * @see Rectangle
 * @see Shape
 */
public class Square extends Rectangle {
	/**
	 * A constructor to set the position and size of the Square
	 * 
	 * @param x				- The x coordinate of the Square
	 * @param y				- The y coordinate of the Square
	 * @param w				- The width of the Square
	 * @author James Nhan
	 * @since 1.0
	 * @see	Rectangle
	 */
	public Square(int x, int y, int w) {
		this.x = x;
		this.y = y;
		this.width = w;
		this.height = w;
	}

	/**
	 * A constructor to set the color, position, and size of the Square
	 * 
	 * @param color			- The color of the Square
	 * @param x				- The x coordinate of the Square
	 * @param y				- The y coordinate of the Square
	 * @param w				- The width of the Square
	 * @author James Nhan
	 * @since 1.0
	 * @see	Rectangle
	 */
	public Square(Color color, int x, int y, int w) {
		this.color = color;
		this.x = x;
		this.y = y;
		this.width = w;
		this.height = w;
	}
}
