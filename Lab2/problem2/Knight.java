package oop24.Lab2.problem2;

public class Knight extends Piece{
    public Knight(Position a, Colour colour){
        super(a, colour);
    }

    @Override
    public boolean isLegalMove(Position b, Board board) {

        if (!b.canMove()){
            return false;
        }
        int dx = Math.abs(a.getX() - b.getX());
        int dy = Math.abs(a.getY() - b.getY());
        return (dx == 3 && dy == 2) || (dx == 2 && dy == 3);
    }

    @Override
    public String getName() {
        return (colour == Colour.WHITE ? "Белый" : "Черный") + " король";
    }
}