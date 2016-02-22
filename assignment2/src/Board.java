/**
 * Board
 *
 * @author      James Nhan
 * @version     1.0
 */

/**
 * This class contains the definition of a board for Connect4
 * using a two-dimensional array
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
        int tlx;
        int tly;
        int brx;
        int bry;

        return false;
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
        int by = y;
        int ty = y;

        by -= (PIECES_FOR_VICTORY - 1);
        if (by < 0) {
            by = 0;
        }

        ty += (PIECES_FOR_VICTORY - 1);
        if (ty > HEIGHT - 1) {
            ty = HEIGHT - 1;
        }

        int lastPlayer = pieces[y][x].getOwner();
        int contiguousPieces = 0;
        for (int i = 0; i < ty - by + 1; ++i) {
            int my = by + i;
            if (my >= 0 && my < HEIGHT) {
                if (pieces[my][x].getOwner() == lastPlayer) {
                    ++contiguousPieces;
                } else if (contiguousPieces < PIECES_FOR_VICTORY) {
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
        int lx = x;
        int rx = x;

        lx -= (PIECES_FOR_VICTORY - 1);
        if (lx < 0) {
            lx = 0;
        }

        rx += (PIECES_FOR_VICTORY - 1);
        if (rx > WIDTH - 1) {
            rx = WIDTH - 1;
        }

        int lastPlayer = pieces[y][x].getOwner();
        int contiguousPieces = 0;
        for (int i = 0; i < rx - lx + 1; ++i) {
            int mx = lx + i;
            if (mx >= 0 && mx < WIDTH) {
                if (pieces[y][mx].getOwner() == lastPlayer) {
                    ++contiguousPieces;
                } else if (contiguousPieces < PIECES_FOR_VICTORY) {
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

        int x = lastColumn;
        int y = lastMove[lastColumn];
        int lastPlayer = pieces[y][x].getOwner();

        if (checkContiguousHorizontal(x, y)) {
            result = lastPlayer;
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
        if (lastMove[column] > HEIGHT - 1) {
            return false;
        }

        pieces[++lastMove[column]][column].setOwner(player);
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

        for (int i = HEIGHT - 1; i >= 0; --i) {
            value += "|";
            for (int j = 0; j < WIDTH; ++j) {
                value += pieces[i][j] + "|";
            }
            value += "\n";
        }

        return value.trim();
    }
}
