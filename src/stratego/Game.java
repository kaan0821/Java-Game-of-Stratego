package stratego;
import java.util.stream.IntStream;
/** This class is for the entire game everything is happening in. */
public class Game {
/** The height of the chess set. */
    public static final int HEIGHT = 10;
/** The width of the chess set. */
    public static final int WIDTH = 10;
/** The water rows. */
    public static final int[] WATER_ROWS = {4, 5 };
/** The water columns. */
    public static final int[] WATER_COLS = {2, 3, 6, 7 };

    private Square[][] gameSet = new Square[10][10];

    private Player p0, p1;
/**
 * Constructor for Game.
 * Fill the chess set when game is constructed.
 * @param p0 first player
 * @param p1 second player
 */
    public Game(Player p0, Player p1) {
        this.p0 = p0;
        this.p1 = p1;

        for (int i = 0; i < WIDTH; i++) {
            for  (int j = 0; j < HEIGHT; j++) {
                int waterRow = i;
                int waterCol = j;
                if (IntStream.of(WATER_ROWS).anyMatch(a -> a == waterRow)
                    && IntStream.of(WATER_COLS).anyMatch(a -> a == waterCol)) {
                    this.gameSet[i][j] = new Square(this, i, j, true);
                } else {
                    this.gameSet[i][j] = new Square(this, i, j, false);
                }

            }
        }
    }
/**
 * This method is to get one of players in the game.
 * @param playerNumber the player's number
 * @return the player the number is associated with
 * @throws IllegalArgumentException if this player number doesn't exist
 */
    public Player getPlayer(int playerNumber) throws IllegalArgumentException {

        if (playerNumber == this.p0.getPlayerNumber()) {
            return p0;
        } else if (playerNumber == this.p1.getPlayerNumber()) {
            return p1;
        } else {
            throw new IllegalArgumentException("This PlayerNumber doesn't match anyone.");
        }

    }
/**
 * This method is to get the winner of this game.
 * @return the player that won the game
 */
    public Player getWinner() {

        if (this.p0.hasLost()) {
            return p1;
        } else if (this.p1.hasLost()) {
            return p0;
        } else {
            return null;
        }
    }
/**
 * This method is to get a square from the game.
 * @param row row of the square
 * @param col column of the square
 * @return the Square on the row and the column
 * @throws IndexOutOfBoundsException if the square doesn't exist on the board
 */
    public Square getSquare(int row, int col) throws IndexOutOfBoundsException {

        boolean checkBound = row > 10 || row < 0 || col > 10 || col < 0;
        if (checkBound) {
            throw new IndexOutOfBoundsException("This square does not exist on the board");
        }

        return this.gameSet[row][col];

    }

}
