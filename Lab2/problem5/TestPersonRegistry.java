package oop24.Lab2.problem5;

public class TestPersonRegistry{public static void main(String[] args) {
    Person shoqan = new Employee("shoqan", 30, "Frontend Developer");
    Person tamirlan = new PhDStudent("tamirlan", 26, "Comp. Science", "AI");
    Person temik = new Student("temik", 20, "AiU");

    Animal murka = new Cat("Murka", 5);
    Animal nemo = new Fish("Nemo", 1);
    Animal tweety = new Bird("Tweety", 2);

    shoqan.assignPet(murka);

    tamirlan.assignPet(nemo);

    temik.assignPet(tweety);

    PersonRegistry registry = new PersonRegistry();
    registry.addPerson(shoqan);
    registry.addPerson(tamirlan);
    registry.addPerson(temik);

    System.out.println(registry);

    shoqan.leavePetWith(tamirlan);

    System.out.println("шокан оставил питомца тамиру:");
    System.out.println(registry);

    shoqan.retrievePetFrom(tamirlan);

    System.out.println("шокан забрал питомца у тамира:");
    System.out.println(registry);

    temik.leavePetWith(shoqan);

    System.out.println("Итоговая информация о реестре:");
    System.out.println(registry);
}}