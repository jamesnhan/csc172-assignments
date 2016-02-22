/**
 * Connect4
 *
 * @author      James Nhan
 * @version     1.0
 */

import java.util.Scanner;

/**
 * This class contains the definition of a game of Connect4
 *
 * @author 		James Nhan
 * @since		1.0
 * @see 		Board
 */
public class Connect4 {
    /**
     * No player
     */
    public final static int NOPLAYER=0;

    /**
     * The first player
     */
    public final static int PLAYER1=1;
    
    /**
     * The second player
     */
    public final static int PLAYER2=2;

    /**
     * A static method to initiate a game of Connect4 taking input from the Scanner passed
     *
     * @param       input - A Scanner to read input from
     * @since       1.0
     * @see         Board
     */
    public static void playGame(Scanner input) {
        int player = PLAYER2;
        int winner = NOPLAYER;
        int moves = 0;

        Board board = new Board();
        System.out.println(board);

        while (winner == NOPLAYER) {
            player = (player == PLAYER1) ? PLAYER2 : PLAYER1;
            ++moves;

            int value = -1;
            do {
                System.out.print("(Player " + player + ") Enter a column to move to: ");
                // Wait for a valid input value, ignoring non-numeric values
                while (!input.hasNextInt()) {
                    input.nextLine();
                }
                value = input.nextInt();
                // Validate the input
                if (value < 0 || value >= Board.WIDTH) {
                	// If it's not within the valid range, set it to -1
                    System.out.println("Invalid input!");
                    value = -1;
                } else {
                	// Else try to make a move
                    if (!board.makeMove(value, player)) {
                    	// Failure sets value to -1
                    	System.out.println("Column is full!");
                        value = -1;
                    }
                }
                // Continue asking for a column if the value is -1
            } while (value == -1);

            System.out.println(board);

            winner = board.checkWin();
        }

        System.out.println("Congratulations Player " + winner + "!!!");
        System.out.println("You won in " + moves + " moves!!!");
    }
}
