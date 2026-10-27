package org.jsp.Merchant_Product.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.Merchant_Product.DTO.Merchant;
import org.jsp.Merchant_Product.DTO.Product;

public class ProductDao {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("M15");
	EntityManager em = emf.createEntityManager();

	public Product addProduct(int mid, Product p) {
		EntityTransaction etran = em.getTransaction();
		Merchant m = em.find(Merchant.class, mid);
		if (m != null) {
			p.setM(m);
			etran.begin();
			em.persist(p);
			etran.commit();
			return p;
		} else {
			return null;
		}
	}

	public Product updateProduct(Product p) {

		EntityTransaction etran = em.getTransaction();

		Product db = em.find(Product.class, p.getId());
		if (db != null) {
			etran.begin();

			db.setName(p.getName());
			db.setBrand(p.getBrand());
			db.setCategory(p.getCategory());
			db.setPrice(p.getPrice());

			etran.commit();

			return db;
		} else {
			return null;
		}
	}

	public List<Product> findAllProduct() {
		Query query = em.createQuery("select p from Product p");
		List<Product> products = query.getResultList();
		return products;
	}

	public List<Product> findProductByMerchantName(String name) {
		Query query = em.createQuery("select p from Product p " + "where p.m.name=?1");
		query.setParameter(1, name);
		List<Product> products = query.getResultList();
		return products;
	}

	public List<Product> findProductByMerchantGstNumAndPassword(String gst_num, String password) {
		Query query = em.createQuery("select p from Product p " + "where p.m.gst_num=?1 " + "and p.m.password=?2");
		query.setParameter(1, gst_num);
		query.setParameter(2, password);
		List<Product> products = query.getResultList();
		return products;
	}
}