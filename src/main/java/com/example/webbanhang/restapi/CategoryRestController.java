package com.example.webbanhang.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.webbanhang.dto.CategoryDTO;
import com.example.webbanhang.service.impl.CategoryServiceImpl;

@RestController
@RequestMapping("/api/category")
public class CategoryRestController {

	@Autowired
	CategoryServiceImpl categoryServiceImpl;

	@PostMapping("/add")
	public CategoryDTO add(@RequestBody CategoryDTO c) {
		categoryServiceImpl.add(c);
		return c;
	}

	@GetMapping("/list")
	public List<CategoryDTO> getList() {
		return categoryServiceImpl.getList();
	}

	@PutMapping("/update")
	public void update(@RequestBody CategoryDTO c) {
		categoryServiceImpl.update(c);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable(name = "id") Long id) {
		categoryServiceImpl.delete(id);
	}

	@GetMapping("/getbyID/{id}")
	public CategoryDTO getByID(@PathVariable(name = "id") Long id) {
		return categoryServiceImpl.getById(id);
	}

}
