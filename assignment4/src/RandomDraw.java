/**
 * Mark Haselhoff
 * mhaselho@nwciowa.edu
 */

import java.applet.*;
import java.awt.*;

/**
 * RandomDraw
 * This class consists of the entry point for testing the ShapeCreator and
 * Shapes
 */
public class RandomDraw extends Applet {
	final int MAX_SHAPE = 50;
	Shape[] shapes = new Shape[MAX_SHAPE];
	ShapeCreator creator;

	/**
	 * This is the entry point of your program. It is similar to main for
	 * applets. Often this method is finished, paint will be called implicitly
	 * (You don't actually need to call it) In this method, you should create
	 * your shapes. I have created one for you.
	 */
	public void init() {
		creator = new ShapeCreator();
		for (int i = 0; i < MAX_SHAPE; ++i) {
			shapes[i] = creator.newShape();
		}
	}

	/**
	 * This method will be called implicitly after the init() method executes.
	 * The actual sequence for method calls for applets is init(), start(),
	 * paint() but you don't need to worry about start. In this method, you
	 * should call the draw methods for each respective shape I have created one
	 * shape for you. (a line)
	 * 
	 * @param page
	 */
	public void paint(Graphics page) {
		for (int i = 0; i < MAX_SHAPE; ++i) {
			shapes[i].draw(page);
		}
	}
}
