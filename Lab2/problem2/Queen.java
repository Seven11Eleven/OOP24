package oop24.Lab2.problem2;

public class Queen extends Piece{
    public Queen(Position a, Colour colour){
        super(a, colour);
    }

    @Override
    public boolean isLegalMove(Position b, Board board) {
        if (!b.canMove()){
            return false;
        }
        boolean validMove = false;
        if(a.getX() == b.getX() || a.getY() == b.getY()){
            validMove = isPathClear(b, board, 0);
        }else if (Math.abs(a.getX() - b.getX()) == Math.abs(a.getY() - b.getY())){
            validMove = isPathClear(b, board,1);
        }
        return validMove;
    }

    @Override
    public String getName() {
        return (colour == Colour.WHITE ? "Белая" : "Черная") + " королева";
    }

    private boolean isPathClear(Position b, Board board, int type) {
        int fromX = a.getX() - 'a';
        int fromY = a.getY() - 1;
        int toX = b.getX() - 'a';
        int toY = b.getY() - 1;
        Piece destinationPiece = board.getPieceAt(toX, toY);
        if (destinationPiece != null && destinationPiece.colour == this.colour) {
            return false;
        }
        int dx = 0, dy = 0;

        if( type == 0){
            dx = Integer.signum(toX - fromX);
            dy = Integer.signum(toY - fromY);
            if(dx != 0 && dy != 0){
                return false;
            }
        }else if (type == 1){
            dx = Integer.signum(toX - fromX);
            dy = Integer.signum(toY - fromY);
            if(Math.abs(dx) != Math.abs(dy)){
                return false;
            }
        }
        int x = fromX + dx;
        int y = fromY + dy;
        while(x != toX || y != toY){
            if (board.getPieceAt(x,y) != null){
                return false;
            }
            x += dx;
            y += dy;
        }
        return true;
    }
}