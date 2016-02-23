/**
 * Mark Haselhoff
 * mhaselho@nwciowa.edu
 */

import java.awt.*;

/**
 * This is the line class I have created for you. You may use it as a template
 * for your other classes if you would like.
 * 
 * @author Mark
 */
public class Line extends Shape {
	protected int x1, y1, x2, y2;

	/**
	 * A constructor for a line. This constructor does not take a color
	 * 
	 * @param xa 		the start x position
	 * @param ya 		the start y position
	 * @param xb 		the end x position
	 * @param yb 		the end y position
	 */
	public Line(int xa, int ya, int xb, int yb) {
		super();
		x1 = xa;
		y1 = ya;
		x2 = xb;
		y2 = yb;
	}

	/**
	 * A constructor for a line that takes a color.
	 * 
	 * @param color 	the color of the line
	 * @param xa 		the start x position
	 * @param ya 		the start y position
	 * @param xb 		the end x position
	 * @param yb 		the end y position
	 */
	public Line(Color color, int xa, int ya, int xb, int yb) {
		super(color);
		x1 = xa;
		y1 = ya;
		x2 = xb;
		y2 = yb;
	}

	/**
	 * The method to draw the line. This overrides the shape draw method.
	 * 
	 * @param page 		The page to draw the line on.
	 */
	public void draw(Graphics page) {
		page.setColor(color);
		page.drawLine(x1, y1, x2, y2);
	}
}