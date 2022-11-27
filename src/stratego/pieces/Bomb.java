package stratego.pieces;

import stratego.Player;
import stratego.Square;
import java.util.ArrayList;
import java.util.List;

/** This class is for Bomb piece. */
public class Bomb extends ImmobilePiece {
/**
 * Constructor for Bomb.
 * @param owner Owner of the bomb
 * @param square The square the bomb is on
 */
    public Bomb(Player owner, Square square) {
        super(owner, square, 0);
    }
/**
 * This method is to get all the legal moves.
 * @return List of square it can move to
 */
    public  List<Square> getLegalMoves() {

        List<Square> legalMoves = new ArrayList<Square>();
        return legalMoves;

    }
/**
 * This method is ro get all the attackable squares.
 * @return List of squares it can attack
 */
    public  List<Square> getLegalAttacks() {

        List<Square> legalAttacks = new ArrayList<Square>();
        return legalAttacks;

    }

}
