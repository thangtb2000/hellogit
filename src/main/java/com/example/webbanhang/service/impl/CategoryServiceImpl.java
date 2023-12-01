package com.example.webbanhang.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.webbanhang.dao.CategoryDao;
import com.example.webbanhang.dto.CategoryDTO;
import com.example.webbanhang.entity.Category;
import com.example.webbanhang.service.CategoryService;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryDao categoryDao;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public List<CategoryDTO> getList() {

		List<Category> list = categoryDao.getList();

		List<CategoryDTO> listDTO = new ArrayList<>();

		for (Category c : list) {
			CategoryDTO categoryDTO = modelMapper.map(c, CategoryDTO.class);

//			categoryDTO.setId(c.getId());
//			categoryDTO.setName(c.getName());

			listDTO.add(categoryDTO);
		}

		return listDTO;
	}

	@Override
	public void add(CategoryDTO c) {
		Category category = modelMapper.map(c, Category.class);

		category.setId(c.getId());
		category.setName(c.getName());

		categoryDao.add(category);

	}

	@Override
	public void delete(Long id) {
		Category category = categoryDao.getById(id);
		if (category != null) {
			categoryDao.delete(category);
		}

	}

	@Override
	public void update(CategoryDTO c) {
		Category category = categoryDao.getById(c.getId());
	
		if (category != null) {

//			category.setId(c.getId());
//			category.setName(c.getName());
			
			modelMapper.typeMap(CategoryDTO.class, Category.class)
			.addMapping(CategoryDTO::getName, Category::setName).map(c, category);
			
			categoryDao.update(category);
			
		}

		
		
	}

	@Override
	public CategoryDTO getById(Long id) {

		Category c = categoryDao.getById(id);
		
		if(c != null) {
			return modelMapper.map(c, CategoryDTO.class);
		}

//		categoryDTO.setId(c.getId());
//		categoryDTO.setName(c.getName());

		return null;
	}

}
