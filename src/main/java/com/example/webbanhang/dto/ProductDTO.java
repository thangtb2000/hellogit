package com.example.webbanhang.dto;

public class ProductDTO {

	private Long id;

	private String name;

	private Long price;

	private String description;
	
	private String photo;

	private CategoryDTO category;


	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public CategoryDTO getCategory() {
		return category;
	}

	public void setCategory(CategoryDTO category) {
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ProductDTO() {
		// TODO Auto-generated constructor stub
	}

	public ProductDTO(Long id, String name, Long price, String description, String photo, CategoryDTO category) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.photo = photo;
		this.category = category;
	}

	

}
