package stratego.pieces;

import stratego.CombatResult;
import stratego.Player;
import stratego.Square;
/** This class is for Miners. */
public class Miner extends StepMover {
    /**
     * Constructor for Miner.
     * @param owner The owner of the Miner
     * @param square the square the Miner's on
     */
    public Miner(Player owner, Square square) {
        super(owner, square, 3);
    }
    /**
     * This method is to decide who wins in an attack.
     * @param targetPiece
     * @return the result of the fight
     */
    @Override
    public CombatResult resultWhenAttacking(Piece targetPiece) {
        //If it's a bomb, win
        if (targetPiece.getRank() == 0) {
            return CombatResult.WIN;
        }//Win if lower rank opponent
        else if (targetPiece.getRank() < this.getRank()) {
            return CombatResult.WIN;
        }//Lose is higher rank opponent
        else if (targetPiece.getRank() > this.getRank()) {
            return CombatResult.LOSE;
        }//Both die if draw
        else {
            return CombatResult.DRAW;
        }

    }

}
