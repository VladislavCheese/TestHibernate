package org.course.test;

import org.course.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(CategoriesEntity.class).addAnnotatedClass(PeopleEntity.class)
                .buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();
            PeopleEntity people = new PeopleEntity();
            people.setName("sdfa");
            people.setAge(32);
            people.setEmail("dfsa@dfsa.re");
            session.beginTransaction();
            session.save(people);
            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}
