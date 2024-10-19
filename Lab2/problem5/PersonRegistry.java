package oop24.Lab2.problem5;

import java.util.ArrayList;
import java.util.List;

public class PersonRegistry {
    private List<Person> people;

    public PersonRegistry() {
        people = new ArrayList<>();
    }

    public void addPerson(Person person) {
        if (!people.contains(person)) {
            people.add(person);
            System.out.println("добавлен человек: " + person.getName());
        } else {
            System.out.println("человек уже есть в реестре");
        }
    }

    public void removePerson(Person person) {
        if (people.remove(person)) {
            System.out.println("удален человек: " + person.getName());
        } else {
            System.out.println("человек не найден в реестре");
        }
    }

    public List<Person> findPeopleWithPets() {
        List<Person> result = new ArrayList<>();
        for (Person person : people) {
            if (person.hasPet()) {
                result.add(person);
            }
        }
        return result;
    }

    public List<Person> findPeopleWithoutPets() {
        List<Person> result = new ArrayList<>();
        for (Person person : people) {
            if (!person.hasPet()) {
                result.add(person);
            }
        }
        return result;
    }

    @Override
    public String toString() {
        String result = "Реестр людей и их питомцев:\n";
        for (Person person : people) {
            result += person.toString() + "\n";
            if (person.hasPet()) {
                result += "   Питомец: " + person.getPet().toString() + ", Звук: " + person.getPet().getSound() + "\n";
            }
        }
        return result;
    }

}
