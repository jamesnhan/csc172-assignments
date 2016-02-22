/**
 * Board
 *
 * @author      James Nhan
 * @version     1.0
 */

/**
 * This class contains the definition of a board for Connect4
 * using a two-dimensional array
 * 
 * @author 		James Nhan
 * @since		1.0
 * @see 		Connect4
 * @see 		Piece
 */
public class Board {
    /**
     * The maximum width of the board
     */
    public static final int WIDTH = 8;

    /**
     * The maximum height of the board
     */
    public static final int HEIGHT = 8;

    /**
     * The number of contiguous pieces to constitute victory
     */
    private static final int PIECES_FOR_VICTORY = 4;

    /**
     * The array that keeps track of the board's positions
     * as rows of columns
     */
    private Piece[][] pieces;

    /**
     * An array that keeps track of each column's last row
     * that was filled
     */
    private int[] lastMove;

    /**
     * An integer to mark the last column moved into
     */
    private int lastColumn;

    /**
     * Default constructor that creates an board of size WIDTHxHEIGHT
     *
     * @since       1.0
     * @see         Piece
     */
    public Board() {
        pieces = new Piece[HEIGHT][WIDTH];
        lastMove = new int[WIDTH];
        lastColumn = 0;
        
        // Fill the board with Pieces owned by NOPLAYER
        for (int i = 0; i < HEIGHT; ++i) {
            lastMove[i] = -1;
            for (int j = 0; j < WIDTH; ++j) {
                pieces[i][j] = new Piece();
            }
        }
    }

    /**
     * Checks slots for contiguous owners diagonally
     *
     * @param       x - The column to check outwards from
     * @param       y - The row to check outwards from
     * @return      Whether or not enough contiguous pieces make a win
     * @since       1.0
     * @see         Connect4
     * @see         Piece
     */
    private boolean checkContiguousDiagonal(int x, int y) {
    	// The number of contiguous Pieces moving up and to the right
        int contiguousPiecesUR = 0;
        // The number of contiguous Pieces moving down and to the right
        int contiguousPiecesDR = 0;
        // The player that made the last move
        int lastPlayer = pieces[y][x].getOwner();
        
        // TODO: Make this more efficient
        // E.G. [1 - 4, 4) --> [-3, 4) for the range,
        // which yields |-3|-2|-1|X|1|2|3| where X is (x, y)
    	for (int i = 1 - PIECES_FOR_VICTORY; i < PIECES_FOR_VICTORY; ++i) {
    		// Move left to right
    		int mx = x + i;
    		// Move bottom to top
    		int my1 = y + i;
    		// Move top to bottom
    		int my2 = y - i;
    		// Only check if the mx is on the board [0, WIDTH)
            if (mx >= 0 && mx < WIDTH) {
            	// Only check vertical if the my1 is on the board [0, HEIGHT)
            	if (my1 >= 0 && my1 < HEIGHT) {
	                if (pieces[my1][mx].getOwner() == lastPlayer) {
	                    ++contiguousPiecesUR;
	                } else if (contiguousPiecesUR < PIECES_FOR_VICTORY) {
	                	// Piece by NOPLAYER or other player resets contiguous
	                    contiguousPiecesUR = 0;
	                }
            	}
            	// Only check vertical if the my1 is on the board [0, HEIGHT)
            	if (my2 >= 0 && my2 < HEIGHT) {
	                if (pieces[my2][mx].getOwner() == lastPlayer) {
	                    ++contiguousPiecesDR;
	                } else if (contiguousPiecesDR < PIECES_FOR_VICTORY) {
	                	// Piece by NOPLAYER or other player resets contiguous
	                    contiguousPiecesDR = 0;
	                }
            	}
            }
    	}
    	
        return contiguousPiecesUR >= PIECES_FOR_VICTORY
        		|| contiguousPiecesDR >= PIECES_FOR_VICTORY;
    }

