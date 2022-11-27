package stratego;
/** This class if for players in the game. */
public class Player {

    private String name;
    private int playerNumber;
    private boolean lose = false;
/**
 * Constructor for Player.
 * @param name name of the player
 * @param playerNumber player number of the player
 */
    public Player(String name, int playerNumber) {
        this.name = name;
        this.playerNumber = playerNumber;
    }
/**
 * This method is to get the name of the player.
 * @return name of the player
 */
    public String getName() {
        return this.name;
    }
/**
 * This method is to get the number of the player.
 * @return the number of the player
 */
    public int getPlayerNumber() {
        return this.playerNumber;
    }
/**
 * This method is to make the player lose.
 * It changes the player's lose status.
 */
    public void loseGame() {
        lose = true;
    }
/**
 * This method is to check if the player has lost.
 * @return whether the player has lost
 */
    public boolean hasLost() {
        return lose;
    }

}
