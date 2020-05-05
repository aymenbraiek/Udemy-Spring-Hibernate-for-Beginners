package com.luv2code.hibernate;

import com.luv2code.hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadEmployee {

    public static void main(String[] args) {


        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            // create a Employee object
            System.out.println("Creating new Employee object...");
            Employee tempEmployee = new Employee("Marin", "Madera", "WSK");


            // start a transaction
            session.beginTransaction();

            // save the student object
            System.out.println("Saving the Employee ...");
            session.save(tempEmployee);


            // commit the transaction
            session.getTransaction().commit();

            System.out.println("Employee saved. Generated id= " + tempEmployee.getId());

            // now get a new session and start transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            // retrieve student based on the id: primary key
            System.out.println("\nGetting employee with id:" + tempEmployee.getId());

            Employee myEmployee = session.get(Employee.class, tempEmployee.getId());

            System.out.println("Get complete: " + myEmployee);


            // commit the transaction
            session.getTransaction().commit();

            System.out.println("Done");

        } finally {
            factory.close();
        }
    }
}
