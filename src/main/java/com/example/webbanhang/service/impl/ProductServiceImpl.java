package com.example.webbanhang.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.webbanhang.dao.CategoryDao;
import com.example.webbanhang.dao.ProductDao;
import com.example.webbanhang.dto.CategoryDTO;
import com.example.webbanhang.dto.ProductDTO;
import com.example.webbanhang.entity.Category;
import com.example.webbanhang.entity.Product;
import com.example.webbanhang.service.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;

	@Autowired
	private CategoryDao categoryDao;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public List<ProductDTO> getList() {
		List<Product> list = productDao.getList();

		List<ProductDTO> listDTO = new ArrayList<ProductDTO>();

		for (Product p : list) {
			ProductDTO productDTO = new ProductDTO();
			CategoryDTO categoryDTO = new CategoryDTO();

			productDTO.setId(p.getId());
			productDTO.setName(p.getName());
			productDTO.setPrice(p.getPrice());
			productDTO.setDescription(p.getDescription());
			productDTO.setPhoto(p.getPhoto());

			categoryDTO.setId(p.getCategory().getId());
			categoryDTO.setName(p.getCategory().getName());

			productDTO.setCategory(categoryDTO);

			listDTO.add(productDTO);
		}

		return listDTO;
	}

	@Override
	public void add(ProductDTO c) {
		Product product = modelMapper.map(c, Product.class);

//		product.setId(c.getId());
//		product.setName(c.getName());
//		product.setPrice(c.getPrice());
//		product.setDescription(c.getDescription());
//		product.setPhoto(c.getPhoto());
//		product.setCategory(categoryDao.getById(c.getCategory().getId()));

		productDao.add(product);

	}

	@Override
	public void delete(Long id) {
		Product p = productDao.getById(id);

		if (p != null) {
			productDao.delete(p);
		}

	}

	@Override
	public void update(ProductDTO c) {
		Product product = productDao.getById(c.getId());

		if (product != null) {
			product.setId(c.getId());
			product.setName(c.getName());
			product.setPrice(c.getPrice());
			product.setDescription(c.getDescription());
			product.setPhoto(c.getPhoto());

			product.setCategory(categoryDao.getById(c.getCategory().getId()));

			productDao.update(product);
		}

	}

	@Override
	public ProductDTO getById(Long id) {
		Product p = productDao.getById(id);

		ProductDTO productDTO = new ProductDTO();
		CategoryDTO categoryDTO = new CategoryDTO();

		productDTO.setId(p.getId());
		productDTO.setName(p.getName());
		productDTO.setPrice(p.getPrice());
		productDTO.setDescription(p.getDescription());
		productDTO.setPhoto(p.getPhoto());

		categoryDTO.setId(p.getCategory().getId());
		categoryDTO.setName(p.getCategory().getName());

		productDTO.setCategory(categoryDTO);

		return productDTO;
	}

}
