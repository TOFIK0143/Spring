package com.demo.hibernatedemo;

import com.demo.Entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();

        try {
            int studentId = 6;
            // get a new session and start transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            // retrieve student on  primary key
            Student myStudent = session.get(Student.class,studentId);
            System.out.println("Student is : "+myStudent);

            //Deleting the student

            if(myStudent != null) {
                session.delete(myStudent);
            }
            // commit the transaction
            session.getTransaction().commit();
            System.out.println("Done");

            //Second way to Delete

            session = factory.getCurrentSession();
            session.beginTransaction();

            session.createQuery("delete from Student s where s.id=5").executeUpdate();

            session.getTransaction().commit();
            System.out.println("Done");

        }finally {
            session.close();

        }

    }
}
