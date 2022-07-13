package com.demo.hibernatedemo;

import com.demo.Entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {
    public static void main(String[] args) {
        //create sessionFactory

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        //create session

        Session session = factory.getCurrentSession();

        try {
            //create 3 student obj
            System.out.println("creating a new student obj....");
            Student student1 = new Student("Ron","wiesly","Ron@gmail.com");
            Student student2 = new Student("Harry","Potter","Harry@gmail.com");
            Student student3 = new Student("Albus","Dambuldoor","Albus@gmail.com");

            // start the transaction
            session.beginTransaction();

            //save the student obj
            System.out.println("saving the 3 student obj....");
            session.save(student1);
            session.save(student2);
            session.save(student3);

            //commit the transaction
            session.getTransaction().commit();
            System.out.println("Done....");


        }finally {
            session.close();

        }


    }

}
