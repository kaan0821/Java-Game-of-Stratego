package stratego.pieces;

import stratego.CombatResult;
import stratego.Player;
import stratego.Square;
/** This class is for spy pieces. */
public class Spy extends StepMover {
/**
 * Constructor for Spy.
 * @param owner Owner of the Spy
 * @param square The square the Spy is on
 */
    public Spy(Player owner, Square square) {
        super(owner, square, -1);
    }
/**
 * This method is to decide the result of an attack for Spy.
 * @param targetPiece the piece Spy is attacking
 * @return the result of the attack
 */
    @Override
    public CombatResult resultWhenAttacking(Piece targetPiece) {
        //Win over marshal
        if (targetPiece.getRank() == 10) {
            return CombatResult.WIN;
        //Die to bomb, both destryo
        } else if (targetPiece.getRank() == 0) {
            return CombatResult.DRAW;
        }
        else if (targetPiece.getRank() < this.getRank()) {
            return CombatResult.WIN;
        }
        else if (targetPiece.getRank() > this.getRank()) {
            return CombatResult.LOSE;
        }
        else {
            return CombatResult.DRAW;
        }

    }

}
