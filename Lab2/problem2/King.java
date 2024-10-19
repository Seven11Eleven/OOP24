package oop24.Lab2.problem2;

public class King extends Piece {
    private boolean hasMoved = false;

    public King(Position a, Colour colour) {
        super(a, colour);
    }


    public boolean isHasMoved() {
        return hasMoved;
    }

    public void setHasMoved(boolean hasMoved) {
        this.hasMoved = hasMoved;
    }

    @Override
    public boolean isLegalMove(Position b, Board board) {

        if (!b.canMove()) {
            return false;
        }
        int dx = Math.abs(a.getX() - b.getX());
        int dy = Math.abs(a.getY() - b.getY());

        if (dx <= 1 && dy <= 1) {
            int toX = b.getX() - 'a';
            int toY = b.getY() - 1;
            Piece destinationPiece = board.getPieceAt(toX, toY);
            if (destinationPiece != null && destinationPiece.colour == this.colour) {
                return false;
            }
            return true;
        }

        if (!hasMoved && dy == 0 && dx == 2) {
            return canCastle(b, board);
        }

        return false;
    }

    @Override
    public String getName() {
        return (colour == Colour.WHITE ? "Белый" : "Черный") + " король";
    }

    private boolean canCastle(Position b, Board board) {
        int fromX = a.getX() - 'a';
        int fromY = a.getY() - 1;
        int toX = b.getX() - 'a';
        int direction = (toX - fromX) > 0 ? 1 : -1;
        int rookX = direction > 0 ? 7 : 0;

        Piece rook = board.getPieceAt(rookX, fromY);
        if (rook instanceof Rook && !((Rook) rook).isHasMoved() && rook.colour == this.colour && !this.isHasMoved()) {
            int x = fromX + direction;
            while (x != rookX) {
                if (board.getPieceAt(x, fromY) != null) {
                    return false;
                }
                x += direction;
            }
            return true;
        }
        return false;
    }
}