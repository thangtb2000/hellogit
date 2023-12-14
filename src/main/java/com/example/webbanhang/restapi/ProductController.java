package com.example.webbanhang.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.webbanhang.dto.ProductDTO;
import com.example.webbanhang.service.impl.CategoryServiceImpl;
import com.example.webbanhang.service.impl.ProductServiceImpl;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/src/main/resources/static/img";

	@Autowired
	private ProductServiceImpl productServiceImpl;
	
	@Autowired
	private CategoryServiceImpl categoryServiceImpl;
	
	@GetMapping("/list")
	public String list1(Model model) {
		model.addAttribute("list", productServiceImpl.getList());
		System.out.println("list1 start");
		return "product/list";
	}

	@GetMapping("/add")
	public String add(Model model) {
		
		model.addAttribute("categorys", categoryServiceImpl.getList());
		return "product/addProduct";
	}

	@PostMapping("/add")
	public String add(@ModelAttribute ProductDTO p, @RequestParam("image") MultipartFile file, Model model) throws IOException {
		
		StringBuilder fileNames = new StringBuilder();
		Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, file.getOriginalFilename());
		fileNames.append(file.getOriginalFilename());
		Files.write(fileNameAndPath, file.getBytes());
		model.addAttribute("msg", "Uploaded images: " + fileNames.toString());
		p.setPhoto(file.getOriginalFilename());
		productServiceImpl.add(p);
		return "redirect:/product/list";
	}

	@GetMapping("/view")
	public String view(@RequestParam(name = "pID") Long id, Model model) {
//		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		model.addAttribute("user", userDetails);
		model.addAttribute("p", productServiceImpl.getById(id));
		
		
		return "product/view";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam(name = "pID") Long id) {

		productServiceImpl.delete(id);
		return "redirect:/product/list";
	}

	@GetMapping("/update")
	public String update(@RequestParam(name = "pID") Long id, Model model) {

		model.addAttribute("p", productServiceImpl.getById(id));
		model.addAttribute("categorys", categoryServiceImpl.getList());
		return "product/updateProduct";
	}

	@PostMapping("/update")
	public String update(@ModelAttribute ProductDTO p, @RequestParam("image") MultipartFile file, Model model) throws IOException {
		StringBuilder fileNames = new StringBuilder();
		Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, file.getOriginalFilename());
		fileNames.append(file.getOriginalFilename());
		Files.write(fileNameAndPath, file.getBytes());
		model.addAttribute("msg", "Uploaded images: " + fileNames.toString());
		p.setPhoto(file.getOriginalFilename());
		productServiceImpl.update(p);
		return "redirect:/product/list";
	}

}
