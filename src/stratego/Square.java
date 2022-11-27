package stratego;
import stratego.pieces.Piece;
/** This class is for the Squares in the game. */
public class Square {

    private Game game;
    private int row, col;
    private boolean isWater;
    private Piece piece;
/**
 * Constructor for Square.
 * @param game the game the square is in
 * @param row The row of the square
 * @param col The column of the square
 * @param isWater if the square is water
 */
    public Square(Game game, int row, int col, boolean isWater) {
        this.game = game;
        this.row = row;
        this.col = col;
        this.isWater = isWater;
    }
/**
 * This method is to place a piece onto the square.
 * @param piece the piece being placed on the square
 * @throws IllegalArgumentException if a square is occupied or is water
 */
    public void placePiece(Piece piece) throws IllegalArgumentException {

        if (!this.canBeEntered()) {
            throw new IllegalArgumentException("This square is occupied or is waater");
        }

        this.piece = piece;
    }
/**
 * This method is to remove a piece on the square.
 */
    public void removePiece() {
        this.piece = null;
    }
/**
 * This method is to get the game the square is in.
 * @return the game the square is in
 */
    public Game getGame() {
        return this.game;
    }
/**
 * This method is to get the piece on the square.
 * @return the piece on the square
 */
    public Piece getPiece() {
        return this.piece;
    }
/**
 * This method is to get the row of the square.
 * @return the row of the square
 */
    public int getRow() {
        return this.row;
    }
/**
 * This method is to get the column of the square.
 * @return the column of the square
 */
    public int getCol() {
        return this.col;
    }
/**
 * This method is to check if a square can be entered.
 * @return whether the square can be entered
 */
    public boolean canBeEntered() {

        boolean isOccupied;

        if (this.piece != null) {
            isOccupied = true;
        } else {
            isOccupied = false;
        }

        boolean canNotEnter = this.isWater || isOccupied;

        return !canNotEnter;

    }
/**
 * This method is to check if the piece on the square is an enemy.
 * @param targetSquare the square being attacked
 * @return whether the piece on the square is an enemy
 */
    public boolean isEnemy(Square targetSquare) {
    //If it's not a water block, and is the opponent's piece
        boolean checkEnemy = (!targetSquare.isWater) && (targetSquare.getPiece().getOwner() != this.getPiece().getOwner());
        return checkEnemy;
    }

}
