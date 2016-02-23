/**
 * Assignment 4: Oval
 * @author James Nhan
 * Version: 1.0
 */

import java.awt.Color;
import java.awt.Graphics;

/**
 * Oval
 * This class consists of the definition of an Oval shape based on the
 * Shape class
 * 
 * @author James Nhan
 * @since 1.0
 * @see Shape
 */
public class Oval extends Shape {
	// These members should be protected because this class can be the base for
	// another type of shape
	
	/**
	 * The color of the Oval
	 */
	protected Color color;
	
	/**
	 * The x coordinate of the Oval
	 */
	protected int x;
	
	/**
	 * The y coordinate of the Oval
	 */
	protected int y;
	
	/**
	 * The width of the Oval
	 */
	protected int width;
	
	/**
	 * The height of the Oval
	 */
	protected int height;

	// Delegate defaults to the super's default constructor
	public Oval() { }

	/**
	 * A constructor to set the position and size of the Oval
	 * 
	 * @param color			- The color of the lines
	 * @param x				- The x coordinate of the Oval
	 * @param y				- The y coordinate of the Oval
	 * @param w				- The width of the Oval
	 * @param h				- The height of the Oval
	 * @author James Nhan
	 * @since 1.0
	 * @see	Shape
	 */
	public Oval(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.width = w;
		this.height = h;
	}

	/**
	 * A constructor to set the position and size of the Oval
	 * 
	 * @param color			- The color of the lines
	 * @param x				- The x coordinate of the Oval
	 * @param y				- The y coordinate of the Oval
	 * @param w				- The width of the Oval
	 * @param h				- The height of the Oval
	 * @author James Nhan
	 * @since 1.0
	 * @see	Shape
	 */
	public Oval(Color color, int x, int y, int w, int h) {
		this.color = color;
		this.x = x;
		this.y = y;
		this.width = w;
		this.height = h;
	}

	/**
	 * A method to draw the Oval that overrides the abstract method in the
	 * super class
	 * 
	 * @param page			- The Graphics object to draw on
	 * @author James Nhan
	 * @since 1.0
	 * @see Shape
	 */
	@Override
	public void draw(Graphics page) {
		page.setColor(color);
		page.drawOval(x, y, width, height);
	}
}
