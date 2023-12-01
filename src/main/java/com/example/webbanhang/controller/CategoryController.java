package com.example.webbanhang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.webbanhang.dto.CategoryDTO;
import com.example.webbanhang.service.CategoryService;

@Controller
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	CategoryService categoryService;

	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("list", categoryService.getList());
		return "category/listCategory";
	}

	@GetMapping("/add")
	public String add(Model model) {
		
		return "category/addCategory";
	}

	@PostMapping("/add")
	public String add(@ModelAttribute CategoryDTO c) {
		categoryService.add(c);
		return "redirect:/category/list";
	}

	@GetMapping("/view")
	public String view(@RequestParam(name = "cID") Long id, Model model) {

		model.addAttribute("c", categoryService.getById(id));
		return "category/view";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam(name = "cID") Long id) {

		categoryService.delete(id);
		return "redirect:/category/list";
	}
	
	@GetMapping("/update")
	public String update(@RequestParam(name = "cID") Long id, Model model) {

		model.addAttribute("c", categoryService.getById(id));
		return "category/updateCategory";
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute CategoryDTO c) {

		categoryService.update(c);
		return "redirect:/category/list";
	}

}
