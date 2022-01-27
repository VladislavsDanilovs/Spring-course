package spring_lesson1;

public class Dog implements Pet {
    public Dog() {
        System.out.println("Dog bean is created");
    }

    public void bark(){
        System.out.println("*barks*");
    }

    @Override
    public void say() {
        System.out.println("woooof");
    }
}
