package com.demo.hibernatedemo;

import com.demo.Entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {
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
            Student theStudent = new Student("Daffy","Duck","Daffy@gmail.com");

            // start the transaction
            session.beginTransaction();

            //save the student obj
            System.out.println("saving the student obj....");
            session.save(theStudent);

            //commit the transaction
            session.getTransaction().commit();
            System.out.println("Done....");

            // code for read student from database

            //fine student id or primary key
            System.out.println("primary key is:"+ theStudent.getId());

            // get a new session and start transaction
         session = factory.getCurrentSession();
         session.beginTransaction();
            // retrieve student on  primary key
          Student myStudent = session.get(Student.class,theStudent.getId());
            System.out.println("Student is : "+myStudent);
            // commit the transaction
            session.getTransaction().commit();



        }finally {
            session.close();

        }

    }
}