    /**
     * Checks slots for contiguous owners vertically
     *
     * @param       x - The column of the piece
     * @param       y - The row to check outwards from
     * @return      Whether or not enough contiguous pieces make a win
     * @since       1.0
     * @see         Connect4
     * @see         Piece
     */
    private boolean checkContiguousVertical(int x, int y) {
    	// Bottom Y
        int by = y;
        // Top Y
        int ty = y;

        // Minimum bottom Y clamped to 0
        by -= (PIECES_FOR_VICTORY - 1);
        if (by < 0) {
            by = 0;
        }

        // Maximum bottom Y clamped to HEIGHT - 1
        ty += (PIECES_FOR_VICTORY - 1);
        if (ty > HEIGHT - 1) {
            ty = HEIGHT - 1;
        }

        // The player that made the last move
        int lastPlayer = pieces[y][x].getOwner();
        // The number of contiguous Pieces
        int contiguousPieces = 0;
        
        // Bottom to Top where ty - by + 1 is at most
        // PIECES_FOR_VICTORY * 2 - 1
        for (int i = 0; i < ty - by + 1; ++i) {
        	// Move bottom to top
            int my = by + i;
        	// Only check vertical if the my is on the board [0, HEIGHT)
            if (my >= 0 && my < HEIGHT) {
                if (pieces[my][x].getOwner() == lastPlayer) {
                    ++contiguousPieces;
                } else if (contiguousPieces < PIECES_FOR_VICTORY) {
                	// Piece by NOPLAYER or other player resets contiguous
                    contiguousPieces = 0;
                }
            }
        }
        
        return contiguousPieces >= PIECES_FOR_VICTORY;
    }



    /**
     * Checks slots for contiguous owners horizontally
     *
     * @param       x - The column to check outwards from
     * @param       y - The row of the piece
     * @return      Whether or not enough contiguous pieces make a win
     * @since       1.0
     * @see         Connect4
     * @see         Piece
     */
    private boolean checkContiguousHorizontal(int x, int y) {
    	// Left X
        int lx = x;
        // Right X
        int rx = x;

        // Minimum bottom X clamped to 0
        lx -= (PIECES_FOR_VICTORY - 1);
        if (lx < 0) {
            lx = 0;
        }

        // Maximum bottom X clamped to WIDTH - 1
        rx += (PIECES_FOR_VICTORY - 1);
        if (rx > WIDTH - 1) {
            rx = WIDTH - 1;
        }

        // The player that made the last move
        int lastPlayer = pieces[y][x].getOwner();
        // The number of contiguous Pieces
        int contiguousPieces = 0;
        
        for (int i = 0; i < rx - lx + 1; ++i) {
        	// Move left to right
            int mx = lx + i;
        	// Only check horizontal if the mx is on the board [0, WIDTH)
            if (mx >= 0 && mx < WIDTH) {
                if (pieces[y][mx].getOwner() == lastPlayer) {
                    ++contiguousPieces;
                } else if (contiguousPieces < PIECES_FOR_VICTORY) {
                	// Piece by NOPLAYER or other player resets contiguous
                    contiguousPieces = 0;
                }
            }
        }
        return contiguousPieces >= PIECES_FOR_VICTORY;
    }

    /**
     * Checks to see if there is a winner on the board
     *
     * @return      The player number of the winner
     * @since       1.0
     * @see         Connect4
     * @see         Piece
     */
    public int checkWin() {
        int result = Connect4.NOPLAYER;

        // Get the coordinates of the last piece
        int x = lastColumn;
        int y = lastMove[lastColumn];

        // Check for PIECES_FOR_VICTORY in a row
        if (checkContiguousHorizontal(x, y) || checkContiguousVertical(x, y)
        		|| checkContiguousDiagonal(x, y)) {
        	// The last player to move is the winner
            result = pieces[y][x].getOwner();
        }

        return result;
    }

    /**
     * Places a piece in the column
     *
     * @return      Whether or not the move was legal
     * @since       1.0
     * @see         Piece
     */
    public boolean makeMove(int column, int player) {
    	// Check for a valid move
        if (lastMove[column] > HEIGHT - 1) {
            return false;
        }

        // Change the owner of the first free row in the selected column
        // to the player making a move
        pieces[++lastMove[column]][column].setOwner(player);
        // Update the last column
        lastColumn = column;

        return true;
    }

    /**
     * Override of Object's toString method to display the
     * state of the Connect4 Board
     *
     * @return      The state of the board in String format
     * @since       1.0
     * @see         Object
     * @see         Piece
     */
    public String toString() {
        String value = "|";
        String temp = "-";

        for (int i = 0; i < WIDTH; ++i) {
            value += i + "|";
            temp += "--";
        }
        value += "\n" + temp + "\n";

        /*
         * |1|2|3|4|5|6|7| Represent the board
         * |8|9|.........| in this order
         */
        for (int i = HEIGHT - 1; i >= 0; --i) {
            value += "|";
            for (int j = 0; j < WIDTH; ++j) {
                value += pieces[i][j] + "|";
            }
            value += "\n";
        }
        value += temp;

        return value;
    }
}
