package com.luv2code.hibernate;

import com.luv2code.hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateEmployee {

    public static void main(String[] args) {


        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();



        try {
            int employeeId = 2;

            // start a transaction
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            // retrieve employee based on the id: primary key
            System.out.println("\nGetting employee with id:" + employeeId);

            Employee myEmployee = session.get(Employee.class, employeeId);

            System.out.println("Updating employee ...");

            // update first name to "Marcin"
            myEmployee.setFirstName("Marcin");

            // commit the transaction
            session.getTransaction().commit();

            // NEW CODE

            session = factory.getCurrentSession();
            session.beginTransaction();

            // update email for all students
            System.out.println("Update email for all students");
            session.createQuery("update Employee set company='WSK' where id=2")
                    .executeUpdate();

            // commit the transaction
            session.getTransaction().commit();

            System.out.println("Done");

        } finally {
            factory.close();
        }

    }
}
