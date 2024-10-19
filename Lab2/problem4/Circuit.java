package oop24.Lab2.problem4;

public abstract class Circuit {
    public abstract double getResistance();
    public abstract double getPotentialDiff();
    public abstract void applyPotentialDiff(double V);

    public double getPower() {
        return getPotentialDiff() * getCurrent(); // P = V * I
    }

    public double getCurrent() {
        return getPotentialDiff() / getResistance(); // I = V / R
    }
}