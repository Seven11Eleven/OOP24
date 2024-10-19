package oop24.Lab2.problem2;

public class Rook extends Piece{
    private boolean hasMoved = false;

    public Rook(Position a, Colour colour) {
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


        if(!b.canMove()){
            return false;
        }
        if(a.getX() != b.getX() && a.getY() != b.getY()){
            return false;
        }
        return isPathClear(b, board);
    }

    @Override
    public String getName() {
        return (colour == Colour.WHITE ? "Белая" : "Черная") + " ладья";
    }

    private boolean isPathClear(Position b, Board board){
        int fromX = a.getX() - 'a';
        int fromY = a.getY() - 1;
        int toX = b.getX() - 'a';
        int toY = b.getY() - 1;
        int dx = Integer.signum(toX - fromX);
        int dy = Integer.signum(toY - fromY);

        int x = fromX + dx;
        int y = fromY + dy;
        while (x != toX || y != toY){
            if (board.getPieceAt(x,y) != null){
                return false;
            }
            x += dx;
            y += dy;
        }
        Piece destinationPiece = board.getPieceAt(toX, toY);
        if(destinationPiece != null && destinationPiece.colour == this.colour){
            return false;
        }
        return true;
    }
}