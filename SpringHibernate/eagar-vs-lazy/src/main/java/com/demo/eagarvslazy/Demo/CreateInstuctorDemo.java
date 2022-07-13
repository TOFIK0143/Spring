package com.demo.eagarvslazy.Demo;

import com.demo.eagarvslazy.Entity.Course;
import com.demo.eagarvslazy.Entity.Instructor;
import com.demo.eagarvslazy.Entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstuctorDemo {

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
            // create the objects
        Instructor tempInstructor =
                new Instructor("Susan", "Shelby", "Susan.@Shelby's.com");

        InstructorDetail tempInstructorDetail =
                new InstructorDetail(
                        "http://www.youtube.com",
                        "Video Games");

        // associate the objects
        tempInstructor.setInstructorDetail(tempInstructorDetail);

        // start a transaction
        session.beginTransaction();

        // save the instructor
        //
        // Note: this will ALSO save the details object
        // because of CascadeType.ALL
        //
        System.out.println("Saving instructor: " + tempInstructor);
        session.save(tempInstructor);

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
