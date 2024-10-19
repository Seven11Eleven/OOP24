package oop24.Lab2.problem2;

public class Pawn extends Piece{
    public Pawn(Position a, Colour colour){
        super(a, colour);
    }

    @Override
    public boolean isLegalMove(Position b, Board board) {

        if (!b.canMove()){
            return false;
        }
        char x1 = a.getX();int y1 = a.getY();
        char x2 = b.getX();
        int y2 = b.getY();
        int dx = x2 - x1;
        int dy = y2 - y1;

        if( colour == Colour.WHITE){
            if (dx == 0){
                if(y1 == 2){
                    return dy == 1 || dy == 2;
                }else{
                    return dy == 1;
                }
            }else if (Math.abs(dx) == 1){
                return dy == 1;
            }
        }else {
            if (dx == 0){
                if (y1 == 7){
                    return dy == -1 || dy == -2;
                }else{
                    return dy == -1;
                }
            }else if (Math.abs(dx) == 1){
                return dy == -1;
            }
        }
        return false;
    }

    @Override
    public String getName() {
        return (colour == Colour.WHITE ? "Белая" : "Черная") + " пешка";    }


}