package stratego.pieces;
import java.util.List;
import java.util.ArrayList;


import stratego.Square;
import stratego.Player;
import stratego.CombatResult;
import stratego.Game;
/** This class is for Piece in general. */
public abstract class Piece {

    private Player owner;
    private Square square;
    private int rank;
/**
 * Constructor for Piece.
 * @param owner Owner of the piece
 * @param square The square the piece is on
 * @param rank The rank of the piece
 */
    public Piece(Player owner, Square square, int rank) {
        this.owner = owner;
        this.square = square;
        this.rank = rank;
        this.getSquare().placePiece(this);
    }
/**
 * This method is to get all legal moves a piece can make.
 * @return list of squares a piece can move onto
 */
    public abstract List<Square> getLegalMoves();
/**
 * This method is to get all legal attacks a piece can make.
 * @return list of squares a piece can attack
 */
    public abstract List<Square> getLegalAttacks();
/**
 * This method is to move a piece.
 * Remove the piece originally on the square, then place the new piece on.
 * @param toSquare The square I'm moving onto
 */
    public  void move(Square toSquare) {

        this.square.removePiece();
        toSquare.placePiece(this);
        this.square = toSquare;

    }
/**
 * This method is to attack another piece.
 * Depending on the result of the fight, different things will happen.
 * @param targetSquare the square of the piece I'm attacking
 */
    public  void attack(Square targetSquare) {
        //If no piece on the square, nothing happens
        if (targetSquare.getPiece() == null) {
            return;
        }
        //if win, capture target, move onto its square
        if (this.resultWhenAttacking(targetSquare.getPiece()) == CombatResult.WIN) {
            targetSquare.getPiece().beCaptured();
            this.move(targetSquare);
        //if draw, both be captured
        }
        else if (this.resultWhenAttacking(targetSquare.getPiece()) == CombatResult.DRAW) {
            targetSquare.getPiece().beCaptured();
            this.beCaptured();
        //if lose, capture itself
        }
        else {
            this.beCaptured();
        }

    }
/**
 * This method is to decide the resulf of a fight.
 * @param targetPiece the square of the piece I'm attacking
 * @return the result of the fight
 */
    public  CombatResult resultWhenAttacking(Piece targetPiece) {

        if (targetPiece.getRank() == 0) {
            return CombatResult.DRAW;
        }
        else if (targetPiece.getRank() < this.rank) {
            return CombatResult.WIN;
        }
        else if (targetPiece.getRank() > this.rank) {
            return CombatResult.LOSE;
        }
        else {
            return CombatResult.DRAW;
        }

    }
/**
 * This method is for a piece being captured.
 * Remove the piece on the square and change the square associated to null.
 */
    public  void beCaptured() {
        this.square.removePiece();
        this.square = null;
    }
/**
 * This method is to get the piece's square.
 * @return the square of the piece
 */
    public  Square getSquare() {
        return this.square;
    }
/**
 * This method is to get the owner of the piece.
 * @return the owner of the piece
 */
    public  Player getOwner() {
        return this.owner;
    }
/**
 * This method is to get the rank of the piece.
 * @return the rank of the piece
 */
    public  int getRank() {
        return this.rank;
    }
/**
 * This method is to get all the adjacent squares to the current piece.
 * @return Arraylist of squares that are adjacent
 */
    public ArrayList<Square> getAdjacentSquares() {

        ArrayList<Square> adjacent = new ArrayList<Square>();
        Square forwardSquare;
        Square backwardSquare;
        Square leftSquare;
        Square rightSquare;
        Square currentSquare = this.getSquare();
        Game currentgame = currentSquare.getGame();
        //if not the first row
        if (this.getSquare().getRow() > 0) {
            forwardSquare = currentgame.getSquare(currentSquare.getRow() - 1, currentSquare.getCol());
            adjacent.add(forwardSquare);
        }//if not the last row
        if (this.getSquare().getRow() < 10) {
            backwardSquare = currentgame.getSquare(currentSquare.getRow() + 1, currentSquare.getCol());
            adjacent.add(backwardSquare);
        }//if not the first column
        if (this.getSquare().getCol() > 0) {
            leftSquare = currentgame.getSquare(currentSquare.getRow(), currentSquare.getCol() - 1);
            adjacent.add(leftSquare);
        }//if not the last column
        if (this.getSquare().getCol() < 10) {
            rightSquare = currentgame.getSquare(currentSquare.getRow(), currentSquare.getCol() + 1);
            adjacent.add(rightSquare);
        }

        return adjacent;
    }
}
