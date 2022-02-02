package spring_lesson2_AOP.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import spring_lesson2_AOP.Book;

@Component
@Aspect
@Order(10)
public class LoggingAspect {

//    @Pointcut("execution(* spring_lesson2_AOP.UniLibrary.*())")
//    private void allMethodsFromUniLibrary() {
//    }
//
//    @Pointcut("execution(public void spring_lesson2_AOP.UniLibrary.returnMagazine())")
//    private void returnMagazineFromUniLibrary() {
//    }
//
//    @Pointcut("allMethodsFromUniLibrary() && !returnMagazineFromUniLibrary()")
//    private void allMethodsExceptReturnMagazineFromUniLibrary() {
//    }
//
//    @Before("allMethodsExceptReturnMagazineFromUniLibrary()")
//        public void beforeAllMethodsExceptReturnMagazineAdvice(){
//            System.out.println("beforeAllMethodsExceptReturnMagazineAdvice: Log #10");
//        }

//    @Pointcut("execution(* spring_lesson2_AOP.UniLibrary.get*())")
//    private void allGetMethodsFromUniLibrary() {
//    }
//
//    @Pointcut("execution(* spring_lesson2_AOP.UniLibrary.return*())")
//    private void allReturnMethodsFromUniLibrary() {
//    }
//
//    @Pointcut("allGetMethodsFromUniLibrary() || allReturnMethodsFromUniLibrary()")
//    private void allGetAndReturnMethodsFromUniLibrary(){
//    }
//
//    @Before("allGetMethodsFromUniLibrary()")
//    public void beforeGetLoggingAdvice() {
//        System.out.println("beforeGetLoggingAdvice: writing Log #1");
//    }
//
//    @Before("allReturnMethodsFromUniLibrary()")
//    public void beforeReturnLoggingAdvice() {
//        System.out.println("beforeReturnLoggingAdvice: writing Log #2");
//    }
//
//    @Before("allGetAndReturnMethodsFromUniLibrary()")
//    public void beforeGetAndReturnLoggingAdvice(){
//        System.out.println("beforeGetAndReturnLoggingAdvice: writing Log #3");
//    }


    @Before("spring_lesson2_AOP.aspects.MyPointcuts.allAddMethods()")
    public void beforeAddLoggingAdvice(JoinPoint joinPoint) {

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("methodSignature = " + methodSignature);
        System.out.println("methodSignature.getMethod() = " + methodSignature.getMethod());
        System.out.println(" methodSignature.getReturnType() = " + methodSignature.getReturnType());
        System.out.println(" methodSignature.getName() = " + methodSignature.getName());

        if (methodSignature.getName().equals("addBook")) {
            Object[] arguments = joinPoint.getArgs();
            for (Object obj : arguments) {
                if (obj instanceof Book) {
                    Book myBook = (Book) obj;
                    System.out.println("Information about book: name - " + myBook.getName()
                            + ", author - " + myBook.getAuthor() + ", year of publication - " + myBook.getYearOfPublication());
                } else if (obj instanceof String) {
                    System.out.println(obj + " Added book");
                }
            }
        }
        System.out.println("beforeAddBookAdvice: Logging attempt to get book/magazine");
        System.out.println("-----------------------------------------------");
    }
}
