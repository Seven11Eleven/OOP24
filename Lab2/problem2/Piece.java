package oop24.Lab2.problem2;

public abstract class Piece {
    Position a;
    Colour colour;

    public Piece(Position a, Colour colour) {
        this.a = a;
        this.colour = colour;
    }

    public abstract boolean isLegalMove(Position b, Board board);

    public Position getPosition() {
        return a;
    }

    public abstract String getName();

    @Override
    public String toString() {
        return getName();
    }
}
