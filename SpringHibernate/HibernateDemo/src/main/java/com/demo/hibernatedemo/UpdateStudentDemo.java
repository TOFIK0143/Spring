package com.demo.hibernatedemo;

import com.demo.Entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {

    public static void main(String[] args) {
        //create sessionFactory

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        //create session

        Session session = factory.getCurrentSession();

        try {
            int studentId = 1;
            // get a new session and start transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            // retrieve student on  primary key
            Student myStudent = session.get(Student.class,studentId);
            System.out.println("Student is : "+myStudent);

            //updating the student

             myStudent.setFirstName("Shaun");
            // commit the transaction
            session.getTransaction().commit();
            System.out.println("Done");

            //Second way to update

            session = factory.getCurrentSession();
            session.beginTransaction();

            session.createQuery("update Student s set email='shaun@gmail.com' where s.id=1").executeUpdate();

            session.getTransaction().commit();
            System.out.println("Done");

        }finally {
            session.close();

        }

    }
}
