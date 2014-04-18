package com.dao.impl;

import com.aop.FinderExecutor;
import com.dao.GenericDao;
import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.List;

/**
 * User: Anish
 * Date: 2/17/13
 * Time: 12:01 PM
 */
public class GenericDaoImpl<T, PK extends Serializable> implements GenericDao<T, PK>, FinderExecutor<T> {

    private Class<T> type;
    private EntityManager entityManager;

    public GenericDaoImpl(Class<T> type) {
        this.type = type;
    }

    /**
     * Persist the newInstance object into database
     * @param o
     */
    public void create(T o) {
    	entityManager.persist(o);
    }

    /**
     * Retrieve an object that was previously persisted to the database using the indicated id as primary key
     * @param id
     * @return
     */
    public T read(PK id) {
        return (T) entityManager.find(type, id);
    }

    /**
     * Save changes made to a persistent object.
     * @param o
     */
    public void update(T o) {
        entityManager.merge(o);
    }

    /**
     * Remove an object from persistent storage in the database
     * @param o
     */
    public void delete(T o) {
        entityManager.remove(o);
    }

    /**
     * The method to load the all records
     * @return
     */
    public List<T> loadAll() {
        return entityManager.createQuery("from "+type.getSimpleName()).getResultList();
    }

    /**
     * The method to call named queries, named query must start with (find)
     * @param method
     * @param queryArgs
     * @return
     */
    public List<T> executeFinder(Method method, final Object[] queryArgs) {
        final String queryName = queryNameFromMethod(method);
        final Query namedQuery = entityManager.createNamedQuery(queryName);
        //String[] namedParameters = namedQuery.getNamedParameters();
        for (int i = 0; i < queryArgs.length; i++) {
            Object arg = queryArgs[i];
            namedQuery.setParameter(i, arg);
        }
        return (List<T>) namedQuery.getResultList();
    }
    


    public String queryNameFromMethod(Method finderMethod) {
        return type.getSimpleName() + "." + finderMethod.getName();
    }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
