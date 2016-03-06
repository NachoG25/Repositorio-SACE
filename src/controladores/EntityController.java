/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.util.List;
import java.util.Map;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * 
 */
public abstract class EntityController {

    public static final String PU = "sacePU";
    private static EntityManagerFactory entityManagerFactory;

    public EntityManager getEntityManager() {
        return this.getEntityManagerFactory().createEntityManager();
    }

    private EntityManagerFactory getEntityManagerFactory() {
        if (entityManagerFactory == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory(PU);
        }
        return entityManagerFactory;
    }

    protected void persist(Object entity) throws Exception {
        EntityManager em = this.getEntityManager();
        em.getTransaction().begin();
        try {
            this.persist(entity, em);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            //em.close();
            em.clear();
        }
    }

    protected void persist(Object entity, EntityManager em) throws Exception {
        em.persist(entity);

    }

    protected void dispose(Object entity) throws Exception {
        EntityManager em = this.getEntityManager();
        em.getTransaction().begin();
        try {
            this.dispose(entity, em);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    protected void dispose(Object entity, EntityManager em) throws Exception {
        Object e = em.merge(entity);
        em.remove(e);

    }

    protected void merge(Object entity) throws Exception {
        EntityManager em = this.getEntityManager();
        em.getTransaction().begin();
        try {
            this.merge(entity, em);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    protected void merge(Object entity, EntityManager em) throws Exception {
        em.merge(entity);

    }

    protected List executeNamedQuery(String queryName) {
        EntityManager em = this.getEntityManager();
        Query query = em.createNamedQuery(queryName);
        List resultList = this.executeNamedQuery(query);
        em.close();
        return resultList;
    }

    protected List executeNamedQuery(Query query) {

        List resultList = query.getResultList();
        return resultList;
    }

    protected List executeNamedQuery(String queryName, Map<String, Object> parametros) {
        EntityManager em = this.getEntityManager();
        Query query = em.createNamedQuery(queryName);
        for (String param : parametros.keySet()) {
            query.setParameter(param, parametros.get(param));
        }
        List resultList = this.executeNamedQuery(query);
        em.close();
        return resultList;
    }
}
