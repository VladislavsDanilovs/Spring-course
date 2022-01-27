package spring_lesson1;

public class Person {
    private Pet pet;

    public Person(Pet pet) {
        System.out.println("Person bean is created");
        this.pet = pet;
    }

    public void callYourPet(){
        System.out.println("Hello pet");
        pet.say();
    }
}
