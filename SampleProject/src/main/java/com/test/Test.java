package com.test;

import com.dto.DBUser;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * User: Anish
 * Date: 3/19/14
 * Time: 12:05 PM
 */
public class Test {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sampleUnitName");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        //DBUser dbUser = entityManager.find(DBUser.class, 1l);
        DBUser dbUser = new DBUser();
        dbUser.setUserName("Najeeb");
        dbUser.setPassword("najeeb");
        entityManager.getTransaction().begin();
        entityManager.persist(dbUser);
        entityManager.getTransaction().commit();
        System.out.println(dbUser.getUserName()+"--"+dbUser.getPassword());


    }
}
