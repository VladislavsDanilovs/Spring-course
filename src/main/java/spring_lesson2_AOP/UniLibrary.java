package spring_lesson2_AOP;

import org.springframework.stereotype.Component;

@Component
public class UniLibrary extends AbstractLibrary {

    public void getBook(){
        System.out.println("Take book from UniLibrary ");
    }

    public void returnBook(){
        System.out.println("returning book into UniLibrary");
    }

    public void getMagazine(){
        System.out.println("Take magazine from UniLibrary");
    }

    public void returnMagazine(){
        System.out.println("Returning magazine to UniLibrary");
    }

    public void addBook(){
        System.out.println("Add book to UniLibrary ");
    }

    public void addMagazine(){
        System.out.println("Add magazine to UniLibrary ");
    }


}
