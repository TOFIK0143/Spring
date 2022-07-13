package com.demo.hibernatedemo;

import com.demo.Entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateStudentDemo {

    public static void main(String[] args) {

        //create sessionFactory

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                                                    .addAnnotatedClass(Student.class)
                                                    .buildSessionFactory();

        //create session

        Session session = factory.getCurrentSession();

        try {
            //create student obj
            System.out.println("creating a new student obj....");
            Student theStudent = new Student("Tofik","Maniyar","tofik.maniyar@zemosolabs.com");

            // start the transaction
            session.beginTransaction();

            //save the student obj
            System.out.println("saving the student obj....");
            session.save(theStudent);

            //commit the transaction
            session.getTransaction().commit();
            System.out.println("Done....");


        }finally {
            session.close();

        }


    }
}
