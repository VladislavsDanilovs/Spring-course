package spring_lesson1;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//@Component
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

//    @PostConstruct
//    protected void init(){
//        System.out.println("Class Dog: init method");
//    }
//
//    @PreDestroy
//    private void destroy(){
//        System.out.println("Class Dog: destroy method");
//
//    }
}
