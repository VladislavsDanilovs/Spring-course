package spring_lesson2_AOP;

import org.springframework.stereotype.Component;

@Component
public class UniLibrary extends AbstractLibrary {

    public void getBook(Book book){
        System.out.println("Take book from UniLibrary " +book.getName());
    }

//    public String returnBook(){
//        System.out.println("returning book into UniLibrary");
//        return "okey";
//    }

    public void getMagazine(){

        System.out.println("Take magazine from UniLibrary");

    }

}
