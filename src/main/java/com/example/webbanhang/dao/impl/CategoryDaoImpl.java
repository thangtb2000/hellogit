package com.example.webbanhang.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.webbanhang.dao.CategoryDao;
import com.example.webbanhang.entity.Category;

@Repository
@Transactional
public class CategoryDaoImpl implements CategoryDao {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<Category> getList() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("FROM Category").getResultList();
	}

	@Override
	public void add(Category c) {
		entityManager.persist(c);

	}

	@Override
	public void delete(Category c) {
		entityManager.remove(c);

	}

	@Override
	public void update(Category c) {
		entityManager.merge(c);

	}

	@Override
	public Category getById(Long id) {
		// TODO Auto-generated method stub
		return 	entityManager.find(Category.class, id);
	}

	
}
