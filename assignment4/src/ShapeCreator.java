/**
 * Mark Haselhoff
 * mhaselho@nwciowa.edu
 */

import java.awt.*;

/**
 * ShapeCreator
 * This class consists of the definition of a Shape generator
 */
public class ShapeCreator {
	/**
	 * Types of Shapes we can draw
	 * 
	 * <li>{@link #LINE}</li>
	 * <li>{@link #POLYGON}</li>
	 * <li>{@link #RECTANGLE}</li>
	 * <li>{@link #SQUARE}</li>
	 * <li>{@link #OVAL}</li>
	 * <li>{@link #CIRCLE}</li>
	 * 
	 * @author 	James Nhan
	 * @since 	1.0
	 */
	private enum ShapeType {
		/**
		 * A line
		 */
		LINE,
		
		/**
		 * A polygon
		 */
		POLYGON,
		
		/**
		 * A rectangle
		 */
		RECTANGLE,
		
		/**
		 * A square
		 */
		SQUARE,
		
		/**
		 * An oval
		 */
		OVAL,
		
		/**
		 * A circle
		 */
		CIRCLE
	}

	/**
	 * Maximum value of a color component [0, 255]
	 */
	private static final int COLOR_MAX = 255;

	/**
	 * Maximum dimension of any coordinate
	 */
	private static final int DIMENSION_MAX = 900;

	/**
	 * Maximum vertices in a polygon
	 */
	private static final int POLYGON_MAX_VERTICES = 10;

	/**
	 * List of shape types in an array
	 */
	private static final ShapeType[] SHAPE_TYPES = ShapeType.values();

	/**
	 * Generates a random number
	 * 
	 * @param max the bound on the random number. The number will be between 0
	 *            and max
	 * @return a random number
	 */
	public int randomInt(int max) {
		return (int) (Math.random() * max + 1);
	}

	/**
	 * Generates a random color
	 * 
	 * @return a new random Color
	 */
	public Color randomColor() {
		return new Color(randomInt(COLOR_MAX), randomInt(COLOR_MAX),
				randomInt(COLOR_MAX));
	}

	/**
	 * This method should be used to determine which shape to draw and call the
	 * constructor for the appropriate shape with appropriate arguments.
	 * 
	 * @return the Shape that was created
	 */
	public Shape newShape() {
		Shape result = null;
		ShapeType randomShape
				= SHAPE_TYPES[randomInt(SHAPE_TYPES.length) - 1];

		// Use polymorphism to set result to a random type of shape based on the
		// generated random integer
		switch (randomShape) {
		case LINE: {
			int x1 = randomInt(DIMENSION_MAX);
			int y1 = randomInt(DIMENSION_MAX);
			int x2 = randomInt(DIMENSION_MAX);
			int y2 = randomInt(DIMENSION_MAX);
			result = new Line(randomColor(), x1, y1, x2, y2);
			break;
		}
		case POLYGON: {
			int n = randomInt(POLYGON_MAX_VERTICES);
			
			int[] points = new int[n * 2];
			for (int i = 0; i < points.length; ++i) {
				points[i] = randomInt(DIMENSION_MAX);
			}
			
			result = new Polygon(randomColor(), points);
			break;
		}
		case RECTANGLE: {
			int x = randomInt(DIMENSION_MAX);
			int y = randomInt(DIMENSION_MAX);
			int w = randomInt(DIMENSION_MAX);
			int h = randomInt(DIMENSION_MAX);
			result = new Rectangle(randomColor(), x, y, w, h);
			break;
		}
		case SQUARE: {
			int x = randomInt(DIMENSION_MAX);
			int y = randomInt(DIMENSION_MAX);
			int w = randomInt(DIMENSION_MAX);
			result = new Square(randomColor(), x, y, w);
			break;
		}
		case OVAL: {
			int x = randomInt(DIMENSION_MAX);
			int y = randomInt(DIMENSION_MAX);
			int w = randomInt(DIMENSION_MAX);
			int h = randomInt(DIMENSION_MAX);
			result = new Oval(randomColor(), x, y, w, h);
			break;
		}
		case CIRCLE: {
			int x = randomInt(DIMENSION_MAX);
			int y = randomInt(DIMENSION_MAX);
			int r = randomInt(DIMENSION_MAX);
			result = new Circle(randomColor(), x, y, r);
			break;
		}
		}

		return result;
	}
}