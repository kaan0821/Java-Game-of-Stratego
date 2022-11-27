package stratego.pieces;

import stratego.Player;
import stratego.Square;
import java.util.ArrayList;
import java.util.List;

/** This class is for Bomb piece. */
public class Flag extends ImmobilePiece {

    /**
     * Constructor for Flag.
     * @param owner Owner of the flag
     * @param square The square the flag is on
     */
    public Flag(Player owner, Square square) {
        super(owner, square, -2);
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
 * This method is to get all the legal attacks.
 * @return List of square it can attack
 */
    public  List<Square> getLegalAttacks() {

        List<Square> legalAttacks = new ArrayList<Square>();
        return legalAttacks;

    }
/**
 * This method is for flags when captured.
 * The flag will be captured and player lose the game
 */
    @Override
    public void beCaptured() {

        super.beCaptured();
        this.getOwner().loseGame();
    }
}
