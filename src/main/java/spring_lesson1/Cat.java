package spring_lesson1;

import org.springframework.stereotype.Component;

//@Component("catBean")
public class Cat implements Pet{
    public Cat(){
        System.out.println("Cat bean is created");
    }
    @Override
    public void say() {
        System.out.println("Meooooooooooooow");
    }
}
