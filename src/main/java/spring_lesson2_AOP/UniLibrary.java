package spring_lesson2_AOP;

import org.springframework.stereotype.Component;

@Component
public class UniLibrary extends AbstractLibrary {

    public void getBook(){
        System.out.println("Take book from UniLibrary ");
        System.out.println("----------------------------------------------");
    }

    public void returnBook(){
        System.out.println("returning book into UniLibrary");
        System.out.println("----------------------------------------------");
    }

    public void getMagazine(){
        System.out.println("Take magazine from UniLibrary");
        System.out.println("----------------------------------------------");
    }

    public void returnMagazine(){
        System.out.println("Returning magazine to UniLibrary");
        System.out.println("----------------------------------------------");
    }

    public void addBook(String person_name, Book book){
        System.out.println("Add book to UniLibrary ");
        System.out.println("----------------------------------------------");
    }

    public void addMagazine(){
        System.out.println("Add magazine to UniLibrary ");
        System.out.println("----------------------------------------------");
    }
}
