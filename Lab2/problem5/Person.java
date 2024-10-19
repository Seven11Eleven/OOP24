package oop24.Lab2.problem5;

import java.util.ArrayList;
import java.util.List;

public abstract class Person {
    private String name;
    private int age;
    private Animal pet;
    private List<Animal> petsUnderCare;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.pet = null;
        this.petsUnderCare = new ArrayList<>();
    }

    public void assignPet(Animal pet) {
        if (hasPet()) {
            System.out.println(name + " уже имеет собственного питомца.");
            return;
        }
        if (this instanceof PhDStudent && pet instanceof Dog) {
            System.out.println("Phd student не может иметь собаку.");
            return;
        }
        this.pet = pet;
        pet.setOwner(this);
    }

    public void addPetUnderCare(Animal pet) {
        petsUnderCare.add(pet);
    }

    public void removePetUnderCare(Animal pet) {
        petsUnderCare.remove(pet);
    }

    public boolean isCaringForPet(Animal pet) {
        return petsUnderCare.contains(pet);
    }

    public List<Animal> getPetsUnderCare() {
        return petsUnderCare;
    }



    public void removePet() {
        if (pet != null) {
            pet.setOwner(null);
            this.pet = null;
        } else {
            System.out.println(name + " не имеет питомца для удаления.");
        }
    }

    public boolean hasPet() {
        return pet != null;
    }

    public abstract String getOccupation();

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Animal getPet() {
        return pet;
    }
    @Override
    public String toString() {
        String petInfo = hasPet() ? "Питомец: " + pet.getName() + " (" + pet.getClass().getSimpleName() + ")" : "Нет питомца";
        String petsUnderCareInfo = "";
        if (!petsUnderCare.isEmpty()) {
            petsUnderCareInfo = ", Присматривает за питомцами: ";
            for (Animal pet : petsUnderCare) {
                petsUnderCareInfo += pet.getName() + " (" + pet.getClass().getSimpleName() + "), ";
            }
            petsUnderCareInfo = petsUnderCareInfo.substring(0, petsUnderCareInfo.length() - 2);
        }
        return getOccupation() + " [Имя: " + name + ", Возраст: " + age + ", " + petInfo + petsUnderCareInfo + "]";
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Person other = (Person) obj;
        return age == other.age &&
                name.equals(other.name) &&
                ((pet == null && other.pet == null) || (pet != null && pet.equals(other.pet)));
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + age;
        result = 31 * result + (pet != null ? pet.hashCode() : 0);
        return result;
    }

    public void leavePetWith(Person caretaker) {
        if (!hasPet()) {
            System.out.println(name + " не имеет питомца, чтобы оставить.");
            return;
        }
        if (caretaker instanceof PhDStudent && pet instanceof Dog) {
            System.out.println("Phd студенту нельзя собак.");
            return;
        }
        if (caretaker.isCaringForPet(this.pet)) {
            System.out.println(caretaker.getName() + " уже присматривает за этим питомцем.");
            return;
        }
        caretaker.addPetUnderCare(this.pet);
        System.out.println(name + " оставил питомца " + caretaker.getName());
        this.pet = null;
    }

    public void retrievePetFrom(Person caretaker) {
        if (this.hasPet()) {
            System.out.println(name + " уже имеет питомца.");
            return;
        }
        Animal petToRetrieve = null;
        for (Animal pet : caretaker.getPetsUnderCare()) {
            if (pet.getOwner() == this) {
                petToRetrieve = pet;
                break;
            }
        }
        if (petToRetrieve == null) {
            System.out.println(caretaker.getName() + " не имеет вашего питомца.");
            return;
        }
        caretaker.removePetUnderCare(petToRetrieve);
        this.pet = petToRetrieve;
        System.out.println(name + " забрал своего питомца у " + caretaker.getName());
    }

}
