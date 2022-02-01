package spring_lesson2_AOP;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test1 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        UniLibrary l1 = context.getBean("uniLibrary", UniLibrary.class);
        Book book = context.getBean("book", Book.class);
        l1.getBook(book);
//        l1.returnBook();
//        l1.getMagazine();


//        SchoolLibrary schoolLibrary = context.getBean("schoolLibrary", SchoolLibrary.class);
//        schoolLibrary.getBook();

        context.close();
    }
}
