package com.example.webbanhang.dao;

import java.util.List;

import com.example.webbanhang.entity.Category;

public interface CategoryDao {

	
	void add(Category c);
	void delete(Category c);
	void update(Category c);
	Category getById(Long id);
	List<Category> getList();
	

}
