package oop24.Lab2.problem5;

public abstract class Animal {
    private String name;
    private int age;
    private Person owner;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
        this.owner = null;
    }

    public abstract String getSound();
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " [Имя: " + name + ", Возраст: " + age + "]";
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Animal other = (Animal) obj;
        return age == other.age && name.equals(other.name);
    }
    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + age;
        return result;
    }
}
