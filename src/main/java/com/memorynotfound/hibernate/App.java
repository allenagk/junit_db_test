package com.memorynotfound.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class App {

    public static void main (String[] args) throws InterruptedException {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("mnf-pu");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Book book = new Book("Hibernate/JPA Named Query Example");
        em.persist(book);
        em.getTransaction().commit();

        List<Book> r1 = em.createNamedQuery("Book.findAll.nq", Book.class).getResultList();
        System.out.println("BOOK FIND ALL: " + r1);

        Book r2 = em.createNamedQuery("Book.findById.nq", Book.class)
                .setParameter("id", 1)
                .getSingleResult();
        System.out.println("BOOK FIND BY ID: " + r2);

        emf.close();
    }
}
