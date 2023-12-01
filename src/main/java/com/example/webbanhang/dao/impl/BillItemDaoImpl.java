package com.example.webbanhang.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.webbanhang.dao.BillItemsDao;
import com.example.webbanhang.entity.BillItems;

@Repository
@Transactional
public class BillItemDaoImpl implements BillItemsDao {
	
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public void add(BillItems bi) {
		entityManager.persist(bi);
		
	}

	

}
