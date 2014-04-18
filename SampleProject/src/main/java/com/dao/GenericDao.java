package com.dao;


import java.io.Serializable;
import java.util.List;

/**
 * User: Anish
 * Date: 2/17/13
 * Time: 12:01 PM
 */
public interface GenericDao<T, PK extends Serializable> {

    /**
     * Persist the newInstance object into database
     * @param newInstance
     */
    void create(T newInstance);

    /**
     * Retrieve an object that was previously persisted to the database using the indicated id as primary key
     * @param id
     * @return
     */
    T read(PK id);

    /**
     * Save changes made to a persistent object.
     * @param transientObject
     */
    void update(T transientObject);

    /**
     * Remove an object from persistent storage in the database
     * @param persistentObject
     */
    void delete(T persistentObject);

    /**
     * The method to load the all records
     * @return
     */
    List<T> loadAll();
    

}
