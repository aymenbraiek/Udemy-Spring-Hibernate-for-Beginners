package com.luv2code.hibernate;

import com.luv2code.hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteEmployee {

    public static void main(String[] args) {


        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();



        try {
            int employeeId = 1;

            // start a transaction
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            // retrieve employee based on the id: primary key
            System.out.println("\nGetting employee with id:" + employeeId);

            Employee myEmployee = session.get(Employee.class, employeeId);

            System.out.println("Deleting employee ...");

            session.delete(myEmployee);
            session.getTransaction().commit();



            System.out.println("Done");

        } finally {
            factory.close();
        }

    }
}
