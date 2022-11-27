package stratego.pieces;

import stratego.Square;
import stratego.Game;
import stratego.Player;
import java.util.ArrayList;
import java.util.List;
/** This class is for Scout pieces. */
public class Scout extends Piece {
/**
 * Constructor for Bomb.
 * @param owner Owner of the bomb
 * @param square The square the bomb is on
 */
    public Scout(Player owner, Square square) {
        super(owner, square, 2);
    }

/**
 * This method is to get all the legal moves a Scout can go.
 * @return List of squares a Scout can go
 */
    public  List<Square> getLegalMoves() {

        List<Square> legalMoves = new ArrayList<Square>();
        Game currGame = this.getSquare().getGame();
        Square currSquare = this.getSquare();

        //Four seperate lists of legal moves on four directions
        List<Square> forwardList = new ArrayList<Square>();
        List<Square> backwardList = new ArrayList<Square>();
        List<Square> leftList = new ArrayList<Square>();
        List<Square> rightList = new ArrayList<Square>();

        //Keep a cursor for current row
        int rowPointer = currSquare.getRow();
        //Decrease the row to check forward legal moves
        while (rowPointer > 0) {
            //If forward can be entered, keep going forward
            if (currGame.getSquare(rowPointer - 1, currSquare.getCol()).canBeEntered()) {
                forwardList.add(currGame.getSquare(rowPointer - 1, currSquare.getCol()));
                rowPointer--;
            } else { //Once meet a barrier, stop
                break;
            }
        }

        //Refresh cursor
        rowPointer = currSquare.getRow();
        //Increase row to check backward legal moves
        while (rowPointer < (Game.HEIGHT - 1)) {
            if (currGame.getSquare(rowPointer + 1, currSquare.getCol()).canBeEntered()) {
                backwardList.add(currGame.getSquare(rowPointer + 1, currSquare.getCol()));
                rowPointer++;
            } else {
                break;
            }
        }

        //Keep a cursor for current column
        int colPointer = currSquare.getCol();
        //Decrease col to check leftward legal moves
        while (colPointer > 0) {
            if (currGame.getSquare(currSquare.getRow(), colPointer - 1).canBeEntered()) {
                leftList.add(currGame.getSquare(currSquare.getRow(), colPointer - 1));
                colPointer--;
            } else {
                break;
            }
        }

        //Refresh cursor
        colPointer = currSquare.getCol();
        //Increase col to check rightward legal moves
        while (colPointer < (Game.WIDTH) - 1) {
            if (currGame.getSquare(currSquare.getRow(), colPointer + 1).canBeEntered()) {
                rightList.add(currGame.getSquare(currSquare.getRow(), colPointer + 1));
                colPointer++;
            } else {
                break;
            }
        }


        //Add all four direction moves together
        legalMoves.addAll(forwardList);
        legalMoves.addAll(backwardList);
        legalMoves.addAll(leftList);
        legalMoves.addAll(rightList);

        return legalMoves;

    }
/**
 * This method is to get all the legal attacks a Scout can make.
 * If the adjacent isn't water and doesn't belong to me, it's attackable.
 * @return List of squares Scouts can attack
 */
    public  List<Square> getLegalAttacks() {

        List<Square> legalAttacks = new ArrayList<Square>();
        ArrayList<Square> adjacentSquares = this.getAdjacentSquares();

        for (int i = 0; i < adjacentSquares.size(); i++) {
            if (!adjacentSquares.get(i).canBeEntered() && this.getSquare().isEnemy(adjacentSquares.get(i))) {
                legalAttacks.add(adjacentSquares.get(i));
            }
        }

        return legalAttacks;

    }

}
