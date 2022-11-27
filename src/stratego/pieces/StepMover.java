package stratego.pieces;

import stratego.Player;
import stratego.Square;

import java.util.ArrayList;
import java.util.List;
/** This class if for StepMover pieces. */
public class StepMover extends Piece {
/**
 * Constructor for StepMover.
 * @param owner Owner of the StepMover
 * @param square The square the StepMover is on
 * @param rank The rank of the StepMover
 */
    public StepMover(Player owner, Square square, int rank) {
        super(owner, square, rank);
    }

/**
 * This method is to get all the legal moves for StepMover.
 * @return List of square it can move to
 */
    public  List<Square> getLegalMoves() {

        List<Square> legalMoves = new ArrayList<Square>();
        ArrayList<Square> adjacentSquares = this.getAdjacentSquares();
        //Iterate through the adjacents, if can be entered, it's legal move
        for (int i = 0; i < adjacentSquares.size(); i++) {
            if (adjacentSquares.get(i).canBeEntered()) {
                legalMoves.add(adjacentSquares.get(i));
            }
        }

        return legalMoves;

    }
/**
 * This method is to get all the legal attacks for StepMover.
 * @return List of square a StepMover can attack
 */
    public  List<Square> getLegalAttacks() {

        List<Square> legalAttacks = new ArrayList<Square>();
        ArrayList<Square> adjacentSquares = this.getAdjacentSquares();
        //Iterate through the adjacents, if is enemy, can attack
        for (int i = 0; i < adjacentSquares.size(); i++) {
            if (!adjacentSquares.get(i).canBeEntered() && this.getSquare().isEnemy(adjacentSquares.get(i))) {
                legalAttacks.add(adjacentSquares.get(i));
            }
        }

        return legalAttacks;

    }


}
