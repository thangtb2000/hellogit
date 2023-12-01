package com.example.webbanhang.dto;

import com.example.webbanhang.entity.Usser;

public class BillDTO {

	private Long id;

	private Usser usser;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usser getUsser() {
		return usser;
	}

	public void setUsser(Usser usser) {
		this.usser = usser;
	}
	
	public BillDTO() {
		// TODO Auto-generated constructor stub
	}

}
