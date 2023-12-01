package com.example.webbanhang.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.webbanhang.dao.BillDao;
import com.example.webbanhang.entity.Bill;

@Repository
@Transactional
public class BillDaoImpl implements BillDao {
	
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public void add(Bill b) {
		entityManager.persist(b);
	}

	@Override
	public Bill getbyId(Long id) {
		// TODO Auto-generated method stub
		return entityManager.find(Bill.class, id);
	}

}
