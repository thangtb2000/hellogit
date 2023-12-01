package com.example.webbanhang.service;

import java.util.List;

import com.example.webbanhang.dto.ProductDTO;

public interface ProductService {

	void add(ProductDTO c);

	void delete(Long id);

	void update(ProductDTO c);

	ProductDTO getById(Long id);

	List<ProductDTO> getList();

}
