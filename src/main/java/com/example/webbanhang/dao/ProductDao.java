package com.example.webbanhang.dao;

import java.util.List;

import com.example.webbanhang.entity.Product;

public interface ProductDao {

	
	void add(Product c);
	void delete(Product c);
	void update(Product c);
	Product getById(Long id);
	List<Product> getList();
	

}
