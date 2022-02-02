package spring_lesson2_AOP.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class MyPointcuts {
    @Pointcut("execution(* addd*(..))")
    public void allAddMethods(){}
}
