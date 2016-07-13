package org.datanucleus.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.sql.Timestamp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.datanucleus.util.NucleusLogger;
import org.junit.Test;

public class IdentifiableTypeImplTest {

    @Test
    public void testGetId()
    {
        NucleusLogger.GENERAL.info(">> test START");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyTest");

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try
        {
            tx.begin();
            
            em.getMetamodel().getEntities()
              .forEach(e -> assertNotNull("@Id attribute must not be null", 
                  e.getDeclaredId(e.getIdType().getJavaType())));

            tx.commit();
        }
        catch (Throwable thr)
        {
            NucleusLogger.GENERAL.error(">> Exception in test", thr);
            fail("Failed test : " + thr.getMessage());
        }
        finally 
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            em.close();
        }

        emf.close();
        NucleusLogger.GENERAL.info(">> test END");
    }

    @Test
    public void testGetVersion()
    {
        NucleusLogger.GENERAL.info(">> test START");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyTest");

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try
        {
            tx.begin();
            
            em.getMetamodel().getEntities()
              .forEach(e -> assertNotNull("@Version attribute must not be null", 
                  e.getDeclaredVersion(Timestamp.class)));

            tx.commit();
        }
        catch (Throwable thr)
        {
            NucleusLogger.GENERAL.error(">> Exception in test", thr);
            fail("Failed test : " + thr.getMessage());
        }
        finally 
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            em.close();
        }

        emf.close();
        NucleusLogger.GENERAL.info(">> test END");
    }
}
