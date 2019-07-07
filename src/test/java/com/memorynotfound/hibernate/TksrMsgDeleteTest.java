package com.memorynotfound.hibernate;

import org.junit.Test;

import javax.persistence.PersistenceException;
import javax.persistence.Query;
import java.sql.Date;
import java.util.Calendar;
import org.junit.Assert;

import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class TksrMsgDeleteTest extends JPAHibernateTest{

    @Test
    public void T_S0830() {
        Date old_date = new Date(Calendar.getInstance().getTimeInMillis());
        String msg_id = "'TT_TTT_" + old_date + old_date.getTime() + "'";
        System.out.println(old_date);
        String[] batchId = {"ald", "aldsd"};

        //ADD DATA TO DATABASE
        try {
            add_data_to_db(msg_id, old_date);
        } catch (PersistenceException e) {
            assertTrue(false);
        }

        SystemExitControl.forbidSystemExitCall();
        try {
            System.out.println("Running a program which calls System.exit");
            BatchLogicMain.main(batchId);
        } catch (SystemExitControl.ExitTrappedException e) {
            System.out.println("Forbidding call to System.exit");
            assertFalse(is_data_available(msg_id));
        }

        SystemExitControl.enableSystemExitCall();

    }

    //write comments here
    private void add_data_to_db(String msg_id, Date time_stamp) throws PersistenceException {
        StringBuilder sb = new StringBuilder();
        sb.append(" INSERT INTO t_ksr_message_mng(msg_id, insurer_code, receive_date, processing_id, data1, data2) VALUES (:msg_id_name, 'B1_00001', :receive_date, '2', '223432243', '2342342432')");
        Query query = em.createNativeQuery(sb.toString());
        query.setParameter("msg_id_name", msg_id);
        query.setParameter("receive_date", time_stamp);
        em.getTransaction().begin();
        query.executeUpdate();
        em.getTransaction().commit();
    }

    //write comments here
    private boolean is_data_available(String msg_id) {
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT * FROM t_ksr_message_mng WHERE msg_id=:msg_id");
        Query query = em.createNativeQuery(sb.toString());
        query.setParameter("msg_id", msg_id);
        if (query.getResultList().size()>0){
            return true;
        } else {
            return false;
        }
    }
}
