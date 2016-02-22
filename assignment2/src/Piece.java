/**
 * Piece
 *
 * @author      James Nhan
 * @version     1.0
 */

/**
 * This class contains the definition of the Piece object for use in the
 * Connect4 game.
 *
 * @see Connect4
 */
public class Piece {
    private int owner;

    /**
     * The default constructor that sets the owner to Connect4.NOPLAYER
     *
     * @since       1.0
     * @see         Connect4
     */
    public Piece() {
        this.owner = Connect4.NOPLAYER;
    }

    /**
     * The mutator for the owner data member
     *
     * @param       owner - The new owner of the piece
     * @since       1.0
     * @see         Connect4
     */
    public void setOwner(int owner) {
        this.owner = owner;
    }

    /**
     * The accessor for the owner data member
     *
     * @return      The owner of the piece
     * @since       1.0
     * @see         Connect4
     */
    public int getOwner() {
        return this.owner;
    }

    /**
     * Override of Object's toString method to display the
     * symbol of the piece's owner
     *
     * @return      The symbol of the piece's owner
     * @since       1.0
     * @see         Object
     */
    public String toString() {
        if (owner == Connect4.PLAYER1) {
            return "X";
        } else if (owner == Connect4.PLAYER2) {
            return "O";
        } else {
            return " ";
        }
    }
}
