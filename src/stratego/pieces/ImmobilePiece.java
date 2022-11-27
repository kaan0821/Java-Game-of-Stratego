package stratego.pieces;

import stratego.Player;
import stratego.Square;
/** This class is for Immobile Pieces like Bombs and Flags. */
public abstract class ImmobilePiece extends Piece {
    /**
     * Constructor for Immobile Pieces.
     * @param owner The owner of the piece
     * @param square The square it's on
     * @param rank The rank of the piece
     */
    public ImmobilePiece(Player owner, Square square, int rank) {
        super(owner, square, rank);
    }

}
