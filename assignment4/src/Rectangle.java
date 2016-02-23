/**
 * Assignment 4: Rectangle
 * @author James Nhan
 * Version: 1.0
 */

import java.awt.Color;
import java.awt.Graphics;

/**
 * Rectangle
 * This class consists of the definition of a Rectangle shape based on the
 * Shape class
 * 
 * @author James Nhan
 * @since 1.0
 * @see Shape
 * @see Square
 */
public class Rectangle extends Shape {
	// These members should be protected because this class can be the base for
	// another type of shape
	
	/**
	 * The x coordinate on the page
	 */
	protected int x;

	/**
	 * The y coordinate on the page
	 */
	protected int y;
	
	/**
	 * The width of the Rectangle
	 */
	protected int width;
	
	/**
	 * The height of the Rectangle
	 */
	protected int height;
	
	// Delegate defaults to the super's default constructor
	public Rectangle() { }
	
	/**
	 * A constructor to set the position and size of the Rectangle
	 * 
	 * @param x				- The x coordinate of the Rectangle
	 * @param y				- The y coordinate of the Rectangle
	 * @param w				- The width of the Rectangle
	 * @param h				- The height of the Rectangle
	 * @author James Nhan
	 * @since 1.0
	 * @see	Shape
	 */
	public Rectangle(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.width = w;
		this.height = h;
	}

	/**
	 * A constructor to set the color, position, and size of the Rectangle
	 * 
	 * @param color			- The color of the lines
	 * @param x				- The x coordinate of the Rectangle
	 * @param y				- The y coordinate of the Rectangle
	 * @param w				- The width of the Rectangle
	 * @param h				- The height of the Rectangle
	 * @author James Nhan
	 * @since 1.0
	 * @see	Shape
	 */
	public Rectangle(Color color, int x, int y, int w, int h) {
		this.color = color;
		this.x = x;
		this.y = y;
		this.width = w;
		this.height = h;
	}

	/**
	 * A method to draw the Rectangle that overrides the abstract method in the
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
		page.drawRect(x, y, width, height);
	}
}
