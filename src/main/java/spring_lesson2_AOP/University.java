package spring_lesson2_AOP;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class University {
    private List<Student> students = new ArrayList<>();

    public void addStudents(){
        Student st1 = new Student("Vlad Danilov", 5, 7.4);
        Student st2 = new Student("Zaur Tregulov", 7, 7.5);
        Student st3 = new Student("Michael Bergs", 2, 8.3);
        students.add(st1);
        students.add(st2);
        students.add(st3);
    }

    public List<Student> getStudents(){
        System.out.println("Information from method getStudents: ");
        System.out.println(students);
        return students;
    }
}
