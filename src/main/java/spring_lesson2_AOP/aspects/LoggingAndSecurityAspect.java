package spring_lesson2_AOP.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAndSecurityAspect {

    @Pointcut("execution(* spring_lesson2_AOP.UniLibrary.*())")
    private void allMethodsFromUniLibrary() {
    }

    @Pointcut("execution(public void spring_lesson2_AOP.UniLibrary.returnMagazine())")
    private void returnMagazineFromUniLibrary() {
    }

    @Pointcut("allMethodsFromUniLibrary() && !returnMagazineFromUniLibrary()")
    private void allMethodsExceptReturnMagazineFromUniLibrary() {
    }

    @Before("allMethodsExceptReturnMagazineFromUniLibrary()")
        public void beforeAllMethodsExceptReturnMagazineAdvice(){
            System.out.println("beforeAllMethodsExceptReturnMagazineAdvice: Log #10");
        }

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


//
//    @Pointcut("execution(* get*())")
//    private void allGetMethods(){}
//
//    @Before("allGetMethods()")
//    public void beforeGetLoggingAdvice(){
//        System.out.println("beforeGetBookAdvice: trying get book/magazine");
//    }
//
//    @Before("allGetMethods()")
//    public void beforeGetSecurityAdvice(){
//        System.out.println("beforeGetSecurityAdvice: access control check");
//    }
}
