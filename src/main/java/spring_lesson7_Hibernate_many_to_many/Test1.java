package spring_lesson7_Hibernate_many_to_many;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import spring_lesson7_Hibernate_many_to_many.entity.Child;
import spring_lesson7_Hibernate_many_to_many.entity.Section;


public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();

        Session session = null;

        try {
//            session = factory.getCurrentSession();
//
//            Section section1 = new Section("Hip-hop");
//            Section section2 = new Section("Chess");
//            Section section3 = new Section("Dance");
//
//            Child child1 = new Child("Margaret", 5);
//            Child child2 = new Child("Tom", 8);
//            Child child3 = new Child("Tyler", 6);
//
//            section1.addChildrenToSection(child1);
//            section1.addChildrenToSection(child2);
//            section1.addChildrenToSection(child3);
//
//            session.beginTransaction();
//
//            //If we use persist instead of save, we can save section using cascade and save children,
//            // and if we will delete this section, children will stay in data base, and not be deleted by cascade
//            session.persist(section1);
//
//
//            session.getTransaction().commit();
//            System.out.println("Done!");
            //********************************************************************************


//            session = factory.getCurrentSession();
//
//            Section section1 = new Section("VolleyBall");
//            Section section2 = new Section("Chess");
//            Section section3 = new Section("QuickMath");
//
//            Child child1 = new Child("Viktor", 10);
//            Child child2 = new Child("Kayne", 6);
//            Child child3 = new Child("Eddy", 7);
//
//            child1.addSectionToChild(section1);
//            child1.addSectionToChild(section2);
//            child1.addSectionToChild(section3);
//
//
//
//            session.beginTransaction();
//
//            session.save(child1);
//
//            session.getTransaction().commit();
//            System.out.println("Done!");

            //********************************************************************************
//            session = factory.getCurrentSession();
//
//
//
//            session.beginTransaction();
//
//            Section section = session.get(Section.class, 1);
//
//            System.out.println(section);
//            System.out.println(section.getChildList());
//
//            session.getTransaction().commit();
//            System.out.println("Done!");

            //********************************************************************************

//            session = factory.getCurrentSession();
//
//
//
//            session.beginTransaction();
//
//            Child child = session.get(Child.class, 4);
//
//            System.out.println(child);
//            System.out.println(child.getSectionList());
//
//            session.getTransaction().commit();
//            System.out.println("Done!");

            //********************************************************************************
//            session = factory.getCurrentSession();
//
//            session.beginTransaction();
//
//            Section section = session.get(Section.class, 9);
//            session.delete(section);
//
//            session.getTransaction().commit();
//            System.out.println("Done!");
            //********************************************************************************

            session = factory.getCurrentSession();

            session.beginTransaction();

            Child child = session.get(Child.class, 5);
            session.delete(child);

            session.getTransaction().commit();
            System.out.println("Done!");

        }
        finally {
            session.close();
            factory.close();
        }
    }
}
