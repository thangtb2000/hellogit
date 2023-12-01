package com.example.webbanhang.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.webbanhang.dto.ProductDTO;
import com.example.webbanhang.service.impl.ProductServiceImpl;

@RestController
@RequestMapping("/api/product")
public class ProductRestController {

	@Autowired
	ProductServiceImpl productServiceImpl;

	@PostMapping("/add")
	public ProductDTO add(@RequestBody ProductDTO p) {
		System.out.println(p.getName());
		productServiceImpl.add(p);

		return p;
		
	}
}
