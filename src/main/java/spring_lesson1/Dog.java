package spring_lesson1;

public class Dog implements Pet {
//    private String name;

//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getName() {
//        return name;
//    }

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

    protected void init(){
        System.out.println("Class Dog: init method");
    }

    private void destroy(){
        System.out.println("Class Dog: destroy method");
    }
}
