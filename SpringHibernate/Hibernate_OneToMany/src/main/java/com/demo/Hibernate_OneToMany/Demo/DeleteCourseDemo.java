package com.demo.Hibernate_OneToMany.Demo;

import com.demo.Hibernate_OneToMany.Entity.Course;
import com.demo.Hibernate_OneToMany.Entity.Instructor;
import com.demo.Hibernate_OneToMany.Entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteCourseDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            // start a transaction
            session.beginTransaction();

            // get the course from database
            int theId = 10;
           Course course = session.get(Course.class,theId);

           // delete course

            session.delete(course);



            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            // add clean up code
            session.close();
            factory.close();
        }
    }

}




