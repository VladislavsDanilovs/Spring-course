package spring_lesson1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test2 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml"); // Creating Srping Container

            Pet pet = context.getBean("myPet", Pet.class); //Creating object using Bean (reflection)
            pet.say();

            context.close();
    }
}
