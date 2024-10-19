package oop24.Lab2.problem4;

public class Parallel extends Circuit {
    private Circuit a;
    private Circuit b;

    public Parallel(Circuit a, Circuit b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double getResistance() {
        double R1 = a.getResistance();
        double R2 = b.getResistance();
        return 1 / (1 / R1 + 1 / R2);
    }

    @Override
    public double getPotentialDiff() {
        return a.getPotentialDiff();
    }

    @Override
    public void applyPotentialDiff(double V) {
        a.applyPotentialDiff(V);
        b.applyPotentialDiff(V);
    }
}
