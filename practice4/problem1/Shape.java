package oop24.practice4.problem1;

public abstract class Shape {
    protected int position;
    protected Color color;

    public Shape(int position, Color color) {
        this.position = position;
        this.color = color;
    }

    public abstract void draw();

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public enum Color {
        RED, GREEN, BLUE
    }
}