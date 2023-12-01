package com.example.webbanhang.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.webbanhang.dao.ProductDao;
import com.example.webbanhang.entity.Product;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<Product> getList() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("FROM Product").getResultList();
	}

	@Override
	public void add(Product c) {
		entityManager.persist(c);

	}

	@Override
	public void delete(Product c) {
		entityManager.remove(c);

	}

	@Override
	public void update(Product c) {
		entityManager.merge(c);

	}

	@Override
	public Product getById(Long id) {

		return entityManager.find(Product.class, id);
	}

}
