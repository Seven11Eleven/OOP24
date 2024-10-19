package oop24.Lab2.problem4;

public class TestCircuits {
    public static void main(String[] args) {
        Circuit a = new Resistor(2.0);
        Circuit b = new Resistor(2.0);
        Circuit c = new Resistor(2.0);
        Circuit d = new Resistor(2.0);

        Parallel e = new Parallel(a, b);
        Parallel f = new Parallel(e, c);

        Series g = new Series(f, d);
    }
}
