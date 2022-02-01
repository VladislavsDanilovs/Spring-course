package spring_lesson2_AOP;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Book {
    @Value("Code")
    private String name;

    public String getName() {
        return name;
    }
}
