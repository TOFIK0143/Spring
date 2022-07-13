package com.demo.hibernatedemo;

import com.demo.Entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class QueryStudentDemo {

    public static void main(String[] args) {

        //create sessionFactory

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                                                    .addAnnotatedClass(Student.class)
                                                    .buildSessionFactory();

        //create session

        Session session = factory.getCurrentSession();

        try {
            // start the transaction
            session.beginTransaction();

           // query the students
            List<Student> theStudents = session.createQuery("from Student").list();
           // display the students

            displayStudent(theStudents);

            theStudents = session.createQuery("from Student where email LIKE '%@gmail.com' ").list();

            displayStudent(theStudents);

            theStudents = session.createQuery("from Student s where s.lastName='Duck' OR s.lastName='Potter'").list();

            displayStudent(theStudents);
            //commit the transaction
            session.getTransaction().commit();
            System.out.println("Done....");


        }finally {
            session.close();

        }


    }

    private static void displayStudent(List<Student> theStudents) {
        for(Student temp : theStudents)
        {
            System.out.println(temp);
        }
    }
}
