package com.example.webbanhang.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.webbanhang.dao.UsserDao;
import com.example.webbanhang.entity.Usser;

@Repository
@Transactional
public class UsserDaoImpl implements UsserDao {
	
	@PersistenceContext 
	EntityManager entityManager;

	@Override
	public Usser getByUsername(String username) {
		String jql = "select u from Usser u where u.username = ?1";
		 
		return entityManager.createQuery(jql, Usser.class).setParameter(1, username).getSingleResult();
	}
	
	
	

}
