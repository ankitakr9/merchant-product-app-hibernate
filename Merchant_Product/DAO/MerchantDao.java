package org.jsp.Merchant_Product.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.EntityTransaction;

import org.jsp.Merchant_Product.DTO.Merchant;

public class MerchantDao {

    EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("M15");

    EntityManager em = emf.createEntityManager();

    public Merchant saveMerchant(Merchant m) {

        EntityTransaction etran = em.getTransaction();

        etran.begin();

        em.persist(m);

        etran.commit();

        return m;
    }

    public Merchant updateMerchant(Merchant m) {

        EntityTransaction etran = em.getTransaction();

        Merchant db = em.find(Merchant.class, m.getId());

        if (db != null) {

            etran.begin();

            db.setName(m.getName());
            db.setGst_num(m.getGst_num());
            db.setEmail(m.getEmail());
            db.setPhone(m.getPhone());
            db.setPassword(m.getPassword());

            etran.commit();

            return db;

        } else {

            return null;
        }
    }

    public Merchant findMerchantById(int id) {

        Merchant m = em.find(Merchant.class, id);

        return m;
    }

    public Merchant findMerchantByNameAndPassword(
            String name, String password) {

        String jpql =
                "select m from Merchant m "
                + "where m.name=?1 and m.password=?2";

        Query query = em.createQuery(jpql);

        query.setParameter(1, name);
        query.setParameter(2, password);

        Merchant m = null;

        try {

            m = (Merchant) query.getSingleResult();

        } catch (Exception e) {

            System.out.println("Merchant not found");
        }

        return m;
    }

    public Merchant findMerchantByProductId(int pid) {

        String jpql =
                "select p.m from Product p where p.id=?1";

        Query query = em.createQuery(jpql);

        query.setParameter(1, pid);

        Merchant m = null;

        try {

            m = (Merchant) query.getSingleResult();

        } catch (Exception e) {

            System.out.println("Product not found");
        }

        return m;
    }
}