package spring_lesson1;

public class Person {
    private Pet pet;
    private String surname;
    private int Age;

    public void setSurname(String surname) {
        System.out.println("Class Person: set surname");
        this.surname = surname;
    }

    public void setAge(int age) {
        System.out.println("Class Person: set age");
        Age = age;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return Age;
    }

    //conversion process from xml file name= pet to setPet
    // pet -> setPet
    // Pet
    // setPet
    public void setPet(Pet pet) {
        System.out.println("Class Person: set pet");
        this.pet = pet;
    }

    public Person() {
        System.out.println("Person bean is created");
    }
    //    public Person(Pet pet) {
//        System.out.println("Person bean is created");
//        this.pet = pet;
//    }

    public void callYourPet(){
        System.out.println("Hello pet");
        pet.say();
    }
}
