package com.memorynotfound.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class TksrMsgDelete extends BatchLogicMain {

    protected void run(){
        //Delete sql query here
        StringBuilder sb = new StringBuilder();
        sb.append(" DELETE");
        sb.append(" FROM t_ksr_message_mng");
        sb.append(" WHERE processing_id = '2'");

        em.getTransaction().begin();
        Query query = em.createNativeQuery(sb.toString());
        query.executeUpdate();
        em.getTransaction().commit();
        em.close();
    }

}
