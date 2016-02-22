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
 * @see Board
 * @see Piece
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
        int p1Moves = 0;
        int p2Moves = 0;

        Board board = new Board();
        System.out.println(board);

        while (winner == NOPLAYER) {
            player = (player == PLAYER1) ? PLAYER2 : PLAYER1;
            if (winner == Connect4.PLAYER1) {
                ++p1Moves;
            }else {
                ++p2Moves;
            }

            int value = -1;
            do {
                System.out.print("(Player " + player + ") Enter a column to move to: ");
                while (!input.hasNextInt()) {
                    input.nextLine();
                }
                value = input.nextInt();
                if (value < 0 || value >= Board.WIDTH) {
                    System.out.println("Invalid input!");
                    value = -1;
                } else {
                    if (!board.makeMove(value, player)) {
                        value = -1;
                    }
                }
            } while (value == -1);

            System.out.println(board);

            winner = board.checkWin();
        }

        System.out.println("Congratulations Player " + winner + "!!!");
        System.out.println("You won in " + ((winner == Connect4.PLAYER1) ? p1Moves : p2Moves) + " moves!!!");
    }
}
