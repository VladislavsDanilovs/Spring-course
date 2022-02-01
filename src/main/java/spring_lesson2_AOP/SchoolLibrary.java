package spring_lesson2_AOP;

import org.springframework.stereotype.Component;

@Component
public class SchoolLibrary extends AbstractLibrary{

//    @Override
    public void getBook() {
        System.out.println("Take book from SchoolLibrary");
    }
}
