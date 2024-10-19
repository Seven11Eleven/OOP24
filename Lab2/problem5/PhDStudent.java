package oop24.Lab2.problem5;

public class PhDStudent extends Student {
    private String researchArea;

    public PhDStudent(String name, int age, String major, String researchArea) {
        super(name, age, major);
        this.researchArea = researchArea;
    }

    @Override
    public void assignPet(Animal pet) {
        if (pet instanceof Dog) {
            System.out.println("phdstudent не может иметь собаку.");
        } else {
            super.assignPet(pet);
        }
    }
    @Override
    public String getOccupation() {
        return "phdstudent (Область исследований: " + researchArea + ")";
    }
}
