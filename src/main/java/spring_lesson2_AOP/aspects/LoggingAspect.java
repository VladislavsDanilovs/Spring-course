package spring_lesson2_AOP.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    @Before("execution(public void getBook(spring_lesson2_AOP.Book))")
    public void beforeGetBookAdvice(){
        System.out.println("beforeGetBookAdvice: trying get book");
    }

    @Before("execution(public * returnBook())")
    public void beforeReturnBookAdvice(){
        System.out.println("beforeReturnBookAdvice: trying to return book");
    }
}
