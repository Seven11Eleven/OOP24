package oop24.Lab2.problem2;
public class Bishop extends Piece{
    
    public Bishop(Position a, Colour colour){
        super(a, colour);
    }
    @Override
    public boolean isLegalMove(Position b, Board board) {

        if (!b.canMove()){
            return false;
        }
        int dx = Math.abs(a.getX() - b.getX());
        int dy = Math.abs(a.getY() - b.getY());
        if(dx != dy){
            return false;
        }
        return isPathClear(b, board);
    }

    @Override
    public String getName() {
        return (colour == Colour.WHITE ? "Белый" : "Черный") + " ферз";
    }

    private boolean isPathClear(Position b, Board board) {
        int fromX = a.getX() - 'a';
        int fromY = a.getY() - 1;
        int toX = b.getX() - 'a';
        int toY = b.getY() - 1;
        Piece destinationPiece = board.getPieceAt(toX, toY);
        if (destinationPiece != null && destinationPiece.colour == this.colour) {
            return false;
        }
        int dx = Integer.signum(toX - fromX);
        int dy = Integer.signum(toY - fromY);
        int x = fromX + dx;
        int y = fromY + dy;
        while(x != toX && y != toY){
            if (board.getPieceAt(x, y) != null) {
                return false;
            }
            x += dx;
            y += dy;
        }

        return true;
    }

}