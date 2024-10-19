package oop24.Lab2.problem1.partc;

public class Car extends Vehicle {
    private String licensePlate;

    public Car(String brand, String model, String licensePlate) {
        super(brand, model);
        this.licensePlate = licensePlate;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    @Override
    public String toString() {
        return "Car [brand=" + getBrand() + ", model=" + getModel() + ", licensePlate=" + licensePlate + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Car other = (Car) obj;
        return (licensePlate != null ? licensePlate.equals(other.licensePlate) : other.licensePlate == null);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (licensePlate != null ? licensePlate.hashCode() : 0);
        return result;
    }
}
