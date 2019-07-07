package com.memorynotfound.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BatchLogicMain {

    private static EntityManagerFactory factory =
            Persistence.createEntityManagerFactory("mnf-pu-test");
    EntityManager em = factory.createEntityManager();

    public static void main(String[] args) {

        TksrMsgDelete tksrMsgDelete = new TksrMsgDelete();
        tksrMsgDelete.run();

        System.exit(0);

    }
}
