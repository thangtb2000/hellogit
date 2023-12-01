package com.example.webbanhang.service;

import java.util.List;

import com.example.webbanhang.dto.CategoryDTO;

public interface CategoryService {

	void add(CategoryDTO c);

	void delete(Long id);

	void update(CategoryDTO c);

	CategoryDTO getById(Long id);

	List<CategoryDTO> getList();

}
