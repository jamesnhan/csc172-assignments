/**
 * Assignment 4: Polygon
 * @author James Nhan
 * Version: 1.0
 */

import java.awt.Color;
import java.awt.Graphics;

/**
 * Polygon
 * This class consists of the definition of a Polgyon shape based on the
 * Shape class
 * 
 * @author James Nhan
 * @since 1.0
 * @see Shape
 */
public class Polygon extends Shape {
	// These members should be protected because this class can be the base for
	// another type of shape
	
	/**
	 * The x coordinate points of the Polygon's vertices
	 */
	protected int[] xPoints;
	
	/**
	 * The y coordinate points of the Polygon's vertices
	 */
	protected int[] yPoints;
	
	/**
	 * A constructor to set the coordinates of the Polygon's vertices
	 * 
	 * @param points			- The the x, y coordinates alternating x1, y1,
	 * 							  x2, y2...
	 * @author James Nhan
	 * @since 1.0
	 * @see	Shape
	 */
	public Polygon(int[] points) {
		// Half of the points are x coordinates and the other half are
		// y coordinates
		xPoints = new int[points.length / 2];
		yPoints = new int[points.length / 2];
		
		// Set the coordinates moving by two indices at a time
		// This assumes that the size of the array is always even
		for (int i = 0; i < points.length; i += 2) {
			xPoints[i] = points[i];
			yPoints[i] = points[i + 1];
		}
	}

	
	/**
	 * A constructor to set the color and coordinates of the Polygon's vertices
	 * 
	 * @param color				- The color of the lines
	 * @param points			- The the x, y coordinates alternating x1, y1,
	 * 							  x2, y2...
	 * @author James Nhan
	 * @since 1.0
	 * @see	Shape
	 */
	public Polygon(Color color, int[] points) {
		this.color = color;
		// Half of the points are x coordinates and the other half are
		// y coordinates
		xPoints = new int[points.length / 2];
		yPoints = new int[points.length / 2];
		
		// Set the coordinates moving by two indices at a time
		// This assumes that the size of the array is always even
		for (int i = 0; i < points.length; i += 2) {
			xPoints[i / 2] = points[i];
			yPoints[i / 2] = points[i + 1];
		}
	}

	/**
	 * A method to draw the Polygon that overrides the abstract method in the
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
		page.drawPolygon(xPoints, yPoints, xPoints.length);
	}
}
