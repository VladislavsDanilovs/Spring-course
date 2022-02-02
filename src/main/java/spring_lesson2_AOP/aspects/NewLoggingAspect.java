package spring_lesson2_AOP.aspects;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class NewLoggingAspect {

    @Around("execution(public String returnBook())")
    public Object aroundReturnBookLoggingAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("aroundReturnBookLoggingAdvice: trying to return book to the Library");
//        long begin = System.currentTimeMillis();
        Object targetMethodResult = null;
        try {
            targetMethodResult = proceedingJoinPoint.proceed();
        } catch (Exception e) {
            System.out.println("aroundReturnBookLoggingAdvice: Logging exception " + e);
//            targetMethodResult = "Unknown book name"; //But better to not handle exception in advice @Around
            throw e;
        }
//        targetMethodResult = "Code"; //we can change books name
//        long end = System.currentTimeMillis();
        System.out.println("aroundReturnBookLoggingAdvice: returning book to the library");
        System.out.println("aroundReturnBookLoggingAdvice: Method returnBook completed job in " +/*(end-begin) */ "milliseconds");
        return targetMethodResult;
    }
}
